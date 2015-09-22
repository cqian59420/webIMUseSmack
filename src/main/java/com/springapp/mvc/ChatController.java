package com.springapp.mvc;

import chat.ChatConnectionException;
import chat.ChatLogginException;
import chat.OpenfireManager;
import com.alibaba.fastjson.JSON;
import com.springapp.mvc.beans.ResultWrapper;
import com.springapp.mvc.beans.UserAccount;
import org.jivesoftware.smack.AbstractXMPPConnection;
import org.jivesoftware.smack.roster.Roster;
import org.jivesoftware.smack.roster.RosterEntry;
import org.jivesoftware.smack.roster.packet.RosterPacket;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@Controller
@RequestMapping("/chat")
public class ChatController {
    Logger logger = LoggerFactory.getLogger(this.getClass());

    @RequestMapping(value = "/login", method = {RequestMethod.GET, RequestMethod.POST})
    public String printWelcome(ModelMap model) {
        logger.info("sdasdasdsaa");
        return "login";
    }

    @RequestMapping("/getRoster")
    public
    @ResponseBody
    Set<RosterEntry> getRoster() throws ChatConnectionException, ChatLogginException {
        AbstractXMPPConnection connection = OpenfireManager.getConnection("ccc", "012342");
        OpenfireManager.loginChatServer(connection);
        Set<RosterEntry> entries = OpenfireManager.getRoster(connection).getEntries();

        /*for (RosterEntry entry : entries) {
            System.out.println(entry);
        }*/

        return entries;

    }

    @RequestMapping("/login")
    public
    @ResponseBody
    ResultWrapper login(@RequestBody UserAccount userAccount) throws ChatConnectionException, ChatLogginException {
        ResultWrapper resultWrapper = new ResultWrapper("SUCCESS");
        logger.info(userAccount.toString());
        AbstractXMPPConnection connection = OpenfireManager.getConnection("ccc", "012342");
        OpenfireManager.loginChatServer(connection);
        Set<RosterEntry> entries = OpenfireManager.getRoster(connection).getEntries();

        /*for (RosterEntry entry : entries) {
            System.out.println(entry);
        }*/

        return resultWrapper;

    }

    private Set<Map> fakeMapData() {
        Set<Map> sets = new HashSet<Map>();
        int i=200;
        for (int i1 = 0; i1 < i; i1++) {
            Map<String,Integer> map = new HashMap<String,Integer>();
            map.put("zhi",i1);
            sets.add(map);
        }
        return sets;
    }

}