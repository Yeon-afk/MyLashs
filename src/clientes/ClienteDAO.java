/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clientes;

import java.sql.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;

public class ClienteDAO {

    private static final String URL = "jdbc:mysql://localhost:3306/MyLashs";
    private static final String USUARIO = "root";
    private static final String SENHA = "";

    private Connection conectar() throws SQLException {
        return DriverManager.getConnection(URL, USUARIO, SENHA);
    }

    public static void adicionarCliente(Cliente cliente) {
    String sql = "INSERT INTO clientes (cpf, nome, data_nascimento, email, telefone, endereco) VALUES (?, ?, ?, ?, ?, ?)";

    try (Connection conn = DriverManager.getConnection(URL, USUARIO, SENHA);
         PreparedStatement stmt = conn.prepareStatement(sql)) {

        // Converter a data de nascimento de "dd/MM/yyyy" para "yyyy-MM-dd"
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate data = LocalDate.parse(cliente.getDataNascimento(), formatter);
        Date sqlDate = Date.valueOf(data); // converte para java.sql.Date

        stmt.setString(1, cliente.getCpf());
        stmt.setString(2, cliente.getNome());
        stmt.setDate(3, sqlDate);
        stmt.setString(4, cliente.getEmail());
        stmt.setString(5, cliente.getTelefone());
        stmt.setString(6, cliente.getEndereco());

        stmt.executeUpdate();

    } catch (SQLException | DateTimeParseException e) {
        e.printStackTrace();
    }
    }


    public static Cliente buscarClientePorCpf(String cpf) {
    String sql = "SELECT * FROM clientes WHERE cpf = ?";
    
    try (Connection conn = DriverManager.getConnection(URL, USUARIO, SENHA);
         PreparedStatement stmt = conn.prepareStatement(sql)) {
        
        stmt.setString(1, cpf);
        ResultSet rs = stmt.executeQuery();
        
        if (rs.next()) {
            return new Cliente(
    rs.getString("nome"),
    rs.getString("endereco"),
    rs.getString("email"),
    rs.getString("cpf"),
    rs.getString("telefone"),
    rs.getString("data_nascimento") 
);
        }
        
    } catch (SQLException e) {
        e.printStackTrace();
    }
    
    return null; // Se não encontrar
}

    public boolean editarCliente(Cliente cliente) {
        String sql = "UPDATE clientes SET nome = ?, data_nascimento = ?, email = ?, telefone = ?, endereco = ? WHERE cpf = ?";
        try (Connection conn = conectar(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, cliente.getNome());
            stmt.setString(2, cliente.getDataNascimento());
            stmt.setString(3, cliente.getEmail());
            stmt.setString(4, cliente.getTelefone());
            stmt.setString(5, cliente.getEndereco());
            stmt.setString(6, cliente.getCpf());
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public static boolean excluirCliente(String cpf) {
    String sql = "DELETE FROM clientes WHERE cpf = ?";
    
    try (Connection conn = DriverManager.getConnection(URL, USUARIO, SENHA);
         PreparedStatement stmt = conn.prepareStatement(sql)) {
        
        stmt.setString(1, cpf);
        int linhasAfetadas = stmt.executeUpdate();
        
        return linhasAfetadas > 0;
        
    } catch (SQLException e) {
        e.printStackTrace();
    }
    
    return false;
}

    public static List<Cliente> listarClientes() {
    List<Cliente> lista = new ArrayList<>();
    String sql = "SELECT * FROM clientes";

    try (Connection conn = DriverManager.getConnection(URL, USUARIO, SENHA);
         PreparedStatement stmt = conn.prepareStatement(sql);
         ResultSet rs = stmt.executeQuery()) {

        while (rs.next()) {
            Cliente cliente = new Cliente(
                rs.getString("nome"),
                rs.getString("endereco"),
                rs.getString("email"),
                rs.getString("cpf"),
                rs.getString("telefone"),
                rs.getString("data_nascimento") 
            );
            lista.add(cliente);
        }

    } catch (SQLException e) {
        e.printStackTrace();
    }

    return lista;
}
}