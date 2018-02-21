package Menu;

import java.util.*;

public class Efficacite {

	public float reussite(Personnage p, String cap) {// calculer la PBA d'une capacite puis retourner les degats engendres
		float PBA = 0.0f;						//probabilite						
		Bouclier b = new Bouclier();
		Arme a = new Arme();
		Remede sr = new Remede();
		SortSoin ss = new SortSoin();
		SortAttaque sa = new SortAttaque();
		SortDefense sd = new SortDefense();
		float efficacite = 0;					//efficacite degats

		if (cap.equals("AA")||(cap.equals("aa"))) {// attaque arme
			PBA = (p.getDEX() * a.getMAN());		//calcule la proba en fonction des caracteristiques de l'enonce
			PBA /= 10000;					
			if (PBA != 0) {							//si proba non nulle
				System.out.println("Attaque reussie.");
				efficacite = eff(p, cap);			//calcul des degats
			} else {
				System.out.println("Echec de la capacite, probabilite de reussite nulle.\n");//sinon, aucun degat
			}
		}
		if (cap.equals("AB")||(cap.equals("ab"))) {// attaque bouclier
			PBA = (p.getDEX() * b.getMAN());
			PBA /= 5000;
			if (PBA != 0) {
				System.out.println("Attaque reussie.");
				efficacite = eff(p, cap);
			} else {
				System.out.println("Echec de la capacite, probabilite de reussite nulle.\n");
			}
		}
		if (cap.equals("AS")||(cap.equals("as"))) {//attaque sort
			PBA = (p.getINT() * sa.getFAC());
			PBA /= 10000;
			if (PBA != 0) {
				System.out.println("Attaque reussie.");
				efficacite = eff(p, cap);
			} else {
				System.out.println("Echec de la capacite, probabilite de reussite nulle.\n");
			}
		}
		if (cap.equals("DA")||(cap.equals("da"))) {// defense arme
			PBA = (p.getDEX() * a.getMAN());
			PBA /= 5000;
			if (PBA != 0) {
				efficacite = eff(p, cap);
			} else {
				System.out.println("Echec de la capacite, probabilite de reussite nulle.\n");
			}
		}
		if (cap.equals("DB")||(cap.equals("db"))) {//defense bouclier
			PBA = (p.getDEX() * b.getMAN());
			PBA /= 10000;
			if (PBA != 0) {
				efficacite = eff(p, cap);
			} else {
				System.out.println("Echec de la capacite, probabilite de reussite nulle.\n");
			}
		}
		if (cap.equals("DS")||(cap.equals("ds"))) {//defense sort
			PBA = (p.getINT() * sd.getFAC());
			PBA /= 10000;
			if (PBA != 0) {
				efficacite = eff(p, cap);
			} else {
				System.out.println("Echec de la capacite, probabilite de reussite nulle.\n");
			}
		}
		if (cap.equals("SP")||(cap.equals("sp"))) {//sort potion
			PBA = (p.getDEX() * sr.getFAC());
			PBA /= 10000;

			if (PBA != 0) {
				efficacite = eff(p, cap);
			} else {
				System.out.println("Echec de la capacite, probabilite de reussite nulle.\n");
			}
		}
		if (cap.equals("SS")||(cap.equals("ss"))) {//sort soin
			PBA = (p.getINT() * ss.getFAC());
			PBA /= 10000;
			if (PBA != 0) {
				efficacite = eff(p, cap);
			} else {
				System.out.println("Echec de la capacite, probabilite de reussite nulle.\n");
			}
		}
		if (cap.equals("F")||cap.equals("f") ) {//fuite
			efficacite=8;
		}
		
		return efficacite;
	}

	public float eff(Personnage p, String cap) {// prend la PBA en param ->calcule l'efficacite et la retourne

		int EFF = 0;
		Bouclier b = new Bouclier();
		Arme a = new Arme();
		Remede sr = new Remede();
		SortSoin ss = new SortSoin();
		SortAttaque sa = new SortAttaque();
		SortDefense sd = new SortDefense();
		Random r = new Random();

		// ATTAQUE__________________________________________________________________________
		if (cap.equals("AA")||(cap.equals("aa"))) {//attaque arme
			EFF = (p.getFOR() * a.getIMP());		//calcul efficacite
			EFF /= 100;
			double d = -0.25 + r.nextDouble() * 0.50; // valeur aleat ~
			EFF += d;
		}
		if (cap.equals("AB")||(cap.equals("ab"))) {// attaque bouclier
			EFF = (p.getFOR() * b.getPRO());
			EFF /= 50;
		}
		if (cap.equals("AS")||(cap.equals("as"))) {//attaque sort
			EFF = (p.getCON() * sa.getPUI());
			EFF /= 100;
		}
		
		// DEFENSE_____________________________________________________________________
		if (cap.equals("DA")||(cap.equals("da"))) {//defense arme
			EFF = (p.getFOR() * a.getIMP());
			EFF /= 50;
			double d = -0.25 + r.nextDouble() * 0.50; // valeur aleat ~
			EFF += d;
			System.out.println("Efficacite : " + EFF);
			System.out.println("Vitalite : " + p.getVIT());
		}
		if (cap.equals("DB")||(cap.equals("db"))) {//defense bouclier
			EFF = (p.getFOR() * b.getPRO());
			EFF /= 100;
			System.out.println("Efficacite : " + EFF);
			System.out.println("Vitalite : " + p.getVIT());
		}
		if (cap.equals("DS")||(cap.equals("ds"))) {//defense sort
			EFF = (p.getCON() * sd.getPUI());
			EFF /= 100;
			System.out.println("Efficacite : " + EFF);
			System.out.println("Vitalite : " + p.getVIT());
		}
		// SOIN_____________________________________________________________
		if (cap.equals("SP")||(cap.equals("sp"))) {//soin potion
			EFF = (p.getFOR() * sr.getPUI());
			EFF /= 100;
			p.setVIT(p.getVIT() + EFF);
			System.out.println("Vitalite : " + p.getVIT());
		}
		if (cap.equals("SS")||(cap.equals("ss"))) {//soin sort
			EFF = (p.getCON() * ss.getPUI());
			EFF /= 100;
			p.setVIT(p.getVIT() + EFF);
			System.out.println("Vitalite : " + p.getVIT());
		}

		// _________________________________________________________________
		return EFF;
	}

	public int apresattaque(Personnage p, String cap, int reussiteautrejoueur,Combat c) {
		float eff1=0;
		Menu m = new Menu();
		
		
		// Encaisser_attaque
		if (cap.equals("E")||(cap.equals("e"))) {
			if((p.getVIT()- reussiteautrejoueur)>0){
			p.setVIT(p.getVIT() - reussiteautrejoueur);
			}else{
				p.setVIT(0);
			}
			System.out.println("Vitalite " + p.getNom() + " : " + p.getVIT());
			
			if(p.getVIT()!=0){
				
			c.setr(m.tourjeu(p));
			eff1 = reussite(p, c.getr());// calcul reussite et efficacite
			}								
		}
		// Se defendre
		if (cap.equals("D")||(cap.equals("d"))) {
			String e = m.evaluer_defendre();
			if (e.equals("D")) {// defendre immediatement
				String t = m.tourjeuchoixdefense(p);
				c.setr(t);
				
				float effdef = reussite(p, t);
					if (effdef < reussiteautrejoueur) {
						if((p.getVIT()- (reussiteautrejoueur -(int)effdef))>0){
							p.setVIT(p.getVIT() - (reussiteautrejoueur - (int) effdef));
						}else{
							p.setVIT(0);
						}
					} else {
						System.out.println("Votre defense a totalement bloque l'attaque subie. Degats nuls.");
					}
			} else {// evaluer
				System.out.println(
						"Cette attaque vous enleverait " + (int) reussiteautrejoueur
						+ " pv.\nQue voulez-vous faire ?");
				String tjca = m.tourjeucasattaque();
				c.setr(tjca);
				if (tjca.equals("E")) {//Encaisser
				if((p.getVIT()- reussiteautrejoueur)>0){
					p.setVIT(p.getVIT() - reussiteautrejoueur);
				}else{
					p.setVIT(0);
				}
					System.out.println("Vitalite " + p.getNom() + " : " + p.getVIT());
					
					if(p.getVIT()!=0){
					c.setr(m.tourjeu(p));
					
					eff1 = reussite(p, c.getr());// calcul reussite et efficacite*/
					eff1/=4;
					eff1*=3;
					}
					
				} else {//Se defendre
					String t = m.tourjeuchoixdefense(p);
					
					c.setr(t);
					
					float effdef = reussite(p, t);
					effdef/=4;
					effdef*=3;
				if (effdef < reussiteautrejoueur) {
					if((p.getVIT()- (reussiteautrejoueur-(int)effdef))>0){
						p.setVIT(p.getVIT() - (reussiteautrejoueur - (int) effdef));

						//System.out.println("Vitalite " + p.getNom() + " : " + p.getVIT());
						
					}else{
						p.setVIT(0);

						//System.out.println("Vitalite " + p.getNom() + " : " + p.getVIT());
						
					}
					} else {
						System.out.println("Votre defense a totalement bloque l'attaque subie. Degats nuls.");
					}
				}
				
			}
			}
		
		
		return (int)eff1;	
	}
	
}
