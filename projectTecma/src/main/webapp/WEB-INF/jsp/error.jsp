<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fd" %>
 <%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
 <%@ taglib prefix="m" uri="http://java.sun.com/jsp/jstl/core"%>
<%@include file="includes/header.jsp"%>

<div class="container">
    <div class="row">
        <div class="col-md-12">
            <div class="error-template col-md-offset-4" style="padding-top:100px">
                <h1>Oops!</h1>
                <h2>${status}</h2>
                <div class="error-details">
                    There was an unexpected error ${error} <i>${message}</i>
                </div>
                <div class="error-actions">
                    <a href="/" class="btn btn-primary btn-lg"><span class="glyphicon glyphicon-home"></span>
                        Take Me Home </a><a href="/contact" class="btn btn-default btn-lg"><span class="glyphicon glyphicon-envelope"></span> Contact Support </a>
                </div>
            </div>
        </div>
    </div>
</div>
<!-- Important Code for Showing error messages as per the error codes -->
	
		<%-- <div class="alert alert-danger">
				<p>There was an unexpected error (type=${error}, status=${status}): <i>${message}</i></p>
				<p>Click <a href="/">here</a> to go to home page</a></p>
			</div>
	
			<c:if test="${status == 403}"> 
				You are not authorised to Access this page ! </br> Please contact site Administrator for help! 
			</c:if> --%>
</br></br></br>		
<%@include file="includes/footer.jsp"%>