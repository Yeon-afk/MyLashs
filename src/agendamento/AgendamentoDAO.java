/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package agendamento;
import conexao.ConexaoBD;
import static conexao.ConexaoBD.conectar;

import java.sql.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;


/**
 * Classe responsável por manipular os agendamentos armazenados no banco de dados MySQL.
 */
public class AgendamentoDAO {

    /**
     * Registra o pagamento de um agendamento com base no CPF, data e hora.
     * @param cpfCliente CPF do cliente.
     * @param data Data do agendamento.
     * @param hora Hora do agendamento.
     * @return true se o pagamento foi registrado com sucesso, false caso contrário.
     */
    public boolean registrarPagamento(String cpfCliente, String data, String hora) {
        String sql = "UPDATE agendamentos SET status = true WHERE cpf_cliente = ? AND data = ? AND hora = ?";

        try (Connection conn = ConexaoBD.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, cpfCliente);
            stmt.setString(2, data);
            stmt.setString(3, hora);

            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
public static Date converterParaSqlDate(String dataFormatoBrasil) {
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    LocalDate localDate = LocalDate.parse(dataFormatoBrasil, formatter);
    return Date.valueOf(localDate);
}
    /**
     * Adiciona um novo agendamento ao banco de dados.
     * @param agendamento
     */
    public static boolean adicionarAgendamento(Agendamento agendamento) {
        String sql = "INSERT INTO agendamentos (nome_cliente, cpf_cliente, tipo_atendimento, especificacao, data, hora, valor, status) " +
                     "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = ConexaoBD.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, agendamento.getNome());
            stmt.setString(2, agendamento.getCpfCliente());
            stmt.setString(3, agendamento.getTipoAtendimento());
            stmt.setString(4, agendamento.getEspecificacao());
            stmt.setString(5, agendamento.getData());
            stmt.setString(6, agendamento.getHora());
            stmt.setDouble(7, agendamento.getValor());
           stmt.setBoolean(8, agendamento.isStatus());

            stmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
public static boolean excluirAgendamentoPorId(int id) {
    String sql = "DELETE FROM agendamentos WHERE id = ?";
    try (Connection conn = conectar();
         PreparedStatement stmt = conn.prepareStatement(sql)) {
        stmt.setInt(1, id);
        return stmt.executeUpdate() > 0;
    } catch (SQLException e) {
        e.printStackTrace();
        return false;
    }
}
    
    public static boolean editarAgendamento(Agendamento agendamento) {
    String sql = "UPDATE agendamentos SET tipo_atendimento = ?, especificacao = ?, data = ?, hora = ?, valor = ?, status = ? " +
                 "WHERE cpf_cliente = ? AND nome_cliente = ?";

    try (Connection conn = ConexaoBD.conectar();
         PreparedStatement stmt = conn.prepareStatement(sql)) {

        stmt.setString(1, agendamento.getTipoAtendimento());
        stmt.setString(2, agendamento.getEspecificacao());
        stmt.setString(3, agendamento.getData());
        stmt.setString(4, agendamento.getHora());
        stmt.setDouble(5, agendamento.getValor());
        stmt.setBoolean(6, agendamento.isStatus());
        stmt.setString(7, agendamento.getCpfCliente());
        stmt.setString(8, agendamento.getNome());

        return stmt.executeUpdate() > 0;
    } catch (SQLException e) {
        System.out.println("Erro ao editar agendamento: " + e.getMessage());
        return false;
    }
}
    
    /**
     * Retorna uma lista de agendamentos de um cliente pelo CPF.
     * @param cpf
     * @return 
     */
    public static List<Agendamento> buscarAgendamentosPorCliente(String cpf) {
        return buscarAgendamentosPorCpf(cpf); // Redireciona para o método com SQL
    }

    /**
     * Retorna uma lista de agendamentos de um cliente pelo CPF (duplicado, mas mantido por nome).
     * @param cpf
     * @return 
     */
    public static List<Agendamento> buscarAgendamentosPorCpf(String cpf) {
        List<Agendamento> lista = new ArrayList<>();
        String sql = "SELECT * FROM agendamentos WHERE cpf_cliente = ?";

        try (Connection conn = ConexaoBD.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, cpf);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                lista.add(new Agendamento(
                    rs.getString("nome_cliente"),
                    rs.getString("cpf_cliente"),
                    rs.getString("tipo_atendimento"),
                    rs.getString("especificacao"),
                    rs.getString("data"),
                    rs.getString("hora"),
                    rs.getDouble("valor"),
                    rs.getBoolean("status")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }

    /**
     * Retorna uma cópia da lista de agendamentos para evitar modificações externas.
     * @return 
     */
    public static List<Agendamento> listarAgendamentos() {
        List<Agendamento> agendamentos = new ArrayList<>();
        String sql = "SELECT * FROM agendamentos";

        try (Connection conn = ConexaoBD.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                agendamentos.add(new Agendamento(
                    rs.getString("nome_cliente"),
                    rs.getString("cpf_cliente"),
                    rs.getString("tipo_atendimento"),
                    rs.getString("especificacao"),
                    rs.getString("data"),
                    rs.getString("hora"),
                    rs.getDouble("valor"),
                    rs.getBoolean("status")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return agendamentos;
    }

    /**
     * Busca um agendamento pelo nome do cliente.
     * @param nome
     * @return 
     */
    public static Agendamento buscarAgendamentoPorNome(String nome) {
        String sql = "SELECT * FROM agendamentos WHERE LOWER(nome) = LOWER(?) LIMIT 1";

        try (Connection conn = ConexaoBD.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, nome);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return new Agendamento(
                    rs.getString("nome_cliente"),
                    rs.getString("cpf_cliente"),
                    rs.getString("tipo_atendimento"),
                    rs.getString("especificacao"),
                    rs.getString("data"),
                    rs.getString("hora"),
                    rs.getDouble("valor"),
                    rs.getBoolean("status")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

   public static boolean salvarAgendamento(Agendamento agendamento) throws SQLException {
    String sql = "INSERT INTO agendamentos (nome_cliente, cpf_cliente, tipo_atendimento, especificacao, data, hora, valor, status) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

    try (Connection conn = ConexaoBD.conectar();
         PreparedStatement stmt = conn.prepareStatement(sql)) {

        stmt.setString(1, agendamento.getNome());
        stmt.setString(2, agendamento.getCpfCliente());
        stmt.setString(3, agendamento.getTipoAtendimento());
        stmt.setString(4, agendamento.getEspecificacao());

        // ✅ Converte data de "dd/MM/yyyy" para java.sql.Date
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate dataLocal = LocalDate.parse(agendamento.getData(), formatter);
        Date sqlDate = Date.valueOf(dataLocal); // converte para java.sql.Date
        stmt.setDate(5, sqlDate);

        stmt.setString(6, agendamento.getHora());
        stmt.setDouble(7, agendamento.getValor());
        stmt.setBoolean(8, agendamento.isStatus());

        stmt.executeUpdate();
        return true;
    } catch (SQLException e) {
        System.out.println("Erro ao salvar agendamento: " + e.getMessage());
        return false;
    }
}
   
   public static Agendamento buscarAgendamentoPorId(int id) {
    Agendamento agendamento = null;

    String sql = "SELECT * FROM agendamentos WHERE id = ?";

    try (Connection conn = ConexaoBD.conectar();
         PreparedStatement stmt = conn.prepareStatement(sql)) {

        stmt.setInt(1, id);
        ResultSet rs = stmt.executeQuery();

        if (rs.next()) {
            agendamento = new Agendamento();
            agendamento.setId(rs.getInt("id"));
            agendamento.setNome(rs.getString("nome_cliente"));
            agendamento.setCpfCliente(rs.getString("cpf_cliente"));
            agendamento.setTipoAtendimento(rs.getString("tipo_atendimento"));
            agendamento.setEspecificacao(rs.getString("especificacao"));

            // Corrigido: usa "data" e converte para String no formato esperado pela aplicação
            Date sqlDate = rs.getDate("data");
            agendamento.setData(sqlDate.toLocalDate().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));

            agendamento.setHora(rs.getString("hora"));
            agendamento.setValor(rs.getDouble("valor"));
            agendamento.setStatus(rs.getBoolean("status"));
        }

        rs.close();
    } catch (SQLException e) {
        System.err.println("Erro ao buscar agendamento por ID: " + e.getMessage());
    }

    return agendamento;
}
    /**
     * Exclui um agendamento pelo CPF e salva a alteração.
    
     * @return 
     */
    public boolean excluirAgendamento(int idAgendamento) {
    String sql = "DELETE FROM agendamentos WHERE id = ?";

    try (Connection conn = conectar();
         PreparedStatement stmt = conn.prepareStatement(sql)) {

        stmt.setInt(1, idAgendamento);
        return stmt.executeUpdate() > 0;

    } catch (SQLException e) {
        e.printStackTrace();
    }

    return false;
}
}


