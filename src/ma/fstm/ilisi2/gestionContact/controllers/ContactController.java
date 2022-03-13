package ma.fstm.ilisi2.gestionContact.controllers;

import java.util.*;

import ma.fstm.ilisi2.gestionContact.models.bo.*;
import ma.fstm.ilisi2.gestionContact.models.dao.*;
import ma.fstm.ilisi2.gestionContact.views.*;

public class ContactController {
	IDaoContact myContact;
	IDaoType myType;
	
	
	public ContactController() {
		myContact=new DaoContact();
		myType=new DaoType();
	}
	
	
	public Boolean deleteContact(Long id) {
		return myContact.delete(id);
	}
	
	public Collection<Contact> searchByKeyword(String keyword){
		return myContact.findByKeyword(keyword);
	}
	
	public void updateContact(Long id,String firstName,String lastName,String phone,Long idType) {
		Type type=new Type();
		type.setId(idType);
		Contact contact=new Contact(firstName, lastName, phone,type);
		contact.setId(id);
		myContact.update(contact);
		ListContactPage lisPage=new ListContactPage();
		lisPage.setVisible(true);
	}
	
	public void updatePage(Long id) {
		Contact contact= myContact.findByID(id);
		UpdatePage updatePage=new UpdatePage(contact);
		updatePage.setVisible(true);
	}

	public void addContactPage() {
		FrameContact fContact=new FrameContact();
		fContact.setVisible(true);
	}
	
	public boolean addContact(String firstName,String lastName,String phone,Long idType) {
		if(phone.length()>0){
			Type type=new Type();
			type.setId(idType);
			Contact contact=new Contact(firstName, lastName, phone,type);
			myContact.add(contact);
			ListContactPage lisPage=new ListContactPage();
			lisPage.setVisible(true);
			return true;
		}
		return false;
	}
	
	public Collection<Contact> getAllContacts(){
		return myContact.getAll();
	}
	public Collection<Type> getAllTypes(){
		return myType.getAll();
	}
	
	/*public void listContactPage(){
		ListContactPage listContactPage=new ListContactPage();
		listContactPage.setVisible(true);
	}
	
	public void backHome() {
		HomePage home=new HomePage();
		home.setVisible(true);
	}*/
}
