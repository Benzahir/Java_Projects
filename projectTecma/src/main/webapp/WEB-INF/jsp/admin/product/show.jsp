<%@include file="../includes/header.jsp"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<div class="container">
	<div class="row">
		<div
			class="col-xs-12 col-sm-12 col-md-6 col-lg-6 col-xs-offset-0 col-sm-offset-0 col-md-offset-3 col-lg-offset-3 toppad">
			<div class="panel panel-info">
				<div class="panel-heading">
					<h3 class="panel-title">${product.name }</h3>
				</div>
				<div class="panel-body">
					<div class="row">
						<div class="col-md-3 col-lg-3 " align="center">
								
									
										<img alt=""
											src="/photos/cucina-fruitpassion.jpg"
											style="width: 100px; height: 100px" class="img-circle">
									
								
									
							</div>
						<div class=" col-md-9 col-lg-9 ">
							<table class="table table-user-information">
								<tbody>
									<tr>
										<td>Name:</td>
										<td>${product.name}</td>
									</tr>
									<tr>
										<td>Company Name:</td>
										<td>${product.companyName}</td>
									</tr>
									<tr>
										<td>Description</td>
										<td>${product.description}</td>
									</tr>
									<tr>
										<td>Selling Price</td>
										<td>${product.sellingPrice}</td>
									</tr>
									<tr>
										<td>Cost Price</td>
										<td>${product.costPrice}</td>
									</tr>
								</tbody>
							</table>
						</div>
					</div>
				</div>
				<div class="panel-footer">
					<a href="<%=request.getHeader("Referer")%>" data-original-title="Back" data-toggle="tooltip"
						type="button" class="btn btn-sm btn-primary"><i
						class="glyphicon glyphicon-arrow-left"></i></a> <span class="pull-right">
							<a href="/admin/product/${product.id}/edit"
								data-original-title="Edit this product" data-toggle="tooltip"
								type="button" class="btn btn-sm btn-warning"><i
								class="glyphicon glyphicon-edit"></i></a>
								<a href="/admin/product/${product.id}/delete"
						data-original-title="Remove this dog" data-toggle="tooltip"
						type="button" class="btn btn-sm btn-danger CONFIRMDELETE"
						data-dialog-title="Are you sure you wanna delete ${product.name}?"
						data-dialog-msg="You are about to delete this product '${product.name}'."><i
							class="glyphicon glyphicon-remove"></i></a>
					</span>
				</div>
			</div>
		</div>
	</div>
</div>

<%@include file="../includes/footer.jsp"%>
