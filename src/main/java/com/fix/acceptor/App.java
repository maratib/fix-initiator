package com.fix.acceptor;

import java.io.InputStream;

import quickfix.Acceptor;
import quickfix.DefaultMessageFactory;
import quickfix.FileLogFactory;
import quickfix.FileStoreFactory;
import quickfix.LogFactory;
import quickfix.MessageFactory;
import quickfix.MessageStoreFactory;
import quickfix.SessionSettings;
import quickfix.SocketAcceptor;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) {

        try {

            quickfix.Application acceptorApp = new Application();
            SessionSettings settings = getSettingsInputStream();

            MessageStoreFactory storeFactory = new FileStoreFactory(settings);
            LogFactory logFactory = new FileLogFactory(settings);
            MessageFactory messageFactory = new DefaultMessageFactory();
            Acceptor acceptor = new SocketAcceptor(acceptorApp, storeFactory, settings, logFactory, messageFactory);
            acceptor.start();
            boolean condition = true;

            System.out.println("FIX Acceptor STARTED!");
            while (condition == true) {
                Thread.sleep(100);
            }
            acceptor.stop();

            System.out.println("Hello FIX Acceptor!");
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }

    }

    private static SessionSettings getSettingsInputStream() {

        InputStream inputStream = null;
        SessionSettings settings = null;
        inputStream = App.class.getResourceAsStream("executor.cfg");

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
