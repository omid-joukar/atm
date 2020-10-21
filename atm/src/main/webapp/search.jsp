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
  </head>

<body style="background-color: tan;">
      <legend><b>search</b></legend><br /><br /><br />
      <form action="/search_account" method="post" >



          <label for="accountNumber"> Account Number: </label></br>
          <input type="text" name="accountNumber" id="accountNumber" required/> <br /><br />

          <label for="cardNummber">Card Nummber:</label></br>
          <input type="text" name="cardNummber" id="cardNummber" required/> <br /><br />

           <br /><br /><br />

         

          <input type="submit" value="send" /> <br /><br />
          <input type="reset" value="reset" /> <br />


      </form>

</body>
</html>