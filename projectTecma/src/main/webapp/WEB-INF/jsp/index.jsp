<%@include file="includes/header.jsp"%>

<div class="container">

	<div class="row">
		<div class="col-xs-12">
			<div class="col-lg-3 col-md-3 col-sm-12">

				<!-- Categories -->
				<div class="col-lg-12 col-md-12 col-sm-6">
					<div class="no-padding">
						<span class="title">Feedbacks</span>
					</div>

					<div id="main_menu">
						<div class="list-group panel panel-cat">

							<a href="" class="list-group-item">News</a>
						</div>
					</div>
				</div>
			</div>

			<div class="col-lg-9 col-md-9 col-sm-9 col-xs-9">
				<div class="col-lg-12 col-sm-12">
					<span class="title">FEATURED PRODUCTS</span>
				</div>

				<c:forEach var="product" items="${products}">
					<div class="col-lg-4 col-sm-4 col-xs-4 hero-feature text-center">
						<div class="thumbnail img-responsive">
							
								
								
									<a href="/product/${product.id}/detail" class="link-p"> <img
										src="/photos/cucina-fruitpassion.jpg"
										alt="">
									</a>
								
							
							
							<div class="caption prod-caption">
								<h4>
									<a href="/product/${product.id}/detail">${product.name}</a>
								</h4>
								<div class="btn-group">
									<a href="" class="btn btn-default">$
										${product.sellingPrice}</a> <a href="" class="btn btn-primary"><i
										class="glyphicon glyphicon-shopping-cart"></i> Buy</a>
								</div>
							</div>
						</div>
					</div>
				</c:forEach>
			</div>
		</div>
	</div>
</div>
<%@include file="includes/footer.jsp"%>