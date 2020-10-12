package com.cretus.soapweb;

import org.springframework.ws.soap.server.endpoint.annotation.FaultCode;
import org.springframework.ws.soap.server.endpoint.annotation.SoapFault;

@SoapFault(faultCode = FaultCode.CLIENT)
public class CourseNotFoundException extends RuntimeException {
    private static final long serialVersionUID = 1193181112;
    public CourseNotFoundException(String message) {
        super(message);
    }

}
