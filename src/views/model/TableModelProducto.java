/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views.model;

import java.sql.SQLException;
import SistemaGestionProductos.DBProductos;
import SistemaGestionProductos.Producto;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author lean
 */
public class TableModelProducto extends AbstractTableModel {
    
    private final DBProductos db;
    private final String[] columnas = {"Código", "Descripción", "Costo"};
    
            
    public TableModelProducto() {
        db = new DBProductos();
    }
    
    public void addRow(int codigo, String descripcion, double precioCosto) throws SQLException{
        db.create(new Producto(codigo, descripcion, precioCosto));
    }

    @Override
    public int getRowCount() {
        try {
            return db.getRowCount();
        } catch (SQLException ex) {
            Logger.getLogger(TableModelProducto.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }

    @Override
    public int getColumnCount() {
        return columnas.length; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        try {
            Producto p = db.getProduct(rowIndex);
            
            switch(columnIndex) {
                case 0: 
                    return p.getCodigo();
                case 1:
                    return p.getDescripcion();
                case 2:
                    return p.getPrecioCosto();
                default:
                    return null;
            }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(TableModelProducto.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        
    }
    
    @Override
    public String getColumnName(int column) {
        return columnas[column];
    }
}
