package com.kim.web;

import com.kim.domain.Excel;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WebSocketController {
    @MessageMapping("/server")
    @SendTo("/subscribe/client")
    public Excel greeting(Excel message) {
        return message;
    }
}