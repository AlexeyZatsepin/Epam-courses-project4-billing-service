package controller.commands;


import model.dao.impl.ClientDAO;
import model.service.Context;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * EPAM_Project_4_WEB_APP
 * Created 7/31/16, with IntelliJ IDEA
 *
 * @author Alex
 */
public class LogInCommand implements Command {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response, Context context) throws ServletException, IOException {
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        ClientDAO dao = (ClientDAO) context.getDBService().getClientDAO();
        long userId  = dao.getUserByParams(email, password);

        if (userId < 0) { // user doesn't exist
            request.setAttribute("message", "Wrong login or password");
            return "index.jsp";
        }
        request.setAttribute("user", dao.get(userId));
        request.getSession().setAttribute("userId", userId);
        return "./WEB-INF/views/userProfile.jsp";
    }
}
