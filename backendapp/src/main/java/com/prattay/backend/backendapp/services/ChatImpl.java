package com.prattay.backend.backendapp.services;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

// import org.springframework.beans.factory.annotation.Autowired;

import com.prattay.backend.backendapp.domain.Chat;
import com.prattay.backend.backendapp.domain.Message;
import com.prattay.backend.backendapp.exceptions.ChatNotFoundException;
import com.prattay.backend.backendapp.exceptions.NoChatExistInTheRepo;
import com.prattay.backend.backendapp.repositories.ChatRepository;
// import com.prattay.backend.backendapp.repositories.MessageRepository;

@Service
public class ChatImpl implements ChatService {

    @Autowired
    private ChatRepository chatRepository;

    public Chat addChat(Chat chat) {
        return chatRepository.save(chat);
    }

    @Override
    public List<Message> getAllMessagesInChat(Long chatId) throws NoChatExistInTheRepo {
        Optional<Chat> chat = chatRepository.findById(chatId);

        if (chat.isEmpty()) {
            throw new NoChatExistInTheRepo();
        } else {
            return chat.get().getMessageList();
        }
    }

    @Override
    public List<Chat> findAllChats() throws NoChatExistInTheRepo {
        if (chatRepository.findAll().isEmpty()) {
            throw new NoChatExistInTheRepo();
        } else {
            return chatRepository.findAll();
        }

    }

    @Override
    public Chat getById(Long id) throws ChatNotFoundException {
        Optional<Chat> chatid = chatRepository.findById(id);
        if (chatid.isPresent()) {
            return chatid.get();
        } else {
            throw new ChatNotFoundException();
        }
    }

    @Override
    public HashSet<Chat> getChatByFirstUserName(String username) throws ChatNotFoundException {
        HashSet<Chat> chat = chatRepository.getChatByFirstUserName(username);

        if (chat.isEmpty()) {
            throw new ChatNotFoundException();
        } else {
            return chat;
        }
    }

    @Override
    public HashSet<Chat> getChatBySecondUserName(String username) throws ChatNotFoundException {
        HashSet<Chat> chat = chatRepository.getChatBySecondUserName(username);
        if (chat.isEmpty()) {
            throw new ChatNotFoundException();
        } else {
            return chat;
        }
    }

    @Override
    public Chat addMessage1(Message add, Long chatId) throws ChatNotFoundException {
        Optional<Chat> chat = chatRepository.findById(chatId);
        Chat chat1 = chat.get();

        if (chat1.getMessageList() == null) {
            List<Message> msg = new ArrayList<>();
            msg.add(add);
            chat1.setMessageList(msg);
            return chatRepository.save(chat1);
        } else {
            List<Message> rates = chat1.getMessageList();
            rates.add(add);
            chat1.setMessageList(rates);
            return chatRepository.save(chat1);
        }
    }

    @Override
    public HashSet<Chat> getChatByFirstUserNameOrSecondUserName(String username) throws ChatNotFoundException {
        HashSet<Chat> chat = chatRepository.getChatByFirstUserName(username);
        HashSet<Chat> chat1 = chatRepository.getChatBySecondUserName(username);

        chat1.addAll(chat);

        if (chat.isEmpty() && chat1.isEmpty()) {
            throw new ChatNotFoundException();
        } else if (chat1.isEmpty()) {
            return chat;
        } else {
            return chat1;
        }
    }

    @Override
    public HashSet<Chat> getChatByFirstUserNameAndSecondUserName(String firstUserName, String secondUserName)
            throws ChatNotFoundException {
        HashSet<Chat> chat = chatRepository.getChatByFirstUserNameAndSecondUserName(firstUserName, secondUserName);
        HashSet<Chat> chat1 = chatRepository.getChatBySecondUserNameAndFirstUserName(firstUserName, secondUserName);
        if (chat.isEmpty() && chat1.isEmpty()) {
            throw new ChatNotFoundException();
        } else if (chat.isEmpty()) {
            return chat1;
        } else {
            return chat;
        }
    }
}
