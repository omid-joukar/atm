package servlets;

import services.AccountsDao;
import services.TransactionsDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by omid on 10/19/2020.
 */

@WebServlet(name = "TransactionsServlet", urlPatterns = {"/transaction_order"})
public class TransactionsServlet extends HttpServlet {
    private TransactionsDao transactionsDao;
    private AccountsDao accountsDao;
    @Override
    public void init() throws ServletException {
        super.init();
        accountsDao = new AccountsDao();
        transactionsDao = new TransactionsDao();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            String action = request.getParameter("action");
            Integer employeeId = Integer.valueOf(request.getParameter("employeeId"));
            Integer transactionId = Integer.valueOf(request.getParameter("transactionId"));
            Integer accountId = Integer.valueOf(request.getParameter("accountId"));
            Integer targetAccountNumber = Integer.valueOf(request.getParameter("targetAccountNumber"));
            Float balance = Float.valueOf(request.getParameter("balance"));
            if (action == null || action.trim().equals("")){
                response.sendError(HttpServletResponse.SC_BAD_REQUEST);
                return;
            }else if (action.trim().equals("confirm")){
                transactionsDao.confirmTransaction(employeeId , transactionId);
                accountsDao.transferMony(accountId , targetAccountNumber ,balance);
                response.sendRedirect(request.getServletContext().getContextPath()+"/confirmtransactions.jsp");
            }else if (action.trim().equals("reject")){
                transactionsDao.rejectTransaction(employeeId , transactionId , accountId , targetAccountNumber , balance);
                response.sendRedirect(request.getServletContext().getContextPath()+"/confirmtransactions.jsp");

            }
        }
    }


