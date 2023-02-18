package application;

import implementation.ListaCircular;

public class Main {

	public static void main(String[] args) {
		ListaCircular<String> minhaLista = new ListaCircular<>();
		
		minhaLista.add("Dado 1");
		minhaLista.add("Dado 2");
		minhaLista.add("Dado 3");
		minhaLista.add("Dado 4");
		minhaLista.add("Dado 5");

		System.out.println(minhaLista);
		
		minhaLista.remove(3);
		minhaLista.add("99");
		
		System.out.println(minhaLista);
		
		System.out.println(minhaLista.get(0));
	}

}
