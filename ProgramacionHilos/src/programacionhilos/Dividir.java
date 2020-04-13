/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package programacionhilos;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author John Henry
 */
public  class Dividir extends Thread
{
    
     private HashMap<Integer, String> doc = new HashMap<Integer, String>();
     private List<HashMap<String, Integer>> docPalabras = new ArrayList<>();
     private List<String> palabrasUnicas = new ArrayList<String>();

     public void cargarArchivos(String ruta) {
		try {
			File corpus = new File(ruta);
			FileReader fr = new FileReader(corpus);
			BufferedReader br = new BufferedReader(fr);
			String linea;
			Integer cont = 0;
			while ((linea = br.readLine()) != null) {
				doc.put(cont, linea);
				cont++;
			}
			fr.close();
			br.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		this.Unicas();
	}
     public void Unicas() {
		Map<String, Integer> diccionarioPalabras = new HashMap<String, Integer>();
		Set<Integer> keys = doc.keySet();
		for (Integer key : keys) {
			String[] palabras = doc.get(key).split(" ");
			for (String p : palabras) {
				if (!diccionarioPalabras.containsKey(p)) {
					diccionarioPalabras.put(p, 1);
				}
			}
		}
		for (Object a : diccionarioPalabras.keySet().toArray()) {
			palabrasUnicas.add(a.toString());
		}
		this.documentoPalabra();
	}
     public void documentoPalabra() {
		Set<Integer> keys = doc.keySet();
		for (Integer key : keys) {
			HashMap<String, Integer> palabraCantidad = new HashMap<String, Integer>();
			String[] palabras = doc.get(key).split(" ");
			for (String p : palabras) {
				if (palabraCantidad.containsKey(p)) {
					palabraCantidad.put(p, (Integer) (palabraCantidad.get(p) + 1));
				} else {
					palabraCantidad.put(p, (Integer) 1);
				}
			}
			docPalabras.add(palabraCantidad);
		}
	}
    public void DosHilos()  {
        List<HashMap<String, Integer>> docPalabrasHilo1 = new ArrayList<>();
        List<HashMap<String, Integer>> docPalabrasHilo2 = new ArrayList<>();
        int contador = 0;
        for (HashMap<String, Integer> divid : docPalabras) {
            contador++;
            if (contador <=docPalabras.size()/2)
            {
               docPalabrasHilo1.add(divid);
            }
            else
            {
                docPalabrasHilo2.add(divid);
            }
        }
         /*System.out.println("Uso De Dos Hilos");*/
         UsoHilos prueba = new UsoHilos(docPalabrasHilo1);
         prueba.run();
         UsoHilos prueba2 = new UsoHilos(docPalabrasHilo2);
         prueba2.run();

    }
    public void CuatroHilos() {
       List<HashMap<String, Integer>> docPalabrasHilo1 = new ArrayList<>();
       List<HashMap<String, Integer>> docPalabrasHilo2 = new ArrayList<>();
       List<HashMap<String, Integer>> docPalabrasHilo3 = new ArrayList<>();
       List<HashMap<String, Integer>> docPalabrasHilo4 = new ArrayList<>();
    int contador = 0;
        for (int i =0;i <= docPalabras.size();i++)
        {
            //System.out.println(i);
            contador++;
             if (contador <=222096)
            {
               docPalabrasHilo1.add(docPalabras.get(i));
            }
            if (contador > 222096 && contador <=444192 )
            {
                docPalabrasHilo2.add(docPalabras.get(i));
            }
            if (contador >444192 && contador <=666288 )
            {
                docPalabrasHilo3.add(docPalabras.get(i));
            }
            if(contador >666288  && contador <=888386 )
            {
                docPalabrasHilo4.add(docPalabras.get(i));
            }
        }
        /*System.out.println("Tamano primer hilo="+docPalabrasHilo1.size());
        System.out.println("Tamano Segundo hilo="+docPalabrasHilo2.size());
        System.out.println("Tamano Tercer hilo="+docPalabrasHilo3.size());
        System.out.println("Tamano Cuarto hilo="+docPalabrasHilo4.size());
        System.out.println("Uso De Dos Hilos");*/
        UsoHilos prueba = new UsoHilos(docPalabrasHilo1);
        prueba.run();
        UsoHilos prueba2 = new UsoHilos(docPalabrasHilo2);
        prueba2.run();
        UsoHilos prueba3 = new UsoHilos(docPalabrasHilo3);
        prueba3.run();
        UsoHilos prueba4 = new UsoHilos(docPalabrasHilo4);
        prueba4.run();
    }
    public void SeisHilos()  {
        List<HashMap<String, Integer>> docPalabrasHilo1 = new ArrayList<>();
       List<HashMap<String, Integer>> docPalabrasHilo2 = new ArrayList<>();
       List<HashMap<String, Integer>> docPalabrasHilo3 = new ArrayList<>();
       List<HashMap<String, Integer>> docPalabrasHilo4 = new ArrayList<>();
       List<HashMap<String, Integer>> docPalabrasHilo5 = new ArrayList<>();
       List<HashMap<String, Integer>> docPalabrasHilo6 = new ArrayList<>();
       
       int contador = 0;
       // System.out.println(docPalabras.size());
      
        for (int i =0;i <= docPalabras.size();i++)
        {
            //System.out.println(i);
            contador++;
             if (contador <=148064)
            {
               docPalabrasHilo1.add(docPalabras.get(i));
            }
            if (contador >148064 && contador <=296128 )
            {
                docPalabrasHilo2.add(docPalabras.get(i));
            }
            if (contador >296128 && contador <=444192 )
            {
                docPalabrasHilo3.add(docPalabras.get(i));
            }
            if(contador >444192  && contador <=592256 )
            {
                docPalabrasHilo4.add(docPalabras.get(i));
            }
            if(contador >592256  && contador <=740320 )
            {
                docPalabrasHilo5.add(docPalabras.get(i));
            }
            if(contador >740320  && contador <=888386 )
            {
                docPalabrasHilo6.add(docPalabras.get(i));
            }
        }
        /*System.out.println("Tamano primer hilo="+docPalabrasHilo1.size());
        System.out.println("Tamano Segundo hilo="+docPalabrasHilo2.size());
        System.out.println("Tamano Tercer hilo="+docPalabrasHilo3.size());
        System.out.println("Tamano Cuarto hilo="+docPalabrasHilo4.size());
        System.out.println("Tamano Cinco hilo="+docPalabrasHilo5.size());
        System.out.println("Tamano Seis hilo="+docPalabrasHilo6.size());*/
       
        UsoHilos prueba = new UsoHilos(docPalabrasHilo1);
        prueba.run();
        UsoHilos prueba2 = new UsoHilos(docPalabrasHilo2);
        prueba2.run();
        UsoHilos prueba3 = new UsoHilos(docPalabrasHilo3);
        prueba3.run();
        UsoHilos prueba4 = new UsoHilos(docPalabrasHilo4);
        prueba4.run();
        UsoHilos prueba5 = new UsoHilos(docPalabrasHilo5);
        prueba5.run();
        UsoHilos prueba6 = new UsoHilos(docPalabrasHilo6);
        prueba6.run();
    }
    public void OchoHilos() {
        List<HashMap<String, Integer>> docPalabrasHilo1 = new ArrayList<>();
       List<HashMap<String, Integer>> docPalabrasHilo2 = new ArrayList<>();
       List<HashMap<String, Integer>> docPalabrasHilo3 = new ArrayList<>();
       List<HashMap<String, Integer>> docPalabrasHilo4 = new ArrayList<>();
       List<HashMap<String, Integer>> docPalabrasHilo5 = new ArrayList<>();
       List<HashMap<String, Integer>> docPalabrasHilo6 = new ArrayList<>();
       List<HashMap<String, Integer>> docPalabrasHilo7 = new ArrayList<>();
       List<HashMap<String, Integer>> docPalabrasHilo8 = new ArrayList<>();
       
       int contador = 0;
        //System.out.println(docPalabras.size());
      
        for (int i =0;i <= docPalabras.size();i++)
        {
            //System.out.println(i);
            contador++;
            if (contador <=111048)
            {
               docPalabrasHilo1.add(docPalabras.get(i));
            }
            if (contador >111048 && contador <=222096 )
            {
                docPalabrasHilo2.add(docPalabras.get(i));
            }
            if (contador >222096 && contador <=333144 )
            {
                docPalabrasHilo3.add(docPalabras.get(i));
            }
            if(contador >333144  && contador <=444192 )
            {
                docPalabrasHilo4.add(docPalabras.get(i));
            }
            if(contador >444192  && contador <=555240 )
            {
                docPalabrasHilo5.add(docPalabras.get(i));
            }
            if(contador >555240  && contador <=666288 )
            {
                docPalabrasHilo6.add(docPalabras.get(i));
            }
            if(contador >666288  && contador <=777336 )
            {
                docPalabrasHilo7.add(docPalabras.get(i));
            }
            if(contador >777336  && contador <=888386 )
            {
                docPalabrasHilo8.add(docPalabras.get(i));
            }
        }
      
        /*System.out.println("Tamano primer hilo="+docPalabrasHilo1.size());
        System.out.println("Tamano Segundo hilo="+docPalabrasHilo2.size());
        System.out.println("Tamano Tercer hilo="+docPalabrasHilo3.size());
        System.out.println("Tamano Cuarto hilo="+docPalabrasHilo4.size());
        System.out.println("Tamano  5 hilo="+docPalabrasHilo5.size());
        System.out.println("Tamano 6 hilo="+docPalabrasHilo6.size());
        System.out.println("Tamano 7 hilo="+docPalabrasHilo7.size());
        System.out.println("Tamano 8 hilo="+docPalabrasHilo8.size());*/
        UsoHilos prueba = new UsoHilos(docPalabrasHilo1);
        prueba.run();
        UsoHilos prueba2 = new UsoHilos(docPalabrasHilo2);
        prueba2.run();
        UsoHilos prueba3 = new UsoHilos(docPalabrasHilo3);
        prueba3.run();
        UsoHilos prueba4 = new UsoHilos(docPalabrasHilo4);
        prueba4.run();
        UsoHilos prueba5 = new UsoHilos(docPalabrasHilo5);
        prueba5.run();
        UsoHilos prueba6 = new UsoHilos(docPalabrasHilo6);
        prueba6.run();
        UsoHilos prueba7 = new UsoHilos(docPalabrasHilo7);
        prueba7.run();
        UsoHilos prueba8 = new UsoHilos(docPalabrasHilo8);
        prueba8.run();

    }
    
    


}
