package controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.HibernateUsuarioDao;
import modelo.Usuario;
import modelo.UsuarioDao;

/**
 * Servlet implementation class RegistroServlet
 */
public class RegistroServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public RegistroServlet() {
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
		String nombreTxt = request.getParameter("nombre");
		String direccionTxt = request.getParameter("direccion");
		String telefonoTxt = request.getParameter("telefono");
		String correoTxt = request.getParameter("email");
		
		Usuario usuario= new Usuario();
		
		usuario.setUsuario(usuarioTxt);
		usuario.setClave(claveTxt);
		usuario.setCorreo(correoTxt);
		usuario.setDireccion(direccionTxt);
		usuario.setNombre(nombreTxt);
		usuario.setTelefono(telefonoTxt);
		
		System.out.println("Aca la prueba");
		
		UsuarioDao usuarioDao = new HibernateUsuarioDao();
		usuarioDao.insert(usuario);
		
		request.getRequestDispatcher("/login.jsp").forward(request, response);
		
		
		
		
		
		
	}

}
