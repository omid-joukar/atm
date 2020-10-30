<%--
  Created by IntelliJ IDEA.
  User: omid
  Date: 10/13/2020
  Time: 12:35 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link rel="stylesheet" type="text/css" href="resources/form_style_sheet.css">
<html>
<head>
    <title>Create Account</title>
</head>
<body>
<div class="boxbase2">
<form action="/create_account" method="post">


      <legend>Creating Bank Account For Customer</legend><br />
      <form action="/customer_change_card" method="post" >




           <input type="text" id="accountName" name="accountName" placeholder="account name"><br/>
    <input type="text" id="accountNumber" name="accountNumber" placeholder="account number"><br/>
    
    <input type="text" id="accountPassword" name="accountPassword" placeholder="password"><br/>
    <input type="text" id="cardnummber" name="cardnummber" placeholder="card number"><br/>
    <input type="text" id="balance" name="balance" placeholder="balance"><br/>
    <input type="text" id="firstName" name="firstName" placeholder="first name"><br/>
    
    <input type="text" id="lastName" name="lastName" placeholder="last name"><br/>

    <input type="text" id="address" name="address" placeholder="address"><br/>
    
    <input type="text" id="telefonnumber" name="telefonnumber" placeholder="telefone number"><br/>
    
    <input type="text" id="email" name="email" placeholder="email"><br/>
   
    <input type="text" id="jobTitle" name="jobTitle" placeholder="job title"><br/>
    <input class="button" type="submit" value="Create">

      </form>
    </form>
</div>
</body>
</html>
