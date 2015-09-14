package chat;


import org.jivesoftware.smack.SmackException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ChatLogginException extends Throwable {
    private Logger logger = LoggerFactory.getLogger(ChatLogginException.class);

    public ChatLogginException(SmackException.NotLoggedInException e) {
        super("用户登录异常，请检查用户名或者密码");
    }
}
