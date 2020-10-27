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
    <link rel="stylesheet" type="text/css" href="resources/table_input_style_sheet.css">
</head>
<body>
    <form method="post" action="/transfer_mony">
        <div class="boxbase">
           
           
           
       <div class="boxleft">
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
        </div>
        <form method="post">
            
          
           <div class="boxright">
               <img class="transferpic" src="WEB-PICTURES/tasl.png">
                   
               <input class="target" type="text" width="200px" height="12px" name="targetAccount" id="targetAccount" placeholder="target account number"><br/>
                
                    
                        <input class="balance" width="200px" height="12px" type="text" name="balance" id="balance" placeholder="balance"><br/>
               
                
                        <input class="transfer" type="submit" value="transfer">
                </div> 
        </form>
        </div>
    </form>
</body>
</html>
