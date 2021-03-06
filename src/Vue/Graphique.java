
package Vue;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import Controleur.Joueur;
import java.awt.FlowLayout;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JOptionPane;


/**
 * gère les sous-menus de l'interface graphique
 * Classe appartient à la partie Vue du pattern MVC
 * @author fishe
 */

public class Graphique extends JFrame{
 
 /**
 * Permet de choisir de jouer en solo où à deux
 * Auteur : Paul Fisher  
 * @return config : le nombre de joueur souhaités
 */
    public int nombreJoueur(){
        JOptionPane nombre = new JOptionPane();
        int config = 0;
        
        String saisie = nombre.showInputDialog(null, "Tapez 1 si vous êtes seul(e),\n"
                + "Tapez 2 si vous jouez en multijoueur", " Joueurs ", JOptionPane.QUESTION_MESSAGE);
        
        if("1".equals(saisie)){
                config = 1;
            }else if("2".equals(saisie)){
                config = 2;
            } else{
                JOptionPane.showMessageDialog(null, "Vous avez saisie un nombre incorrect","erreur", JOptionPane.ERROR_MESSAGE);
            }
        return config;
    }

  /**
 * Affiche règle du jeu à partir d'un .txt.
 * Auteur : Paul Fisher 
 * @param question_id  
 * @return non utilisateur choisit 
 */
    public String utilisateur(String question_id){
        
        JOptionPane saisie = new JOptionPane(); // création de la boite de dialogue
        
        String nom = saisie.showInputDialog(null, question_id, " Identification ", JOptionPane.QUESTION_MESSAGE);
        
        if(nom == null){
            saisie.showMessageDialog(null,"La partie n'a pas commencée ", "Erreur", JOptionPane.CLOSED_OPTION);
        }
        
        return nom;
    }
 
    
 /**
 * PopUp indiquant début de partie
 * Auteur : Paul Fisher 
 * @author fishe 
 */
    public void MenuCommencer(){
        
        JOptionPane commence = new JOptionPane();
        
        commence.showMessageDialog(null, "Bonjour vous disposez de :  \n "
        + "1 Cuirassé\n "
        + "2 Croisseurs\n"
        + "3 Destroyeurs\n"
        + "4 Sous-marins\n"
        +"Vous pouvez jouer contre un humain ou un ordinateur\n"
        + "Bonne partie !!", "Commencer", JOptionPane.INFORMATION_MESSAGE);
         
    }
    
       
 /**
 * gère le popUp pour charger la partie
 * Auteur : Paul Fisher 
 * @return nom
 */
    public String MenuCharger(){
    
        JOptionPane charger = new JOptionPane();

        String nom = charger.showInputDialog(null, "Veuillez saisir la partie que vous souhaitez charger\n"
        + "Sinon tapez 'exit' ", "charger une partie", JOptionPane.QUESTION_MESSAGE); // saisie du message

        return nom;
    }
    
    /**
 * Permet de choisir l'action à effectuer, tirer où déplacer
 * Auteur : Paul Fisher
 * @return valeur : le choix de l'utilisateur
 */
    public String choixAction(){
        
        JFrame position = new JFrame();
        setLayout(new FlowLayout());
        position.setSize(10, 10); // taille du popUp
        position.setLocation(200, 500); // localisation du PopUp dans la fenêtre
        position.setVisible(true);
        
        JOptionPane choix = new JOptionPane();
        
        String valeur;
        valeur = choix.showInputDialog(position, "Tapez 'deplacer' si vous souhaitez vous déplacer,\n"
                + "Tapez 'tirer' si vous souhaitez effectuer un tir,\n"+"(quitter ou sauvegarder)", "Choix action");
        
        if(valeur ==  null)
            valeur = "a";
            
        position.setVisible(false);
        return valeur;
    }
    
 /**
 * Permet d'effectuer un tir
 * Auteur : Paul Fisher
 * @return tirer : correspond à l'emplacement du tir 
 */
    public String PopUpTirer(){
        
         JFrame position = new JFrame();
        setLayout(new FlowLayout());
        position.setSize(10, 10); // taille du popUp
        position.setLocation(200, 500); // localisation du PopUp dans la fenêtre
        position.setVisible(true);
        
        JOptionPane tire = new JOptionPane();
        
        String tirer = tire.showInputDialog(position, "Veuillez selectionner la case", "choix coordonnées");

        position.setVisible(false);
        
        return tirer;
       
    }
   
 /**
 * Permet de saisir de faire bouger un bateau
 * Auteur : Paul Fisher
 * @return la nouvelle position
 */
    public String PopUpDeplacer(){
        
        JFrame position = new JFrame();
        setLayout(new FlowLayout());
        position.setSize(10, 10); // taille du popUp
        position.setLocation(200, 500); // localisation du PopUp dans la fenêtre
        position.setVisible(true);
        
        JOptionPane deplacer = new JOptionPane();
        
        String mouvement = deplacer.showInputDialog(position, "Veuillez selectionner la nouvelle case", "choix coordonnées");

        position.setVisible(false);
        
        if(mouvement ==  null)
            mouvement = "a";
        
        return mouvement;
       
    }
      
 /**
 *Affiche un popUp si il y'a un gagnant
 * Auteur : Paul Fisher
 * @param gagnant : identité du joueur
 */
    
    public void PopUpGagne(String gagnant){
        JOptionPane gagne = new JOptionPane();
        
        gagne.showMessageDialog(null,  "Le "  +gagnant + "a gagné"  , "gagnant", JOptionPane.INFORMATION_MESSAGE);
    }  
    
 /**
 * PopUp pour sélectionner le bateau souhaité
 * Auteur : Paul Fisher
 * @return coordonnées du bateau
 */
   
    public String SelectionBateau(){
        
        JFrame position = new JFrame();
        setLayout(new FlowLayout());
        position.setSize(10, 10);        // taille du popUp
        position.setLocation(200, 500); // localisation du PopUp dans la fenêtre
        position.setVisible(true);
        JOptionPane choix = new JOptionPane();
        
        String bateau = choix.showInputDialog(position, "Veuillez selectionner le bateau désiré", "choix navire");

        position.setVisible(false);
        
        if(bateau ==  null)
            bateau = "a";
        
        return bateau;
       
    }
    
 /**
 * Boite de dialogue pour sauvegarder en cours de jeu
 * Auteur : Paul Fisher 
 * @return nom de la partie  
 */
    
    public String MenuSauvegarde(){
    
        JOptionPane sauvegarde = new JOptionPane();
        
        String nom_partie = sauvegarde.showInputDialog(null, " Saisir le nom de la partie ", "Sauvegarder", JOptionPane.QUESTION_MESSAGE); // saisie du message

        return nom_partie;
    }
    
    /**
 * Générer le PopUp de sauvegarde si on souhaite quitter
 * Auteur : Paul Fisher
 * @return etat true si sauvegarder false si quitter
 */
   
    public boolean SauvegardeQuitter(){
        
        JOptionPane sauvegardeExit = new JOptionPane();
        boolean etat = false;

        String nom_partie = sauvegardeExit.showInputDialog(null, " Si vous voulez sauvegarder la partie tapez oui ", "Quitter", JOptionPane.QUESTION_MESSAGE); // saisie du message
        etat = "oui".equals(nom_partie);
            
        return etat;
    }
    
    
 /**
 * Affiche pop si défault de sauvegarde
 * Auteur : Paul Fisher 
 */
     public void DefaultSauvegarde(){
        
        JOptionPane sauvegarde = new JOptionPane();
        
        sauvegarde.showMessageDialog(null, " Vous ne pouvez sauvegarder que si une partie est en cours", "Sauvegarder", JOptionPane.WARNING_MESSAGE);
    }
    
     
 /**
 * Affiche règle du jeu à partir d'un .txt
 * Auteur : Paul Fisher 
 * @throws java.io.FileNotFoundException 
 * @throws java.io.UnsupportedEncodingException 
 */
    public void Menuaide() throws FileNotFoundException, UnsupportedEncodingException, IOException{
       
         JOptionPane aide = new JOptionPane(); // création de la boite de dialogue
         File regle = new File("src\\files\\test.txt"); // emplacement du fichier
         ArrayList<String> donnees = new ArrayList<String>();
         String ligne;

                try{
                    FileReader lecture_fichier = new FileReader(regle); // fichier qu'on souhaite lire
                    BufferedReader lecture = new BufferedReader(lecture_fichier); // permet de lire le fichier ligne par ligne
                    
                    while((ligne = lecture.readLine()) != null){ // lorsque la ligne n'est pas vide
                        donnees.add(ligne); // stockage d'une ligne dans un ArrayList
                        donnees.add("\n");
                    }
             
                    aide.showMessageDialog(null, donnees , "Règles du jeu", JOptionPane.INFORMATION_MESSAGE); // affichage du contenu dans PopUp
     
                    lecture.close(); // fermeture de la mémoire tampon
  
                // Exception     
                }catch(FileNotFoundException e){ // dans le cas ou le fichier est introuvable
                } 
    }
    
 /**
 * gère le popUp pour quitter la partie
 * Auteur : Paul Fisher 
 * @return true si quitter false si reste 
 */
    public boolean MenuQuitter(){
    
        JOptionPane quitter = new JOptionPane();
        boolean etat = false;
        int dernier_message =  quitter.showConfirmDialog(null, "voulez vous vraiment quitter la partie ?", "arrêt", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

        if(dernier_message != JOptionPane.NO_OPTION &&  dernier_message != JOptionPane.CLOSED_OPTION){
            etat = true;
           // System.exit(0); // quitte si appuie sur OUI
        }
        
        return etat;
    }
       
}

 