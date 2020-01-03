<%@include file="includes/header.jsp"%>
<!-- Cart -->
<div class="container">
	<div class="page-header">
		<h2>Shopping Cart</h2>
	</div>
	<c:if test="${orders.size() == 0 or orders == null}">
		<div class="alert alert-info" role="alert">
			<strong>Cart Empty!</strong> Your cart currently Empty!
		</div>
	</c:if>
	<c:if test="${orders.size() ne 0 and orders ne null}">
		<div class="col-lg-9 col-md-9 col-sm-12">
			<div class="col-lg-12 col-sm-12 hero-feature">
				<table
					class="table table-striped table-bordered table-condensed table-hover">
					<thead>
						<tr>
							<td>Product Name</td>
							<td class="td-qty">Quantity</td>
							<td>Unit Price</td>
							<td>Sub total</td>
							<td>Remove</td>
						</tr>
					</thead>
					<tbody>
						<c:if test="${orders.size() gt 0 or orders ne null}">
							<c:set var="row_total" value="0" />
							<c:forEach var="product" items="${orders}" varStatus="loop">
								<tr>
									<td><a href="/detail">${product.name}</a></td>
									<td>${product.quantityOfMeasure}</td>
									<td>$ ${product.sellingPrice}</td>
									<c:set var="result"
										value="${product.sellingPrice * product.quantityOfMeasure}" />
									<td>$ ${result}</td>
									<c:set var="row_total" value="${row_total + result}" />
									<td class="text-center"><a href="/order/${loop.index}"
										class="remove_cart" rel="2"> <i
											class="glyphicon glyphicon-trash"></i>
									</a></td>
								</tr>
							</c:forEach>
						</c:if>
						<tr>
							<td colspan="6" align="right">Total</td>
							<td class="total" colspan="2">$ ${row_total}</td>
						</tr>
					</tbody>
				</table>
				<div class="btn-group">
					<button type="button" class="btn btn-primary"
						onclick="window.location='/'">
						<i class="glyphicon glyphicon-arrow-left"></i> Continue Shopping
					</button>
					<button type="button" class="btn btn-primary"
						onclick="window.location='/checkout'">
						<i class="glyphicon glyphicon-ok"></i> Checkout
					</button>
				</div>

			</div>
		</div>
	</c:if>
	<!-- End Cart -->
</div>

<%@include file="includes/footer.jsp"%>