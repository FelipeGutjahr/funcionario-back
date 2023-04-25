package com.gutjahr.funcionario.model;

import com.fasterxml.jackson.annotation.JsonInclude;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "funcionario")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Funcionario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @NotNull(message = "Informe o nome do funcionário")
    @Size(min = 2, max = 30, message = "Nome deve ter entre 2 e 50 caracteres")
    @Column(name="nome", length = 30, nullable = false)
    private String nome;
    @NotNull(message = "Infome o sobrenome do funcionário")
    @Size(min = 2, max = 50, message = "Sobrenome deve ter entre 2 e 50 caracteres")
    @Column(name = "sobrenome", length = 50, nullable = false)
    private String sobrenome;
    @NotNull(message = "Informe o email do funcionário")
    @Email(message = "Informe um email válido", regexp = ".+[@].+[\\\\.].+")
    @Column(name = "email", nullable = false)
    private String email;
    @Column(name = "pis")
    private Integer pis;

    public Funcionario() {}

    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getPis() { return pis; }

    public void setPis(Integer pis) { this.pis = pis; }
}
