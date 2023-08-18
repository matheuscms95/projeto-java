package com.senai.segundoProjetoWeb.model;

import org.hibernate.annotations.Type;
import org.w3c.dom.Text;

import javax.persistence.*;

@Entity
@Table(name = "usuarios")
public class UserModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column
    private String nome;
    @Column
    private String email;
    @Column
    private String senha;
    @Column
    private String cpf;
    @Column
    private String telefone;
    @Column
    @Type(type = "text")
    private String sobreVoce;

    public UserModel() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getSobreVoce() {
        return sobreVoce;
    }

    public void setSobreVoce(String sobreVoce) {
        this.sobreVoce = sobreVoce;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
