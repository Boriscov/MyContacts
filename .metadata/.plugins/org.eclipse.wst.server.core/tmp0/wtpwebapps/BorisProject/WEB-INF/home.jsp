<%@ page pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div id="home">
    <p><a href="<c:url value="/registration"/>">create a new user</a></p>
    <p><a href="<c:url value="/userList"/>">list of existing user</a></p>
</div>
<a onclick="return confirm('Are you sure?')" href="<c:url value="logout"/>">Logout</a>