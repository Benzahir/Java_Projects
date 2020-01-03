<%-- <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%> --%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<!DOCTYPE html>
<html lang="en">
<head>

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">

<title>Tecma - Admin</title>

<!-- Bootstrap Core CSS -->
<link href="/public/bootstrap/css/bootstrap.min.css" rel="stylesheet">

<!-- Custom CSS -->
<link href="/public/bootstrap/css/modern-business.css" rel="stylesheet">
<link href="/public/bootstrap/css/custom.css" rel="stylesheet">

<!-- datepicker css -->
<link rel="stylesheet" href="/public/bootstrap/css/jquery-ui.css">

<!-- Custom Fonts -->
<link href="/public/bootstrap/css/font-awesome.min.css" rel="stylesheet"
	type="text/css">

<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

</head>
<body>
	<div class="navbar navbar-inverse navbar-fixed-top" role="navigation">
		<div class="container">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle" data-toggle="collapse"
					data-target=".navbar-collapse">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="/"> Tecma </a>
			</div>
			<div class="navbar-collapse collapse">
				<ul class="nav navbar-nav">
					<sec:authorize
						access="hasRole('ROLE_SUPERADMIN') || hasRole('ROLE_ADMIN') || hasRole('ROLE_SALESENGINEER')">
						<li><a href="/">Dashboard</a></li>
						<li><a href="/admin/product/list">Products</a></li>
					</sec:authorize>
					<sec:authorize access="hasRole('ROLE_SUPERADMIN')">
						<li><a href="/admin/user/list">Users</a></li>
					</sec:authorize>
					<li><a href="/admin/orders">Orders</a></li>
				</ul>
				<ul class="nav navbar-nav navbar-right">
					<li></li>
				</ul>
				<ul class="nav navbar-nav navbar-right">
					<li class="dropdown"><a href="#" class="dropdown-toggle"
						data-toggle="dropdown"><i class="glyphicon glyphicon-cog"></i>
							Settings <b class="caret"></b></a>
						<ul class="dropdown-menu" role="menu">
							<li><a href="/admin/user/change-password"> <span
									class="glyphicon glyphicon-cog"></span> Change password
							</a></li>
							<li class="divider"></li>
							<li><a id="logoutForm" href="/logout"> <i
									class="glyphicon glyphicon-log-out"></i> logout
							</a></li>
						</ul></li>
				</ul>
			</div>
		</div>
	</div>
	<div class="container">
		<div class="row">
			<div class="col-xs-12">
				<div id="page-content">
					<sec:authorize access="hasRole('ROLE_UNVERIFIED')">
						<div class="alert alert-warning alert-dismissable">
							<button type="button" class="close" data-dismiss="alert"
								aria-hidden="true">&times;</button>
							Your email id is unverified. <a href="/admin/users/resend">Click
								here</a> to get the verification mail again.
						</div>
					</sec:authorize>
					<c:if test="${not empty flashMessage}">
						<div class="alert alert-${flashkind} alert-dismissible">
							<button type="button" class="close" data-dismiss="alert"
								aria-hidden="true">&times;</button>
							${flashMessage}
						</div>
					</c:if>