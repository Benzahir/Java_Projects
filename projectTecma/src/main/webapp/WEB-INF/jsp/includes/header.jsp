<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<!DOCTYPE html>
<html lang="en">
	<head>	
		<meta charset="utf-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<meta name="description" content="">
		<meta name="author" content="">
		
		<title>TECMA - Home</title>
		
		<!-- Bootstrap Core CSS -->
		<link href="/public/bootstrap/css/bootstrap.min.css" rel="stylesheet">
		
		<!-- Custom CSS -->
		<link href="/public/bootstrap/css/modern-business.css" rel="stylesheet">
		<link href="/public/bootstrap/css/custom.css" rel="stylesheet">
		
		<!-- Custom Fonts -->
		<link href="/public/bootstrap/font-awesome/css/font-awesome.min.css"
			rel="stylesheet" type="text/css">
		
	</head>

<body>

	<!-- Navigation -->
	<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
		<div class="container">
			<!-- Brand and toggle get grouped for better mobile display -->
			<div class="navbar-header">
				<button type="button" class="navbar-toggle" data-toggle="collapse"
					data-target="#bs-example-navbar-collapse-1">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="/">TECMA</a>
			</div>
			<!-- Collect the nav links, forms, and other content for toggling -->
			<div class="collapse navbar-collapse"
				id="bs-example-navbar-collapse-1">
				<ul class="nav navbar-nav navbar-right">
					<li><a href="/">Home</a></li>
					<li><a href="/order">Cart</a></li>
					<li><a href="/contact">Contact</a></li>
				<sec:authorize access="isAnonymous()">
			        <li>
			        	<a href="<c:url value='/signup' />"><span class="glyphicon glyphicon-list-alt"></span> Sign up</a>
			        </li>
			        <li>
		                <a href="/login">Sign in <span class="glyphicon glyphicon-log-in"></span></a>
		            </li>
         		</sec:authorize>
				</ul>
			</div>
			<!-- /.navbar-collapse -->
		</div>
		<!-- /.container -->
	</nav>

	<!-- Page Content -->
	<div class="container">
			<div class="row">
				<div class="col-xs-12">
					<div id="page-content">
						<c:if test="${not empty flashMessage}">
							<div class="alert alert-${flashkind} alert-dismissible">
								<button type="button" class="close" data-dismiss="alert"
									aria-hidden="true">&times;</button>
								${flashMessage}
							</div>
						</c:if>