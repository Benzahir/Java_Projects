<%@include file="includes/header.jsp"%>
<div class="page-header">
	<h2>
		Sign In
	</h2>
</div>
<div class="container">
	<div class="row">
		<c:if test="${param.error != null}">
		    <div class="alert alert-danger">
		        Invalid Email and Password.
		    </div>
	    </c:if>
		<div class="col-sm-6 col-md-12 col-md-offset-3">
			<form:form role="form" class="form form-horizontal" method="post">
			    <div class="form-group">
			        <div class="col-md-5">
						<input type="email" name="username" id="username" class="form-control input-lg" placeholder="Email">
					</div>
			    </div>
			    <div class="form-group">
				    <div class="col-md-5">
				        <input type="password" name="password" id="password" class="form-control input-lg" placeholder="Password">
			        </div>
			    </div>
			    <div class="form-group">
			        <div class="col-md-5">
						<button type="submit" class="btn btn-primary btn-lg btn-block">
							<i class="glyphicon glyphicon-log-in"></i> Sign In
						</button>
				        <span><a href="/forgot-password">Forget Password?</a></span>
				        <span class="pull-right"><a href="/signup">New Registration</a></span>
					</div>
			    </div>
			</form:form>
		</div>
	</div>
</div>
<%@include file="includes/footer.jsp"%>