package com.fix.initiator;

import java.io.InputStream;

import quickfix.Application;
import quickfix.DefaultMessageFactory;
import quickfix.FileLogFactory;
import quickfix.FileStoreFactory;
import quickfix.Initiator;
import quickfix.LogFactory;
import quickfix.MessageFactory;
import quickfix.MessageStoreFactory;
import quickfix.SessionSettings;
import quickfix.SocketInitiator;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) {

        try {

            // Your application
            Application initiatorApplication = new InitiatorApplication();
            SessionSettings settings = getSettingsInputStream();

            // Message store
            MessageStoreFactory storeFactory = new FileStoreFactory(settings);

            // Logs
            LogFactory logFactory = new FileLogFactory(settings);

            // Message factory
            MessageFactory messageFactory = new DefaultMessageFactory();

            // Initiator instance
            Initiator acceptor = new SocketInitiator(initiatorApplication, storeFactory, settings, logFactory,
                    messageFactory);

            acceptor.start();
            boolean condition = true;

            System.out.println("FIX Initiator STARTED!");
            while (condition == true) {
                Thread.sleep(100);
            }
            acceptor.stop();

            System.out.println("Hello FIX Initiator!");
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }

    }

    private static SessionSettings getSettingsInputStream() {

        InputStream inputStream = null;
        SessionSettings settings = null;
        inputStream = App.class.getResourceAsStream("initiator.cfg");

        if (inputStream == null) {
            System.out.println("usage: " + App.class.getName() + " [configFile is missing]");
            System.exit(1);
        }

        try {
            settings = new SessionSettings(inputStream);
            inputStream.close();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return settings;
    }
}
