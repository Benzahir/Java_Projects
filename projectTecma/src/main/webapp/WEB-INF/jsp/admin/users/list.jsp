<%@include file="../includes/header.jsp"%>
<div class="container">
	<div class="row visible-on">
		<div class="col-md-12">
			<div class="page-header">
				<div class="pull-right"><a href="/admin/user/create" class="btn btn-primary"><i class="glyphicon glyphicon-pencil"></i> Add Users</a></div>
				<h3>Users</h3>
			</div>
		</div>
	</div>

	<div class="row visible-on">
		<div class="col-md-12">
			<div class="table-responsive">
				<c:choose>
					<c:when test="${users.size() > 0}">
						<table
							class="table table-striped table-bordered table-condensed table-hover">
							<thead>
								<tr class="info">
									<th>First Name</th>
									<th>Last Name</th>
									<th>Email</th>
									<th>Role</th>
									<th>Actions</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach var="user" items="${users}">
									<c:forEach var="role" items="${user.roles}">
										<tr>
											<td>${user.firstName}</td>
											<td>${user.lastName}</td>
											<td>${user.email}</td>
											<td>${role}</td>
											<td><a href="/admin/user/${user.id}/edit"
												class="btn btn-xs btn-success" data-toggle="tooltip"
												data-placement="top" title="Edit"> <i
													class="glyphicon glyphicon-edit"></i>
											</a> <a href="/admin/user/${user.id}/show"
												class="btn btn-xs btn-info" title="show"
												data-toggle="tooltip" data-placement="top"> <i
													class="glyphicon glyphicon-eye-open"></i>
											</a> <a href="/admin/user/${user.id}/delete"
												class="btn btn-xs btn-danger" title="Delete"
												data-toggle="tooltip" data-placement="top"> <i
													class="glyphicon glyphicon-trash"></i>
											</a></td>
										</tr>
									</c:forEach>
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