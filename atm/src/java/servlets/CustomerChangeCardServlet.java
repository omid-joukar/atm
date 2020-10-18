package servlets;

import model.ChangeCardNummber;
import services.ChangeCardNummberDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by omid on 10/12/2020.
 */
@WebServlet(name = "CustomerChangeCardServlet", urlPatterns = {"/customer_change_card"})
public class CustomerChangeCardServlet extends HttpServlet {
    private ChangeCardNummberDao changeCardNummberDao;

    @Override
    public void init() throws ServletException {
        super.init();
        changeCardNummberDao = new ChangeCardNummberDao();



    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
     String userName = request.getParameter("userName");
     String userFamily = request.getParameter("userFamily");
     String email = request.getParameter("email");
     String cardnummber = request.getParameter("cardnummber");
     if (userName == null || userName.trim().equals("")||
             userFamily == null || userFamily.trim().equals("") ||
             email == null || email.trim().equals("")||
             cardnummber == null || cardnummber.trim().equals("")){
         response.sendError(HttpServletResponse.SC_BAD_REQUEST);
         return;

     }
     changeCardNummberDao.insertAplication(userName , userFamily , email , cardnummber);
     response.sendRedirect(request.getServletContext().getContextPath()+"/customerAbil.html");


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}

