package ma.fstm.ilisi2.gestionContact.models.dao;

import java.util.Collection;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import ma.fstm.ilisi2.gestionContact.models.bo.Type;

public class DaoType implements IDaoType{

	@Override
	public Collection<Type> getAll() {
		// TODO Auto-generated method stub
		SessionFactory sessionFactory=ConnectionHibernate.getSession();
		Session session=sessionFactory.openSession();
		
		//session.load(Contact.class);
		return session.createQuery("from Type").list();
		
	}

}
