package com.eradaw;

import java.util.List;

import org.hibernate.HibernateException;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
//import jakarta.transaction.Transactional;

@Repository
public class ContactRepository {
	@PersistenceContext
	private EntityManager entityManager;
	
	@Transactional
	public void save(Contact contact) throws HibernateException {
	
			entityManager.persist(contact);
			System.out.println("hey excuted");
			System.out.println(findAll());
			if (contact.getName() == "Puja") { throw new HibernateException("Exception message");}
		
	}
	
	public List<Contact> findAll() {
//		String jpql = "SELECT c FROM Contact c";
//		TypedQuery<Contact> query = entityManager.createQuery(jpql, Contact.class);
		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
		CriteriaQuery<Contact> cq = cb.createQuery(Contact.class);
		Root <Contact> contact = cq.from(Contact.class);
		cq.select(contact);
		TypedQuery<Contact> query = entityManager.createQuery(cq);
		
		return query.getResultList();
	}
	public Contact findById(Integer id ) {
		return entityManager.find(Contact.class, id);
	}
	@Transactional
	public Contact update(Contact contact) {
		return entityManager.merge(contact);
		
	}
	@Transactional
	public void delete(Integer id) {
		Contact contact = entityManager.find(Contact.class, id);
		entityManager.remove(contact);
	}
}
