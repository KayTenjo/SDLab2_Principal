/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package managedBeans;

import com.google.gson.Gson;
import com.sun.org.apache.xerces.internal.impl.dv.util.Base64;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import javaClasses.subirArchivo;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import org.apache.commons.io.IOUtils;
import org.primefaces.model.UploadedFile;
import restBeans.uploadClient;

/**
 *
 * @author Kay
 */
@Named(value = "subirArchivoMB")
@RequestScoped
public class subirArchivoMB {

    private String nombre_archivo;
    private String nombre_usuario;
    private UploadedFile archivo;
    
    public subirArchivoMB() {
    }
    
    public void subir() throws FileNotFoundException, IOException{
    
    System.out.println("yey voy a subir un archivo ");
    subirArchivo objeto = new subirArchivo();
    Gson gson = new Gson();
    
    objeto.setNombre_virtual(nombre_archivo);
    
    byte[] bytes = IOUtils.toByteArray(archivo.getInputstream());
    String encode = Base64.encode(bytes);
    objeto.setArchivo(encode);
    String json = gson.toJson(objeto);
    
    uploadClient uc = new uploadClient();
        
    uc.subirArchivo(json);
    
    }
    
    public String getNombre_archivo() {
        return nombre_archivo;
    }

    public void setNombre_archivo(String nombre_archivo) {
        this.nombre_archivo = nombre_archivo;
    }

    public String getNombre_usuario() {
        return nombre_usuario;
    }

    public void setNombre_usuario(String nombre_usuario) {
        this.nombre_usuario = nombre_usuario;
    }

    public UploadedFile getArchivo() {
        return archivo;
    }

    public void setArchivo(UploadedFile archivo) {
        this.archivo = archivo;
    }

    

  
}
