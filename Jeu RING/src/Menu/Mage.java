package Menu;

import java.util.ArrayList;
import java.util.Scanner;

public class Mage extends Personnage{//definit un mage(capacites, vitalite) 

	public Mage(){
		super();
	}
	
	public Mage(Personnage p) {//constructeur par recopie
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
		if (this.getFOR() > this.getDEX()) {
				
			if (this.getINT() <this.getFOR() + 15 &&  this.getCON()<this.getFOR()+ 15){
				System.out.println("Erreur d'attribution : Attribuez les points en suivant les consignes !\n");
				capM();//si mauvaise attribution, rappelle l'initialisation des caracteristiques
			}else{//sinon, attribue la vitalite en fonction de ces caracteristiques
				this.setVIT((200 - (getFOR() + getDEX() + getINT() + getCON())) + (getEXP()*3));
				System.out.println(this.toString());
			}
		
		}else{
			
			if (this.getINT() < this.getDEX() + 15 && this.getCON() < this.getDEX() + 15){
				System.out.println("Erreur d'attribution : Attribuez les points en suivant les consignes !\n");
				capM();//si mauvaise attribution, rappelle l'initialisation des caracteristiques
				
			}else{//sinon, attribue la vitalite en fonction de ces caracteristiques
				this.setVIT((200 - (getFOR() + getDEX() + getINT() + getCON())) + (getEXP()*3));
			}
		}
	}

	
	public void capM(){
		this.sets("mage");
		try{
		System.out.println("Attribution des caracteristiques : ");
		System.out.println("Warning : Il est deconseille de mettre une des caracteristiques au maximum.\n");
		Scanner f=new Scanner(System.in);
	//INTELLIGENCE______________________________________________________________________________________
		System.out.println("Intelligence : entre 20 et "+((100+this.getEXP())-20) );
		this.setINT(f.nextInt());
		int pcint=(100+this.getEXP())-(this.getINT());//calcule les points restants a attribuer
	//CONCENTRATION_____________________________________________________________________________________	
		System.out.println("Concentration : entre 20 et "+pcint+"\n" );
		this.setCON(f.nextInt());
			
		int pcfor=pcint-(this.getCON());//calcule les points restants a attribuer
   //FORCE______________________________________________________________________________________________	
		
			if(this.getINT()>this.getCON()){//respecter les conditions si intelligence>concentration
			
				if (pcfor==0){
					System.out.println("Force : entre 0 et 0\n");		
				}else if (pcfor>this.getCON() && this.getCON()>=15){
					System.out.println("Force : entre 0 et "+(this.getCON()-15)+"\n");
				}else if (pcfor<=this.getCON() && pcfor+15<this.getCON()){
					System.out.println("Force : entre 0 et "+(pcfor)+"\n");	
				}else if (pcfor<=this.getCON() && pcfor+15>=this.getCON()){
					System.out.println("Force : entre 0 et "+(this.getCON()-15)+"\n");
				}else if (pcfor>this.getCON() && this.getCON()<15){
					System.out.println("Force : entre 0 et "+(pcfor)+"\n");
				}
				
				}else{//respecter les conditions si intelligence<concentration
				if (pcfor==0){
					System.out.println("Force : entre 0 et 0\n");		
				}else if (pcfor>this.getINT() && this.getINT()>=15){
					System.out.println("Force : entre 0 et "+(this.getINT()-15)+"\n");		
				}else if (pcfor<=this.getINT() && pcfor+15<this.getINT()){
					System.out.println("Force : entre 0 et "+(pcfor)+"\n");		
				}else if (pcfor<=this.getINT() && pcfor+15>=this.getINT()){
					System.out.println("Force : entre 0 et "+(this.getINT()-15)+"\n");
				}else if (pcfor>this.getINT() && this.getINT()<15){
					System.out.println("Force : entre 0 et "+(pcfor)+"\n");
				}
			}
				
			this.setFOR(f.nextInt());//calcule les points restants a attribuer
	//DEXTERITE_________________________________________________________________________________________
			int pcdex=pcfor-this.getFOR();
			
			if(this.getINT()>this.getCON()){//respecter les conditions si intelligence>force
				
				if (pcdex==0){
					System.out.println("Dexterite : entre 0 et 0\n");		
				}else if (pcdex>this.getCON()&& this.getCON()>=15){
					System.out.println("Dexterite : entre 0 et "+(this.getCON()-15)+"\n");
				}else if (pcdex<=this.getCON() && pcdex+15<this.getCON()){
					System.out.println("Dexterite : entre 0 et "+(pcdex)+"\n");	
				}else if (pcdex<=this.getCON() && pcdex+15>=this.getCON()){
					System.out.println("Dexterite : entre 0 et "+(this.getCON()-15)+"\n");
				}else if (pcdex>this.getCON() && this.getCON()<15){
					System.out.println("Dexterite : entre 0 et "+(pcdex)+"\n");
				}
				
				}else{//respecter les conditions si intelligence<force
					
				if (pcdex==0){
					System.out.println("Dexterite : entre 0 et 0\n");		
				}else if (pcdex>this.getINT()&& this.getINT()>=15){
					System.out.println("Dexterite : entre 0 et "+(this.getINT()-15)+"\n");		
				}else if (pcdex<=this.getINT() && pcdex+15<this.getINT()){
					System.out.println("Dexterite : entre 0 et "+(pcdex)+"\n");		
				}else if (pcdex<=this.getINT() && pcdex+15>=this.getINT()){
					System.out.println("Dexterite : entre 0 et "+(this.getINT()-15)+"\n");
				}else if (pcdex>this.getINT() && this.getINT()<15){
					System.out.println("Dexterite : entre 0 et "+(pcdex)+"\n");
				}
			}
				
			this.setDEX(f.nextInt());
	
		}catch(java.util.InputMismatchException e){
				System.out.println(e);
			}
			
		verifcap();//verifier les caracteristiques
	}
	

}