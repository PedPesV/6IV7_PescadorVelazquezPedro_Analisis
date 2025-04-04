package pkg03des;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import static pkg03des.Main.mostrarBytes;

public class Funciones {
    
    // Clave que se genera una vez y se usa para cifrar y descifrar
    private static SecretKey clave;
    
    public static void ciFrar(File archivocif) throws Exception {
        System.out.println("1.-- Generar las claves DES");
        
        KeyGenerator generadorDES = KeyGenerator.getInstance("DES");
        System.out.println("");
        
        generadorDES.init(56);
        
        clave = generadorDES.generateKey();
        
        System.out.println("La clave es: " + clave);
        
        mostrarBytes(clave.getEncoded());
        
        System.out.println("Clave codificada: " + clave.getEncoded());
        System.out.println("");
        
        Cipher cifrador = Cipher.getInstance("DES/ECB/PKCS5Padding");
        
        System.out.println("2.- Cifrar un fichero con DES: " 
        + archivocif.getAbsolutePath() + " dejamos el resultado en: "
        + archivocif.getAbsolutePath() + ".cifrado");
        
        // Iniciar el cifrador
        cifrador.init(Cipher.ENCRYPT_MODE, clave);
        
        byte[] buffer = new byte[1000];
        byte[] buffercifrado;
        
        // Definir el archivo
        FileInputStream entrada = new FileInputStream(archivocif);
        FileOutputStream salida = new FileOutputStream(archivocif.getAbsolutePath() + ".cifrado");
        
        int bytesleidos = entrada.read(buffer, 0, 1000);
        
        while(bytesleidos != -1) {
            buffercifrado = cifrador.update(buffer, 0, bytesleidos);
            if (buffercifrado != null) {
                salida.write(buffercifrado);
            }
            bytesleidos = entrada.read(buffer, 0, 1000);
        }
        
        // Construir salida
        buffercifrado = cifrador.doFinal();
        // Generar el archivo de salida
        salida.write(buffercifrado);
        
        entrada.close();
        salida.close();
        
        // Devolver la ruta del archivo cifrado
        return archivocif.getAbsolutePath() + ".cifrado";
    }
    
    public static void desCifrar(File archivodcif) throws Exception {
        // Asegurarse de que tenemos una clave
        if (clave == null) {
            throw new Exception("No hay clave disponible para descifrar. Cifre primero un archivo.");
        }
        
        System.out.println("3.- Descifrar un fichero con DES: " 
        + archivodcif.getAbsolutePath() + " dejamos el resultado en: "
        + archivodcif.getAbsolutePath() + ".descifrado");
        
        Cipher cifrador = Cipher.getInstance("DES/ECB/PKCS5Padding");
        cifrador.init(Cipher.DECRYPT_MODE, clave);
        
        byte[] buffer = new byte[1000];
        byte[] bufferdescifrado;
        
        // Definir el archivo
        FileInputStream entrada = new FileInputStream(archivodcif);
        FileOutputStream salida = new FileOutputStream(archivodcif.getAbsolutePath() + ".descifrado");
        
        int bytesleidos = entrada.read(buffer, 0, 1000);
        
        while(bytesleidos != -1) {
            bufferdescifrado = cifrador.update(buffer, 0, bytesleidos);
            if (bufferdescifrado != null) {
                salida.write(bufferdescifrado);
            }
            bytesleidos = entrada.read(buffer, 0, 1000);
        }
        
        // Construir salida
        bufferdescifrado = cifrador.doFinal();
        // Generar el archivo de salida
        salida.write(bufferdescifrado);
        
        entrada.close();
        salida.close();
        
        // Devolver la ruta del archivo descifrado
        return archivodcif.getAbsolutePath() + ".descifrado";
    }
}