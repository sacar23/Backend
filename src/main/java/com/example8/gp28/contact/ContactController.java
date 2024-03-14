package com.example8.gp28.contact;

import com.example8.gp28.contact.Contact;
import com.example8.gp28.contact.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping (path = "api/contact")
public class ContactController {

    private final ContactService contactService;


    @Autowired
    public ContactController(ContactService contactService, ContactRepository contactRepository) {
        this.contactService = contactService;

    }

    @GetMapping
    public List<Contact> getAllContacts(){
        return contactService.getContacts();

    }

    @PostMapping
    public void registerNewContact(@RequestBody Contact contact){

        contactService.addNewContact(contact);
    }

    @DeleteMapping(path = "{contactId}")
    public void deleteContact(@PathVariable("contactId") Long contactId){
        contactService.deleteContact(contactId);
    }




    @PostMapping("/submit")
    public ResponseEntity<String> submitContact(@RequestBody Contact contact) {
        try {
            // Process the contact data (save to the database, send emails, etc.)
            contactService.addNewContact(contact);
            return ResponseEntity.ok("Submitted successfully!");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Submission failed");
        }
    }
}

