package DAO;

import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import UTIL.Conexao;
import java.sql.ResultSet;

public class Funcionario_2 {
    
    private PreparedStatement statement;
    
    private static ResultSet rs;
    
    
    private int id_func;
    private String nome;
    private String email;
    private String CPF;
    private String cargo;
    private double salario;

    
    Connection conexao = new Conexao().getConnection();

    public int getId_func() {
        return id_func;
    }

    public void setId_func(int id_func) {
        this.id_func = id_func;
    }
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCPF() {
        return CPF;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }
    
    public double getBonificacao(){
        return this.salario * 1.15;
    }
    public void insereFuncionario(){
    
    try{
        String sql = "INSERT INTO Funcionario(nome,email,cpf,cargo,salario) VALUES (?,?,?,?,?)";
        
    statement = conexao.prepareStatement(sql);
    
    statement.setString(1, getNome());
    statement.setString(2, getEmail());
    statement.setString(3, getCPF());
    statement.setString(4, getCargo());
    statement.setDouble(5, getSalario());
    
    
    statement.execute();
    statement.close();
    
    JOptionPane.showMessageDialog(null,"Gravado com sucesso!");
    } catch (SQLException e1){
        e1.printStackTrace();
        }
    
    }
    
    
    public int consultaFunc(){
    
        try{
            String sql = "select * from funcionario where CPF = ?";
            
            statement = conexao.prepareStatement(sql);
            
            statement.setString(1, getCPF());
            
            rs = statement.executeQuery();
            
            if (rs.next()){
            
                setId_func(rs.getInt(1));
                setNome(rs.getString(2));
                setEmail(rs.getString(3));
                setCPF(rs.getString(4));
                setCargo(rs.getString(5));
                setSalario(rs.getDouble(6));
                
            } else {
                JOptionPane.showMessageDialog(null,"CPF não encontrado!");
                
                
            }
            
            rs.close();
            statement.close();
            }catch (SQLException e){
                    e.printStackTrace();
                }
        return getId_func();
    }
    
    public void alteraFuncionario(){
    
    try{
        String sql = "UPDATE Funcionario set nome = ?,email = ? ,cpf = ?,cargo = ?,salario = ? where id_func = ?";
        
    statement = conexao.prepareStatement(sql);
    
    statement.setString(1, getNome());
    statement.setString(2, getEmail());
    statement.setString(3, getCPF());
    statement.setString(4, getCargo());
    statement.setDouble(5, getSalario());
    statement.setInt(6, getId_func());
    
    statement.execute();
    statement.close();
    
    JOptionPane.showMessageDialog(null,"Atualizado com sucesso!");
    } catch (SQLException e1){
        e1.printStackTrace();
        }
    
    }
}


