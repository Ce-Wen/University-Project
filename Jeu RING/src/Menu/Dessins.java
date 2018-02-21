package Menu;

public class Dessins {    //la classe qui sert a rien sauf a faire joli

	public void dessins(String L) {//dessins suivant choix de guilde

		char c = L.charAt(0);
		if (c == 'M' || c == 'm') {
			System.out.println("		   O");
			System.out.println("		   OO");
			System.out.println("		 * OOO");
			System.out.println("		 I ^-^");
			System.out.println("		  \\|_|/");
			System.out.println("		   | |");

		} else if (c == 'C' || c == 'c') {
			
			System.out.println("		   |||   ##");
			System.out.println("		(| ^-^  //");
			System.out.println("		  \\|_|/");
			System.out.println("		   | |");

		} else if (c == 'G' || c == 'g') {
			
			System.out.println("		| :::::");
			System.out.println("		| :^-^: O");
			System.out.println("		  \\|_|/");
			System.out.println("		   | |");
		
		}
	}
	
public void ring(){//titre
	System.out.println("		 _____  _____ _   _  _____");
	System.out.println("		|  __ \\|_   _| \\ | |/ ____|");
	System.out.println("		| |__) | | | |  \\| | |  __ ");
	System.out.println("		|  _  /  | | | . ` | | |_ |");
	System.out.println("		| | \\ \\ _| |_| |\\  | |__| |");
	System.out.println("		|_|  \\_\\_____|_| \\_|\\_____|\n");
	                           
	                    
}

	


}


