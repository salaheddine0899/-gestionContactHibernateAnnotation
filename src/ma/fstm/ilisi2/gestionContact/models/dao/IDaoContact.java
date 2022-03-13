package ma.fstm.ilisi2.gestionContact.models.dao;

import java.util.Collection;

import ma.fstm.ilisi2.gestionContact.models.bo.Contact;

public interface IDaoContact {
	
	public boolean add(Contact c);
	boolean delete(Long id);
	boolean update(Contact contact);
	Contact findByID(Long id);
	Collection<Contact> getAll();
	Collection<Contact> findByKeyword(String keyword);
}
