package com.prattay.backend.backendapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.prattay.backend.backendapp.domain.Message;

@Repository
public interface MessageRepository extends JpaRepository<Message, Long> {

}
