
package com.pomipomie.contactlist_back.controller;

import com.pomipomie.contactlist_back.exception.ResourceNotFoundException;
import com.pomipomie.contactlist_back.model.Contact;
import com.pomipomie.contactlist_back.repository.ContactRepo;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/contacts")
public class ContactController {
    
    @Autowired
    private ContactRepo contactRepo;
    
    @GetMapping
    public List<Contact> getAllContacts() {
        return contactRepo.findAll();
    }
    
    @PostMapping("/new")
    public Contact createContact(@RequestBody Contact contact) {
        return contactRepo.save(contact);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Contact> getContactById(@PathVariable Long id) {
        Contact contact = contactRepo.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Contact does not exist"));
        return ResponseEntity.ok(contact);
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<Contact> updateContact(@PathVariable Long id, @RequestBody Contact contactDetails) {
        Contact contact = contactRepo.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Contact does not exist"));
        contact.setFirstName(contactDetails.getFirstName());
        contact.setLastName(contactDetails.getLastName());
        contact.setEmail(contactDetails.getEmail());
        Contact updatedContact = contactRepo.save(contact);
        return ResponseEntity.ok(updatedContact);
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteContact(@PathVariable Long id) {
        Contact contact = contactRepo.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Contact does not exist"));
        contactRepo.delete(contact);
        Map<String, Boolean> response = new HashMap();
        response.put("deleted", Boolean.TRUE);
        return ResponseEntity.ok(response);
    }
}
