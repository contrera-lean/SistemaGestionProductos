package SistemaGestionProductos;

import views.model.TableModelProducto;
import views.ventanaSistemaTienda;

public class SistemaGestionProductos {
   
    public static void main(String[] args) {
        
        TableModelProducto modelProductos = new TableModelProducto();
        
        ventanaSistemaTienda v = new ventanaSistemaTienda(modelProductos);
        
        v.setVisible(true); 
    }
}
