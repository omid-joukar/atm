package servlets;

import services.AccountsDao;
import services.CustomersDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by omid on 10/18/2020.
 */
@WebServlet(name = "AccountUpdateConfirmServlet", urlPatterns = {"/account_update_confirm"})
public class AccountUpdateConfirmServlet extends HttpServlet {
   private CustomersDao customersDao;
   private AccountsDao accountsDao;
    @Override
    public void init() throws ServletException {
        super.init();
        customersDao = new CustomersDao();
        accountsDao = new AccountsDao();



    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String accountName = request.getParameter("accountName");
        String accountNumber = request.getParameter("accountNumber");
        String accountPassword = request.getParameter("accountPassword");
        String cardnummber = request.getParameter("cardnummber");
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String address = request.getParameter("address");
        String telefonnumber = request.getParameter("telefonnumber");
        String email = request.getParameter("email");
        String jobTitle = request.getParameter("jobTitle");
        Integer customerId =Integer.parseInt( request.getParameter("customerId"));
        Integer accountId = Integer.parseInt(request.getParameter("accountId"));
        customersDao.updateCustomer(customerId,firstName,lastName,address,telefonnumber,email,jobTitle);
        accountsDao.updateAccount(accountId,accountName,accountNumber,accountPassword,cardnummber);
        response.sendRedirect(request.getServletContext().getContextPath()+"/employeeAbil.html");














    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}

