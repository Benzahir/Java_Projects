<%@include file="includes/header.jsp"%>
<div class="page-header">
	<h2>Check Out</h2>
</div>
<c:if test="${orders.size() == 0 or orders == null}">
	<div class="alert alert-info" role="alert">
		<strong>orders Empty!</strong> Your orders currently Empty!
	</div>
</c:if>
<c:if test="${orders.size() ne 0 and orders ne null}">
	<form:form modelAttribute="booking" method="post">
		<div class="col-lg-9 col-md-9 col-sm-12">
			<div class="col-lg-12 col-sm-12">
				<span><b>Shipping Address</b></span>
			</div>
			<div class="col-lg-12 col-sm-12 hero-feature">
				<table class="table table-bordered tbl-checkout">
					<tbody>
						<tr>
							<td>First Name</td>
							<td><form:input type="text" path="firstName"
									class="form-control" /> <form:errors cssClass="error"
									path="firstName">
								</form:errors></td>
							<td>Last Name</td>
							<td><form:input type="text" path="lastName"
									class="form-control" /> <form:errors cssClass="error"
									path="lastName">
								</form:errors></td>
						</tr>
						<tr>
							<td>Email</td>
							<td><form:input type="text" path="email"
									class="form-control" /> <form:errors cssClass="error"
									path="email">
								</form:errors></td>
							<td>Telephone</td>
							<td><form:input type="text" path="phoneNumber"
									class="form-control" /> <form:errors cssClass="error"
									path="phoneNumber">
								</form:errors></td>
						</tr>
						<tr>
							<td>Address</td>
							<td colspan="3"><form:textarea path="address"
									class="form-control"></form:textarea> <form:errors
									cssClass="error" path="address">
								</form:errors></td>
						</tr>
						<tr>
							<td>City</td>
							<td><form:input type="text" path="city" class="form-control" />
								<form:errors cssClass="error" path="city">
								</form:errors></td>
							<td>State</td>
							<td><form:input type="text" path="state"
									class="form-control" /> <form:errors cssClass="error"
									path="state">
								</form:errors></td>
						</tr>
						<tr>
							<td>Country</td>
							<td><form:input type="text" path="country"
									class="form-control" /> <form:errors cssClass="error"
									path="country">
								</form:errors></td>
						</tr>
					</tbody>
				</table>
			</div>
		</div>
		<%-- <c:if test="${orders.size() ne 0 and orders ne null}"> --%>
		<div class="col-lg-9 col-md-9 col-sm-12">
			<div class="col-lg-12 col-sm-12">
				<span class="title">SHOPPING CART</span>
			</div>
			<div class="col-lg-12 col-sm-12 hero-feature">
				<table class="table table-bordered tbl-cart">
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
							<form:form>
								<c:forEach var="product" items="${orders}" varStatus="loop">
									<tr>
										<td><a href="/detail">${product.name}</a></td>
										<td>${product.quantityOfMeasure}</td>
										<td>$ ${product.sellingPrice}</td>
										<c:set var="result"
											value="${product.sellingPrice * product.quantityOfMeasure}" />
										<td>${result}</td>
										<c:set var="row_total" value="${row_total + result}" />
										<td class="text-center"><a href="/orders/${loop.index}"
											class="remove_orders" rel="2"> <i
												class="glyphicon glyphicon-trash"></i>
										</a></td>
									</tr>
									<input type="hidden" name="totalPrice" value="${result}" />
								</c:forEach>
							</form:form>
						</c:if>
						<tr>
							<td colspan="6" align="right">Total</td>
							<td class="total" colspan="2"><b>$ ${row_total}</b></td>
						</tr>
					</tbody>
				</table>
				<div class="btn-group btns-cart">
					<button type="button" class="btn btn-primary"
						onclick="window.location='/product'">
						<i class="glyphicon glyphicon-arrow-left"></i> Continue Shopping
					</button>
					<button type="submit" class="btn btn-primary">
						<i class="glyphicon glyphicon-ok"></i> Book Now
					</button>
				</div>

			</div>
		</div>
	</form:form>
</c:if>
<!-- End Cart -->

<%@include file="includes/footer.jsp"%>