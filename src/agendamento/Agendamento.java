/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package agendamento;

/**
 * Classe que representa um agendamento de atendimento.
 */
public class Agendamento {
    private int id;
    private String nome;
    private String cpfCliente;
    private String tipoAtendimento;
    private String especificacao;
    private String data;
    private String hora;
    private double valor;
    private boolean status;

    public Agendamento() {
    }
    
    /**
     * Construtor para inicializar um agendamento.
     *
     * @param nome Nome do cliente.
     * @param cpfCliente CPF do cliente.
     * @param tipoAtendimento Tipo de atendimento solicitado.
     * @param especificacao Especificação do serviço.
     * @param data Data do agendamento (Formato: dd/MM/yyyy).
     * @param hora Hora do agendamento (Formato: HH:mm).
     * @param valor Valor do serviço.
     * @param status Indica se o serviço foi pago (true) ou não (false).
     */
    public Agendamento(String nome, String cpfCliente, String tipoAtendimento, String especificacao, String data, String hora, double valor, boolean status) {
        this.nome = nome;
        this.cpfCliente = cpfCliente;
        this.tipoAtendimento = tipoAtendimento;
        this.especificacao = especificacao;
        this.data = data;
        this.hora = hora;
        this.valor = valor;
        this.status = status;
    }

    public Agendamento(int id, String nome, String cpfCliente, String tipoAtendimento, String especificacao, String data, String hora, double valor, boolean status) {
    this.id = id;
    this.cpfCliente = cpfCliente;
        this.tipoAtendimento = tipoAtendimento;
        this.especificacao = especificacao;
        this.data = data;
        this.hora = hora;
        this.valor = valor;
        this.status = status;
    }
    // Getters e Setters
    public int getId() {
        return id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    /**
     * Obtém o nome do cliente.
     * @return Nome do cliente.
     */
    public String getNome() {
        return nome;
    }
       /**
     * Define o nome do cliente.
     * @param nome Nome do cliente.
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

     /**
     * Obtém o CPF do cliente.
     * @return CPF do cliente.
     */
    public String getCpfCliente() {
        return cpfCliente;
    }
       
    /**
     * Define o CPF do cliente.
     * @param cpfCliente CPF do cliente.
     */
    public void setCpfCliente(String cpfCliente) {
        this.cpfCliente = cpfCliente;
    }
     /**
     * Obtém o tipo de atendimento.
     * @return Tipo de atendimento.
     */
    public String getTipoAtendimento() {
        return tipoAtendimento;
    }

    /**
     * Define o tipo de atendimento.
     * @param tipoAtendimento Tipo de atendimento.
     */
    public void setTipoAtendimento(String tipoAtendimento) {
        this.tipoAtendimento = tipoAtendimento;
    }

    /**
     * Obtém a especificação do serviço.
     * @return Especificação do serviço.
     */
    public String getEspecificacao() {
        return especificacao;
    }

     /**
     * Define a especificação do serviço.
     * @param especificacao Especificação do serviço.
     */
    public void setEspecificacao(String especificacao) {
        this.especificacao = especificacao;
    }

    /**
     * Obtém a data do agendamento.
     * @return Data do agendamento (Formato: dd/MM/yyyy).
     */
    public String getData() {
        return data;
    }

     /**
     * Define a data do agendamento.
     * @param data Data do agendamento (Formato: dd/MM/yyyy).
     */
    public void setData(String data) {
        this.data = data;
    }

    /**
     * Obtém a hora do agendamento.
     * @return Hora do agendamento (Formato: HH:mm).
     */
    public String getHora() {
        return hora;
    }

    /**
     * Define a hora do agendamento.
     * @param hora Hora do agendamento (Formato: HH:mm).
     */
    public void setHora(String hora) {
        this.hora = hora;
    }

    /**
     * Obtém o valor do serviço.
     * @return Valor do serviço.
     */
    public double getValor() {
        return valor;
    }

    /**
     * Define o valor do serviço.
     * @param valor Valor do serviço.
     */
    public void setValor(double valor) {
        this.valor = valor;
    }

    /**
     * Verifica se o serviço foi pago.
     * @return true se pago, false se pendente.
     */
    public boolean isStatus() {
        return status;
    }

     /**
     * Define o status de pagamento do serviço.
     * @param status true para pago, false para pendente.
     */
    public void setStatus(boolean status) {
        this.status = status;
    }

    /**
     * Retorna uma representação formatada do status de pagamento.
     * @return "Pago" se status for true, "Pendente" se for false.
     */
    public String getStatusFormatado() {
        return status ? "Pago" : "Pendente";
    }
}