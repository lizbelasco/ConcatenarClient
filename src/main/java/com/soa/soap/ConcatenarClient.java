/**
 * 
 */
package com.soa.soap;

import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;

import com.soa.dto.ConcatenarRequest;
import com.soa.dto.ConcatenarResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * Clase que genera el método de ejecución de un servicio web.
 */
public class ConcatenarClient extends WebServiceGatewaySupport {

    private static final Logger log = LoggerFactory.getLogger(ConcatenarClient.class);

    public ConcatenarResponse execute() {

        ConcatenarRequest request = new ConcatenarRequest();
        request.setNombre("Lizbeth");
        request.setApellidos("Velasco");

        log.info("Executing WS");

        ConcatenarResponse response = (ConcatenarResponse) 
                getWebServiceTemplate().marshalSendAndReceive(
                "http://localhost:8080/concatenar", request, 
                new SoapActionCallback("http://soa.com/ConcatenarRequest"));

        return response;
    }

}