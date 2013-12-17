/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package restBeans;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.UniformInterfaceException;
import com.sun.jersey.api.client.WebResource;

/**
 * Jersey REST client generated for REST resource:testService [/factorial]<br>
 * USAGE:
 * <pre>
 *        factorialClient client = new factorialClient();
 *        Object response = client.XXX(...);
 *        // do whatever with response
 *        client.close();
 * </pre>
 *
 * @author Kay
 */
public class factorialClient {
    private WebResource webResource;
    private Client client;
    private static final String BASE_URI = "http://localhost:8080/SDLab2_Archivos/webresources";

    public factorialClient() {
        com.sun.jersey.api.client.config.ClientConfig config = new com.sun.jersey.api.client.config.DefaultClientConfig();
        client = Client.create(config);
        webResource = client.resource(BASE_URI).path("factorial");
    }

    public String factorial(String base) throws UniformInterfaceException {
        WebResource resource = webResource;
        if (base != null) {
            resource = resource.queryParam("base", base);
        }
        return resource.get(String.class);
    }

    public void close() {
        client.destroy();
    }
    
}
