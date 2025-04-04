package pkg03des;
import java.io.*;
import java.security.*;
import javax.crypto.*;
//Para el algoritmo
import javax.crypto.interfaces.*;
//Para definir el tamaño de la clave y subclave
import javax.crypto.spec.*;

public class Main {

    public static void main(String[] args) throws Exception{
        /*Vamos a crear un programa que tedebe de leer un archivo de texto plano se debe introducir una clabe debe de cifrarlo y generar el archivo correspondiente*/
        if(args.length != 1){
        mensajeAyuda();
        System.exit(1);
       } 
        
        System.out.println("1.-- Generar las claves DES");
        
        KeyGenerator generadorDES = KeyGenerator.getInstance("DES");
        System.out.println("");
        
        generadorDES.init(56);
        
        SecretKey clave = generadorDES.generateKey();
        
        System.out.println("La clave es: " + clave);
        
        //no es posible distinguir los butes de un cracter
        //si no esta codificado
        mostrarBytes(clave.getEncoded());
        
        System.out.println("Clave codificada: " + clave.getEncoded());
        System.out.println("");
        
        /*El tipo de cifrado es del tipo simetrico, la clave de cifrado es la mismo para descifrar.
        Hay que definir el modo de operación del cifrado: Flujo o es por bloque
        ECB 
        Si va a tener o no relleno
        Debemos de aplicar un estándar para dicho relleno
        PKCS5 (estandar de relleno) 
        */
        
        Cipher cifrador = Cipher.getInstance("DES/ECB/PKCS5Padding");
        
        //Vamos a crear el menu para cofrar y descifrar
        System.out.println("2.- Cifrar uun fichero co DES: " 
        + args[0] + "dejamos el resultado en: "
        + args[0] + ".cifrado");
        
       //tenemos que cargar el archivo y ejecutar el cifrado
       cifrador.init(Cipher.ENCRYPT_MODE, clave);
        
       //Es importante recordar el modo
       //ECB no puede automatizar el flujo del bloque
       byte[] buffer = new byte[1000];
       //Sirve para guardar el resultado
       byte[] buffercifrado;
       
       //definir el archivo
       FileInputStream entrada = new FileInputStream(args [0]);
       FileOutputStream salida = new FileOutputStream(args [0] + ".cifrado");
       
       int bytesleidos = entrada.read(buffer,0,1000);
       
       while(bytesleidos != -1){
           buffercifrado = cifrador.update(buffer, 0, 1000);
           salida.write(buffercifrado);
           bytesleidos = entrada.read(buffer, 0, bytesleidos);
           
       }
       
       //construir salida
       buffercifrado = cifrador.doFinal();
       //genero el archivo de salida
       salida.write(buffercifrado);
       
       entrada.close();
       salida.close();
       
       //ahora a descrifrar
        System.out.println("3.- Descifrar uun fichero co DES: " 
        + args[0] + ".cifrado "
        + args[0] + ".cifrado");
        
       //tenemos que cargar el archivo y ejecutar el cifrado
       cifrador.init(Cipher.DECRYPT_MODE, clave);
        
       byte[] bufferdescifrado;
       
       //definir el archivo
        entrada = new FileInputStream(args [0]+".cifrado");
        salida = new FileOutputStream(args [0] + ".descifrado");
       
        bytesleidos = entrada.read(buffer,0,1000);
       
       while(bytesleidos != -1){
           bufferdescifrado = cifrador.update(buffer, 0, 1000);
           salida.write(bufferdescifrado);
           bytesleidos = entrada.read(buffer, 0, bytesleidos);
           
       }
       
       //construir salida
       bufferdescifrado = cifrador.doFinal();
       //genero el archivo de salida
       salida.write(bufferdescifrado);
       
       entrada.close();
       salida.close();
       
       
    }
    
    public static void cifrar(){
       
    }
    
    public static void desCifrar(){
       
    }
    
    public static void mensajeAyuda(){
        System.out.println("Ejemplo de un programa que sirve para cifrR Y DESCIFRAR CON des");
        System.out.println("Favor de ingresar un archivo de texto plano, si no, no funciona .txt");
    }
    
    public static void mostrarBytes(byte[] buffer){
        System.out.write(buffer, 0, buffer.length);
    }
}
    
    
