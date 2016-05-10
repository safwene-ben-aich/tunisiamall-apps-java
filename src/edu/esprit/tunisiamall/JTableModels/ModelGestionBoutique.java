/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.tunisiamall.JTableModels;
import javax.swing.Icon;
import javax.swing.table.AbstractTableModel;
/**
 *
 * @author antar
 */
public class ModelGestionBoutique extends AbstractTableModel {
    
    private String[] columns;
    private Object[][] rows;
    
    public ModelGestionBoutique(){}
    
    public ModelGestionBoutique(Object[][] data, String[] columnName){
    
        this.rows = data;
        this.columns = columnName;
    }

    
    public Class getColumnClass(int column){
// 2 est l'index de la column image
        if(column == 2){
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


}

    
