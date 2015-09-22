package chat;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ChatConnectionException extends Throwable {
    private Logger logger = LoggerFactory.getLogger(ChatConnectionException.class);

    public ChatConnectionException(Exception e) {
        super("连接聊天服务器失败", e);
    }

}
