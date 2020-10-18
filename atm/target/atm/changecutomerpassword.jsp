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
</head>
<body>
<
<form action="/customer_change_password" method="post">

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
<form method="post">
<table>
<tr>
    <td>
        <label for="accountPssword">Account Password :</label>
    </td>
    <td>
        <input type="text" name="accountPassword" id="accountPssword"/>
    </td>
</tr>
<tr>
    <td>
        <label for="accountNewPassword">Account new Password :</label>
    </td>
    <td>
        <input type="text" name="accountNewPassword" id="accountNewPassword" />
    </td>
</tr>
<tr>
    <td>
        <input type="submit" value="change password"/>
    </td>
</tr>
</table>
</form>
</form>
</body>
</html>
