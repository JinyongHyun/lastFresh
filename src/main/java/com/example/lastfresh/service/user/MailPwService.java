package com.example.lastfresh.service.user;

import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import java.io.IOException;
import java.util.List;

@Service
public interface MailPwService {
    void sendUsernames(String email, String usernames) throws MessagingException, IOException;
}
