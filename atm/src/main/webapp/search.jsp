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
      <title>Search Account</title>
      <link rel="stylesheet" type="text/css" href="resources/search_style_sheet.css">
  </head>

<body>
      <div class="boxbase">
     
      <form action="/search_account" method="post" >
          
          <input class="inputt1" type="text" name="accountNumber" id="accountNumber" required placeholder="account number"/> <br />

          <input class="inputt2" type="text" name="cardNummber" id="cardNummber" placeholder="card number" required/><br/>

         

          <input class="button" type="submit" value="search" /> <br /><br />
         
          
          <img src="WEB-PICTURES/search.gif">
          
        


      </form>
</div>
</body>
</html>