<%@include file="../includes/header.jsp"%>

<div class="row">
	<div class="col-sm-12">
		<div class="page-header">
			<h3>Change your password</h3>
		</div>
	</div>
</div>

<div class="row">
	<div class="col-sm-12">
		<form:form role="form" modelAttribute="changePasswordForm" class="form-vertical" method="post">
			<div class="col-sm-6">
				<div class="form-group">
					<label for="password"><h4>enter current password</h4></label>
					 <input type="password" class="form-control" name="password" id="password" />
					 <form:errors cssClass="error" path="password" />
				</div>
				<div class="form-group">
					<label for="newPassword"><h4>enter new password</h4></label>
					 <input type="password" class="form-control" name="newPassword" id="newPassword" />
					 <form:errors cssClass="error" path="newPassword" />
				</div>
				<div class="form-group">
					<label for="confirmPassword"><h4>enter confirm password</h4></label> 
					<input type="password" class="form-control" name="confirmPassword" id="confirmPassword" />
					<form:errors cssClass="error" path="confirmPassword" />
				</div>
			</div>
			<div class="form-group">
				<div class="col-sm-12">
					<br>
					<button class="btn btn-lg btn-success" type="submit">
						<i class="glyphicon glyphicon-ok-sign"></i> Save
					</button>
					<button class="btn btn-lg" type="reset">
						<i class="glyphicon glyphicon-repeat"></i> Reset
					</button>
				</div>
			</div>
		</form:form>
	</div>
</div>
<%@include file="../includes/footer.jsp"%>