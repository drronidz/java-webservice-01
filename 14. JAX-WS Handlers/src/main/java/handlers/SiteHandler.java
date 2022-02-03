package handlers;

/*
PROJECT NAME : 14. JAX-WS Handlers
Module NAME: IntelliJ IDEA
Author Name : @ DRRONIDZ
DATE : 03/02/2022 14:18
*/

import com.diogonunes.jcolor.Attribute;

import javax.xml.namespace.QName;
import javax.xml.soap.SOAPEnvelope;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPHeader;
import javax.xml.soap.SOAPMessage;
import javax.xml.ws.handler.MessageContext;
import javax.xml.ws.handler.soap.SOAPHandler;
import javax.xml.ws.handler.soap.SOAPMessageContext;
import java.util.Iterator;
import java.util.Set;

import static com.diogonunes.jcolor.Ansi.colorize;
import static com.diogonunes.jcolor.Attribute.BACK_COLOR;
import static com.diogonunes.jcolor.Attribute.TEXT_COLOR;

public class SiteHandler implements SOAPHandler<SOAPMessageContext> {

    Attribute backgroundColor = BACK_COLOR(39, 179, 118);
    Attribute textColor = TEXT_COLOR(0, 0, 0);

    @Override
    public Set<QName> getHeaders() {
        return null;
    }

    @Override
    public boolean handleMessage(SOAPMessageContext context) {
        Boolean isResponse = (Boolean) context.get(MessageContext.MESSAGE_OUTBOUND_PROPERTY);
        if (!isResponse) {
            SOAPMessage soapMessage = context.getMessage();
            try {
                SOAPEnvelope soapEnvelope = soapMessage.getSOAPPart().getEnvelope();
                SOAPHeader soapHeader = soapEnvelope.getHeader();
                Iterator childElements = soapHeader.getChildElements();
            } catch (SOAPException e) {
                e.printStackTrace();
            }

        } else {
            System.out.println(colorize("Response on the way", textColor, backgroundColor));
        }
        return false;
    }

    @Override
    public boolean handleFault(SOAPMessageContext context) {
        return false;
    }

    @Override
    public void close(MessageContext context) {

    }
}
