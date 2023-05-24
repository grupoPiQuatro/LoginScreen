/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

/**
 *
 * @author lukas
 */
public class UserLogin {
    private String login;
    private String senha;
    private String fkEmpresa;
    
    public UserLogin(String login, String senha, String fkEmpresa){
        this.login = login;
        this.senha = senha;
        this.fkEmpresa = fkEmpresa;
    }
    
    public UserLogin() {
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getFkEmpresa() {
        return fkEmpresa;
    }

    public void setFkEmpresa(String fkEmpresa) {
        this.fkEmpresa = fkEmpresa;
    }
    
    
}
