package servlets;

import model.Accounts;
import services.AccountsDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by omid on 10/7/2020.
 */
@WebServlet(name = "TransferMonyServlet", urlPatterns = {"/transfer_mony"})
public class TransferMonyServlet extends HttpServlet {
    private AccountsDao accountsDao;

    @Override
    public void init() throws ServletException {
        super.init();
        accountsDao = new AccountsDao();

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        Accounts accounts = (Accounts) session.getAttribute("accounts");
        String targetAccountNumber = request.getParameter("targetAccount");
        Float balance = Float.valueOf(request.getParameter("balance"));
        String errorMessage = "";
        if (accounts == null || targetAccountNumber == "" || targetAccountNumber.trim().equalsIgnoreCase("")
                || balance == null || balance == 0){
            response.sendError(HttpServletResponse.SC_BAD_REQUEST);
            return;
        }
        Accounts targetAccount = accountsDao.getAccount(targetAccountNumber);
        if (targetAccount == null){
            errorMessage +="The account Number is not correct.\n";
        }
        if (accounts.getBalance() < balance){
            errorMessage +="The balance for your account is not enough";
        }
        if (errorMessage == "" || errorMessage.trim().equals("")){
           session.setAttribute("targetAccount" , targetAccount);
           session.setAttribute("balance" , balance);
           response.sendRedirect(request.getServletContext().getContextPath()+"/confirmtransform.jsp");
        }else {
            request.setAttribute("errorMessage" , errorMessage);
            request.getRequestDispatcher("/transfererror.jsp").forward(request,response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
