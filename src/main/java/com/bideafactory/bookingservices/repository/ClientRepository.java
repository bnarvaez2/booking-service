package com.bideafactory.bookingservices.repository;

import com.bideafactory.bookingservices.entity.Client;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository<Client, Integer> {
    
    public Client findById(String userCode);
}
