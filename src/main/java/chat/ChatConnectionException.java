package chat;
/********************************************
 * 文件名称: ChatConnection <br/>
 * 系统名称: F2F
 * 模块名称: WEB业务平台
 * 软件版权: 信雅达系统工程股份有限公司
 * 功能说明: TODO ADD FUNCTION. <br/>
 * 系统版本: 1.0.0.1
 * 开发人员:  Terrance
 * 开发时间: 2015/9/13 22:51
 * 审核人员:
 * 相关文档:
 * 修改记录: 修改日期    修改人员    修改说明
 *********************************************/

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ChatConnectionException extends Throwable {
    private Logger logger = LoggerFactory.getLogger(ChatConnectionException.class);

    public ChatConnectionException(Exception e) {
        super("连接聊天服务器失败",e);
    }

}
