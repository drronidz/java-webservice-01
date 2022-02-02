package com.cleverdeveloper.utclient.ws.client;

/*
PROJECT NAME : 12. User Name Token Profile Client
Module NAME: IntelliJ IDEA
Author Name : @ DRRONIDZ
DATE : 02/02/2022 22:20
*/

import org.apache.wss4j.common.ext.WSPasswordCallback;

import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.UnsupportedCallbackException;
import java.io.IOException;

public class UTPasswordCallBack implements CallbackHandler {
    @Override
    public void handle(Callback[] callbacks) throws IOException, UnsupportedCallbackException {
        for (int i = 0; i < callbacks.length; i++) {
            WSPasswordCallback wsPasswordCallback = (WSPasswordCallback) callbacks[i];
            if (wsPasswordCallback.getIdentifier().equals("cleverdeveloper")) {
                wsPasswordCallback.setPassword("drronidz@12041994");
            }
        }
    }
}
