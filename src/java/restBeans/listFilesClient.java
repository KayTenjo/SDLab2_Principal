/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package restBeans;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.UniformInterfaceException;
import com.sun.jersey.api.client.WebResource;

/**
 * Jersey REST client generated for REST resource:showFilesService [/upload]<br>
 * USAGE:
 * <pre>
 *        listFilesClient client = new listFilesClient();
 *        Object response = client.XXX(...);
 *        // do whatever with response
 *        client.close();
 * </pre>
 *
 * @author Kay
 */
public class listFilesClient {
    private WebResource webResource;
    private Client client;
    private static final String BASE_URI = "http://localhost:8080/SDLab2_Archivos/webresources";

    public listFilesClient() {
        com.sun.jersey.api.client.config.ClientConfig config = new com.sun.jersey.api.client.config.DefaultClientConfig();
        client = Client.create(config);
        webResource = client.resource(BASE_URI).path("list");
    }

    public String listarArchivos(String user) throws UniformInterfaceException {
        WebResource resource = webResource;
        if (user != null) {
            resource = resource.queryParam("user", user);
        }
        return resource.accept(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(String.class);
    }

    public void close() {
        client.destroy();
    }
    
}
