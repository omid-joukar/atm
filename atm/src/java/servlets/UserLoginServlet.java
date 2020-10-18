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
 * Created by KPS on 9/17/2020.
 */
@WebServlet(name = "UserLoginServlet" , urlPatterns = {"/user_login"})
public class UserLoginServlet extends HttpServlet {
    private AccountsDao accountsDao;

    @Override
    public void init() throws ServletException {
        super.init();
        accountsDao = new AccountsDao();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      String accountNumber = request.getParameter("accountNumber");
      String accountPassword = request.getParameter("accountPassword");
      if (accountNumber == "" || accountNumber.trim().equals("") ||
              accountPassword == "" || accountPassword.trim().equals("")){
          response.sendError(HttpServletResponse.SC_BAD_REQUEST);
      }
      Accounts accounts = accountsDao.getAccount(accountNumber , accountPassword);

      if (accounts == null){
          response.sendError(HttpServletResponse.SC_BAD_REQUEST);
      }
      HttpSession session = request.getSession();
      session.setAttribute("accounts" , accounts);
      response.sendRedirect(request.getServletContext().getContextPath()+"/customerAbil.html");






    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
