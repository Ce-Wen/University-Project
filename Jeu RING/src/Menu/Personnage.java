package Menu;
import java.io.Serializable;
import java.util.*;
public class Personnage implements Serializable {     //la maman des mage, guerrier et chasseur 
		private int FOR;//force
		private int DEX;//dexterite 
		private int INT;//intelligence 
		private int CON;//concentraction 
		private int VIT;//vitalite 
		private int EXP;//experience
		private String Nom;//nom
		private String s;//nom de classe fille
		private ArrayList<Capacite> AL=new ArrayList<Capacite>();//arraylist des capacites
		
		public Personnage(){}//constructeur vide 


public Personnage(Personnage p){//constructeur par recopie
 this.FOR=p.getFOR();	
 this.DEX=p.getDEX();
 this.INT=p.getINT();
 this.CON=p.getCON();
 this.VIT=p.getVIT();
 this.EXP=p.getEXP();
 this.Nom=new String(p.getNom());
 this.s=p.gets();
 this.AL=new ArrayList<Capacite>(p.getAL());
}

public int getEXP(){
	return this.EXP;
}
public void setEXP(int EXP){
	this.EXP=EXP;
}
public int getFOR(){
	return this.FOR;
}
public void setFOR(int FOR){
	this.FOR=FOR;
}
public int getDEX(){
	return this.DEX;
}
public void setDEX(int dex){
	this.DEX=dex;
}
public int getINT(){
	return this.INT;
}
public void setINT(int intt){
	this.INT=intt;}
public int getCON(){
	return this.CON;
}
public void setCON(int con){
	this.CON=con;
}
public int getVIT(){
	return this.VIT;
}
public void setVIT(int vit){
	this.VIT=vit;
}
public String getNom(){
	return Nom;
}
public void setNom(String n){
	this.Nom=n;
}
public void sets(String c){
	this.s=c;
}
public String gets(){
	return this.s;
}	
public ArrayList<Capacite> getAL(){
	return this.AL;
}
public void setAL(ArrayList<Capacite> c){
	this.AL=c;
}

public Personnage caracteristique(Personnage P,String champ1,Menu m){//suivant la guilde, attribue les caracteristiques et les capacites
	String choix=new String();
	Capacite capa=new Capacite();
	

	
	if (champ1.charAt(0)=='C'){					//suivant la guilde
		
		Chasseur C=new Chasseur();				//cree un perso type
		C.setEXP(1);							//affecte une experience de 1
		C.nom();								//donne un nom
		C.capC();								//attribue les caracteristiques
		System.out.println(C.toString());
		choix=m.capacites(C);					//choix des capacites 
		capa.capacite(C,choix);					//attribue les capacites
		P=new Personnage(C);					//renvoie une personnage avec les caracteristiques d'une guilde
		
	}else if (champ1.charAt(0)=='G'){
		Guerrier G=new Guerrier();
		G.setEXP(1);
		G.nom();
		G.capG();
		System.out.println(G.toString());
		choix=m.capacites(G);
		capa.capacite(G,choix);
		P=new Personnage(G);
		
	}else {
		Mage M=new Mage();
		M.setEXP(1);
		M.nom();
		M.capM();
		System.out.println(M.toString());
		choix=m.capacites(M);
		
		capa.capacite(M,choix);
		P=new Personnage(M);
	}
	
	

		return P;
}



 
public String nom(){//choisit et retourne le nom du perso
	System.out.println("Donnez un nom a votre heros :\n");
	Scanner sc=new Scanner (System.in);
	String Nom=sc.nextLine();
	this.setNom(Nom);
	return Nom;
	}



public String guilde(String g){//retourne le nomn de guilde
	String nomguilde=new String();
	if(g.charAt(0)=='M'||g.charAt(0)=='m'){
		nomguilde=("mage");
	}else if(g.charAt(0)=='C'||g.charAt(0)=='c'){
		nomguilde=("chasseur");
	}else{
		nomguilde=("guerrier");
	}
	return nomguilde;
}

public String toString() {
	String s = new String("Nom : "+this.Nom+"\nVitalite :"+this.VIT+"\nForce : " +this.FOR + "\nDexterite : " + this.DEX+ "\nIntelligence : " 
							+this.INT+ "\nConcentration : " + this.CON+"\nExperience :"+this.getEXP()+"\n");
	return s;
}

}