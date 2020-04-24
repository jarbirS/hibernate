package controlador;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.LoginDao;
import modelo.Usuario;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public LoginServlet() {
        // TODO Auto-generated constructor stub
    	super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String usuarioTxt = request.getParameter("usuario");
		String claveTxt = request.getParameter("clave");
		
		Usuario usuario= new Usuario();
		
		usuario.setUsuario(usuarioTxt);
		usuario.setClave(claveTxt);
		
		LoginDao loginDao= new LoginDao();
		
		String userValidate = loginDao.authenticateUser(usuario);
		System.out.println(userValidate);
		
		if(userValidate.contentEquals("SUCCESS")) {
			request.setAttribute("username", usuarioTxt);
			request.getRequestDispatcher("/home.jsp").forward (request, response);
			}
		else {
			request.setAttribute("errMessage", userValidate);
			request.getRequestDispatcher("/login.jsp").forward(request, response);
			
			
		}
		
	}

}
