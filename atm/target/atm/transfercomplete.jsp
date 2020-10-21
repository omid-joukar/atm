<%@ page import="services.AccountsDao" %>
<%@ page import="model.Accounts" %>
<%@ page import="model.Customers" %>
<%@ page import="services.TransactionsDao" %><%--
  Created by IntelliJ IDEA.
  User: omid
  Date: 10/7/2020
  Time: 11:14 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Complete Transfer</title>
</head>
<body>
<%
    TransactionsDao transactionsDao = new TransactionsDao();
    Accounts targetAccount = (Accounts) session.getAttribute("targetAccount");
    Accounts accounts = (Accounts) session.getAttribute("accounts");
    Float balance = (Float) session.getAttribute("balance");
    if (targetAccount == null|| accounts == null || balance == null || balance == 0){
        response.sendError(HttpServletResponse.SC_BAD_REQUEST);
        return;
    }
    transactionsDao.insertTransaction(accounts,targetAccount.getAccountNumber(),balance);
    response.sendRedirect(request.getServletContext().getContextPath()+"/customerAbil.html");
%>
</body>
</html>
