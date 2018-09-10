package com.onestopshop.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.onestopshop.model.Item;
import com.onestopshop.service.ItemService;
import com.onestopshop.service.ItemServiceImpl;
import static com.onestopshop.util.IdGenerator.*;

@WebServlet("/items/*")
public class ItemServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private ItemService itemService;

	public ItemServlet() {
		itemService = new ItemServiceImpl();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String requestedUri = request.getRequestURI();

		if (requestedUri.contains("delete")) {
			String id = request.getParameter("id");
			itemService.deleteItem(Long.valueOf(id));
			List<Item> itemsFromDb = itemService.getItems();
			RequestDispatcher rd = request.getRequestDispatcher("/items.jsp");
			request.setAttribute("items", itemsFromDb);
			rd.forward(request, response);
		} else if (requestedUri.contains("view")) {
			String id = request.getParameter("id");
			Item itemFromDb = itemService.getItem(Long.valueOf(id));
			RequestDispatcher rd = request.getRequestDispatcher("/item.jsp");
			request.setAttribute("item", itemFromDb);
			rd.forward(request, response);
		} else if (requestedUri.contains("edit")) {
			String id = request.getParameter("id");
			Item itemFromDb = itemService.getItem(Long.valueOf(id));
			RequestDispatcher rd = request.getRequestDispatcher("/save-item.jsp");
			request.setAttribute("item", itemFromDb);
			rd.forward(request, response);
		} else {
			List<Item> itemsFromDb = itemService.getItems();
			RequestDispatcher rd = request.getRequestDispatcher("/items.jsp");
			request.setAttribute("items", itemsFromDb);
			rd.forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Item item = (Item) request.getAttribute("item");
		if (item.getId() > 0) {
			itemService.updateItem(item);
			response.sendRedirect("items");
		} else {
			item.setId(getItemId());
			itemService.saveItem(item);
			response.sendRedirect("items");
		}
	}

}
