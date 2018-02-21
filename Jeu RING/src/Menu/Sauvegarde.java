package Menu;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Sauvegarde {//sauvegarde et charge une sauvegarde
 
	public void sauvegarder(Personnage J1, Personnage J2) {//sauvegarde des personnage dans un fichier 
		
		try{
			FileOutputStream fos = new FileOutputStream ("sauvegarde.ser");	//nouveau fichier .ser 
			ObjectOutputStream oos = new ObjectOutputStream (fos);//ouverture
			oos.writeObject (J1);								//ecriture des persos dans le fichier
			oos.writeObject (J2);
			oos.close();
		}
		catch (java.io.IOException e) {e.printStackTrace();}
	}


	public ArrayList<Personnage> chargersauvegarde(Personnage J1,Personnage J2) {//charge des personnages
		
		 ArrayList<Personnage> ar=new ArrayList();
        try{
            FileInputStream fich = new FileInputStream("sauvegarde.ser" );//chargement du fichier .ser
            ObjectInputStream ois = new ObjectInputStream(fich);//ouverture
            J1 = (Personnage) ois.readObject();					//lecture des persos du fichier
            J2 = (Personnage) ois.readObject();
           
            ar.add(J1);					//ajoute les persos a l'arraylist
            ar.add(J2);
			
           ois.close();					//ferme la sauvegarde
          
        }catch (java.io.IOException e){
            e.printStackTrace();
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }
    
        return ar;						//retourne l'arraylist contenant les persos charges 
	}


	
	
}