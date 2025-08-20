package vn.iotstar;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/profile")
public class ProfileSession extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession(false); // khong tao moi neu chua co
        if (session != null && session.getAttribute("user") != null) {
            String user = (String) session.getAttribute("user");
            response.getWriter().println("Xin chao " + user + "! <a href='logoutsession'>Dang xuat</a>");
        } else {
            response.sendRedirect("Login.html");
        }
    }
}
