<%@ page import="java.util.List" %>
<%@ page import="model.Transactions" %>
<%@ page import="services.TransactionsDao" %>
<%@ page import="model.Employees" %><%--
  Created by IntelliJ IDEA.
  User: omid
  Date: 10/13/2020
  Time: 12:36 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Confirm Transactions</title>
</head>
<body>

    <%
        TransactionsDao transactionsDao = new TransactionsDao();
        List<Transactions> transactionsList = transactionsDao.getTransactionsList();
        Employees employees = (Employees) session.getAttribute("employees");
    %>
    <table>
        <tr>
            <td>Transaction Id</td>
            <td>Date</td>
            <td>Type</td>
            <td>Employee Name</td>
            <td>Customer Id</td>
            <td>Account Id</td>
            <td>Target Account Number</td>
            <td>Balance</td>
            <td>Status</td>
            <td>Confirm</td>
            <td>Reject</td>
        </tr>
        <tr>
            <%for (Transactions transactions : transactionsList){%>
            <td><%=transactions.getTransactionId()%></td>
            <td><%=transactions.getDate()%></td>
            <td><%=transactions.getType()%></td>
            <td><%=transactions.getEmployees().getFirstName()+ " "+transactions.getEmployees().getLastName()%></td>
            <td><%=transactions.getCustomers().getCustomerId()%></td>
            <td><%=transactions.getCustomers().getAccountsList().get(0).getAccountId()%></td>
            <td><%=transactions.getTargetAccountNumber()%></td>
            <td><%=transactions.getStatus()%></td>
            <td><a href="<%=request.getServletContext().getContextPath()%>/transaction_order?action=confirm&employeeId=<%=employees.getEmployeeId()%>&transactionId=<%=transactions.getTransactionId()%>&accountId=<%=transactions.getAccounts().getAccountId()%>&targetAccountNumber=<%=transactions.getTargetAccountNumber()%>&balance=<%=transactions.getBalance()%>">Confirm</a></td>
            <td><a href="<%=request.getServletContext().getContextPath()%>/transaction_order?action=reject&employeeId=<%=employees.getEmployeeId()%>&transactionId=<%=transactions.getTransactionId()%>&accountId=<%=transactions.getAccounts().getAccountId()%>&targetAccountNumber=<%=transactions.getTargetAccountNumber()%>&balance=<%=transactions.getBalance()%>">Reject</a></td>
            <%}%>
        </tr>
    </table>
</body>
</html>
