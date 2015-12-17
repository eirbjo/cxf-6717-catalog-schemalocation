import org.junit.Test;

import javax.wsdl.Definition;
import javax.wsdl.WSDLException;
import javax.wsdl.factory.WSDLFactory;

/**
 *
 */
public class CatalogImportIT {

    @Test
    public void shouldParseRemoteWsdl() throws WSDLException {
        Definition definition = WSDLFactory.newInstance().newWSDLReader().readWSDL("http://localhost:8080/ws/hello?wsdl");
    }

}
