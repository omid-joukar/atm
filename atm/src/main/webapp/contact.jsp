<%--
  Created by IntelliJ IDEA.
  User: omid
  Date: 10/6/2020
  Time: 7:18 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Contact</title>
    <link rel="stylesheet" type="text/css" href="resources/form_style_sheet.css">
</head>
<body>
<div class="boxbase">
<legend>Contact</legend><br />
<form action="/user_contact" method="post" >
   <input type="text" name="userName" id="userName" placeholder="user name" required/> <br/>
    
    <input type="text" name="userFamily" id="userFamily" placeholder="family" required><br />
    
    <input type="text" name="email" id="email"
    placeholder="email" required><br />

    
    <textarea name="textArea" id="textArea" placeholder="please neter your message here!" >

		</textarea><br/>

    <input class="button" type="submit" value="send" > <br/>
</form>
    </div>
</body>
</html>
