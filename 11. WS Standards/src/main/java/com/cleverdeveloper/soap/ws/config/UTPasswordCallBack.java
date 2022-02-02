package com.cleverdeveloper.soap.ws.config;

/*
PROJECT NAME : 11. WS Standards
Module NAME: IntelliJ IDEA
Author Name : @ DRRONIDZ
DATE : 02/02/2022 16:20
*/

import org.apache.wss4j.common.ext.WSPasswordCallback;

import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.UnsupportedCallbackException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class UTPasswordCallBack implements CallbackHandler {

    private Map<String, String> usernamesPasswords = new HashMap<>();

    public UTPasswordCallBack() {
        usernamesPasswords.put("cleverdeveloper", "drronidz@12041994");
        usernamesPasswords.put("javaguru", "abdou@12041994");
    }

    @Override
    public void handle(Callback[] callbacks) throws IOException, UnsupportedCallbackException {
        for (Callback callback: callbacks) {
            // Getting the id (username) from the callback
            WSPasswordCallback passwordCallback = (WSPasswordCallback) callback;
            // Setting the corresponding password to it
            String password = usernamesPasswords.get(passwordCallback.getIdentifier());
            if (password != null) {
                passwordCallback.setPassword(password);
            }
        }
    }
}
