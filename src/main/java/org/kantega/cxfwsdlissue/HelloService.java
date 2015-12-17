package org.kantega.cxfwsdlissue;

import org.kantega.respiro.hello.ws.hello_1_0.Hello;
import org.kantega.respiro.hello.ws.hello_1_0.MyFault;

import javax.jws.WebService;

/**
 *
 */
@WebService(targetNamespace = "http://hello.respiro.kantega.org/ws/hello-1.0", name = "Hello", wsdlLocation = "classpath:wsdl/HelloService.wsdl")
public class HelloService implements Hello {
    public String greet(String receiver, String lang) throws MyFault {
        return "Hello " + receiver;
    }
}
