<%@include file="../includes/header.jsp"%>
<div class="container">
	<div class="row visible-on">
		<div class="col-md-12">
			<div class="page-header">
				<div class="pull-right"><a href="/admin/product/create" class="btn btn-primary"><i class="glyphicon glyphicon-plus"></i> Add product</a></div>
				<h3>Products</h3>
			</div>
		</div>
	</div>

	<div class="row visible-on">
		<div class="col-md-12">
			<div class="table-responsive">
				<c:choose>
					<c:when test="${products.size() > 0}">
						<table
							class="table table-striped table-bordered table-condensed table-hover">
							<thead>
								<tr class="info">
									<th>Name</th>
									<th>Company Name</th>
									<th>Description</th>
									<th>Cost Price</th>
									<th>Selling Price</th>
									<th>Profit</th>
									<th>Profit Percent</th>
									<th>Loss</th>
									<th>Loss Percent</th>
									<th>Actions</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach var="product" items="${products}">
									<tr>
										<td>${product.name}</td>
										<td>${product.companyName}</td>
										<td>${product.description}</td>
										<td>${product.costPrice}</td>
										<td>${product.sellingPrice}</td>
										<td>${product.profit}</td>
										<td>${product.profitPercent}</td>
										<td>${product.loss}</td>
										<td>${product.lossPercent}</td>
										<td>
											<a href="/admin/product/${product.id}/edit" class="btn btn-xs btn-success" data-toggle="tooltip" data-placement="top" title="Edit">
												<i class="glyphicon glyphicon-edit"></i>
											</a>
											<a href="/admin/product/${product.id}/show" class="btn btn-xs btn-info" title="show" data-toggle="tooltip" data-placement="top">
												<i class="glyphicon glyphicon-eye-open"></i>
											</a>
											<a href="/admin/product/${product.id}/delete" class="btn btn-xs btn-danger" title="Delete" data-toggle="tooltip" data-placement="top">
												<i class="glyphicon glyphicon-trash"></i>
											</a>
										</td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</c:when>
					<c:otherwise>
						<strong>There is no content to display</strong>
					</c:otherwise>
				</c:choose>
			</div>
		</div>
	</div>
</div>
<%@include file="../includes/footer.jsp"%>