
package clientes;

/**
 * Classe que representa um Cliente no sistema.
 */
public class Cliente {
    private String nome;
    private String endereco;
    private String email;
    private String cpf;
    private String telefone;
    private String dataNascimento;

    /**
     * Construtor para criar um cliente com os dados fornecidos.
     *
     * @param nome Nome do cliente.
     * @param endereco Endereço do cliente.
     * @param email Email do cliente.
     * @param cpf CPF do cliente.
     * @param telefone Telefone do cliente.
     * @param dataNascimento Data de nascimento do cliente.
     */
    public Cliente(String nome, String endereco, String email, String cpf, String telefone, String dataNascimento) {
        this.nome = nome;
        this.endereco = endereco;
        this.email = email;
        this.cpf = limparCpf(cpf);
        this.telefone = telefone;
        this.dataNascimento = dataNascimento;
    }

    /**
     * Obtém o nome do cliente.
     * 
     * @return Nome do cliente.
     */
    public String getNome() { return nome; }
    
    /**
     * Obtém o endereço do cliente.
     * 
     * @return Endereço do cliente.
     */
    public String getEndereco() { return endereco; }
    
    /**
     * Obtém o email do cliente.
     * 
     * @return Email do cliente.
     */
    public String getEmail() { return email; }
    
    /**
     * Obtém o CPF do cliente.
     * 
     * @return CPF do cliente.
     */
    public String getCpf() { return cpf; }
    
    /**
     * Retorna o CPF formatado como ###.###.###-## (para exibição).
     * 
     * @return CPF formatado.
     */
    public String getCpfFormatado() {
        if (cpf != null && cpf.length() == 11) {
            return cpf.replaceAll("(\\d{3})(\\d{3})(\\d{3})(\\d{2})", "$1.$2.$3-$4");
        }
        return cpf;
    }
    
    /**
     * Remove qualquer caractere que não seja número do CPF.
     * 
     * @param cpf CPF com ou sem formatação.
     * @return CPF limpo, contendo apenas números.
     */
    private String limparCpf(String cpf) {
        return cpf.replaceAll("[^\\d]", "");
    }
    
    /**
     * Obtém o telefone do cliente.
     * 
     * @return Telefone do cliente.
     */
    public String getTelefone() { return telefone; }
    
    /**
     * Obtém a data de nascimento do cliente.
     * 
     * @return Data de nascimento do cliente.
     */
    public String getDataNascimento() { return dataNascimento; }
}
