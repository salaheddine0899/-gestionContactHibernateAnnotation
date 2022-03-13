package ma.fstm.ilisi2.gestionContact.models.dao;

import java.util.Arrays;
import java.util.List;

import javax.transaction.Transaction;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.Session;
import org.hibernate.SharedSessionContract;
import org.hibernate.cfg.Configuration;


import ma.fstm.ilisi2.gestionContact.models.bo.Contact;
import ma.fstm.ilisi2.gestionContact.models.bo.Type;

public class Test {

	public static void main(String[] args) {
		SessionFactory sessionFact=ConnectionHibernate.getSession();
		//System.out.println("it's hoji");
		
	}
}
