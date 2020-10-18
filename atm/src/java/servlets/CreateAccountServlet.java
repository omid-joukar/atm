package servlets;


import model.Employees;
import services.AccountsDao;
import services.CustomerAccountDao;
import services.CustomersDao;
import services.EmployeesDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by omid on 10/13/2020.
 */
@WebServlet(name = "CreateAccountServlet", urlPatterns = {"/create_account"})
public class CreateAccountServlet extends HttpServlet {
    private AccountsDao accountsDao;
    private CustomerAccountDao customerAccountDao;

    private CustomersDao customersDao;


    @Override
    public void init() throws ServletException {
        super.init();
        accountsDao = new AccountsDao();
        customersDao = new CustomersDao();
        customerAccountDao = new CustomerAccountDao();



    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException , IOException {
        String accountName = request.getParameter("accountName");
        String accountNumber = request.getParameter("accountNumber");
        String accountPassword = request.getParameter("accountPassword");
        String cardnummber = request.getParameter("cardnummber");
        Float balance = Float.valueOf(request.getParameter("balance"));
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String address = request.getParameter("address");
        String telefonnumber = request.getParameter("telefonnumber");
        String email = request.getParameter("email");
        String jobTitle = request.getParameter("jobTitle");
        Employees employees = (Employees) request.getSession().getAttribute("employees");
        if (accountName == null || accountName.trim().equals("")||
            accountNumber == null || accountNumber.trim().equals("")||
            accountPassword == null || accountPassword.trim().equals("")||
            cardnummber == null || cardnummber.trim().equals("")||
            balance == null || balance == 0.0||
            firstName == null || firstName.trim().equals("")||
            lastName == null || lastName.trim().equals("")||
            address == null || address.trim().equals("")||
            email == null || email.trim().equals("")||
            jobTitle == null || jobTitle.trim().equals("")){
            response.sendError(HttpServletResponse.SC_BAD_REQUEST);
            return;
        }
        accountsDao.insertAccount(accountName,accountNumber,accountPassword,cardnummber,balance);
        customersDao.insertCustomer(firstName,lastName,address,telefonnumber,email,jobTitle);

        customerAccountDao.insertCustomerAccount(customersDao.getCustomerId(firstName,lastName,email),accountsDao.getAccountId(accountNumber,accountPassword));
        response.sendRedirect(request.getServletContext().getContextPath()+"/employeeAbil.html");

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
