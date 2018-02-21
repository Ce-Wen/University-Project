package Menu;
import java.util.*;


public class Combat {
private String r1;//action du joueur 1
private String r2;//action du joueur 2
private String r;//action du tour precedent (de l'autre joueur donc)

	public void setr1(String r1){this.r1=r1;}
	public void setr2(String r2){this.r2=r2;}
	public String getr1(){return this.r1;}
	public String getr2(){return this.r2;}
	public void setr(String r){this.r=r;}
	public String getr(){return this.r;}
	
	public ArrayList<Personnage> fight(Personnage p1, Personnage p2) {//combat: renvoie les deux persos
		
		Efficacite e = new Efficacite();
		Menu m1 = new Menu();
		float eff1 = 0, eff2 = 0;                                          //efficacites des capacites
		setr1("X");
		setr2("X");
		setr("X");
		int fuite=2;                                                      //fuite
		int tour=0;                                                        //change de valeur si on fuit
		int vitalite=1;														//change de valeur si on meurt
		
		System.out.println(p1.getNom() + " versus " + p2.getNom() + " !");//debut du combat
		ArrayList<Personnage> alp=new ArrayList();                        //arraylist pour la sauvegarde
		
		
		while (p1.getVIT() > 0 && p2.getVIT() > 0 && tour==0 && vitalite==1) {			//Tant que la vitalite des deux joueurs est positive et qu'on ne fuit pas, jouer.
			
		if (fuite!=1 && vitalite==1){                                                  //si pas de fuite
				System.out.println("\n\nTour de " + p1.getNom());			//Tour du joueur 1.

				if (getr2().charAt(0) == 'A'|| getr2().charAt(0)=='a' ) {	//En cas d'attaque de joueur 2, defense possible de joueur1
					setr1(m1.tourjeucasattaque());						//choix: encaisser ou se defendre
					eff1=e.apresattaque(p1, getr1(), (int) eff2,this);	// calcule l'efficacite de la defense eventuelle ou de l'attaque apres encaissement
					
					if (eff1==8){	                                   //si p1 decide de fuir
						fuite=1;                                       //l'autre joueur ne jouera pas
						tour=1;                                         //le combat va s'arreter
						alp=findepartie(p2,p1);							//designation du gagnant
						p1=alp.get(1);									//enregistrement des joueurs dans l'arraylist pour sauvegarde eventuelle
						p2=alp.get(0);                                  //p1 position 1, p2 position 0
					}
					
					setr1(getr());									//action de joueur 1 prend une valeur neutre(X)
					
					if (p1.getVIT()==0){							//si joueur 1 meurt
							alp=findepartie(p2,p1);					//designation du gagnant
							p1=alp.get(1);							//enregistrement des joueurs dans l'arraylist pour sauvegarde eventuelle
							p2=alp.get(0);							//p1 position 1, p2 position 0
							vitalite=0;								//l'autre joueur ne jouera pas
						}

				} else {
					setr1(m1.tourjeu(p1));
					eff1 = e.reussite(p1, getr1());						// calcul reussite et efficacite joueur 1
					
					if (eff1==8){										//si p1 decide de fuir
						fuite=1;										//l'autre joueur ne jouera pas
						tour=1;											//le combat va s'arreter
						alp=findepartie(p2,p1);							//designation du gagnant
						p1=alp.get(1);									//enregistrement des joueurs dans l'arraylist pour sauvegarde eventuelle
						p2=alp.get(0);									//p1 position 1, p2 position 0
					}
				}
			
			
		}
			if (fuite!=1 && vitalite==1){												//si le joueur 1 n'a pas fuit et n'est pas mort
												
				System.out.println("\n\nTour de " + p2.getNom());			//Tour du joueur 2.(meme fonctionnement que pour joueur 1)

				if (getr1().charAt(0) == 'A'|| getr2().charAt(0)=='a'){							
					setr2(m1.tourjeucasattaque());						
					eff2=e.apresattaque(p2, getr2(), (int) eff1,this); 
					
					if (eff2==8){							
						fuite=1;
						tour=1;
						alp=findepartie(p1,p2);
						p1=alp.get(0);
						p2=alp.get(1);
						
					}
					
					setr2(getr());
					
					if (p2.getVIT()==0){
							alp=findepartie(p1,p2);
							p1=alp.get(0);
							p2=alp.get(1);
							vitalite=0;
						}
				}else{
					setr2(m1.tourjeu(p2));
					eff2 = e.reussite(p2, getr2());		
					
					if (eff2==8){										
						fuite=1;
						tour=1;
						alp=findepartie(p1,p2);
						p1=alp.get(0);
						p2=alp.get(1);
						
					}
				}
				
			}
		
		}
		return alp;//retourne la liste des personnages avec leurs caracteritiques, capacites...
	}
	
	
	public ArrayList<Personnage> findepartie(Personnage p,Personnage p2){//si un des personnages fuit ou perd
		
	
		Menu m=new Menu();
		Capacite capa=new Capacite();
		System.out.println("\n\n        *********************************");
		System.out.println("         "+p.getNom()+" remporte le combat !");
		System.out.println("        *********************************");
		
		if (p.getEXP()<20){								//si le joueur n'a pas atteint le niveau 20
		p.setEXP(p.getEXP()+1);							//son niveau (experience) augmente de 1
		System.out.println("Votre "+p.gets()+" a gagne un niveau !");
		}
		
		System.out.println("Reattribution des caracteristiques pour le niveau "+p.getEXP()+" : \n");
		
		System.out.println("Classe : "+p.gets());
		Personnage plusniv=null;//le gagnant est transfere dans un nouveau personnage d'un niveau superieur
		p2.setVIT(200-((p2.getFOR()+p2.getDEX()+p2.getINT()+p2.getCON())+p2.getEXP()*3));//le perdant regagne sa vitalite
		
		if (p.gets().equals("chasseur")){				//suivant la classe : 
			Chasseur c=new Chasseur (p);				//nouveau perso de la bonne classe
			System.out.println("EXP : "+c.getEXP());	//experience a augmente
			c.capC();									//attribution caracteristiques
			String choix=m.capacites(c);				//choix des capacites
			capa.capacite(c,choix);						//attribution des capacites suivant les choix
			plusniv= new Personnage(c);					//chasseur caste en personnage
			
		}else if (p.gets().equals("guerrier")){
			Guerrier c=new Guerrier (p);
			System.out.println("EXP : "+c.getEXP());
			c.capG();
			String choix=m.capacites(c);
			capa.capacite(c,choix);
			plusniv= new Personnage(c);
			
		}else if (p.gets().equals("mage")){
			Mage c=new Mage (p);
			System.out.println("EXP : "+c.getEXP());
			c.capM();
			String choix=m.capacites(c);
			capa.capacite(c,choix);
			plusniv=new Personnage(c);
		}
		
		System.out.println("Gagnant : "+plusniv.toString());
		System.out.println("Perdant : "+p2.toString());

		ArrayList<Personnage> alp=new ArrayList();//ajout des personnages a une array list
		alp.add(plusniv);
		alp.add(p2);
		
		return alp;//retour de l'arraymist
		}
	}

