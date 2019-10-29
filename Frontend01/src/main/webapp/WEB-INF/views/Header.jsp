<%@ page language="java" contentType="text/html"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html"%>
<title>${pageinfo} eshop</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" ></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>

</head>
		

<body>


<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="#">eshop</a>
 	</div>

    <ul class="nav navbar-nav"> 
      <li><a href="<c:url value="/home"/>">HOME</a></li>
      <li><a href="<c:url value="/login"/>">LOGIN</a></li>
      <li><a href="<c:url value="/register"/>">REGISTER</a></li>
      <li><a href="<c:url value="/contactus"/>">CONTACTUS</a></li>
      <li><a href="<c:url value="/aboutus"/>">ABOUTUS</a></li>
      <li><a href="<c:url value="/category"/>">Manage Category</a></li>
      <li><a href="<c:url value="/supplier"/>">Manage Supplier</a></li>
                         
        </ul>
 
 <div align="right">
<a href="" class="btn btn-danger">Logout</a>
</div>
</div>
</nav>

</body>
</html>