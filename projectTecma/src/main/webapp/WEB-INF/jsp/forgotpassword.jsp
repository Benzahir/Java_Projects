<%@include file="includes/header.jsp"%>
	<div class="page-header">
		<h2>
			Password Recovery
		</h2>
	</div>
	<div class="container">
		<div class="row">
			<div class="col-sm-6 col-md-12 col-md-offset-3">
				<form:form role="form" class="form form-horizontal" modelAttribute="forgotPasswordForm" method="post">
					<fieldset>
						<div class="form-group">
							<div class="col-md-4">
								<label>Enter email</label>
								<input type="email" class="form-control input-lg" name="email" id="email" placeholder="email" required>
							</div>
						</div>
					    <div class="form-group">
					        <div class="col-md-4">
								<button type="submit" class="btn btn-primary btn-lg btn-block">
									<i class="glyphicon glyphicon-ok-sign"></i> Send
								</button>
								<a href="/login" class="btn btn-success btn-lg  btn-block">
									<i class="glyphicon glyphicon-log-in"></i> Sign In
								</a>
							</div>
					    </div>
					</fieldset>
				</form:form>
			</div>
		</div>
	</div>
<%@include file="includes/footer.jsp"%>