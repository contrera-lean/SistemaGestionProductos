package SistemaGestionProductos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBProductos {
    
    private Connection connection;
    
    public DBProductos () {
        //.env
        String url = "jdbc:mariadb://localhost:3306/empresa_db?allowMultiQueries=true";
        String user = "lean";
        String password = "Greenmaster2004$";
        
        try {
            connection = DriverManager.getConnection(url, user, password);
            System.out.println("Connection be sucessed!" + connection);
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
    
    public void create(Producto p) throws SQLException {
        
        Statement statement = connection.createStatement();
        
        String codigo = String.valueOf(p.getCodigo());
        String descripcion = String.valueOf(p.getDescripcion());
        String precioCosto = String.valueOf(p.getPrecioCosto());
                
        statement.execute("INSERT INTO products VALUES (" + codigo + ",'" 
                + descripcion + "'," 
                + precioCosto + ");");
    }
    
    public Producto read(int id) {
        throw new UnsupportedOperationException("Not implemented yet");
    }
    
    public void update(Producto p, int index) {
        throw new UnsupportedOperationException("Not implemented yet");
    }
    
    public void delete(int id) {
        throw new UnsupportedOperationException("Not implemented yet");
    } 
    
    public int getRowCount() throws SQLException {
        String sql = "SELECT COUNT(*) AS total FROM products";
        Statement statement = connection.createStatement();
        ResultSet result = statement.executeQuery(sql);
        result.next();
        return result.getInt("total");
    }
    
    public Producto getProduct(int index) throws SQLException {
        String sql = "SELECT * FROM products ORDER BY id LIMIT 1 OFFSET ";
        Statement statement = connection.createStatement();
        ResultSet result = statement.executeQuery(sql + index);
        
        result.next();
        
        int id_codigo = result.getInt("id");
        String descripcion = result.getString("description");
        double precioCosto = result.getDouble("cost");
        
        return new Producto(id_codigo, descripcion, precioCosto);
    }
    
}
