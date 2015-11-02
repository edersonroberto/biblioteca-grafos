package biblioteca;

import java.util.ArrayList;
import java.util.List;

public class TesteInsercaoLista {

	public static void main(String[] args) {
		
		List<String> lista = new ArrayList<String>();
		String a = "a", b = "b", c = "c", d = "d", e = "e";
		int cont = 1;
		
		lista.add(a);
		//cont ++;
		lista.add(cont, b);
		cont ++;
		lista.add(cont, c);
		cont ++;
		
		cont --;
		lista.add(cont, d);
		cont ++;
		lista.add(cont, e);
		cont ++ ;
		
		System.out.println(cont);
		for (String s : lista) {
			
			System.out.println(s);
		}
		
		
	}
}
