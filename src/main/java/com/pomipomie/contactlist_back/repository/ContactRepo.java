
package com.pomipomie.contactlist_back.repository;

import com.pomipomie.contactlist_back.model.Contact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactRepo extends JpaRepository<Contact, Long> {
    
}
