<%@ page import="model.Accounts" %>
<%@ page import="services.AccountsDao" %>
<%@ page import="model.Customers" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: omid
  Date: 10/7/2020
  Time: 10:37 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Confirm Transfer Details</title>
    <link rel="stylesheet" type="text/css" href="resources/table_input_style_sheet.css">
</head>
<body>
<form method="post" action="transfercomplete.jsp">
<%
    Accounts targetAccount = (Accounts) session.getAttribute("targetAccount");
    Accounts accounts = (Accounts) session.getAttribute("accounts");
    Float balance = (Float) session.getAttribute("balance");
    List<Customers> customersList = new ArrayList();
    customersList = targetAccount.getCustomersList();
    if (targetAccount == null|| accounts == null || balance == null || balance == 0
            ||customersList == null){
        response.sendError(HttpServletResponse.SC_BAD_REQUEST);
        return;
    }
%>
<div class="boxbase1">
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
<table class="table2">
    <tr>
        <th>Target Account Type</th>
        <th>Target Account Number</th>
        <th>Target Account Owner</th>
    </tr>
    <tr>
        <td><%=targetAccount.getAccountName()%></td>
        <td><%=targetAccount.getAccountNumber()%></td>
        <%for (Customers customers : customersList){%>
        <td><%=customers.getFirstName()+ " " + customers.getLastName()%></td>
        <%}%>

    </tr>
</table>
<p class="tp">do you confirm to trannsfer <%=balance%> from your account to <%=customersList.get(0).getFirstName() + " "+ customersList.get(0).getLastName()%></p>
<input class="transfer" type="submit" value="Confirm">
</div>
</form>
</body>
</html>
