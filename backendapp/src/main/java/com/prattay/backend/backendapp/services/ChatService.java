package com.prattay.backend.backendapp.services;

import java.util.HashSet;
import java.util.List;

import com.prattay.backend.backendapp.domain.Chat;
import com.prattay.backend.backendapp.domain.Message;
import com.prattay.backend.backendapp.exceptions.AlreadyChatExistException;
import com.prattay.backend.backendapp.exceptions.ChatNotFoundException;
import com.prattay.backend.backendapp.exceptions.NoChatExistInTheRepo;

public interface ChatService {
    public Chat addChat(Chat chat) throws AlreadyChatExistException;

    List<Chat> findAllChats() throws NoChatExistInTheRepo;

    Chat getById(Long id) throws ChatNotFoundException;

    HashSet<Chat> getChatByFirstUserName(String username) throws ChatNotFoundException;

    HashSet<Chat> getChatBySecondUserName(String username) throws ChatNotFoundException;

    Chat addMessage1(Message add, Long chatId) throws ChatNotFoundException;

    List<Message> getAllMessagesInChat(Long chatId) throws NoChatExistInTheRepo;

    HashSet<Chat> getChatByFirstUserNameOrSecondUserName(String username) throws ChatNotFoundException;

    HashSet<Chat> getChatByFirstUserNameAndSecondUserName(String firstUserName, String secondUserName)
            throws ChatNotFoundException;
}
