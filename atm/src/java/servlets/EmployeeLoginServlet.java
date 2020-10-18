package servlets;

import model.Employees;
import services.EmployeesDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by KPS on 9/18/2020.
 */
@WebServlet(name = "EmployeeLoginServlet", urlPatterns = {"/employee_login"})
public class EmployeeLoginServlet extends HttpServlet {
    private EmployeesDao employeesDao;

    @Override
    public void init() throws ServletException {
        super.init();
        employeesDao = new EmployeesDao();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Integer employeeId = Integer.parseInt(request.getParameter("employeeId"));
        String employeePassword = request.getParameter("employeePassword");
        if (employeeId == null  || employeePassword == "" || employeePassword.trim().equals("")){
            response.sendError(HttpServletResponse.SC_BAD_REQUEST);
        }
        Employees employees = employeesDao.getEmployee(employeeId, employeePassword);
        if (employees == null){
            response.sendError(HttpServletResponse.SC_BAD_REQUEST);
        }
        HttpSession session = request.getSession();
        session.setAttribute("employees" , employees);
        response.sendRedirect(request.getServletContext().getContextPath()+"/employeeAbil.html");





    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
