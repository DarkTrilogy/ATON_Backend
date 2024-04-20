package com.aton.backend.repository;

import com.aton.backend.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Integer> {
    Client getByAccountNumber(String accountNumber);
}
