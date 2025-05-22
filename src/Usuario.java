/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 * Classe que representa um usuário do sistema.
 */
public class Usuario {
    private String usuario;
    private String senha;
/**
     * Construtor da classe Usuario.
     *
     * @param usuario Nome de usuário.
     * @param senha Senha do usuário.
     */
    public Usuario(String usuario, String senha) {
        this.usuario = usuario;
        this.senha = senha;
    }

    /**
     * Obtém o nome de usuário.
     *
     * @return Nome de usuário.
     */
    public String getUsuario() {
        return usuario;
    }

     /**
     * Obtém a senha do usuário.
     *
     * @return Senha do usuário.
     */
    public String getSenha() {
        return senha;
    }

    
}
