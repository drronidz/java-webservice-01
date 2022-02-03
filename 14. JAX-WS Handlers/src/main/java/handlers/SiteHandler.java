package handlers;

/*
PROJECT NAME : 14. JAX-WS Handlers
Module NAME: IntelliJ IDEA
Author Name : @ DRRONIDZ
DATE : 03/02/2022 14:18
*/

import com.diogonunes.jcolor.Attribute;

import javax.xml.namespace.QName;
import javax.xml.soap.*;
import javax.xml.ws.handler.MessageContext;
import javax.xml.ws.handler.soap.SOAPHandler;
import javax.xml.ws.handler.soap.SOAPMessageContext;
import java.util.Iterator;
import java.util.Set;

import static com.diogonunes.jcolor.Ansi.colorize;
import static com.diogonunes.jcolor.Attribute.*;
import static com.diogonunes.jcolor.Attribute.BACK_COLOR;

public class SiteHandler implements SOAPHandler<SOAPMessageContext> {


    Attribute backgroundColorHandleMessage = BACK_COLOR(39, 179, 118);
    Attribute backgroundColorGetHeaders = BACK_COLOR(85,107,47);
    Attribute backgroundColorHandleFault = BACK_COLOR(255,0,0);
    Attribute backgroundColorClose = BACK_COLOR(0,191,255);

    Attribute textColor = TEXT_COLOR(0, 0, 0);

    @Override
    public Set<QName> getHeaders() {
        // Should be implemented if the header of SOAP request message contains the attribute mustUnderstand = (value = 0 || 1)
        System.out.println(colorize("getHeaders", BOLD(), textColor, backgroundColorGetHeaders));
        return null;
    }

    @Override
    public boolean handleMessage(SOAPMessageContext context) {
        System.out.println(colorize("handleMessage", BOLD(), textColor, backgroundColorHandleMessage));
        Boolean isResponse = (Boolean) context.get(MessageContext.MESSAGE_OUTBOUND_PROPERTY);
        if (!isResponse) {
            SOAPMessage soapMessage = context.getMessage();
            try {
                SOAPEnvelope soapEnvelope = soapMessage.getSOAPPart().getEnvelope();
                SOAPHeader soapHeader = soapEnvelope.getHeader();
                Iterator childElements = soapHeader.getChildElements();

                while (childElements.hasNext()) {
                    Node node = (Node) childElements.next();
                    String name = node.getLocalName();
                    if (name != null && name.equals("SiteName")) {
                        System.out.println(colorize("Site Name : "+ node.getValue(), BOLD(), textColor, backgroundColorHandleMessage));
                    }
                }

            } catch (SOAPException e) {
                e.printStackTrace();
            }

        } else {
            System.out.println(colorize("Response on the way", BOLD(),textColor, backgroundColorHandleMessage));
        }
        return true;
    }

    @Override
    public boolean handleFault(SOAPMessageContext context) {
        System.out.println(colorize("handleFault", BOLD(), textColor, backgroundColorHandleFault));
        return false;
    }

    @Override
    public void close(MessageContext context) {
        System.out.println(colorize("close", BOLD(), textColor, backgroundColorClose));
    }
}
