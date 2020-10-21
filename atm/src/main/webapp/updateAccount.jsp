<%@ page import="model.Accounts" %>
<%@ page import="java.util.List" %>
<%@ page import="model.Customers" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: omid
  Date: 10/18/2020
  Time: 8:09 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit Account</title>
</head>
<body>
<%
    Accounts accounts = (Accounts) session.getAttribute("accounts");
    List<Customers> customersList = new ArrayList();
    customersList = accounts.getCustomersList();
    if (accounts == null || customersList == null){
        response.sendError(HttpServletResponse.SC_BAD_REQUEST);
        return;
    }
%>
<form method="post" action="/account_update_confirm">
<table>
    <tr>
        <th>Account Id</th>
        <th>Account Name</th>
        <th>Account Number</th>
        <th>Account Password</th>
        <th>Card Number</th>
        <th>Balance</th>
        <th>FirstName</th>
        <th>LastName</th>
        <th>Address</th>
        <th>Telefonnumber</th>
        <th>Email</th>
        <th>Job Title</th>
    </tr>
    <tr>
        <td><%=accounts.getAccountId()%></td>
        <td><input type="text" name="accountName" value="<%=accounts.getAccountName()%>"></td>
        <td><input type="text" name="accountNumber" value="<%=accounts.getAccountNumber()%>"></td>
        <td><input type="text" name="accountPassword" value="<%=accounts.getAccountPassword()%>"></td>
        <td><input type="text" name="cardnummber" value="<%=accounts.getCardnummber()%>"></td>
        <td><%=accounts.getBalance()%></td>
        <%for (Customers customers : customersList){%>
        <td><input type="text" name="firstName" value="<%=customers.getFirstName()%>"></td>
        <td><input type="text" name="lastName" value="<%=customers.getLastName()%>"></td>
        <td><input type="text" name="address" value="<%=customers.getAddress()%>"></td>
        <td><input type="text" name="telefonnumber" value="<%=customers.getTelefonnumber()%>"></td>
        <td><input type="text" name="email" value="<%=customers.getEmail()%>"></td>
        <td><input type="text" name="jobTitle" value="<%=customers.getJobTitle()%>"></td>
        <input type="hidden" name="customerId" value="<%=customers.getCustomerId()%>" >
        <%}%>
    </tr>
</table>
    <input type="hidden" name="accountId" value="<%=accounts.getAccountId()%>" >
    <input type="submit" value="update">
</form>
</body>
</html>
