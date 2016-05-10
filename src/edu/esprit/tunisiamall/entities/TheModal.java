/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.esprit.tunisiamall.entities;

import java.util.ArrayList;
import java.util.List;
import javax.swing.Icon;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Kaouther
 */
public class TheModal extends AbstractTableModel {
    private String[] columns;
    private Object[][] rows;
    
    public TheModal(){}
    
    public TheModal(Object[][] data, String[] columnName){
    
        this.rows = data;
        this.columns = columnName;
    }

    
    public Class getColumnClass(int column){
// 4 is the index of the column image
       
       
            if(column == 8 ){
            return Icon.class;
        }
        else{
            return getValueAt(0,column).getClass();
        }

    }
    
    
    public int getRowCount() {
     return this.rows.length;
    }

    public int getColumnCount() {
     return this.columns.length;
    }

    
    public Object getValueAt(int rowIndex, int columnIndex) {
    
    return this.rows[rowIndex][columnIndex];
    }
    public String getColumnName(int col){
        return this.columns[col];
    }
    
       List data = new ArrayList();
    public void removeRow(int ligne){
       this.data.remove(ligne);
    }

    
}
