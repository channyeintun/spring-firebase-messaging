package com.firebase.firebasedemo.endpoint;

import com.firebase.firebasedemo.service.FirebaseService;
import com.google.firebase.messaging.FirebaseMessagingException;
import io.grpc.netty.shaded.io.netty.handler.codec.http2.Http2Exception;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class NotificationEndpoint {
    @Autowired
    FirebaseService firebaseService;

    @PostMapping("/sendNotification")
    public ResponseEntity sendMessage(@RequestParam("fcmToken") String token){
        // actually fcmToken must be retrieved from db where you saved
        // you can implement your service instead of this example
        // ...
        // this is just demo
        Map<String, Object> payload = new HashMap<>();
        payload.put("title", "New Message");
        payload.put("body", "Here can be any object");

        try {
            firebaseService.sendNotificationToToken(payload,token);
        } catch (FirebaseMessagingException e) {
            return ResponseEntity.internalServerError().build();
        }

        Map<String, Object> response = new HashMap<>();
        response.put("message","notification is sent.");
        response.put("success",true);
        return ResponseEntity.ok(response);
    }
}
