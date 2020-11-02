<%@ page pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8" />
        <title>Edit user</title>
        <link type="text/css" rel="stylesheet" href="<c:url value="style.css"/>" />
    </head>
    <body>
      <form method="post" action="editUser">
        <c:import url="home.jsp" />
        <div id="corps">
            <p class="info">${ message }</p>
            <c:if test="${ !erreur }">
                <p>Name : <c:out value="${ userToEdit.name }"/></p>
                <p>Firstname : <c:out value="${ userToEdit.firstname }"/></p>
                <p>Adress : <c:out value="${ userToEdit.adress }"/></p>
                <p>Telephon : <c:out value="${ userToEdit.telephon }"/></p>
                <p>Email : <c:out value="${ userToEdit.email }"/></p>                        
                
            </c:if>
            
        </div>
        
	        <fieldset>
	                <legend>Edit formular</legend>
	                
					<%--<label for="email">Email adress <span class="requis">*</span></label>
	                <input type="email" id="email" name="eemail" value="<c:out value="${user2.email}"/>"  />
	                <span class="erreur">${form.erreurs['eemail']}</span>
	                <br /> --%>
	                
	
	                <label for="name">Lastname</label>
	                <input type="text" id="name" name="ename" value="<c:out value="${user2.name}"/>"  />
	                <span class="erreur">${form.erreurs['ename']}</span>
	                <br />
	                
	                 <label for="firstname">Firstname</label>
	                <input type="text" id="firstname" name="efirstname" value="<c:out value="${user2.firstname}"/>"  />
	                <span class="erreur">${form.erreurs['efirstname']}</span>
	                <br />
	                
	                 <label for="adress">Adress</label>
	                <input type="text" id="adress" name="eadress" value="<c:out value="${user2.adress}"/>" />
	                <span class="erreur">${form.erreurs['eadress']}</span>
	                <br />
	                
	                 <label for="telephon">Telephon number</label>
	                <input type="text" id="telephon" name="etelephon" value="<c:out value="${user2.telephon}"/>"  />
	                <span class="erreur">${form.erreurs['etelephon']}</span>
	                <br />
	                
	                <label for="password">Password <span class="requis">*</span></label>
	                <input type="password" id="password" name="epassword" value=""  />
	                <span class="erreur">${form.erreurs['epassword']}</span>
	                <br />
	
	                <label for="passwordConf">Password confirmation <span class="requis">*</span></label>
	                <input type="password" id="passwordConf" name="epasswordConf" value=""  />
	                <span class="erreur">${form.erreurs['epasswordConf']}</span>
	                <br />
	
	                <input type="submit" value="Registration" class="sansLabel" />
	                <br />
	                
	                
	                <c:if test="${ !erreur }">
	                     <p class="${empty form.erreurs ? 'succes' : 'erreur'}">${form.resultat}</p>                  
                
            		</c:if>
	            </fieldset>
            <div>
        </div>
      </form>
      
      <script >
        /**
         * 
         */

        // Fonction de désactivation de l'affichage des "tooltips"
        function deactivateTooltips() {

            var tooltips = document.querySelectorAll('.tooltip'),
                tooltipsLength = tooltips.length;

            for (var i = 0; i < tooltipsLength; i++) {
                tooltips[i].style.display = 'none';
            }

        }


        // La fonction ci-dessous permet de récupérer la "tooltip" qui correspond à notre input

        function getTooltip(elements) {

            while (elements = elements.nextSibling) {
                if (elements.className === 'tooltip') {
                    return elements;
                }
            }

            return false;

        }


        // Fonctions de vérification du formulaire, elles renvoient "true" si tout est ok

        var check = {}; // On met toutes nos fonctions dans un objet littéral

        check['sex'] = function() {

            var sex = document.getElementsByName('sex'),
                tooltipStyle = getTooltip(sex[1].parentNode).style;

            if (sex[0].checked || sex[1].checked) {
                tooltipStyle.display = 'none';
                return true;
            } else {
                tooltipStyle.display = 'inline-block';
                return false;
            }

        };

        check['name'] = function(id) {

            var name = document.getElementById(id),
                tooltipStyle = getTooltip(name).style;

            if (name.value.length >= 2) {
                name.className = 'correct';
                tooltipStyle.display = 'none';
                return true;
            } else {
                name.className = 'incorrect';
                tooltipStyle.display = 'inline-block';
                return false;
            }

        };

        check['firstname'] = check['name']; // La fonction pour le prénom est la même que celle du nom

        check['age'] = function() {

            var age = document.getElementById('age'),
                tooltipStyle = getTooltip(age).style,
                ageValue = parseInt(age.value);

            if (!isNaN(ageValue) && ageValue >= 5 && ageValue <= 140) {
                age.className = 'correct';
                tooltipStyle.display = 'none';
                return true;
            } else {
                age.className = 'incorrect';
                tooltipStyle.display = 'inline-block';
                return false;
            }

        };

        check['login'] = function() {

            var login = document.getElementById('login'),
                tooltipStyle = getTooltip(login).style;

            if (login.value.length >= 4) {
                login.className = 'correct';
                tooltipStyle.display = 'none';
                return true;
            } else {
                login.className = 'incorrect';
                tooltipStyle.display = 'inline-block';
                return false;
            }

        };

        check['password'] = function(id) {

            var pwd1 = document.getElementById(id),
                tooltipStyle = getTooltip(pwd1).style;

            if (pwd1.value.length >= 5) {
                pwd1.className = 'correct';
                tooltipStyle.display = 'none';
                return true;
            } else {
                pwd1.className = 'incorrect';
                tooltipStyle.display = 'inline-block';
                return false;
            }

        };

        check['passwordConf'] = function() {

            var pwd1 = document.getElementById('password'),
                pwd2 = document.getElementById('passwordConf'),
                tooltipStyle = getTooltip(pwd2).style;

            if (pwd1.value == pwd2.value && pwd2.value != '') {
                pwd2.className = 'correct';
                tooltipStyle.display = 'none';
                return true;
            } else {
                pwd2.className = 'incorrect';
                tooltipStyle.display = 'inline-block';
                return false;
            }

        };
        
        check['adress'] = check['password']; // La fonction pour l adresse est la même que celle du mot de passe

        check['country'] = function() {

            var country = document.getElementById('country'),
                tooltipStyle = getTooltip(country).style;

            if (country.options[country.selectedIndex].value != 'none') {
                tooltipStyle.display = 'none';
                return true;
            } else {
                tooltipStyle.display = 'inline-block';
                return false;
            }

        };


        // Mise en place des événements

        (function() { // Utilisation d'une IIFE pour éviter les variables globales.

            var myForm = document.getElementById('myForm'),
                inputs = document.querySelectorAll('input[type=text], input[type=password]'),
                inputsLength = inputs.length;

            for (var i = 0; i < inputsLength; i++) {
                inputs[i].addEventListener('keyup', function(e) {
                    check[e.target.id](e.target.id); // "e.target" représente l'input actuellement modifié
                });
            }

            myForm.addEventListener('submit', function(e) {

                var result = true;

                for (var i in check) {
                    result = check[i](i) && result;
                }

                if (result) {
                    alert('Le formulaire est bien rempli.');
                }

                e.preventDefault();

            });

            myForm.addEventListener('reset', function() {

                for (var i = 0; i < inputsLength; i++) {
                    inputs[i].className = '';
                }

                deactivateTooltips();

            });

        })();




        // Maintenant que tout est initialisé, on peut désactiver les "tooltips"

        deactivateTooltips();

        function myFunct(email){
        	alert(pppp);
        }
        </script>
      
      
    </body>
</html>