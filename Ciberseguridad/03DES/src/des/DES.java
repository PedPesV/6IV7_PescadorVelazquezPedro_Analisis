package des;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class DES {
    private static SecretKey clave;

    public static String ciFrar(File archivocif) throws Exception {
        KeyGenerator generadorDES = KeyGenerator.getInstance("DES");
        generadorDES.init(56);
        clave = generadorDES.generateKey();

        Cipher cifrador = Cipher.getInstance("DES/ECB/PKCS5Padding");
        cifrador.init(Cipher.ENCRYPT_MODE, clave);

        byte[] buffer = new byte[1000];
        byte[] buffercifrado;

        FileInputStream entrada = new FileInputStream(archivocif);
        File archivoCifrado = new File(archivocif.getAbsolutePath() + ".cifrado");
        FileOutputStream salida = new FileOutputStream(archivoCifrado);

        int bytesleidos = entrada.read(buffer, 0, 1000);
        while (bytesleidos != -1) {
            buffercifrado = cifrador.update(buffer, 0, bytesleidos);
            if (buffercifrado != null) {
                salida.write(buffercifrado);
            }
            bytesleidos = entrada.read(buffer, 0, 1000);
        }
        buffercifrado = cifrador.doFinal();
        salida.write(buffercifrado);

        entrada.close();
        salida.close();

        return archivoCifrado.getAbsolutePath();
    }

    public static String desCifrar(File archivodcif) throws Exception {
        if (clave == null) {
            throw new Exception("No hay clave disponible para descifrar.");
        }

        Cipher cifrador = Cipher.getInstance("DES/ECB/PKCS5Padding");
        cifrador.init(Cipher.DECRYPT_MODE, clave);

        byte[] buffer = new byte[1000];
        byte[] bufferdescifrado;

        FileInputStream entrada = new FileInputStream(archivodcif);
        File archivoDescifrado = new File(archivodcif.getAbsolutePath() + ".descifrado");
        FileOutputStream salida = new FileOutputStream(archivoDescifrado);

        int bytesleidos = entrada.read(buffer, 0, 1000);
        while (bytesleidos != -1) {
            bufferdescifrado = cifrador.update(buffer, 0, bytesleidos);
            if (bufferdescifrado != null) {
                salida.write(bufferdescifrado);
            }
            bytesleidos = entrada.read(buffer, 0, 1000);
        }
        bufferdescifrado = cifrador.doFinal();
        salida.write(bufferdescifrado);

        entrada.close();
        salida.close();

        return archivoDescifrado.getAbsolutePath();
    }
}
