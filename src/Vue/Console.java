/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vue;

import Model.Coord;
import Controleur.Joueur;
import Model.Navire;
import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author charl
 */

public class Console {
    
     private ArrayList<Joueur> m_joueurs;
     
     public Console(ArrayList<Joueur> joueurs){
         m_joueurs = joueurs;
     }

  /**
 * Affiche la grille du jeu dans la console
 * Auteur : Savinien Godineau
 * @param joueur 
 */
     public void affichage(int joueur)
    {
       //----------------------------------------------------      
        int numero_case =0;
        int numero_case2 =0;
        char[] alphabet = new char[]{'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O'};
        char[] Bateau_Grille_Joueur1 = new char[225];
        char[] Bateau_Grille_Joueur2 = new char[225];
        
        //Initialiser les bateaux en début de partie :
        Bateau_Grille_Joueur1 = Initialisation_Bateau(joueur, 0);
        Bateau_Grille_Joueur2 = Initialisation_Bateau(joueur, 1);
        
        
        //Affichage
        for(int i =0; i< 53;++i)
            System.out.print(" ");
        
        System.out.print("GRILLE JOUEUR");
        
        for(int i =0; i< 119;++i)
            System.out.print(" ");
        
        System.out.println("GRILLE ADVERSE");
                
        System.out.print("      "+1);
        
        for(int i =1;i<10;++i){
          System.out.print("       "+(i+1));
        }
        for(int i =10;i<15;++i){
          System.out.print("      "+(i+1));
        }
            
        System.out.print("      * ");
        
        System.out.print("      "+1);
        
        for(int i =1;i<10;++i){
          System.out.print("       "+(i+1));
        }
        for(int i =10;i<15;++i){
          System.out.print("      "+(i+1));
        }  
        
        System.out.print("\n   ");
           
        for(int i=0;i<15;++i)
            System.out.print("_______ ");
        
        System.out.print("   *    ");
        
        for(int i=0;i<15;++i)
            System.out.print("_______ ");
        
        System.out.print("\n");
        
        for (int i=0;i<15;i++)
        {
            System.out.print("  |");
            
            for(int k=0;k<15;++k)
                System.out.print("       |");

            System.out.print("   *   |");

            for(int k=0;k<15;++k)
                System.out.print("       |");

            System.out.print("\n ");
            System.out.print(alphabet[i]);
            
            for(int a=0;a<15;++a)
                System.out.print("|   "+Bateau_Grille_Joueur1[numero_case++]+"   ");
            
            
            System.out.print("|   *"+" "+alphabet[i]+" ");
            
            for(int a=0;a<15;++a)
                System.out.print("|   "+Bateau_Grille_Joueur2[numero_case2++]+"   ");
                    
            System.out.print("|\n  |");
            
            for(int k=0;k<15;++k)
                System.out.print("_______|");

            System.out.print("   *   |");

            for(int k=0;k<15;++k)
                System.out.print("_______|");

            System.out.print("\n");
        }
        
    }   
    
 /**
 * Transformer des coordonnées pour l'afficher dans la grille
 * Auteur : Savinien Godineau
 * @param y
 * @param x 
 * @return  
 */
    public static int Case(char y,int x){   
        int a = (int)y - 97;
        int b = 15*a;
        
        return x+b;
 }
    
 /**
 * Placement des bateaux dans la console
 * Auteur : Charles Hamery
 * @param joueur 
 * @param grille 
 * @return
 */
     public char[] Initialisation_Bateau(int joueur, int grille)
    {  
        
         char[] Bateau_Grille_Joueur = new char[225];
                
         for(int k=0;k<225;k++)
            Bateau_Grille_Joueur[k]=' ';       
                       
         if(grille == 0){
         
             m_joueurs.get(joueur).getNavire().forEach((elem) -> {
                 for(int i=0;i<elem.getTaille();i++){
                     //Cas bateau horizontal :
                     if (elem.getHonrizontal()){
                         int position = Case((char)(elem.getCoord().getY()+97),elem.getCoord().getX()+i);
                         Bateau_Grille_Joueur[position] = elem.getCarac();
                     }
                     
                     //Cas bateau vertical :
                     else{
                         int position = Case((char)(elem.getCoord().getY()+i+97),elem.getCoord().getX());
                         Bateau_Grille_Joueur[position] = elem.getCarac();
                     }
                 }
             });
         
             m_joueurs.get(joueur).getDefense().forEach((elem) -> {
                 Bateau_Grille_Joueur[Case((char)(elem.getY()+97),elem.getX())]='T';
             });

            return Bateau_Grille_Joueur;
         }
         else{
             m_joueurs.get(joueur).getAttaque().keySet().forEach((elem) -> {
                 if(m_joueurs.get(joueur).getAttaque().get(elem))
                    Bateau_Grille_Joueur[Case((char)(elem.getY()+97),elem.getX())]='T';        
                 else
                    Bateau_Grille_Joueur[Case((char)(elem.getY()+97),elem.getX())]='X'; 
             });
             
            m_joueurs.get(joueur).getEclairante().keySet().forEach((elem) -> {
             
                Bateau_Grille_Joueur[Case((char)(elem.getY()+97),elem.getX())] = m_joueurs.get(joueur).getEclairante().get(elem);       
           });
            
            return Bateau_Grille_Joueur;
            
        }
    } 

 /**
 * Clear la console automatiquement
 * Auteur : Charles Hamery
 */
    public void clearScreen() {  
     
      try {
       
        Robot robbie = new Robot();
        
        robbie.delay(100);
        
        robbie.mouseMove(800, 600);
        
        robbie.delay(100);
        
        robbie.mousePress(InputEvent.BUTTON1_MASK);
        robbie.mouseRelease(InputEvent.BUTTON1_MASK);
        
        robbie.delay(100);
        
        
        robbie.keyPress(KeyEvent.VK_ENTER);
        robbie.keyRelease(KeyEvent.VK_ENTER);
        
        robbie.delay(100);
        
          try (Scanner input = new Scanner(System.in)) {
              //String line = input.nextLine();
              
              robbie.delay(100);
              
              robbie.keyPress(KeyEvent.VK_SPACE);
              robbie.keyRelease(KeyEvent.VK_SPACE);
              
              
              robbie.delay(100);
              
              robbie.keyPress(KeyEvent.VK_ENTER);
              robbie.keyRelease(KeyEvent.VK_ENTER);
          } 
        
        robbie.delay(100);
        
        robbie.keyPress(KeyEvent.VK_CONTROL);
        robbie.keyPress(KeyEvent.VK_L);
        
        robbie.keyRelease(KeyEvent.VK_CONTROL);
        robbie.keyRelease(KeyEvent.VK_L);
       
    } catch (AWTException ex) {}
      
    }
}
