package servlets;

import model.Accounts;
import services.AccountsDao;
import services.UserContactDao;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "SearchAccountServlet", urlPatterns = {"/search_account"})
public class SearchAccountServlet extends HttpServlet {
    private AccountsDao accountsDao;

    @Override
    public void init() throws ServletException {
        super.init();
        accountsDao = new AccountsDao();



    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String accountNumber = (String) request.getParameter("accountNumber");
        String cardnummber = (String) request.getParameter("cardNummber");

        if (accountNumber == null || accountNumber.trim().equals("") ||
                cardnummber == null || cardnummber.trim().equals(""))
        {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST);
        }

        Accounts accounts = accountsDao.getAccount(accountNumber);
        HttpSession session = request.getSession();
        session.setAttribute("accounts",accounts);
        response.sendRedirect(request.getServletContext().getContextPath()+"/updateAccount.jsp");


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
