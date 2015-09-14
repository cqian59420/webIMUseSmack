package chat;


import org.jivesoftware.smack.AbstractXMPPConnection;
import org.jivesoftware.smack.SmackConfiguration;
import org.jivesoftware.smack.SmackException;
import org.jivesoftware.smack.XMPPException;
import org.jivesoftware.smack.packet.Presence;
import org.jivesoftware.smack.roster.Roster;
import org.jivesoftware.smack.roster.RosterEntry;
import org.jivesoftware.smack.roster.RosterListener;
import org.jivesoftware.smack.tcp.XMPPTCPConnection;
import org.jivesoftware.smack.tcp.XMPPTCPConnectionConfiguration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.Collection;

public class OpenfireManager {

    private static Logger logger = LoggerFactory.getLogger(OpenfireManager.class);

    public static void main(String[] args) throws SmackException.NotLoggedInException, InterruptedException, SmackException.NotConnectedException {
        OpenfireManager openFireManager = new OpenfireManager();
        String serviceName = "@sun-d601bacdc00";
        try {
            SmackConfiguration.DEBUG = true;
            AbstractXMPPConnection connection = openFireManager.getConnection("ccc", "012342");
            openFireManager.loginChatServer(connection);
            System.out.println("readRoster");


            Roster roster = Roster.getInstanceFor(connection);
            if (!roster.isLoaded()) {
                roster.reloadAndWait();
            }
            for (RosterEntry rosterEntry : roster.getEntries()) {
                String name = rosterEntry.getName();
                System.out.println(name + "~~~~~~~~~~~" + roster.getPresence(name + serviceName));
            }

        } catch (ChatConnectionException e) {
            e.printStackTrace();
        }
    }

    public static AbstractXMPPConnection getConnection(CharSequence userName,String pass) throws ChatConnectionException {

        /*CharSequence userName = "ccc";
        String pass = "012342";*/
        String host = "172.16.9.88";
        int port = 5222;
        String serviceName = "172.16.9.88";
        XMPPTCPConnectionConfiguration xmpptcpConnectionConfiguration =
                XMPPTCPConnectionConfiguration.builder().setSecurityMode(XMPPTCPConnectionConfiguration.SecurityMode.disabled).
                        setUsernameAndPassword(userName, pass).setHost(host).setPort(port).setServiceName(serviceName).setDebuggerEnabled(Boolean.TRUE).build();
        AbstractXMPPConnection connection = new XMPPTCPConnection(xmpptcpConnectionConfiguration);
        try {
            return connection.connect();
        } catch (SmackException e) {
            throw new ChatConnectionException(e);
        } catch (IOException e) {
            throw new ChatConnectionException(e);
        } catch (XMPPException e) {
            throw new ChatConnectionException(e);
        }

    }

    public static void disConnection(AbstractXMPPConnection connection) {
        connection.disconnect();
    }

    public static void loginChatServer(AbstractXMPPConnection connection) throws ChatConnectionException {
        try {
            connection.login();
        } catch (XMPPException e) {
            throw new ChatConnectionException(e);
        } catch (SmackException e) {
            throw new ChatConnectionException(e);
        } catch (IOException e) {
            throw new ChatConnectionException(e);
        }
    }

    public static Roster getRoster(AbstractXMPPConnection connection) throws ChatConnectionException,ChatLogginException {
        Roster roster = Roster.getInstanceFor(connection);
        if (!roster.isLoaded()) {
            try {
                roster.reloadAndWait();
            } catch (SmackException.NotLoggedInException e) {
               throw new ChatLogginException(e);
            } catch (SmackException.NotConnectedException e) {
               throw new ChatConnectionException(e);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        roster.addRosterListener(new RosterListener() {
            @Override
            public void entriesAdded(Collection<String> collection) {

            }

            @Override
            public void entriesUpdated(Collection<String> collection) {

            }

            @Override
            public void entriesDeleted(Collection<String> collection) {

            }

            @Override
            public void presenceChanged(Presence presence) {
                logger.info(presence.getStatus()+"发生改变");
            }
        });
        logger.info("roster的数目为" + roster.getEntries().size());
        return roster;
    }
}
