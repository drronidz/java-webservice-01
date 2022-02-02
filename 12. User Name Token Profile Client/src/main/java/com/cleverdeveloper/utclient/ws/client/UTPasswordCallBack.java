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
        for (Callback callback: callbacks) {
            WSPasswordCallback wsPasswordCallback = (WSPasswordCallback) callback;
            if(wsPasswordCallback.equals("cxf")) {
                wsPasswordCallback.setPassword("cxf");
            }
        }
    }
}
