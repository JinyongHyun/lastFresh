package com.example.lastfresh.service.user;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import java.io.IOException;
import java.util.List;

@Service
public interface MailService {

    void sendUsernames(String email, String usernames) throws MessagingException, IOException;

    }

