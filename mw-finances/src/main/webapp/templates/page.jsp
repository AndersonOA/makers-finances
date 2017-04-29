<!DOCTYPE html>
<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator" prefix="dec"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html lang="pt-br">
	<head>
		<meta charset="UTF-8" />
		<meta http-equiv="X-UA-Compatible" content="IE=edge" />
    	<meta name="viewport" content="width=device-width,initial-scale=1,maximum-scale=1,user-scalable=0"/>
		<title><dec:title /></title>
		<meta name="description" content="O Helpeo é um sistema!"/>
        <meta name="robots" content="index, follow"/>
        <meta name="makers_api_version" content="<spring:message code="finances.api.version" />" />

        <link rel="shortcut icon" href="../_cdn/vendors/img/favicon.png" />
        <link href='https://fonts.googleapis.com/css?family=Open+Sans:300,400,600,700,800' rel='stylesheet' type='text/css'>
        <link href='https://fonts.googleapis.com/css?family=Source+Code+Pro:300,500' rel='stylesheet' type='text/css'>
		
		<link rel="stylesheet" href="../_cdn/vendors/css/makers-reset.css"/>        
        <link rel="stylesheet" href="../_cdn/vendors/css/makers-control.css"/>
		
	</head>
	<body>
	
		<dec:body />
		
		<script src="../_cdn/vendors/js/jquery.js"></script>
        <script src="../_cdn/vendors/js/makers-config.js"></script>
        <script src="../_cdn/vendors/js/makers-control.js"></script>
	</body>
</html>