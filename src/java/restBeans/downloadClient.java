/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package restBeans;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.UniformInterfaceException;
import com.sun.jersey.api.client.WebResource;

/**
 * Jersey REST client generated for REST resource:downloadService
 * [/download]<br>
 * USAGE:
 * <pre>
 *        downloadClient client = new downloadClient();
 *        Object response = client.XXX(...);
 *        // do whatever with response
 *        client.close();
 * </pre>
 *
 * @author Kay
 */
public class downloadClient {
    private WebResource webResource;
    private Client client;
    private static final String BASE_URI = "http://localhost:8080/SDLab2_Archivos/webresources";

    public downloadClient() {
        com.sun.jersey.api.client.config.ClientConfig config = new com.sun.jersey.api.client.config.DefaultClientConfig();
        client = Client.create(config);
        webResource = client.resource(BASE_URI).path("download");
    }

    public <T> T descargarArchivo(Class<T> responseType, String user, String file) throws UniformInterfaceException {
        WebResource resource = webResource;
        resource = resource.path(java.text.MessageFormat.format("{0}/{1}", new Object[]{user, file}));
        return resource.get(responseType);
    }

    public void close() {
        client.destroy();
    }
    
}
