<%@include file="includes/header.jsp"%>
	<h1>Hello</h1>
	<sec:authorize access="hasRole('ROLE_UNVERIFIED')">
		<h1>UNVERIFIED</h1>
	</sec:authorize>
	
	<sec:authorize access="hasRole('ROLE_CUSTOMER')">
		<h1>CUSTOMER</h1>
	</sec:authorize>
	
	<sec:authorize access="hasRole('ROLE_SALESENGINEER')">
		<h1>Sales Engineer</h1>
	</sec:authorize>
	
	<sec:authorize access="hasRole('ROLE_ADMIN')">
		<h1>ADMIN</h1>
	</sec:authorize>
	
	<sec:authorize access="hasRole('ROLE_SUPERADMIN')">
		<h1>ROLE_SUPERADMIN</h1>
	</sec:authorize>
	
<%@include file="includes/footer.jsp"%>