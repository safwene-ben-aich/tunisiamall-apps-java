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
 * @author Fatma Jaafar
 */
public class TheModal1 extends AbstractTableModel{
  private String[] columns;
    private Object[][] rows;
    
    public TheModal1(){}
    
    public TheModal1(Object[][] data, String[] columnName){
    
        this.rows = data;
        this.columns = columnName;
    }

    
    public Class getColumnClass(int column){
// 4 is the index of the column image
       
       
            if(column == 3 ){
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
  private void printDebugData() {
            int numRows = getRowCount();
            int numCols = getColumnCount();

            for (int i=0; i < numRows; i++) {
                System.out.print("    row " + i + ":");
                for (int j=0; j < numCols; j++) {
                    System.out.print("  " + rows[i][j]);
                }
                System.out.println();
            }
            System.out.println("--------------------------");
        }
}

