
import agendamento.Agendamento;
import agendamento.AgendamentoDAO;
import clientes.Cliente;
import clientes.ClienteDAO;
import javax.swing.JOptionPane;
import java.sql.*;



/**
 * TelaAgendamento representa a interface gráfica para agendamentos de serviços.
 * Permite cadastrar, visualizar e editar agendamentos para clientes.
 */
public class TelaAgendamento extends javax.swing.JFrame {
    private Cliente cliente;
    private Agendamento agendamento;
    /**
     * Construtor que inicializa a tela para um novo agendamento.
     * @param cliente Cliente para o qual será realizado o agendamento.
     */
    
    public TelaAgendamento(Cliente cliente) {
        initComponents();
        this.setLocationRelativeTo(null);
        this.cliente = cliente; // Armazena o cliente passado
     
        preencherDadosCliente();
        // Carregar os tipos de atendimento na combo box
       carregarTiposAtendimento();
       cbTipoAtendimento.setSelectedIndex(0);
       txtValor.setEditable(false);
    }
  /**
     * Construtor que inicializa a tela para edição de um agendamento existente.
     * @param agendamento Objeto Agendamento a ser editado.
     */
    public TelaAgendamento(Agendamento agendamento) {
        initComponents();
    this.setLocationRelativeTo(null);
    this.agendamento = agendamento;

    // Busca o cliente pelo CPF
    this.cliente = ClienteDAO.buscarClientePorCpf(agendamento.getCpfCliente());

    // Verifica se o cliente foi encontrado antes de preencher os dados
    if (cliente != null) {
        preencherDadosCliente();
    } else {
        JOptionPane.showMessageDialog(this, "Cliente não encontrado para este CPF.");
        dispose(); 
        return;
    }

    carregarTiposAtendimento();
    preencherDadosAgendamento();
    txtValor.setEditable(false);
    }
     /**
     * Preenche os campos da tela com os dados do agendamento.
     */
    private void preencherDadosAgendamento() {
    if (agendamento != null) {
        txtData.setText(agendamento.getData());
        txtHora.setText(agendamento.getHora());
        cbTipoAtendimento.setSelectedItem(agendamento.getTipoAtendimento());
        
        atualizarEspecificacoes(); // Atualiza as opções da especificação

        cbEspecificacao.setSelectedItem(agendamento.getEspecificacao());
        
        // Calcula o valor corretamente baseado na seleção atual
        double valor = calcularValor(agendamento.getTipoAtendimento(), agendamento.getEspecificacao());
        txtValor.setText(String.format("%.2f", valor));
    }
}
       
    /**
     * Preenche os campos da tela com os dados do cliente.
     */
    private void preencherDadosCliente() {
        
        txtNome.setText(cliente.getNome());
        txtCpf.setText(cliente.getCpf());
        txtCpf.setEditable(false); // Impede edição do CPF
        txtNome.setEditable(false); // Impede edição do Nome
        
    }
    /**
     * Carrega os tipos de atendimento disponíveis na ComboBox.
     */
private void carregarTiposAtendimento() {
        cbTipoAtendimento.addItem("Escolha o tipo de atendimento");
        cbTipoAtendimento.addItem("Cílios");
        cbTipoAtendimento.addItem("Sobrancelhas");
        cbTipoAtendimento.addItem("Lábios");
        cbTipoAtendimento.addItem("Epilação Egípcia");
    }
 /**
     * Calcula o valor do serviço com base no tipo de atendimento e especificação.
     * @param tipoAtendimento Tipo de atendimento selecionado.
     * @param especificacao Especificação do atendimento.
     * @return Valor do serviço correspondente.
     */
    private double calcularValor(String tipoAtendimento, String especificacao) {
        return switch (tipoAtendimento) {
            case "Cílios" -> switch (especificacao) {
                case "Volume Russo" -> 150.0;
                case "Clássico" -> 120.0;
                case "Mega Volume" -> 180.0;
                case "Fio a Fio" -> 100.0;
                default -> 0.0;
            };
            case "Sobrancelhas" -> switch (especificacao) {
                case "Design de Sobrancelha" -> 80.0;
                case "Microblading" -> 200.0;
                case "Lamination" -> 150.0;
                case "Henna" -> 60.0;
                default -> 0.0;
            };
            case "Lábios" -> switch (especificacao) {
                case "Lip Tint" -> 130.0;
                case "Gloss" -> 100.0;
                case "Matte" -> 140.0;
                case "Contorno" -> 160.0;
                default -> 0.0;
            };
            case "Epilação Egípcia" -> switch (especificacao) {
                case "Rosto" -> 90.0;
                case "Corpo" -> 200.0;
                case "Axilas" -> 50.0;
                case "Virilha" -> 80.0;
                default -> 0.0;
            };
            default -> 0.0;
        };
    }
    
     /**
     * Atualiza a lista de especificações com base no tipo de atendimento selecionado.
     */
private void atualizarEspecificacoes() {
    cbEspecificacao.removeAllItems();
    
    Object itemSelecionado = cbTipoAtendimento.getSelectedItem();
    if (itemSelecionado == null) return; // Evita erro de null

    String tipoAtendimento = itemSelecionado.toString();

    switch (tipoAtendimento) {
        case "Cílios" -> {
            cbEspecificacao.addItem("Volume Russo");
            cbEspecificacao.addItem("Clássico");
            cbEspecificacao.addItem("Mega Volume");
            cbEspecificacao.addItem("Fio a Fio");
        }
        case "Sobrancelhas" -> {
            cbEspecificacao.addItem("Design de Sobrancelha");
            cbEspecificacao.addItem("Microblading");
            cbEspecificacao.addItem("Lamination");
            cbEspecificacao.addItem("Henna");
        }
        case "Lábios" -> {
            cbEspecificacao.addItem("Lip Tint");
            cbEspecificacao.addItem("Gloss");
            cbEspecificacao.addItem("Matte");
            cbEspecificacao.addItem("Contorno");
        }
        case "Epilação Egípcia" -> {
            cbEspecificacao.addItem("Rosto");
            cbEspecificacao.addItem("Corpo");
            cbEspecificacao.addItem("Axilas");
            cbEspecificacao.addItem("Virilha");
        }
    }

    if (cbEspecificacao.getItemCount() > 0) {
        cbEspecificacao.setSelectedIndex(0);
    }
    
    atualizarValor(); // Atualiza o valor após carregar opções
}
 /**
     * Atualiza o campo de valor conforme o tipo de atendimento e especificação selecionados.
     */
private void atualizarValor() {
        String tipoAtendimento = (String) cbTipoAtendimento.getSelectedItem();
        String especificacao = (String) cbEspecificacao.getSelectedItem();
        
        if (tipoAtendimento == null || especificacao == null) return;

        double valor = calcularValor(tipoAtendimento, especificacao);
        txtValor.setText(String.format("%.2f", valor));
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
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        cbTipoAtendimento = new javax.swing.JComboBox<>();
        cbEspecificacao = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtData = new javax.swing.JFormattedTextField();
        txtHora = new javax.swing.JFormattedTextField();
        jLabel7 = new javax.swing.JLabel();
        txtValor = new javax.swing.JTextField();
        btnAgendar = new javax.swing.JButton();
        btnVoltar = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtCpf = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setText("MyLashes");

        jLabel2.setText("Nome:");

        jLabel3.setText("Tipo de atendimento:");

        cbTipoAtendimento.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " " }));
        cbTipoAtendimento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbTipoAtendimentoActionPerformed(evt);
            }
        });

        cbEspecificacao.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbEspecificacao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbEspecificacaoActionPerformed(evt);
            }
        });

        jLabel4.setText("Especificação:");

        jLabel5.setText("Data:");

        jLabel6.setText("Horário:");

        try {
            txtData.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        try {
            txtHora.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##:##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        jLabel7.setText("Valor:");

        btnAgendar.setBackground(new java.awt.Color(105, 109, 168));
        btnAgendar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnAgendar.setForeground(new java.awt.Color(255, 255, 255));
        btnAgendar.setText("Agendar");
        btnAgendar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgendarActionPerformed(evt);
            }
        });

        btnVoltar.setBackground(new java.awt.Color(51, 51, 51));
        btnVoltar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnVoltar.setForeground(new java.awt.Color(255, 255, 255));
        btnVoltar.setText("Voltar");
        btnVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVoltarActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel8.setText("Agendamento");

        jLabel9.setText("CPF:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(66, 66, 66)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7)
                            .addComponent(jLabel9))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(btnVoltar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 125, Short.MAX_VALUE)
                                .addComponent(btnAgendar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(cbEspecificacao, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtNome)
                            .addComponent(cbTipoAtendimento, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtData)
                            .addComponent(txtHora)
                            .addComponent(txtValor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtCpf)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(267, 267, 267)
                        .addComponent(jLabel1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(281, 281, 281)
                        .addComponent(jLabel8)))
                .addContainerGap(139, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel8)
                .addGap(36, 36, 36)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(txtCpf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(cbTipoAtendimento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbEspecificacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtValor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtData, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtHora, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAgendar)
                    .addComponent(btnVoltar))
                .addContainerGap(58, Short.MAX_VALUE))
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

    private void btnVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVoltarActionPerformed
        /**
     * Método acionado ao clicar no botão "Voltar".
     * Fecha a tela atual e retorna para a tela de ações.
     * @param evt Evento de clique no botão.
     */
        new TelaAcoes().setVisible(true);
        dispose();
    }//GEN-LAST:event_btnVoltarActionPerformed

    private void btnAgendarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgendarActionPerformed
        
    /**
     * Método acionado ao clicar no botão "Agendar".
     * Valida os dados preenchidos e cria um novo agendamento.
     * @param evt Evento de clique no botão.
     */
        try {
        String nome = txtNome.getText().trim();
        String cpf = txtCpf.getText().trim();
        String data = txtData.getText().trim();
        String hora = txtHora.getText().trim();

        if (nome.isEmpty() || cpf.isEmpty() || data.isEmpty() || hora.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Todos os campos devem ser preenchidos.");
            return;
        }

        Object tipoSelecionado = cbTipoAtendimento.getSelectedItem();
        Object especificacaoSelecionada = cbEspecificacao.getSelectedItem();

        if (tipoSelecionado == null || especificacaoSelecionada == null) {
            JOptionPane.showMessageDialog(this, "Selecione um tipo de atendimento e uma especificação.");
            return;
        }

        String tipoAtendimento = tipoSelecionado.toString();
        String especificacao = especificacaoSelecionada.toString();

        String valorTexto = txtValor.getText().trim().replace(",", ".");
        if (valorTexto.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Erro ao calcular o valor do serviço.");
            return;
        }

        double valor;
        try {
            valor = Double.parseDouble(valorTexto);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Erro: O valor inserido não é válido.");
            return;
        }

        boolean status = false;
        Agendamento novoAgendamento = new Agendamento(nome, cpf, tipoAtendimento, especificacao, data, hora, valor, status);

        // Aqui o tratamento da SQLException
        try {
            boolean sucesso = AgendamentoDAO.salvarAgendamento(novoAgendamento);
            if (sucesso) {
                JOptionPane.showMessageDialog(this, "Agendamento realizado com sucesso!");
                TabelaAgenda tabelaAgenda = new TabelaAgenda();
                tabelaAgenda.setVisible(true);
                dispose();
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Erro ao salvar o agendamento no banco de dados: " + ex.getMessage());
            ex.printStackTrace();
        }

    } catch (Exception e) {
        JOptionPane.showMessageDialog(this, "Erro inesperado: " + e.getMessage());
        e.printStackTrace();
    }
    }//GEN-LAST:event_btnAgendarActionPerformed

    private void cbTipoAtendimentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbTipoAtendimentoActionPerformed
        /**
     * Método acionado ao selecionar um tipo de atendimento.
     * Atualiza as opções de especificação disponíveis.
     * @param evt Evento de seleção na ComboBox.
     */ 
        atualizarEspecificacoes();
    }//GEN-LAST:event_cbTipoAtendimentoActionPerformed

    private void cbEspecificacaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbEspecificacaoActionPerformed
         /**
     * Método acionado ao selecionar uma especificação.
     * Atualiza o valor do serviço com base no tipo e especificação escolhidos.
     * @param evt Evento de seleção na ComboBox.
     */
        Object tipoSelecionado = cbTipoAtendimento.getSelectedItem();
    Object especificacaoSelecionada = cbEspecificacao.getSelectedItem();

    if (tipoSelecionado == null || especificacaoSelecionada == null) {
        return; // Sai do método se algum for nulo
    }

    String tipoAtendimento = tipoSelecionado.toString();
    String especificacao = especificacaoSelecionada.toString();
    
    double valor = calcularValor(tipoAtendimento, especificacao);
    txtValor.setText(String.format("%.2f", valor));
    }//GEN-LAST:event_cbEspecificacaoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgendar;
    private javax.swing.JButton btnVoltar;
    private javax.swing.JComboBox<String> cbEspecificacao;
    private javax.swing.JComboBox<String> cbTipoAtendimento;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField txtCpf;
    private javax.swing.JFormattedTextField txtData;
    private javax.swing.JFormattedTextField txtHora;
    private javax.swing.JTextField txtNome;
    private javax.swing.JTextField txtValor;
    // End of variables declaration//GEN-END:variables
}
