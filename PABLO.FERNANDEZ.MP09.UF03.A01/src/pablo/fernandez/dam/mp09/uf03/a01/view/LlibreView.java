package pablo.fernandez.dam.mp09.uf03.a01.view;

import java.util.Scanner;

import pablo.fernandez.dam.mp09.uf03.a01.domain.Llibre;

public class LlibreView {
	
	public Llibre getLlibre() {
			
			System.out.println("Demanant dades del llibre ...");
			Llibre l = new Llibre();
	
			Scanner scanner = new Scanner(System.in);
			System.out.println("Titulo:");
			l.setTitle(scanner.next());
	
			System.out.println("Autor:");
			l.setAuthor(scanner.next());

			scanner.close();
			return l;
	
		}
}
