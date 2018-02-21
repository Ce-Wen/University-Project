package Menu;

import java.util.ArrayList;
import java.util.Scanner;

public class Chasseur extends Personnage{ //definit un chasseur(capacites, vitalite)

public Chasseur(){
	super();
}


public Chasseur(Personnage p) {//constructeur par recopie
	 this.setFOR(p.getFOR());	
	 this.setDEX(p.getDEX());
	 this.setINT(p.getINT());
	 this.setCON(p.getCON());
	 this.setVIT(p.getVIT());
	 this.setEXP(p.getEXP());
	 this.setNom(new String(p.getNom()));
	 this.sets(p.gets());
	 this.setAL(new ArrayList<Capacite>(p.getAL()));
}


public void verifcap(){//verifie si les caracteristiques entrees sont valides suivant les conditions de l'enonce
	if (this.getFOR()<20 || this.getDEX()<20 || this.getINT()<20 || this.getCON()<20 || (this.getFOR()+this.getDEX()+this.getINT()+this.getCON())>(100+this.getEXP())){
		System.out.println("Erreur d'attribution : Attribuez les points en suivant les consignes !\n");
		capC();//si mauvaise attribution, rappelle l'initialisation des caracteristiques
	}else{//sinon, attribue la vitalite en fonction de ces caracteristiques
		this.setVIT((200 - (this.getFOR() + this.getDEX() + this.getINT() + this.getCON())) + (this.getEXP()*3));
	}
}
	
public void capC(){
	
	System.out.println("Attribution des caracteristiques : ");
		System.out.println("Warning : Il est deconseille de mettre une des capacites a son maximum.\n");
		Scanner f=new Scanner(System.in);
		this.setFOR(20);this.setDEX(20);this.setINT(20);this.setCON(20);//respecte la condition 20 ou +
		this.sets("chasseur");
		
		System.out.println("Force : entre 0 et "+(20+this.getEXP())+"\n");
			this.setFOR(this.getFOR()+f.nextInt());
		System.out.println("Dexterite : entre 0 et "+(    ( (20+this.getEXP()) ) -this.getFOR()+  20    )+"\n");//calcule les points restants a attribuer
			this.setDEX(this.getDEX()+f.nextInt());
		System.out.println("Intelligence : entre 0 et "+(((20+this.getEXP()))-this.getFOR()-this.getDEX()+ 40 )+"\n");//calcule les points restants a attribuer
			this.setINT(this.getINT()+f.nextInt());
		System.out.println("Concentration : entre 0 et "+(((20+this.getEXP()))-this.getFOR()-this.getDEX()-this.getINT()+60)+"\n");//calcule les points restants a attribuer
			this.setCON(this.getCON()+f.nextInt());
	
		verifcap();//verifier les caracteristiques
		
}
				
}
//___________________________________________