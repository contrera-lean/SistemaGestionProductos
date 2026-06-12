package SistemaGestionProductos;

import java.util.ArrayList;
import java.util.Comparator;

public class ListaProductos {
    
    private final ArrayList<Producto> lista;
    
    public ListaProductos(){
        this.lista = new ArrayList<>();
    };
    
    public void agregar(int codigo, String descripcion, double costo) {
        lista.add(new Producto(codigo, descripcion, costo));
    }
    
    public void agregar(Producto p) {
        lista.add(p);
    }
    
    public void mostrar() {
        for(Producto p : lista) {
            p.mostrar();
        }
    }
    
    public void mostrarListaDePrecios() {
        System.out.printf("%-8s %-18s %8s%n", "Código", "Descripción", "Precio");
        for(Producto p : lista) {
            System.out.printf("%-8d %-18s %8.0f%n", p.getCodigo(), p.getDescripcion(), p.getPrecio());
        }
    }
    
    public Producto buscar(int codigo) {
        for(Producto p : lista) {
            if (p.getCodigo() == codigo) {
                return p;
            }
        }
        return null;
    }
    
    
    public int getObtenerCantidadProductos() {
        
        int count = 0;
        
        for(Producto p : lista) {
            count++;
        }
        
        return count;
    }

    public Producto getProductoPorIndex(int index) {
        return lista.get(index);
    }
    
    public void ordenarListaPorCodigo() {
        lista.sort(Comparator.comparingInt(Producto::getCodigo));
    }
    
    public void ordenarListaPorPrecio() {
        lista.sort(Comparator.comparingDouble(Producto::getPrecio));
    }
    
}
