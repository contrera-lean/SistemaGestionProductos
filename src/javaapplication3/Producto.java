package javaapplication3;

public class Producto {
    
    private int codigo;
    private String descripcion;
    private int stock;
    private double precioCosto;
    private double precio;
    private double ganancia;

    public Producto(){};
    
    public Producto(int codigo, String descripcion, double costo) {
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.precioCosto = costo;
        this.ganancia = 0.2;
        this.precio = precioCosto + (precioCosto * ganancia);
    }
    
    public int getCodigo(){
        return this.codigo;
    }
    
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }
    
    public String getDescripcion(){
        return this.descripcion;
    }
    
    public void setDescripcion(String descripcion){
        this.descripcion = descripcion;
    }
    
    public double getPrecioCosto() {
        return this.precioCosto;
    }
    
    public void setPrecioCosto(double precioCosto) {
        this.precioCosto = precioCosto;
    }
    
    public double getPrecio() {
        return this.precio;
    }
    
    public void setPrecio(double precio) {
        this.precio = precio;
    }
            
    public void mostrar() {
        System.out.println("Datos del producto");
        System.out.println("Código:"+this.codigo+"\n" + 
            "Descripción:" + this.descripcion +" \n"+ 
            "Precio costo:" + this.precioCosto +"\n" +
            "Precio: " + this.precio +"\n");
    }
    
    @Override
    public String toString() {
        return "Producto{"+"codigo="+this.codigo+",descripcion="+this.descripcion+",costo="+this.precioCosto+"}\n";
    }
}
