<%--
  Created by IntelliJ IDEA.
  User: omid
  Date: 10/13/2020
  Time: 12:35 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create Account</title>
</head>
<body>
<form action="/create_account" method="post">
    <label for="accountName">Account Name :</label>
    <input type="text" id="accountName" name="accountName"></br>
    <label for="accountNumber">Account Number :</label>
    <input type="text" id="accountNumber" name="accountNumber"></br>
    <label for="accountPassword">Account Password :</label>
    <input type="text" id="accountPassword" name="accountPassword"></br>
    <label for="cardnummber">Card Nummber :</label>
    <input type="text" id="cardnummber" name="cardnummber"></br>
    <label for="balance">Balance :</label>
    <input type="text" id="balance" name="balance"></br>
    <label for="firstName">First Name :</label>
    <input type="text" id="firstName" name="firstName"></br>
    <label for="lastName">Last Name :</label>
    <input type="text" id="lastName" name="lastName"></br>
    <label for="address">Address :</label>
    <input type="text" id="address" name="address"></br>
    <label for="telefonnumber">Telefon Number :</label>
    <input type="text" id="telefonnumber" name="telefonnumber"></br>
    <label for="email">Email :</label>
    <input type="text" id="email" name="email"></br>
    <label for="jobTitle">Job Title :</label>
    <input type="text" id="jobTitle" name="jobTitle"></br>
    <input type="submit" value="Create">

</form>
</body>
</html>
