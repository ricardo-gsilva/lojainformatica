package UTIL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
    
    public Connection getConnection() {
        //criação do método de conexão
            
        try {
            return DriverManager.getConnection("jdbc:Mysql://127.0.0.1:3306/sistemas","root","");
        } catch (SQLException e){
            throw new RuntimeException (e);
        }
    }
    
}
