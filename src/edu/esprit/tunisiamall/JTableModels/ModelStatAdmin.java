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
public class ModelStatAdmin extends AbstractTableModel {
    
    private String[] columns;
    private Object[][] rows;
    
    public ModelStatAdmin(){}
    
    public ModelStatAdmin(Object[][] data, String[] columnName){
    
        this.rows = data;
        this.columns = columnName;
    }

    
    @Override
    public Class getColumnClass(int column){
        try{      
  
          return getValueAt(0,column).getClass();
        }catch (NullPointerException e)  {
            
        }
        return String.class;
      
    }
    
    @Override
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
