package com.example8.gp28.contact;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class ContactService {
    private final ContactRepository contactRepository;


    @Autowired
    public ContactService(ContactRepository contactRepository){
        this.contactRepository = contactRepository;
    }

    public List<Contact> getContacts(){
        return contactRepository.findAll();
    }

    public void deleteContact(Long contactId) {
        boolean exists = contactRepository.existsById(contactId);
        if (!exists){
            throw new IllegalStateException(
                    "contact with id" + contactId + "does not exists");
        }
        contactRepository.deleteById(contactId);

    }
    public void addNewContact(Contact contact){
        Optional<Contact> contactOptional = contactRepository.findContactByEmail(contact.getEmail());
        if (contactOptional.isPresent()) {
            throw new IllegalStateException("Email Exits");
        }
        contactRepository.save(contact);

    }






}
