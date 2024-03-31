package com.project.eventos.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import com.project.eventos.services.implementation.OrganizerDAO;
/**
 * Servlet implementation class OrgLoginVerifyServlet
 */
@WebServlet("/OrgLogin")
public class OrgLoginVerifyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OrgLoginVerifyServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String email = request.getParameter("email");
        String password = request.getParameter("password");
        OrganizerDAO organizerDAO = new OrganizerDAO();
		if (organizerDAO.verifyOrganizer(email, password)) {
			response.sendRedirect("orgDashboard.jsp");
		} else {
			response.sendRedirect("Error.jsp");
		}
	}

}
