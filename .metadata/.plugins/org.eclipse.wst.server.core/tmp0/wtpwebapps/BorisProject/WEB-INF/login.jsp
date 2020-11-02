<%@ page pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8" />
        <title>Login</title>
        <link type="text/css" rel="stylesheet" href="style.css" />
        <script type="text/javascript" src="test.js"></script> 
    </head>
    <body>
        <form method="post" action="login">
            <fieldset>
                <legend>Login</legend>

                <label for="email">Email <span class="requis">*</span></label>
                <input type="email" id="email" name="email" value="<c:out value="${email}"/>" size="20" maxlength="60" />
                <span class="erreur">${form.erreurs['email']}</span>
                <br />

                <label for="password">Password <span class="requis">*</span></label>
                <input type="password" id="password" name="password" value="" size="20" maxlength="20" />
                <span class="erreur">${form.erreurs['password']}</span>
                <br />


                <input type="submit" value="Login" class="sansLabel" />
                <br />
                
                <p class="${empty form.erreurs ? 'succes' : 'erreur'}">${form.resultat}</p>
                
                <%-- Vérification de la présence d'un objet utilisateur en session --%>
                <c:if test="${!empty sessionScope.userSession}">
                    <%-- Si l'utilisateur existe en session, alors on affiche son adresse email. --%>
                    <p class="succes">You are connected with the address : ${sessionScope.userSession.email}</p>
                </c:if>
                
            </fieldset>
        </form>
        <a href="<c:url value="registration"></c:url>">create an account</a>
    </body>
</html>