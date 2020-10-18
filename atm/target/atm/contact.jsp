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
</head>
<body style="background-color: MistyRose;">
<legend><b>CONTACT</b></legend><br /><br /><br />
<form action="/user_contact" method="post" >
    <label for="userName"> Name:</label></br>
    <input type="text" name="userName" id="userName" required/> <br /><br />
    <label for="userFamily"> Family:</label></br>
    <input type="text" name="userFamily" id="userFamily" required/> <br /><br />
    <label for="email"> Email:</label></br>
    <input type="text" name="email" id="email" required/> <br /><br /><br />

    <label for="textArea"> Text:</label></br>
    <textarea name="textArea" id="textArea" rows="10" cols="100" >

		</textarea><br /><br /><br /><br />

    <input type="submit" value="send" /> <br /><br />
    <input type="reset" value="reset" /> <br />
</form>

</body>
</html>
