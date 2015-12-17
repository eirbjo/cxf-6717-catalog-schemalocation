package org.kantega.cxfwsdlissue;

import org.apache.cxf.Bus;
import org.apache.cxf.BusFactory;
import org.apache.cxf.bus.managers.ServiceContractResolverRegistryImpl;
import org.apache.cxf.endpoint.ServiceContractResolver;
import org.apache.cxf.endpoint.ServiceContractResolverRegistry;
import org.apache.cxf.transport.servlet.CXFNonSpringServlet;

import javax.servlet.ServletContainerInitializer;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.xml.namespace.QName;
import javax.xml.ws.Endpoint;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

/**
 *
 */
public class BootInitializer implements ServletContainerInitializer {
    public void onStartup(Set<Class<?>> c, ServletContext ctx) throws ServletException {

        String ns = "http://hello.respiro.kantega.org/ws/hello-1.0";
        final QName serviceName = new QName(ns, "HelloService");


        Bus bus = BusFactory.newInstance().createBus();

        CXFNonSpringServlet cxfNonSpringServlet = new CXFNonSpringServlet();
        cxfNonSpringServlet.setBus(bus);

        ctx.addServlet("cxf", cxfNonSpringServlet).addMapping("/ws/*");

        Endpoint endpoint = Endpoint.create(new HelloService());

        Map<String, Object> props = new HashMap<String, Object>();


        props.put(Endpoint.WSDL_SERVICE, serviceName);
        props.put(Endpoint.WSDL_PORT, new QName(ns, "HelloPort"));

        endpoint.setProperties(props);
        endpoint.publish("/hello");
    }
}
