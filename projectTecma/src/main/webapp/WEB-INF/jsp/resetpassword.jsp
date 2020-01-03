<%@include file="includes/header.jsp"%>
<form:form class="form form-horizontal" modelAttribute="resetPasswordForm" method="post">
	<div class="form-group">
		<div class="col-xs-6">
			<label for="password"><h4>New password</h4></label> <input
				type="password" class="form-control" name="password"
				id="password" placeholder="new password"
				title="enter your new password.">
		</div>
	</div>
	<div class="form-group">
		<div class="col-xs-6">
			<label for="retypePassword"><h4>Confirm password</h4></label> <input
				type="password" class="form-control" name="retypePassword"
				id="retypePassword" placeholder="confirm password"
				title="enter confirm password.">
		</div>
	</div>
	<div class="form-group">
		<div class="col-xs-12">
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
<%@include file="includes/footer.jsp"%>