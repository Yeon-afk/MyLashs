
import agendamento.Agendamento;
import agendamento.AgendamentoDAO;
import clientes.Cliente;
import clientes.ClienteDAO;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 * Classe responsável por exibir e manipular a busca de clientes no sistema.
 * Permite pesquisar, editar, excluir e visualizar detalhes dos clientes.
 */
public class BuscarCliente extends javax.swing.JFrame {
    private Cliente cliente;
    private Agendamento agendamento;
    /**
     * Construtor da classe BuscarCliente.
     * Inicializa os componentes da interface e carrega a lista de clientes na tabela.
     */
    public BuscarCliente() {
        initComponents();
        this.setLocationRelativeTo(null);
        carregarClientesNaTabela();
        
    }

    /**
     * Carrega a lista de clientes na tabela da interface.
     */
    private void carregarClientesNaTabela() {
    List<Cliente> clientes = ClienteDAO.listarClientes();
    DefaultTableModel model = (DefaultTableModel) TabelaCliente.getModel();
    model.setRowCount(0); // Limpa antes de inserir novos dados

    for (Cliente cliente : clientes) {
        model.addRow(new Object[]{
            
            
            cliente.getCpf(),
            cliente.getNome(),
            cliente.getDataNascimento(),
            cliente.getTelefone(),
            
        });
    }
}
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        txtBuscarCpf = new javax.swing.JTextField();
        btnPesquisarCpf = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        TabelaCliente = new javax.swing.JTable();
        btnDetalhesCliente = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnVoltar = new javax.swing.JButton();
        btnAgendar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel2.setText("MyLashes");

        jLabel1.setText("Pesquisar cliente por CPF:");

        btnPesquisarCpf.setBackground(new java.awt.Color(105, 109, 168));
        btnPesquisarCpf.setForeground(new java.awt.Color(255, 255, 255));
        btnPesquisarCpf.setText("Pesquisar");
        btnPesquisarCpf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPesquisarCpfActionPerformed(evt);
            }
        });

        TabelaCliente.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "CPF", "Nome", "Data Nascimento", "Telefone"
            }
        ));
        jScrollPane1.setViewportView(TabelaCliente);

        btnDetalhesCliente.setBackground(new java.awt.Color(51, 51, 51));
        btnDetalhesCliente.setForeground(new java.awt.Color(255, 255, 255));
        btnDetalhesCliente.setText("Detalhes");
        btnDetalhesCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDetalhesClienteActionPerformed(evt);
            }
        });

        btnExcluir.setBackground(new java.awt.Color(51, 51, 51));
        btnExcluir.setForeground(new java.awt.Color(255, 255, 255));
        btnExcluir.setText("Excluir");
        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirActionPerformed(evt);
            }
        });

        btnEditar.setBackground(new java.awt.Color(51, 51, 51));
        btnEditar.setForeground(new java.awt.Color(255, 255, 255));
        btnEditar.setText("Editar");
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

        btnVoltar.setBackground(new java.awt.Color(51, 51, 51));
        btnVoltar.setForeground(new java.awt.Color(255, 255, 255));
        btnVoltar.setText("Voltar");
        btnVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVoltarActionPerformed(evt);
            }
        });

        btnAgendar.setBackground(new java.awt.Color(105, 109, 168));
        btnAgendar.setForeground(new java.awt.Color(255, 255, 255));
        btnAgendar.setText("Agendar");
        btnAgendar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgendarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(264, 264, 264)
                .addComponent(jLabel2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(btnVoltar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(55, 55, 55)
                                .addComponent(btnAgendar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel1)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(txtBuscarCpf, javax.swing.GroupLayout.PREFERRED_SIZE, 289, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(36, 36, 36)
                                        .addComponent(btnExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnPesquisarCpf, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnDetalhesCliente, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addGap(38, 38, 38))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addGap(38, 38, 38)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtBuscarCpf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(btnPesquisarCpf))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnDetalhesCliente)
                    .addComponent(btnExcluir)
                    .addComponent(btnEditar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 13, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnVoltar)
                    .addComponent(btnAgendar))
                .addGap(41, 41, 41))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnPesquisarCpfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPesquisarCpfActionPerformed
        /**
     * Evento do botão "Pesquisar" para buscar um cliente pelo CPF.
     * @param evt Evento acionado pelo clique no botão.
     */
        String cpf = txtBuscarCpf.getText().trim();

    if (cpf.isEmpty()) {
        JOptionPane.showMessageDialog(this, "Por favor, insira o CPF para pesquisa.");
        return;
    }

    Cliente cliente = ClienteDAO.buscarClientePorCpf(cpf);

    if (cliente != null) {
        // Preencher a Tabela com os dados do cliente encontrado
        preencherTabela(cliente);
    } else {
        JOptionPane.showMessageDialog(this, "Cliente não encontrado.");
    }
    }//GEN-LAST:event_btnPesquisarCpfActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        /**
     * Evento do botão "Editar" para abrir a tela de edição do cliente selecionado.
     * @param evt Evento acionado pelo clique no botão.
     */
        int selectedRow = TabelaCliente.getSelectedRow();
    if (selectedRow != -1) {
        // Obtenha os dados da linha selecionada
        String cpf = TabelaCliente.getValueAt(selectedRow, 0).toString();  // Supondo que a coluna 0 tenha o CPF

        // Abrir a tela de edição do cliente (CadastrarCliente, por exemplo)
        Cliente cliente = ClienteDAO.buscarClientePorCpf(cpf);
        if (cliente != null) {
            new CadastrarCliente(cliente).setVisible(true); // Passar o cliente para editar
            dispose(); // Fecha a tela atual
        }
    } else {
        JOptionPane.showMessageDialog(this, "Selecione um cliente para editar.");
    }
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
       /**
     * Evento do botão "Excluir" para remover um cliente do sistema.
     * @param evt Evento acionado pelo clique no botão.
     */
        int selectedRow = TabelaCliente.getSelectedRow();
    if (selectedRow != -1) {
        String cpf = TabelaCliente.getValueAt(selectedRow, 0).toString();

        // Confirmar exclusão
        int confirm = JOptionPane.showConfirmDialog(this, "Você tem certeza que deseja excluir este cliente?");
        if (confirm == JOptionPane.YES_OPTION) {
            boolean sucesso = ClienteDAO.excluirCliente(cpf);

            if (sucesso) {
                JOptionPane.showMessageDialog(this, "Cliente excluído com sucesso.");
                // Atualizar a tabela após a exclusão
                atualizarTabela();
            } else {
                JOptionPane.showMessageDialog(this, "Erro ao excluir o cliente.");
            }
        }
    } else {
        JOptionPane.showMessageDialog(this, "Selecione um cliente para excluir.");
    }
    }//GEN-LAST:event_btnExcluirActionPerformed

    private void btnDetalhesClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDetalhesClienteActionPerformed
        /**
     * Evento do botão "Detalhes" para exibir as informações do cliente e seus agendamentos.
     * @param evt Evento acionado pelo clique no botão.
     */ 
        int selectedRow = TabelaCliente.getSelectedRow();

    if (selectedRow != -1) {
        String cpf = TabelaCliente.getValueAt(selectedRow, 0).toString();

        // Buscar o cliente pelo CPF
        Cliente cliente = ClienteDAO.buscarClientePorCpf(cpf);

        if (cliente == null) {
            JOptionPane.showMessageDialog(this, "Cliente não encontrado!", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Buscar agendamentos do cliente
        List<Agendamento> agendamentos = AgendamentoDAO.buscarAgendamentosPorCliente(cpf);
        if (agendamentos == null) {
            agendamentos = new ArrayList<>(); // Evita NullPointerException
        }

        // Construindo a mensagem
        StringBuilder detalhes = new StringBuilder();
        detalhes.append("Nome: ").append(cliente.getNome()).append("\n")
                .append("Endereço: ").append(cliente.getEndereco()).append("\n")
                .append("Email: ").append(cliente.getEmail()).append("\n")
                .append("Telefone: ").append(cliente.getTelefone()).append("\n")
                .append("Data de Nascimento: ").append(cliente.getDataNascimento()).append("\n\n");

        if (agendamentos.isEmpty()) {
            detalhes.append("Nenhum agendamento encontrado.");
        } else {
            detalhes.append("📅 Agendamentos:\n");
            for (Agendamento agendamento : agendamentos) {
                detalhes.append("- ").append(agendamento.getData()).append(" às ")
                        .append(agendamento.getHora()).append("\n")
                        .append("  Tipo: ").append(agendamento.getTipoAtendimento()).append("\n")
                        .append("  Especificação: ").append(agendamento.getEspecificacao()).append("\n")
                        .append("  Valor: R$ ").append(String.format("%.2f", agendamento.getValor())).append("\n\n");
            }
        }

        // Exibir detalhes em um JOptionPane
        JOptionPane.showMessageDialog(this, detalhes.toString(), "Detalhes do Cliente", JOptionPane.INFORMATION_MESSAGE);
    } else {
        JOptionPane.showMessageDialog(this, "Selecione um cliente para ver os detalhes.", "Aviso", JOptionPane.WARNING_MESSAGE);
    }
    }//GEN-LAST:event_btnDetalhesClienteActionPerformed

    private void btnVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVoltarActionPerformed
        /**
     * Evento do botão "Voltar" para retornar à tela de ações.
     * @param evt Evento acionado pelo clique no botão.
     */
        new TelaAcoes().setVisible(true);
    dispose();
    }//GEN-LAST:event_btnVoltarActionPerformed

    private void btnAgendarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgendarActionPerformed
        /**
     * Evento do botão "Agendar" para abrir a tela de agendamento para o cliente selecionado.
     * @param evt Evento acionado pelo clique no botão.
     */
        int selectedRow = TabelaCliente.getSelectedRow(); // Obtém a linha selecionada na tabela
    
    if (selectedRow != -1) { // Verifica se há uma linha selecionada
        String cpf = TabelaCliente.getValueAt(selectedRow, 0).toString().trim(); // Obtém o CPF e remove espaços em branco

        System.out.println("CPF selecionado: " + cpf); // Depuração: verificar o CPF obtido

        if (cpf.isEmpty()) { // Verifica se o CPF está vazio
            JOptionPane.showMessageDialog(this, "CPF inválido.", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Buscar o cliente pelo CPF
        Cliente cliente = ClienteDAO.buscarClientePorCpf(cpf);
        if (cliente != null) {  // Se o cliente for encontrado
            new TelaAgendamento(cliente).setVisible(true); // Exibe a tela de agendamento
            dispose(); // Fecha a tela atual
        } else {
            JOptionPane.showMessageDialog(this, "Cliente não encontrado.", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    } else {
        JOptionPane.showMessageDialog(this, "Selecione um cliente para agendar.", "Aviso", JOptionPane.WARNING_MESSAGE);
    }
    }//GEN-LAST:event_btnAgendarActionPerformed

    /**
     * Atualiza a tabela de clientes após operações como exclusão.
     */
    private void atualizarTabela() {
    // Obtem a lista de clientes novamente e preenche a tabela
    List<Cliente> clientes = ClienteDAO.listarClientes();
    DefaultTableModel model = (DefaultTableModel) TabelaCliente.getModel();
    model.setRowCount(0); // Limpar a tabela
    for (Cliente cliente : clientes) {
        model.addRow(new Object[]{
            cliente.getCpf(),
            cliente.getNome(),
            cliente.getEndereco(),
            cliente.getEmail(),
            cliente.getTelefone(),
            cliente.getDataNascimento()
        });
    }
}
    /**
     * Preenche a tabela com os dados de um cliente específico.
     * @param cliente Cliente cujos dados serão exibidos na tabela.
     */
  private void preencherTabela(Cliente cliente) {
    DefaultTableModel model = (DefaultTableModel) TabelaCliente.getModel();
    model.setRowCount(0); // Limpar a tabela

    // Adicionar o cliente na tabela
    model.addRow(new Object[]{
        cliente.getCpf(),
        cliente.getNome(),
        cliente.getEndereco(),
        cliente.getEmail(),
        cliente.getTelefone(),
        cliente.getDataNascimento()
    });
}

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable TabelaCliente;
    private javax.swing.JButton btnAgendar;
    private javax.swing.JButton btnDetalhesCliente;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnPesquisarCpf;
    private javax.swing.JButton btnVoltar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField txtBuscarCpf;
    // End of variables declaration//GEN-END:variables
}
