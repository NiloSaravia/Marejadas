package marejadas;
import java.io.File;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.*;

public class Main {
    public static void main(String[] args){
        /*LectorArchivo lector = new LectorArchivo();
        List<Dato> datos = lector.leer("C:\\Users\\Duoc\\Downloads\\nodotongoy.txt");
        
        
        for(Dato d : datos){
            d.mostrar();
        }*/
        /*** Consulta directa al sitio web***/
        try{
            //1- Definir la URL
            String urlStr = "https://fundacion-instituto-profesional-duoc-uc.github.io/ATY1102-Surf/Nodo%208%20(-33,-73)%20-%20Valparai%CC%81so.txt";
            var url = new URL(urlStr);
            //2.- Crear un archio temporal
            File tempFile = File.createTempFile("Valparaiso","txt");
            tempFile.deleteOnExit();
            //3.- Copiar desde el url el archivo temporal
            try(InputStream in = url.openStream()){
                Files.copy(in, tempFile.toPath(),StandardCopyOption.REPLACE_EXISTING);
                
            }
            //4.- UNIFICAR EL ARCHIVO TEMPORAL CON LOS OBJETOS
            LectorArchivo lector = new LectorArchivo();
            List<Dato> datos = lector.leer(tempFile.getAbsolutePath());
            //5.- Mostrar resutados
            for(Dato d: datos){
                d.mostrar();
           
            
            }
        }
        
        catch(Exception e){
            e.printStackTrace();
        }    
    }
}
