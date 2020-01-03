<%@include file="../includes/header.jsp"%>
<div class="row">
	<div class="page-header">
		<h3>Sign Up</h3>
	</div>
</div>
<div class="row">
	<div class="col-sm-12">
		<form:form modelAttribute="user" class="form-vertical" role="form">
			<div class="col-sm-6">
				<div class="form-group">
					<form:label path="firstName" for="firstName">FirstName</form:label>
					<form:input path="firstName" class="form-control"
						placeholder="firstName" required="true" />
					<form:errors cssClass="error" path="firstName" />
				</div>

				<div class="form-group">
					<form:label path="lastName" for="lastName">LastName</form:label>
					<form:input path="lastName" class="form-control"
						placeholder="lastName" required="true" />
					<form:errors cssClass="error" path="lastName" />
				</div>

				<div class="form-group">
					<form:label path="email" for="email">E-mail</form:label>
					<form:input path="email" class="form-control" placeholder="email"
						required="true" />
					<form:errors cssClass="error" path="email" />
				</div>

				<c:if test="${user.id eq 0 }">
					<div class="form-group">
						<label for="password">Password</label>
						<form:input path="password" type="password" class="form-control"
							name="password" id="password" placeholder="Password"
							title="enter password" />
						<form:errors cssClass="error" path="password"></form:errors>
					</div>
				</c:if>
				<div class="form-group">
					<label for="role">Role</label> <select class="form-control"
						name="role">
						<option value="">Select Role</option>
						<c:if test="${user.id ne 0}">
							<c:forEach items="${user.roles}" var="role">
								<option value="1"
									<c:if test="${(role eq 'CUSTOMER') && (user.id ne 0)}">selected="selected"</c:if>>CUSTOMER</option>
								<option value="2"
									<c:if test="${(role eq 'SALESENGINEER') && (user.id ne 0)}">selected="selected"</c:if>>SALESENGINEER</option>
								<option value="3"
									<c:if test="${(role eq 'ADMIN') && (user.id ne 0)}">selected="selected"</c:if>>ADMIN</option>
							</c:forEach>
						</c:if>
						<c:if test="${user.id eq 0}">
							<option value="1">CUSTOMER</option>
							<option value="2">SALESENGINEER</option>
							<option value="3">ADMIN</option>
						</c:if>
					</select>
				</div>
			</div>

			<div class="form-group">
				<div class="col-xs-12">
					<br>
					<button class="btn btn-lg btn-success" type="submit">
						<i class="glyphicon glyphicon-ok-sign"></i> Save
					</button>
				</div>
			</div>
		</form:form>

	</div>
</div>

<%@include file="../includes/footer.jsp"%>