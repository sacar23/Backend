package com.example8.gp28.contact;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ContactRepository
        extends JpaRepository<Contact, Long> {

    Optional<Contact> findContactByEmail(String email);
}
