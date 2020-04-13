/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package programacionhilos;

import com.sun.org.apache.bcel.internal.generic.RETURN;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author John Henry
 */
public class UsoHilos implements Runnable
{

    List<HashMap<String, Integer>>  Dividido;
    public UsoHilos(List<HashMap<String, Integer>> datosDividido)
    {
        Dividido=datosDividido;
    }

    
    @Override
    public void  run() 
    {
        //System.out.println("Entro en el hilo");
		int total = 0;
		for (Map<String, Integer> doc : Dividido) 
                {
			total += doc.size();
		}
		String[][] matriz = new String[total][3];
		int j = 0;
		for (int i = 0; i < Dividido.size(); i++) 
                {
			Map<String, Integer> frecPalabra = Dividido.get(i);
			Object[] palabras = frecPalabra.keySet().toArray();
			for (int k = 0; k < frecPalabra.size(); k++) {
				matriz[j][0] = "Documento " + i;
				matriz[j][1] = palabras[k].toString();
				matriz[j][2] = frecPalabra.get(palabras[k]) + "";
				j++;
			}
		}
		//this.imprimir(matriz);
	
        //System.out.println(Dividido);
        //System.out.println("Fin");
    }
    public void imprimir(String[][] matriz) 
    {
		for (Integer x = 0; x < matriz.length; x++) 
                {
			 //System.out.print(palabras.get(x)+"\t");
			System.out.print("|");
			for (Integer y = 0; y < matriz[x].length; y++) 
                        {
				System.out.print(matriz[x][y]);
				if (y != matriz[x].length - 1)
					System.out.print("\t");
			}
			System.out.println("| ");
		}
	}
    
}
