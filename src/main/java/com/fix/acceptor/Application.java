package com.fix.acceptor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import quickfix.DoNotSend;
import quickfix.FieldNotFound;
import quickfix.IncorrectDataFormat;
import quickfix.IncorrectTagValue;
import quickfix.Message;
import quickfix.MessageCracker;
import quickfix.RejectLogon;
import quickfix.SessionID;
import quickfix.UnsupportedMessageType;

public class Application extends MessageCracker implements quickfix.Application {

    private final Logger log = LoggerFactory.getLogger(getClass());

    public Application() {

    }

    @Override
    public void fromAdmin(Message msg, SessionID sessionID)
            throws FieldNotFound, IncorrectDataFormat, IncorrectTagValue, RejectLogon {
        // TODO Auto-generated method stub
        System.out.println("fromAdmin -> Message : " + msg + " : SessionID : " + sessionID);

    }

    @Override
    public void fromApp(Message msg, SessionID sessionID)
            throws FieldNotFound, IncorrectDataFormat, IncorrectTagValue, UnsupportedMessageType {
        // TODO Auto-generated method stub
        System.out.println("fromApp -> Message : " + msg + " : SessionID : " + sessionID);
        crack(msg, sessionID);

    }

    @Override
    public void onCreate(SessionID sessionID) {
        // TODO Auto-generated method stub
        System.out.println("onCreate SessionID : " + sessionID);

    }

    @Override
    public void onLogon(SessionID sessionID) {
        // TODO Auto-generated method stub
        System.out.println("onLogon SessionID : " + sessionID);

    }

    @Override
    public void onLogout(SessionID sessionID) {
        // TODO Auto-generated method stub
        System.out.println("onLogout SessionID : " + sessionID);

    }

    @Override
    public void toAdmin(Message msg, SessionID sessionID) {
        // TODO Auto-generated method stub
        System.out.println("toAdmin -> Message : " + msg + " : SessionID : " + sessionID);

    }

    @Override
    public void toApp(Message msg, SessionID sessionID) throws DoNotSend {
        // TODO Auto-generated method stub
        System.out.println("toApp -> Message : " + msg + " : SessionID : " + sessionID);

    }

}
