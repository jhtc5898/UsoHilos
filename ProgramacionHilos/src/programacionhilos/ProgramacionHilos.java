/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


package programacionhilos;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ProgramacionHilos 
{
    public static void main(String[] args){
      String Ubicacion = "/home/usuario/Descargas/tweets.txt";
        System.out.println("Tiempo Secuencial");
      long inicio = System.currentTimeMillis();
		Matriz matriz = new Matriz();
		matriz.CargarArchivos(Ubicacion);
		matriz.MatrizFinal();
        long fin = System.currentTimeMillis();
        double tiempo = (double) ((fin - inicio)/1000);
        System.out.println(tiempo +" segundos");
        
        ///////////////////////////////////////////////////////////////////////////////////////////////
        /*
        Uso De Hilos
        */
       Dividir div = new Dividir();
      
      
      //Dos.CuatroHilos();
      //Dos.SeisHilos();
      //Dos.OchoHilos();
      
        System.out.println("Tiempo 2 Hilos");
        long inicioHilo = System.currentTimeMillis();	
         div.cargarArchivos(Ubicacion);
        div.DosHilos();
	long finHilo = System.currentTimeMillis();
        double tiempoHilo = (double) ((finHilo - inicioHilo)/1000);
        System.out.println(tiempoHilo +" segundos");
        
        /*System.out.println("Tiempo 4 Hilos");
        long inicioHilo2 = System.currentTimeMillis();	
         div.cargarArchivos(Ubicacion);
        div.CuatroHilos();
	long finHilo2 = System.currentTimeMillis();
        double tiempoHilo2 = (double) ((finHilo2 - inicioHilo2)/1000);
        System.out.println(tiempoHilo2 +" segundos");*/
        
        /*System.out.println("Tiempo 6 Hilos");
        long inicioHilo3 = System.currentTimeMillis();	
         div.cargarArchivos(Ubicacion);
        div.SeisHilos();
	long finHilo3 = System.currentTimeMillis();
        double tiempoHilo3 = (double) ((finHilo3 - inicioHilo3)/1000);
        System.out.println(tiempoHilo3 +" segundos");*/
        
        /*System.out.println("Tiempo 8 Hilos");
        long inicioHilo4 = System.currentTimeMillis();
         div.cargarArchivos(Ubicacion);
        div.OchoHilos();
	long finHilo4 = System.currentTimeMillis();
        double tiempoHilo4 = (double) ((finHilo4 - inicioHilo4)/1000);
        System.out.println(tiempoHilo4 +" segundos");*/

    }


    
}
