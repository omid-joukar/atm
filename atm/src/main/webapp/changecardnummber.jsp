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
      <title>Changebankcard</title>
      <link rel="stylesheet" type="text/css" href="resources/form_style_sheet.css">
  </head>

<body>
<div class="boxbase">

      <legend>Change Bank Card</legend><br />
      <form action="/customer_change_card" method="post" >




          <input type="text" name="userName" id="userName" required placeholder="user name"/> <br />

          
          <input type="text" name="userFamily" id="userFamily" required placeholder="family"/> <br />
          
          <input type="text" name="email" id="email" required placeholder="email"/> <br />

          <input type="text" name="cardnummber" id="cardnummber" required placeholder="card number"/> <br />

         

          <input type="submit" value="send" class="button" /> <br />
         


      </form>
</div>
</body>
</html>