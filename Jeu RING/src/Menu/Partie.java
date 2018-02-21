package Menu;

import java.util.ArrayList;
//import java.io.Serializable;
import java.util.Scanner;

public class Partie{ //mega-main qui appelle les autres classes pour jouer, de la creation des persos au combat.
	
	public static void clearScreen() {  		//fige le jeu qqes secondes pour avoir le temps de lire sur la console
		for(int clear = 0; clear < 5; clear++)
		  {
		     System.out.println("\n") ;
		  }
	   } 
	
	public static void main(String[]args){			
		ArrayList<Personnage> alp=new ArrayList();		//arraylist pour la sauvegarde
		String choix;									//recommencer ou arreter de jouer
do {													//tant que choix=1
		choix="";
		Menu m=new Menu();								
		Dessins d=new Dessins();
		
		d.ring();
		String s=new String(m.accueil());              //choix jouer/charger partie
		clearScreen();
		
		if (s.equals("J")){								//si on choisit de faire une nouvelle partie
		
//__________________________________________________________________________________________________
		System.out.println("Joueur 1 \n");				//creation joueur 1
		
		String champ1=m.champions();					//choix guilde
		Personnage P=new Personnage();					//perso general
		Personnage J1=new Personnage(P.caracteristique(P,champ1,m));//perso instancie par le joueur
		J1.sets(J1.guilde(champ1));						//donner le nom de sa guilde a j1
		
		try{Thread.sleep(1000);}catch(InterruptedException e){ 
			System.out.println(e.getMessage()); }
		
		d.dessins(champ1);								//le  petit dessin adapte a la guilde du joueur
		System.out.println("\n Le "+J1.guilde(champ1)+" "+J1.getNom()+" est pret a combattre.\n");
		
//____________________________________________________________________________________________________		
		System.out.println("Joueur 2 \n");			//creation joueur 2
		
		String champ2=m.champions();		
		Personnage P2=new Personnage();
		Personnage J2=new Personnage(P2.caracteristique(P2,champ2,m));
		J2.sets(J2.guilde(champ2));
		
		try{Thread.sleep(1000);}catch(InterruptedException e){
			System.out.println(e.getMessage());}
		
		d.dessins(champ2);
		System.out.println("\n Le "+J2.guilde(champ2)+" "+J2.getNom()+" est pret a combattre.\n");
//____________________________________________________________________________________________________
		

		System.out.println("\n Sauvegarder O/N ?");			//choix pour sauvegader
		Scanner sa=new Scanner(System.in);
		String sauv=new String();
		sauv=sa.nextLine();
		Sauvegarde s1= new Sauvegarde();
			if (sauv.equals("O")){
				s1.sauvegarder(J1, J2);
				System.out.println("SAVED \n\n");
			}
		
			
//____________________________________________________________________________________________________
			
			
		Combat c=new Combat();
		alp=c.fight(J1,J2);											//met les persos apres combat dans l'arraylist
		
			System.out.println("\n Sauvegarder O/N ?");				//nouveau choix pour sauvegarder apres combat
			String sauver=new String();
			sauver=sa.nextLine();
				if (sauv.equals("O")){
					s1.sauvegarder(alp.get(0), alp.get(1));			//sauvegarde les persos de l'arraylist
					System.out.println("SAVED \n\n");
				}
		
	}
	
		if (s.equals("C")){											//si on choisit de charger une sauvegarde existante
			
			Sauvegarde s1 = new Sauvegarde();
			Personnage J1=null;
			Personnage J2=null;
			ArrayList<Personnage> ar=s1.chargersauvegarde(J1,J2);	//on charge la sauvegarde dans deux personnages
			J1=ar.get(0);
			J2=ar.get(1);

			System.out.println("J1 : "+J1.toString());
   			System.out.println("J2 : "+J2.toString());

			Combat c=new Combat();									//puis on combat avec eux
   			alp=c.fight(J1,J2);
   			

   			System.out.println("\n Sauvegarder O/N ?");				//nouveau choix pour sauvegarder apres combat
   			Scanner sa=new Scanner(System.in);
   			String sauv=new String();
   			sauv=sa.nextLine();
   				if (sauv.equals("O")){
   					s1.sauvegarder(alp.get(0), alp.get(1));
   					System.out.println("SAVED \n\n");
   				}
		}
	
		
		do {
			choix="";
			Scanner scan=new Scanner(System.in);
			
		System.out.println("\nVoulez-vous recommencer (1) ou sortir (0) ?\n");
		choix=scan.nextLine();
		
		}while (choix.charAt(0)=='0' && choix.charAt(0)=='1');

		
	}while (choix.charAt(0)=='1');
		
		
		}
	}

