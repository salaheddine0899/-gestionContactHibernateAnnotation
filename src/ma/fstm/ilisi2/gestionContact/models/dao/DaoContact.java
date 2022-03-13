package ma.fstm.ilisi2.gestionContact.models.dao;

import java.util.Collection;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import ma.fstm.ilisi2.gestionContact.models.bo.*;

public class DaoContact implements IDaoContact {

	@Override
	public boolean add(Contact c) {
		// TODO Auto-generated method stub
		SessionFactory sessionFactory=ConnectionHibernate.getSession();
		Session session=sessionFactory.openSession();
		//Type type=c.getType();
		
		Transaction tx=null;
		try {
			tx=session.beginTransaction();
			session.save(c);
			//Type type=session.load(Type.class, c.getType().getId());
			session.flush();
			tx.commit();
			return true;
		}
		catch(Exception exp) {
			tx.rollback();
			return false;
		}
		
	}

	@Override
	public boolean delete(Long id) {
		// TODO Auto-generated method stub
		SessionFactory sessionFactory=ConnectionHibernate.getSession();
		Session session=sessionFactory.openSession();
		//Type type=c.getType();
		
		Transaction tx=null;
		try {
			tx=session.beginTransaction();
			Contact c=new Contact();
			c.setId(id);
			session.delete(c);
			session.flush();
			tx.commit();
			return true;
			
		}catch(Exception exp) {
			tx.rollback();
			return false;
		}
	}

	@Override
	public boolean update(Contact contact) {
		// TODO Auto-generated method stub
		SessionFactory sessionFactory=ConnectionHibernate.getSession();
		Session session=sessionFactory.openSession();
		//Type type=c.getType();
		
		Transaction tx=null;
		try {
			tx=session.beginTransaction();
			//Contact c=new Contact();
			//c.setId(id);
			session.update(contact);;
			session.flush();
			tx.commit();
			return true;
			
		}catch(Exception exp) {
			tx.rollback();
			return false;
		}
	}

	@Override
	public Contact findByID(Long id) {
		// TODO Auto-generated method stub
		SessionFactory sessionFactory=ConnectionHibernate.getSession();
		Session session=sessionFactory.openSession();
		
		return session.load(Contact.class, id);
	}

	@Override
	public Collection<Contact> getAll() {
		// TODO Auto-generated method stub
		SessionFactory sessionFactory=ConnectionHibernate.getSession();
		Session session=sessionFactory.openSession();
		
		//session.load(Contact.class);
		return session.createQuery("from Contact").list();
	}

	@Override
	public Collection<Contact> findByKeyword(String keyword) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
