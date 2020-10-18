package servlets;

import model.UserContact;
import services.UserContactDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by omid on 10/11/2020.
 */
@WebServlet(name = "ContactServlet", urlPatterns = {"/user_contact"})
public class ContactServlet extends HttpServlet {
    private UserContactDao userContactDao;

    @Override
    public void init() throws ServletException {
        super.init();
        userContactDao = new UserContactDao();


    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userName = (String) request.getParameter("userName");
        String userFamily = (String) request.getParameter("userFamily");
        String email = (String) request.getParameter("email");
        String textArea = (String) request.getParameter("textArea");
        if (userName == null || userName.trim().equals("") ||
                userFamily == null || userFamily.trim().equals("")||
                email == null || email.trim().equals("")||
                textArea == null || textArea.trim().equals("")){
            response.sendError(HttpServletResponse.SC_BAD_REQUEST);
        }

        userContactDao.insertUserApplication(userName , userFamily , email , textArea);
        response.sendRedirect(request.getServletContext().getContextPath()+"/customerAbil.html");


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
