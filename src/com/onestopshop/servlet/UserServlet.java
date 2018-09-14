package com.onestopshop.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.onestopshop.model.User;

@WebServlet("/users/*")
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public UserServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String requestedUri = request.getRequestURI();
		if (requestedUri.contains("register")) {
			response.sendRedirect("register-user.jsp");
		} else if (requestedUri.contains("view")) {
			// fetch the user id from request
			// fetch the user
			// add the user in request
			// show profile.jsp
		} else if (requestedUri.contains("delete")) {
			// fetch the user id from request
			// delete the user in db
			// show home page of your website
		} else {
			// show all the users
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		User user = (User) request.getAttribute("user");
		if (user.getId() > 0) {
			//	update the user
		} else {
			// save the user
		}
	}

}
