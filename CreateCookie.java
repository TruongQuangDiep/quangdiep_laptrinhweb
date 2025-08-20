package vn.iotstar;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = { "/createcookie" })
public class CreateCookie extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// Set response content type và UTF-8
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");

		// Nhận dữ liệu từ FORM
		String ten = request.getParameter("ten");
		String holot = request.getParameter("holot");

		// Create cookies for first and last names.
		Cookie firstName = new Cookie("ten", ten);
		Cookie lastName = new Cookie("holot", holot);

		// Set expiry date after 24 Hrs for both the cookies.
		firstName.setMaxAge(60 * 60 * 24);
		lastName.setMaxAge(60 * 60 * 24);

		// Add both the cookies in the response header.
		response.addCookie(firstName);
		response.addCookie(lastName);

		PrintWriter out = response.getWriter();
		out.println("<b>First Name</b>: " + firstName.getValue() + " <b>Last Name</b>: " + lastName.getValue());

	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}