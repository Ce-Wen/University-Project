
package Menu;
import java.util.*;
public class Menu {//Faire les choix


public Menu(){};

public String accueil(){//choix jouer ou charger partie deja sauvegardee
	String c=new String();
	Scanner s=new Scanner(System.in);
	do {
		c="";
	System.out.println("  	  ----------------------------------------");
	System.out.println(" 	 | Jouer:  J  	   Charger partie:  C     |");
	System.out.println(" 	  ----------------------------------------");
	c=s.nextLine();
	}while (c.charAt(0)!='J' && c.charAt(0)!='j' && c.charAt(0)!='C' && c.charAt(0)!='c' );
		
	return c;
}

public String champions() {//choix de la guilde du personnage
	String c=new String();	
	Scanner s=new Scanner(System.in);
	do{
		c="";
	System.out.println("	 -----------------------------------------");
	System.out.println("	| Choisissez une guilde :   		  |");
	System.out.println("	| Mage:		M	Guerrier:	G |\n  	| Chasseur:	C			  |");
	System.out.println("    	 -----------------------------------------");
	c=s.nextLine();

	}while (c.charAt(0)!='M' && c.charAt(0)!='G' && c.charAt(0)!='C' && c.charAt(0)!='c' && c.charAt(0)!='m' && c.charAt(0)!='g');
		
	switch(c){
	  case "G":
		System.out.println("Vous avez saisi un Guerrier.");
		break;
	  case "M":
		System.out.println("Vous avez saisi un Mage.");
		break; 
	  case "C":
		System.out.println("Vous avez saisi un Chasseur.");
	}	
	return c;
}

public String capacites(Personnage P) {//choix des capacites en fonction du niveau 
	String c= new String();
	String retourcap =new String();
	int nbecap=0;
	if (P.getEXP() <2){ 											//personnage de niveau 1
		nbecap = 2;
	}else if (P.getEXP() >6 && P.gets().equals("mage")){			//mage de niveau 6 ou plus
		nbecap= 6;
	}else if(P.getEXP() >6 && P.gets().equals("chasseur")){			//chasseur de niveau 6 ou plus
		nbecap= 6;
	}else if(P.getEXP() >6 && P.gets().equals("guerrier")){			//guerrier d eniveau 6 ou plus
		nbecap= 3;
	}else{															//personnage de niveau 1 et  de 7 a 20
		nbecap=P.getEXP();			
	}
	
	Scanner s =new Scanner(System.in);
	do {															//tant que le joueur n'a pas saisi des capacites valides
	do{																//tant que le joueur n'a pas saisi de defense
		System.out.println("classe "+P.gets());
		c="";
		retourcap="";
	System.out.println("	 -----------------------------------------");
	System.out.println("	| Choisissez "+nbecap+" capacites :   		  |");
	System.out.println("	|                                         |");
	System.out.println("	| Attaques :                              |");
	System.out.println("	|                                         |");
	System.out.println("	| Arme:		A                         |");
	if (P.gets().equals("chasseur")||P.gets().equals("mage")){						//seulement si je joueur est un mage ou un chasseur
	System.out.println("        | Sort d'attaque:  W                      |");
	}
	System.out.println("	|                                         |");
	System.out.println("	| Defenses :                              |");
	System.out.println("	|                                         |");
	System.out.println("	| Bouclier:	B                         |");
	if (P.gets().equals("chasseur")||P.gets().equals("mage")){						//seulement si je joueur est un mage ou un chasseur
	System.out.println("        | Sort de defense:  D                     |");
	}
	System.out.println("	|                                         |");
	System.out.println("	| Soins :                           	  |");
	System.out.println("	|                                         |");
	System.out.println("	| Remede:	R                         |");
	if (P.gets().equals("chasseur")||P.gets().equals("mage")){						//seulement si je joueur est un mage ou un chasseur
	System.out.println("        | Sort de soin:  S                        |");
	}
	System.out.println("         -----------------------------------------");
	
	
	for (int i = 0; i <nbecap ; i++){   //suivant le nombre de capacites autorisees par le niveau
		c=s.nextLine();					
		retourcap+=c;					//retourcap prend les initiales des capacites choisies
	}
	
	}while ((retourcap.charAt(0)!='A' && retourcap.charAt(0)!='W' && retourcap.charAt(0)!='B' && retourcap.charAt(0)!='D' && retourcap.charAt(0)!='R' && retourcap.charAt(0)!='S'&& retourcap.charAt(0)!='a' && retourcap.charAt(0)!='w' && retourcap.charAt(0)!='b' && retourcap.charAt(0)!='d' && retourcap.charAt(0)!='r' && retourcap.charAt(0)!='s')||(retourcap.charAt(1)!='A' && retourcap.charAt(1)!='W' && retourcap.charAt(1)!='B' && retourcap.charAt(1)!='D' && retourcap.charAt(1)!='R' && retourcap.charAt(1)!='S' && retourcap.charAt(1)!='a' && retourcap.charAt(1)!='w' && retourcap.charAt(1)!='b' && retourcap.charAt(1)!='d' && retourcap.charAt(1)!='r' && retourcap.charAt(1)!='s'));
	
	if (retourcap.charAt(0)!='A' && retourcap.charAt(1)!='A' && retourcap.charAt(0)!='B' && retourcap.charAt(1)!='B' && retourcap.charAt(0)!='D' && retourcap.charAt(1)!='D' && retourcap.charAt(0)!='b' && retourcap.charAt(1)!='b'&& retourcap.charAt(0)!='a' && retourcap.charAt(1)!='a' && retourcap.charAt(0)!='d' && retourcap.charAt(1)!='d'){
		System.out.println("Il vaudrait mieux pouvoir se defendre...choisissez au moins une capacite de defense !\n");
	}
	
	}while(retourcap.charAt(0)!='A' && retourcap.charAt(1)!='A' && retourcap.charAt(0)!='B' && retourcap.charAt(1)!='B' && retourcap.charAt(0)!='D' && retourcap.charAt(1)!='D' && retourcap.charAt(0)!='b' && retourcap.charAt(1)!='b'&& retourcap.charAt(0)!='a' && retourcap.charAt(1)!='a' && retourcap.charAt(0)!='d' && retourcap.charAt(1)!='d');
			
		return 	retourcap;
}


public String tourjeu(Personnage P){//tour normal d'un joueur

	String choix2=new String();
	String choix1=new String();
	Scanner c=new Scanner(System.in);
	Scanner t=new Scanner(System.in);
	
	String e="";

	do {
		choix1="";
	System.out.println("\n	 -------------------------------");
	System.out.println("	| Attaque : A       Fuite   : F	|\n"
					 + "	| Soin    : S                   |");
	System.out.println("         -------------------------------");
	choix1=c.nextLine();
	}while(choix1.charAt(0)!='A' && choix1.charAt(0)!='S' && choix1.charAt(0)!='F' && choix1.charAt(0)!='a' && choix1.charAt(0)!='s' && choix1.charAt(0)!='f' );
	
	
	
	if  (choix1.charAt(0)=='A' || choix1.charAt(0)=='a'){//choix plus specifique de l'attaque
		
		do{
			choix2="";
			
		System.out.println("\n	 -------------------------------");
		
		for (int i=0;i<P.getAL().size();i++){
			Capacite cape=P.getAL().get(i);
		if (cape instanceof Arme){
			System.out.println("	| Arme : A                      |");
		}
		if (cape instanceof SortAttaque){
			System.out.println( "   	| Sort : S                      |");
		}
		if (cape instanceof Bouclier){
			System.out.println("	| Bouclier : B                  |");
		}
		}
		System.out.println( "        |                 Retour   : R  |");
		System.out.println("         -------------------------------");
		choix2=t.nextLine();
		
		}while(choix2.charAt(0)!='A' && choix2.charAt(0)!='S' && choix2.charAt(0)!='B' && choix2.charAt(0)!='R' && choix2.charAt(0)!='s' && choix2.charAt(0)!='r' && choix2.charAt(0)!='a' && choix2.charAt(0)!='b' );
			
		
		e=choix1+choix2;
		if(choix2.charAt(0)=='R'|| choix1.charAt(0)=='r'){//choix de retour renvoie au menu attaque/defense/fuite
			e="";										//pour rassembler les choix
			choix1="";									//choix 1 (attaque/defense/fuite) remis a null
			choix2="";									//choix 2 (menu specifique) remis a null
			e=tourjeu(P);								//nouveau tour de choix
		}
		
	}else if(choix1.charAt(0)=='S'|| choix1.charAt(0)=='s'){//choix plus specifique du soin
		

		do{
			choix2="";
		System.out.println("\n	 -------------------------------");
		for (int i=0;i<P.getAL().size();i++){
			Capacite cape=P.getAL().get(i);
		if (cape instanceof Remede){
			System.out.println("	| Potion : P                      |");
		}
		if (cape instanceof SortSoin){
			System.out.println( "   	| Sort : S                      |");
		}
		}
		System.out.println( "        |                 Retour   : R  |");
		System.out.println("         -------------------------------");
		choix2=t.nextLine();
		
		}while(choix2.charAt(0)!='P' && choix2.charAt(0)!='S' && choix2.charAt(0)!='R' && choix2.charAt(0)!='s' && choix2.charAt(0)!='r' && choix2.charAt(0)!='p' );
		
		
		e=choix1+choix2;
		if(choix2.charAt(0)=='R'|| choix1.charAt(0)=='r'){//choix de retour renvoie au menu attaque/defense/fuite
			e="";
			choix1="";
			choix2="";
			e=tourjeu(P);
		}
		
	}else if  (choix1.charAt(0)=='F'|| choix1.charAt(0)=='f'){//choix de fuite
		System.out.println("\nTu fuis, mais la honte t'empeche de profiter de la vie. \n"
							+ "A jamais, tu resteras hante par cette defaite...\n");

		e=choix1+"";
	}
	
	return e;
	
}

public String tourjeucasattaque(){//choix en cas d'attaque de l'autre joueur
	
	String choix1=new String();
	Scanner c=new Scanner(System.in);
	
	do{
		choix1="";
	System.out.println("\n	 -------------------------------");
	System.out.println("	| Encaisser attaque : E         |");
	System.out.println("	| Defense           : D         |");
	System.out.println("         -------------------------------");
	choix1=c.nextLine();
	

	}while (choix1.charAt(0)!='E' && choix1.charAt(0)!='D' && choix1.charAt(0)!='e' && choix1.charAt(0)!='d' );
	
	
	return choix1;
}

public String tourjeuchoixdefense(Personnage P){//choix de defense specifique
	String choix2=new String();
	Scanner t=new Scanner(System.in);
	String e="";

	do{
		choix2="";
	System.out.println("\n	 -------------------------------");
	for (int i=0;i<P.getAL().size();i++){
		Capacite cape=P.getAL().get(i);
	if (cape instanceof Arme){
		System.out.println("	| Arme : A                      |");
	}
	if (cape instanceof SortDefense){
		System.out.println( "   	| Sort : S                      |");
	}
	if (cape instanceof Bouclier){
		System.out.println("	| Bouclier : B                  |");
	}
	}
	System.out.println("         -------------------------------");
	choix2=t.nextLine();
	
	}while(choix2.charAt(0)!='A' && choix2.charAt(0)!='S' && choix2.charAt(0)!='B' && choix2.charAt(0)!='s' && choix2.charAt(0)!='a' && choix2.charAt(0)!='b' );

	
	e="D"+choix2;
	
	return e;
	
}

public String evaluer_defendre(){//choix en cas de defense apres attaque
	String choix2=new String();
	Scanner t=new Scanner(System.in);
	do{
		choix2="";
	System.out.println("\n	 -------------------------------");
	System.out.println("	| Evaluer les degats : E         |\n"
					 + "   	| Se defendre immediatement : D  |");
	System.out.println("         -------------------------------");
	choix2=t.nextLine();
	

	}while (choix2.charAt(0)!='E' && choix2.charAt(0)!='D' && choix2.charAt(0)!='e' && choix2.charAt(0)!='d' );
		

	return choix2;
}

}
//_________________________________________________________________________