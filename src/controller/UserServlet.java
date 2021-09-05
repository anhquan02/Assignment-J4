package controller;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import dao.UserDAO;
import entity.User;

/**
 * Servlet implementation class UserServlet
 */
@WebServlet({"/users","/users/edit","/users/update","/users/delete","/users/create","/users/store"})

public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private UserDAO dao=new UserDAO();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserServlet() {
        super();

    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String uri = request.getRequestURI();
		if (uri.contains("edit")) {
			this.edit(request, response);
		} else if (uri.contains("create")) {
			this.create(request,response);
		} else if (uri.contains("delete")) {
			this.delete(request, response);
		} else {
			this.index(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String uri = request.getRequestURI();
		if (uri.contains("update")) {
			this.update(request, response);
		}else if(uri.contains("store")) {
			this.store(request,response);
		} else {
			// 404
//			this.index(request, response);
		}
	}
	
	private void store(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		// TODO Auto-generated method stub
		User entity = new User();
		try {
			BeanUtils.populate(entity, request.getParameterMap());
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.dao.create(entity);
		response.sendRedirect(request.getContextPath()+"/users");
	}

	private void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		// TODO Auto-generated method stub
		User entity = new User();
		try {
			BeanUtils.populate(entity, request.getParameterMap());
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.dao.update(entity);
		response.sendRedirect(request.getContextPath()+"/users");
	}

	private void create(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		// TODO Auto-generated method stub
		request.getRequestDispatcher("/views/users/create.jsp").forward(request, response);
	}

	private void index(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setAttribute("users", this.dao.getAll());
		request.getRequestDispatcher("/views/users/index.jsp").forward(request, response);
	}

	private void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		// TODO Auto-generated method stub
		String id = request.getParameter("id");
		this.dao.remove(id);
		response.sendRedirect(request.getContextPath()+"/users");
	}

	private void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		// TODO Auto-generated method stub
		String id = request.getParameter("id");
		User entity = this.dao.findById(id);
		request.setAttribute("user", entity);
		request.getRequestDispatcher("/views/users/edit.jsp").forward(request, response);
	}

}
