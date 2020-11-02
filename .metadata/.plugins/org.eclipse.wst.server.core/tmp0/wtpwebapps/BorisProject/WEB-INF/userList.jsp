<%@ page pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8" />
        <title>Registered User</title>
        <link type="text/css" rel="stylesheet" href="<c:url value="style.css"></c:url>" />
        <script type="text/javascript" src="test.js"></script>
    </head>
    <body>
    	<%-- <form method="get"  action="userList"> --%>
       <c:import url="home.jsp" ></c:import>
        <div id="corps"> 
        <c:choose>
            <%-- Si aucun client n'existe en session, affichage d'un message par défaut. --%>
            <c:when test="${ empty sessionScope.users }">
                <p class="erreur">No User registered.</p>
            </c:when>
            <%-- Sinon, affichage du tableau. --%>
            <c:otherwise>
            <table>
                <tr>
                    <th>Name</th>
                    <th>Firstname</th>
                    <th></th>
                    <th></th>
 
                    <th class="action"></th>                    
                </tr>
                <%-- Parcours de la Map des clients en session, et utilisation de l'objet varStatus. --%>
                <c:forEach items="${ userList }" var="mapUsers" varStatus="boucle">
                <%-- Simple test de parité sur l'index de parcours, pour alterner la couleur de fond de chaque ligne du tableau. --%>
                <tr class="${boucle.index % 2 == 0 ? 'pair' : 'impair'}">
                    <%-- Affichage des propriétés du bean Client, qui est stocké en tant que valeur de l'entrée courante de la map --%>
                    <td><c:out value="${ mapUsers.name }"></c:out></td>
                    <td><c:out value="${ mapUsers.firstname }"></c:out></td>
                    <%-- <td><c:out value="${ mapUsers.value.firstname }"></c:out></td> --%>

                  
                   
                   <td><a href="<c:url value="userDetails"><c:param name="idUser" value="${ mapUsers.id }" /></c:url>">details</a></td> 
                   <%-- <td><a href="<c:url value="userDetails"><c:param name="idUser" value="${ mapUsers.key }" /></c:url>">details</a></td>  --%>
                    
                     <%-- Lien vers la servlet de suppression, avec passage du nom du client - c'est-à-dire la clé de la Map - en paramètre grâce à la balise <c:param></c:param>. --%>
                    <td><a onclick="return confirm('Are you sure?')" href="<c:url value="deleteUser"><c:param name="idUser" value="${ mapUsers.id }" /></c:url>">delete</a></td>
                    <%-- <td><a onclick="return confirm('Are you sure?')" href="<c:url value="deleteUser"><c:param name="idUser" value="${ mapUsers.key }" /></c:url>">delete</a></td> --%>
          
                </tr>
                </c:forEach>
            </table>
            </c:otherwise>
        </c:choose>
        
        <br/>
        
        <br />
        
        </div>
        <%-- </form> --%>
    </body>
</html>