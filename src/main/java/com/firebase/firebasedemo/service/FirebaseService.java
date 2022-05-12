package com.firebase.firebasedemo.service;

import com.google.firebase.messaging.FirebaseMessagingException;

import java.util.Map;

public interface FirebaseService {
    public String sendNotificationToToken(Map<String,Object> payload,String token) throws FirebaseMessagingException;
    public String sendNotificationToTopic(Map<String,Object> payload,String topic) throws FirebaseMessagingException;
}
