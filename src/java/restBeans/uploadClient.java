/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package restBeans;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.UniformInterfaceException;
import com.sun.jersey.api.client.WebResource;

/**
 * Jersey REST client generated for REST resource:uploadService [/upload]<br>
 * USAGE:
 * <pre>
 *        uploadClient client = new uploadClient();
 *        Object response = client.XXX(...);
 *        // do whatever with response
 *        client.close();
 * </pre>
 *
 * @author Kay
 */
public class uploadClient {
    private WebResource webResource;
    private Client client;
    private static final String BASE_URI = "http://localhost:8080/SDLab2_Archivos/webresources";

    public uploadClient() {
        com.sun.jersey.api.client.config.ClientConfig config = new com.sun.jersey.api.client.config.DefaultClientConfig();
        client = Client.create(config);
        webResource = client.resource(BASE_URI).path("upload");
    }

    public String subirArchivo(Object requestEntity) throws UniformInterfaceException {
        return webResource.type(javax.ws.rs.core.MediaType.APPLICATION_JSON).post(String.class, requestEntity);
    }

    public void close() {
        client.destroy();
    }
    
}
