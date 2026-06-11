/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication3.ui.model;

import javaapplication3.DBProductos;
import javaapplication3.Producto;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author lean
 */
public class TableModelProducto extends AbstractTableModel {
    
    private DBProductos db;
    private String[] columnas = {"Código", "Descripción", "Costo"};
    
            
    public TableModelProducto() {
        db = new DBProductos();
    }
    
    public void addRow(int codigo, String descripcion, double precioCosto){
        db.create(new Producto(codigo, descripcion, precioCosto));
    }

    @Override
    public int getRowCount() {
        return db.getRowCount();
    }

    @Override
    public int getColumnCount() {
        return columnas.length; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Producto p = db.getProduct(rowIndex);
        Object object;
        
        switch (columnIndex) {
            case 0:
                object = p.getCodigo();
                break;
            case 1:
                object = p.getDescripcion();
                break;
            case 2:
                object = p.getPrecioCosto();  
                break;
            default:
                object = null;
        }
    
        return object;
    }
    
    @Override
    public String getColumnName(int column) {
        return columnas[column];
    }
}
