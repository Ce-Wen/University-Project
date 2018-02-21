package Menu;
import java.io.Serializable;
import java.util.*;
	public class Capacite implements Serializable{//peut etre sauvegarde
		private int PBA;//probabilite
		private int EFF;//efficacite
		private int MAN;//maniabilite
		private int IMP;//impact
		private int PUI;//puissance
		private int FAC;//facilite
		private int PRO;//protection
	
	
	public int getPBA(){
		return this.PBA;
	}
	public void setPBA(int PBA){
		this.PBA=PBA;
	}
	public int getEFF(){
		return this.EFF;
	}
	public void setEFF(int EFF){
		this.EFF=EFF;
	}
	public int getMAN(){
		return this.MAN;
	}
	public void setMAN(int MAN){
		this.MAN=MAN;
	}
	public int getIMP(){
		return this.IMP;
	}
	public void setIMP(int IMP){
		this.IMP=IMP;
	}
	public int getPUI(){
		return this.PUI;
	}
	public void setPUI(int PUI){
		this.PUI=PUI;
	}
	public int getFAC(){
		return this.FAC;
	}
	public void setFAC(int FAC){
		this.FAC=FAC;
	}
	public int getPRO(){
		return this.PRO;
	}
	public void setPRO(int PRO){
		this.PRO=PRO;
	}


											
		public void capacite(Personnage P,String c){  //perso,choix des capacites
			ArrayList<Capacite> AL=new ArrayList<Capacite>();//contiendra les differentes capacites
				
		for (int i=0;i<c.length();i++){				//pour chaque capacite choisie par le joueur:
			if(c.charAt(i)=='A'||c.charAt(i)=='a'){ //suivant son type
				Arme a=new Arme();					//on instancie une capacite de ce type
				AL.add(a);							//puis on l'ajoute a l'arraylist.
				
			 }if(c.charAt(i)=='W'||c.charAt(i)=='w'){
				SortAttaque b=new SortAttaque();
				AL.add(b);
				
			} if(c.charAt(i)=='B'||c.charAt(i)=='b'){
				Bouclier d=new Bouclier();
				AL.add(d);
				
			} if(c.charAt(i)=='D'||c.charAt(i)=='d'){
				SortDefense e=new SortDefense();
				AL.add(e);
				
			} if(c.charAt(i)=='R'||c.charAt(i)=='r'){
				Remede f=new Remede();
				AL.add(f);
				
			}if (c.charAt(i)=='S'||c.charAt(i)=='s'){
				SortSoin g=new SortSoin();
				AL.add(g);
			}
		}
			P.setAL(AL);								//on ajoute cette arraylist au personnage
			
		}
		public String toString() {
			String s = new String("Man : "+this.MAN+"\nImp : " +this.IMP + "\nPui: " + this.PUI+ "\nFac : " 
									+this.FAC+ "\nPro : " + this.PRO );
			return s;
		}
	}
	
	
	
