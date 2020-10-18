package servlets;

/**
 * Created by omid on 10/6/2020.
 */

import model.Accounts;
import services.AccountsDao;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
@WebServlet(name = "CustomerPasswordchangeServlet", urlPatterns = {"/customer_change_password"})
public class CustomerPasswordchangeServlet extends HttpServlet {
    private AccountsDao accountsDao;

    @Override
    public void init() throws ServletException {
        super.init();
        accountsDao = new AccountsDao();

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String accountPassword = (String) request.getParameter("accountPassword");
        String accountNewPassword = (String) request.getParameter("accountNewPassword");
        Accounts accounts = (Accounts) session.getAttribute("accounts");
        if (accounts == null || accountPassword == "" || accountPassword.trim().equals("")
                || accountNewPassword == "" || accountNewPassword.trim().equals("")){
            response.sendError(HttpServletResponse.SC_BAD_REQUEST);

        }
        if (accountPassword.equalsIgnoreCase(accounts.getAccountPassword())!=true){
            response.sendError(HttpServletResponse.SC_BAD_REQUEST);

        }

        accountsDao.changePassword(accounts.getAccountNumber() , accountNewPassword);
        response.sendRedirect(request.getServletContext().getContextPath()+"/userlogin.html");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
