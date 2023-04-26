package com.prattay.backend.backendapp.repositories;

import java.util.HashSet;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.prattay.backend.backendapp.domain.Chat;

@Repository
public interface ChatRepository extends JpaRepository<Chat, Long> {
    HashSet<Chat> getChatByFirstUserName(String username);

    HashSet<Chat> getChatBySecondUserName(String username);
}