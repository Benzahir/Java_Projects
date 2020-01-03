<%@include file="includes/header.jsp"%>
<div class="col-lg-9 col-md-9 col-sm-12">
	<div class="col-lg-12 col-sm-12">
		<span class="title"><h3>${product.name}</h3></span>
	</div>
	<div class="col-lg-12 col-sm-12 hero-feature">

		<div class="row">
			<div class="col-lg-6 col-md-6 col-sm-6">
				<!-- Main Image -->
				<div class="product-main-image-container">
					 <span
						class="thumbnail product-main-image"> 
							
								<a href="/detail/${product.id}" class="link-p"> <img
									src="/photos/cucina-fruitpassion.jpg"
									alt="">
								</a>
							
						
							
					</span>
				</div>
				<!-- End Main Image -->
			</div>

			<div class="visible-xs">
				<div class="clearfix"></div>
			</div>

			<div class="col-lg-6 col-md-6 col-sm-6">
				<div class="well product-short-detail">
					<div class="row">
						<div class="the-list">
							<h3 class="col-xs-12">$ ${product.sellingPrice}</h3>
						</div>
						<div class="the-list">
							<div class="col-xs-4">CompanyName</div>
							<div class="col-xs-8">
								<!-- <span class="red">OUT OF STOCK</span> -->
								<span class="green">${product.companyName}</span>
							</div>
						</div>
						<div class="clearfix"></div>
						<hr />
						<div class="col-xs-12 input-qty-detail">

							<form:form name="orders" modelAttribute="product" method="post"
								novalidate="true">
								<input name="quantityOfMeasure" class="form-control"
									placeholder="Enter Quantity" />
								<form:input type="hidden" path="name" />
								<form:input type="hidden" path="sellingPrice" />
								<%-- <input type="hidden" name="id" value="${product.id}" /> --%>
								<button class="btn btn-default pull-left" type="submit">
									<i class="glyphicon glyphicon-shopping-cart"></i> Add to Cart
								</button>
							</form:form>
						</div>
						<div class="clearfix"></div>
						<br />
						<div class="col-xs-12 add-to-detail">
							<div class="row"></div>
						</div>
					</div>
				</div>
			</div>

			<div class="clearfix"></div>
			<br clear="all" />

			<div class="col-xs-12 product-detail-tab">
				<!-- Nav tabs -->
				<ul class="nav nav-tabs">
					<li class="active"><a href="#desc" data-toggle="tab">Description</a></li>
				</ul>

				<!-- Tab panes -->
				<div class="tab-content">
					<div class="tab-pane active" id="desc">
						<div class="well">
							<p>${product.description}</p>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>

<%@include file="includes/footer.jsp"%>