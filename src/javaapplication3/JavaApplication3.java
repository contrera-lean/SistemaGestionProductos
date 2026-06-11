package javaapplication3;

import java.util.ArrayList;
import java.util.Scanner;
import javaapplication3.ui.model.TableModelProducto;
import javaapplication3.ui.ventanaSistemaTienda;

public class JavaApplication3 {
   
    public static void main(String[] args) {
        
        TableModelProducto modelProductos = new TableModelProducto();
        
        ventanaSistemaTienda v = new ventanaSistemaTienda(modelProductos);
        
        v.setVisible(true); 
    }
}
