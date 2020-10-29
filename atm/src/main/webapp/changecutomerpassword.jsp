<%@ page import="model.Accounts" %><%--
  Created by IntelliJ IDEA.
  User: omid
  Date: 10/6/2020
  Time: 7:16 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Change Password</title>
     <link rel="stylesheet" type="text/css" href="resources/table_input_style_sheet.css">
</head>
<body>
<
<form action="/customer_change_password" method="post">
<div class="boxbase">
           
           
           
       <div class="boxleft">

<%
    Accounts accounts = (Accounts) session.getAttribute("accounts");
    if (accounts == null){
        response.sendError(HttpServletResponse.SC_BAD_REQUEST);
    }
%>
<table>
    <tr>
        <th>Account Id</th>
        <th>Account Name</th>
        <th>Account Number</th>
    </tr>
    <tr>
        <td><%=accounts.getAccountId()%></td>
        <td><%=accounts.getAccountName()%></td>
        <td><%=accounts.getAccountNumber()%></td>
    </tr>
</table>
</div>
<form method="post">

          <div class="boxright">
              
              <img class="rotatepic"  src="WEB-PICTURES/changepasswordasl.png">
              
               
        <input class="target" type="text" name="accountPassword" id="accountPssword" placeholder="account password"/><br/>
        <input class="balance" type="text" name="accountNewPassword" id="accountNewPassword"placeholder="new account password" /><br/>
        <input class="transfer" type="submit" value="change password"/>
        <br/>
        </div> 
    </form>
    </div> 
</form>
</body>
</html>
