package com.springapp.mvc;

import chat.ChatConnectionException;
import chat.ChatLogginException;
import chat.OpenfireManager;
import org.jivesoftware.smack.AbstractXMPPConnection;
import org.jivesoftware.smack.SmackException;
import org.jivesoftware.smack.XMPPException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.Set;

@Controller
@RequestMapping("/chat")
public class ChatController {
    Logger logger = LoggerFactory.getLogger(this.getClass());

    @RequestMapping(value = "/chatPage",method = {RequestMethod.GET,RequestMethod.POST})
    public String printWelcome(ModelMap model) throws ChatConnectionException {
        logger.info("sdasdasdsaa");
        return "hello";
    }

    @RequestMapping("/getRoster")
    public
    @ResponseBody
    Set getRoster() throws ChatConnectionException, ChatLogginException {
        AbstractXMPPConnection connection = OpenfireManager.getConnection("ccc", "012342");
        OpenfireManager.loginChatServer(connection);
        return OpenfireManager.getRoster(connection).getEntries();
    }

}