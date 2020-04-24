package modelo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class HibernateUsuarioDao implements UsuarioDao {

	@Override
	public Usuario selectById(String usuarioId) {
		SessionFactory sessionFactory= HibernateSession.getSessionFactory();
		Session session= sessionFactory.openSession();
		Usuario usuario = (Usuario) session.get(Usuario.class, usuarioId);
		session.close();
		return usuario;
	}
	
	@Override
	public List<Usuario> selectAll(){
		SessionFactory sessionFactory = HibernateSession.getSessionFactory();
		Session session = sessionFactory.openSession();
		List <Usuario> usuarios= session.createCriteria(Usuario.class).list();
		session.close();
		return usuarios;
		
	}
	
	@Override
	public void insert(Usuario usuario) {
		
		SessionFactory sessionFactory = HibernateSession.getSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		String id = (String) session.save(usuario);
		usuario.setUsuario(id);
		session.getTransaction().commit();
		session.close();
		
			
	}
	
	@Override
	public void update(Usuario usuario) {
		
		SessionFactory sessionFactory = HibernateSession.getSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.merge(usuario);
		session.getTransaction().commit();
		session.close();
	}
	
	@Override
	public void delete (Usuario usuario) {
		
		SessionFactory sessionFactory = HibernateSession.getSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.delete(usuario);
		session.getTransaction().commit();
		session.close();
		
	}
}
