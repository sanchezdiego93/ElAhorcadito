/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Generador;
import java.io.*;
/**
 *
 * @author Diego
 */
public class generador {
    public void generadorPalabras() throws IOException {
        int pos = 5;
        String nombreFichero = "palabras.txt";
        RandomAccessFile raf = null;
        
        try {
            raf = new RandomAccessFile("rw", nombreFichero);
            
            long tamano = raf.length();
            raf.seek(pos);
            
            if(raf.getFilePointer() < tamano){
                int caracter = raf.read();
                
                raf.seek(raf.getFilePointer() - 1);
                raf.write(Character.toUpperCase(caracter));
            }
        } catch (FileNotFoundException e) {
             System.out.println("Error: Fichero no encontrado");
             System.out.println(e.getMessage());
        }
        catch(IOException e){
            System.out.println("Error de lectura/escritura en el fichero");
            System.out.println(e.getMessage());
        }
        finally{
            try{
                if(raf != null){
                    raf.close();
                }
            }catch(IOException e){
                System.out.println("Error al cerrar el fichero");
                System.out.println(e.getMessage());
            }
        }
    } 
}
