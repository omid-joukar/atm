<%@ page import="model.Accounts" %><%--
  Created by IntelliJ IDEA.
  User: omid
  Date: 10/6/2020
  Time: 7:14 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Menual Transfer</title>
</head>
<body>
    <form method="post" action="/transfer_mony">
        <%Accounts accounts = (Accounts) session.getAttribute("accounts");%>
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
                        <label for="targetAccount">Target Account :</label>
                    </td>
                    <td>
                        <input type="text" name="targetAccount" id="targetAccount">
                    </td>
                </tr>
                <tr>
                    <td>
                        <label for="balance">Balance :</label>
                    </td>
                    <td>
                        <input type="text" name="balance" id="balance">
                    </td>
                </tr>
                <tr>
                    <td>
                        <input type="submit" value="transfer">
                    </td>
                </tr>
            </table>
        </form>
    </form>
</body>
</html>
