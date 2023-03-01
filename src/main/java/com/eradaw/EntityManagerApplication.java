package com.eradaw;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EntityManagerApplication implements CommandLineRunner{

	@Autowired private ContactRepository repository;
	
	public static void main(String[] args) {
		SpringApplication.run(EntityManagerApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
//		TODO Auto-generated method stub
//		createContact();
//		updateContact();
//		deleteContract();
		listContacts();
//		getContact();
	}
	private void deleteContract() {
		Integer id = 11;
		repository.delete(id);
	}
	private void updateContact() {
		Integer id = 2;
		Contact contact = repository.findById(id);
		contact.setEmail("john@outlook.com");
		
		repository.update(contact);
	}
	
	private void getContact() {
		Integer id = 2;
		Contact contact = repository.findById(id);
		System.out.println(contact);
	}
	
	private void createContact() throws Exception {
		Contact contact = new Contact();
		contact.setName("Puja");
		contact.setEmail("john.kumar@gmail.com");
		contact.setAddress("usa new york ");
		repository.save(contact);
	}
	private void listContacts() {
		List<Contact> listContacts = repository.findAll();
		listContacts.forEach(System.out::println);
	}
}
