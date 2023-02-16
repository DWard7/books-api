<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- c:out ; c:forEach etc. --> 
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!-- Formatting (dates) --> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"  %>
<!-- form:form -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!-- for rendering errors on PUT routes -->
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Books</title>
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="/css/main.css"> <!-- change to match your file/naming structure -->
    <script src="/webjars/jquery/jquery.min.js"></script>
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="/js/app.js"></script><!-- change to match your file/naming structure -->
</head>
<body>
  <h1>Add a Book</h1>
  <form:form action="/books" method="post" modelAttribute="book">
    <div class="form-control">
      <form:label path="title">Title</form:label>
      <form:input path="title"></form:input>
    </div>
      <div class="form-control">
        <form:label path="author">Author</form:label>
        <form:input path="author"></form:input>
      </div>
      <div class="form-control">
        <form:label path="pages">Pages</form:label>
        <form:input path="pages"></form:input>
      </div>
      <button type="submit" class="btn btn-outline-primary">Submit</button>
  </form:form>

</body>
</html>