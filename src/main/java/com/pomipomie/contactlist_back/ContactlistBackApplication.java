package com.pomipomie.contactlist_back;

import com.pomipomie.contactlist_back.model.Contact;
import com.pomipomie.contactlist_back.repository.ContactRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ContactlistBackApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ContactlistBackApplication.class, args);
	}

    @Autowired
    private ContactRepo contactRepo;
    
    @Override
    public void run(String... args) throws Exception {
    /*    Contact contact = new Contact();
        contact.setFirstName("Caro");
        contact.setLastName("Orieta");
        contact.setEmail("carolinaorieta@cmail.com");
        contactRepo.save(contact);
    */

    }

}
