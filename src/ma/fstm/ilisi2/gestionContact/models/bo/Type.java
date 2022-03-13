package ma.fstm.ilisi2.gestionContact.models.bo;

import java.util.*;

import javax.persistence.*;
@Entity
@Table(name = "type")
public class Type {
	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY )
	private Long id;
	private String title;
	@OneToMany(fetch = FetchType.LAZY,mappedBy = "type")
	private Set<Contact> contacts;
	
	public Type() {
		contacts=new TreeSet<Contact>();
	}
	
	

	public Type(String title) {
		super();
		this.title = title;
		contacts=new TreeSet<Contact>();
	}

	

	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}



	public Set<Contact> getContacts() {
		return contacts;
	}

	public void setContacts(Set<Contact> contacts) {
		this.contacts = contacts;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
}
