package UTIL;

import java.sql.SQLException;
import java.sql.Connection;
import javax.swing.JOptionPane;

public class TestarConexao {
    
    public static void testarConexao() {
        //Classe obj Classe Metodo
        Connection objConexao = new Conexao().getConnection();
        
        JOptionPane.showMessageDialog(null, "Conexão Ok!");
    }
}
   
