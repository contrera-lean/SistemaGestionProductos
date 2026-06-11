package javaapplication3;

import java.util.ArrayList;

public class DBProductos {
    private final ArrayList<Producto> lista;
    
    public DBProductos () {
        lista = new ArrayList<>();
    }
    
    public void create(Producto p) {
        lista.add(p);
    }
    
    public Producto read(int id) {
        for (Producto p : lista) {
            if (p.getCodigo() == id) {
                return p;
            }
        }
        return null;
    }
    
    public void update(Producto p, int index) {
        lista.add(p);
    }
    
    public void delete(int id) {
        for (Producto p : lista) {
            if (p.getCodigo() == id) {
                lista.remove(lista.indexOf(p));
                break;
            }
        }
    } 
    
    public int getRowCount() {
        int count = 0;
        
        for (Producto p : lista) {
            count++;
        }
        
        return count;
    }
    
    public Producto getProduct(int index) {
        return lista.get(index);
    }
    
}
