/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.ArrayList;

/**
 *
 * @author charl
 */
public class N_Destroyer extends Navire{
    
    private boolean m_eclairante;
    
    public N_Destroyer(){
        m_taille = 3;
        m_puissanceTir = 1;
        m_initCoord = false;
        m_caractere = 'D';
        m_eclairante = true;
    }
    
    public boolean getEclairante(){
        return m_eclairante;
    }
}