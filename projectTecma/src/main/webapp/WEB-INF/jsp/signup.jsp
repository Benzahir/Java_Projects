<%@include file="includes/header.jsp"%>
<div class="row">
	<div class="page-header">
		<h3>Sign Up</h3>
	</div>
</div>
<div class="row">
	<div class="col-sm-12">
		<form:form modelAttribute="signupForm" class="form-vertical"
			role="form">
			<div class="col-sm-6">
				<div class="form-group">
					<form:label path="firstName" for="firstName">FirstName</form:label>
					<form:input path="firstName" class="form-control"
						placeholder="firstName" />
					<form:errors cssClass="error" path="firstName" />
				</div>
				
				<div class="form-group">
					<form:label path="email" for="email">E-mail</form:label>
					<form:input path="email" class="form-control" placeholder="email" />
					<form:errors cssClass="error" path="email" />
				</div>
				
				<div class="form-group">
					<label for="password">Password</label> <input type="password"
						class="form-control" name="password" id="password"
						placeholder="Password" title="enter password" />
					<form:errors cssClass="error" path="password"></form:errors>
				</div>
			</div>
			
			<div class="col-sm-6">
			
				<div class="form-group">
					<form:label path="lastName" for="lastName">LastName</form:label>
					<form:input path="lastName" class="form-control"
						placeholder="lastName" />
					<form:errors cssClass="error" path="lastName" />
				</div>

				<div class="form-group">
					<label for="confirmPassword">confirmPassword</label> <input
						type="password" class="form-control" name="confirmPassword"
						id="confirmPassword" placeholder="confirmPassword"
						title="enter confirmPassword" />
					<form:errors cssClass="error" path="confirmPassword"></form:errors>
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

<%@include file="includes/footer.jsp"%>