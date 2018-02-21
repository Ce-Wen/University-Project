package Menu;

import java.util.ArrayList;
import java.util.Scanner;

public class Guerrier extends Personnage{//definit un guerrier(capacites, vitalite)

	public Guerrier(){
		super();
	}
	
	public Guerrier(Personnage p) {//constructeur par recopie
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
		if (this.getFOR()<this.getDEX()+10 || getDEX()+10<this.getINT()+10 || this.getINT()+10<this.getCON() && (this.getFOR() + this.getDEX() + this.getINT() + this.getCON()) <= (100 + this.getEXP())){
			System.out.println("Erreur d'attribution : Attribuez les points en suivant les consignes !\n");
			capG();//si mauvaise attribution, rappelle l'initialisation des caracteristiques
		}else{//sinon, attribue la vitalite en fonction de ces caracteristiques
			this.setVIT((200 - (getFOR() + getDEX() + getINT() + getCON())) + (getEXP()*3));


		}
	}
	
	public void capG(){
		this.sets("guerrier");
		int nbecap=0;
		if (this.getEXP() <2){ 
			nbecap = 2;
		}else if (this.getEXP() >6 ){
			nbecap= 6;
		}else {
			nbecap=this.getEXP();
		}
		System.out.println("Attribution des caracteristiques : "+(this.getEXP()+100)+" points pour 4 caracteristiques.");
		System.out.println("Warning : Il est conseille d'attribuer au moins 50 points a la force.\n");
		Scanner f=new Scanner(System.in);
		int pcfor,pcint,pcdex;
		this.setFOR(0);this.setDEX(0);this.setINT(0);this.setCON(0);
//FORCE___________________________________________________________________________		
		System.out.println("Force : entre 30 et "+(100+this.getEXP())+"\n");
			this.setFOR(f.nextInt());
			pcfor=(100+this.getEXP())-this.getFOR();//calcule les points restants a attribuer
		
//DEXTERITE_____________________________________________________________________________
		
		if (pcfor>this.getFOR()){
			System.out.println("Dexterite : entre 0 et "+(this.getFOR()-10)+"\n");
		}else if (pcfor<=this.getFOR() && pcfor+10<this.getFOR()){
			System.out.println("Dexterite : entre 0 et "+(pcfor)+"\n");
		}else if (pcfor<=this.getFOR() && pcfor+10>=this.getFOR()){
			System.out.println("Dexterite : entre 0 et "+((((this.getFOR()-pcfor)/2))+40)+"\n");
		}
			this.setDEX(f.nextInt());
	
			pcdex=pcfor-this.getDEX();//calcule les points restants a attribuer
//INTELLIGENCE_______________________________________________________________________________
		
			if (this.getDEX()+10>=pcdex+10){  
				System.out.println("Intelligence : entre 0 et "+(pcdex)+"\n");
			}else if(this.getDEX()+10<pcdex+10){
				System.out.println("Intelligence : entre 0 et "+this.getDEX()+"\n");
			}
			this.setINT(f.nextInt());
			
			pcint=pcdex-this.getINT();//calcule les points restants a attribuer
//CONCENTRATION_______________________________________________________________________________
			if (this.getINT()+10>=pcint){  
				System.out.println("Concentration : entre 0 et "+(pcint)+"\n");
				System.out.println("");
			}else if (this.getINT()+10<pcint){
				System.out.println("Concentration : entre 0 et "+(this.getINT()+10)+"\n");	
			}
			this.setCON(f.nextInt());
			
		verifcap();//verifier les caracteristiques
	    
		}

	}

