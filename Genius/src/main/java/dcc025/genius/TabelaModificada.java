/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dcc025.genius;

import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Renan
 */
public class TabelaModificada extends DefaultTableModel{

    
    @Override
    public boolean isCellEditable(int row, int column) {
        return false;
    }

    
    
    
    
}

