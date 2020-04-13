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


public class Matriz
{
private List<String> unicaspalabras = new ArrayList<String>();
private HashMap<Integer, String> docs = new HashMap<Integer, String>();
private List<HashMap<String, Integer>> docpalabras = new ArrayList<HashMap<String, Integer>>();


public void CargarArchivos(String ruta) {
		try {
			File corpus = new File(ruta);
			FileReader fr = new FileReader(corpus);
			BufferedReader br = new BufferedReader(fr);
			String linea;
			Integer cont = 0;
			while ((linea = br.readLine()) != null) 
                        {
				docs.put(cont, linea);
				cont++;
			}
			fr.close();
			br.close();
		}
                catch (Exception e) 
                {
			System.out.println(e.getMessage());
		}
		this.Unicas();
	}
public void docPalabra() {
		Set<Integer> keys = docs.keySet();
		for (Integer key : keys) 
                {
			HashMap<String, Integer> CantidadPalabras = new HashMap<String, Integer>();
			String[] palabras = docs.get(key).split(" ");
			for (String p : palabras) 
                        {
				if (CantidadPalabras.containsKey(p)) 
                                {
					CantidadPalabras.put(p, (Integer) (CantidadPalabras.get(p) + 1));
				} else {
					CantidadPalabras.put(p, (Integer) 1);
				}
			}
			docpalabras.add(CantidadPalabras);
		}
	}
public void Unicas() {
		Map<String, Integer> HashPalabras = new HashMap<String, Integer>();
		Set<Integer> keys = docs.keySet();
		for (Integer key : keys) 
                {
			String[] palabras = docs.get(key).split(" ");
			for (String p : palabras) 
                        {
				if (!HashPalabras.containsKey(p)) 
                                {
					HashPalabras.put(p, 1);
				}
			}
		}
		for (Object a : HashPalabras.keySet().toArray()) 
                {
			unicaspalabras.add(a.toString());
		}
		this.docPalabra();
	}
public void MatrizFinal() {
		int total = 0;
		for (Map<String, Integer> doc : docpalabras) 
                {
			total += doc.size();
		}
		String[][] matriz = new String[total][3];
		int j = 0;
		for (int i = 0; i < docpalabras.size(); i++) 
                {
			Map<String, Integer> frecPalabra = docpalabras.get(i);
			Object[] palabras = frecPalabra.keySet().toArray();
			for (int k = 0; k < frecPalabra.size(); k++) 
                        {
				matriz[j][0] = "Documento " + i;
				matriz[j][1] = palabras[k].toString();
				matriz[j][2] = frecPalabra.get(palabras[k]) + "";
				j++;
			}
		}
		//this.imprimir(matriz);
	}
public void imprimir(String[][] matriz) {
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
