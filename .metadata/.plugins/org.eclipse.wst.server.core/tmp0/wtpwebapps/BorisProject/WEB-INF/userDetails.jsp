<%@ page pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8" />
        <title>User card</title>
        <link type="text/css" rel="stylesheet" href="<c:url value="style.css"/>" />
    </head>
    <body>
        <c:import url="home.jsp" />
        <div id="corps">
            <p class="info">${ message }</p>
            <c:if test="${ !erreur }">
                <p>Name : <c:out value="${ userDetails.name }"/></p>
                <p>Firstname : <c:out value="${ userDetails.firstname }"/></p>
                <p>Adress : <c:out value="${ userDetails.adress }"/></p>
                <p>Telephon : <c:out value="${ userDetails.telephon }"/></p>
                <p>Email : <c:out value="${ userDetails.email }"/></p>                        
                
            </c:if>
        </div>
        <%-- Lien vers la servlet de suppression, avec passage du nom du client - c'est-à-dire la clé de la Map - en paramètre grâce à la balise <c:param></c:param>. --%>
                   
        <a href="<c:url value="editUser"><c:param name="idUser" value="${ userDetails.id }" /></c:url>">Edit</a>
                   
                   
    </body>
</html>