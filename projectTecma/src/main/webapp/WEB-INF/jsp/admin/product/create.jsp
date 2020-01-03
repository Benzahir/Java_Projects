<%@include file="../includes/header.jsp"%>
<!-- Page Heading/Breadcrumbs -->
<div class="row">
	<div class="col-lg-12">
		<h1 class="page-header">
			Add <small>Products</small>
		</h1>
	</div>
</div>
<!-- /.row -->

<!-- Content Row -->
<div class="row">
	<!-- Map Column -->
	<div class="col-md-6">
		<form:form modelAttribute="product" method="post"
			enctype="multipart/form-data"
			id="js-upload-form">
			<form:input path="id" type="hidden" />
			<div class="control-group form-group">
				<div class="controls">
					<label>Name:</label>
					<form:input path="name" type="text" class="form-control" />
					<p class="help-block"></p>
				</div>
			</div>
			<div class="control-group form-group">
				<div class="controls">
					<label>Company Name:</label>
					<form:input path="companyName" type="text" class="form-control" />
					<p class="help-block"></p>
				</div>
			</div>
			<div class="control-group form-group">
				<div class="controls">
					<label>Description:</label>
					<form:input path="description" type="text" class="form-control" />
					<p class="help-block"></p>
				</div>
			</div>
			<div class="control-group form-group">
				<div class="controls">
					<label>Cost Price:</label>
					<form:input path="costPrice" type=" text" class="form-control" />
					<p class="help-block"></p>
				</div>
			</div>
			<div class="control-group form-group">
				<div class="controls">
					<label>Selling Price:</label>
					<form:input path="sellingPrice" type="text" class="form-control" />
					<p class="help-block"></p>
				</div>
			</div>
			<div class="control-group form-group">
				<div class="controls">
					<label>Quantity Of Measure:</label>
					<form:input path="quantityOfMeasure" type="text"
						class="form-control" />
					<p class="help-block"></p>
				</div>
			</div>
			<div class="control-group form-group">
				<div class="controls">
					<label>Stock:</label>
					<form:input path="stock" type="text" class="form-control" />
					<p class="help-block"></p>
				</div>
			</div>
			<div class="control-group form-group">
				<div class="controls">
					<label>Manufacture Date:</label>
					<form:input path="manufactureDate" type="text" class="form-control" />
					<p class="help-block"></p>
				</div>
			</div>
			<div class="control-group form-group">
				<div class="controls">
					<label>Expiry Date:</label>
					<form:input path="expiryDate" type="text" class="form-control" />
					<p class="help-block"></p>
				</div>
			</div>
			<div class="form-inline">
				<small class="text-danger">We accept only jpg files</small>
				<div class="form-group">
					<span class="btn btn-primary btn-file"> Choose Images<input
						id="files" type="file" name="files" multiple="multiple"
						accept="image/jpg" />
					</span>
				</div>
			</div>
			<div class="row inline" id="dvPreview"></div><br />
			<div id="success"></div>
			<!-- For success/fail messages -->
			<button type="submit" class="btn btn-primary">Add Product</button>
		</form:form>
	</div>
</div>

<%@include file="../includes/footer.jsp"%>