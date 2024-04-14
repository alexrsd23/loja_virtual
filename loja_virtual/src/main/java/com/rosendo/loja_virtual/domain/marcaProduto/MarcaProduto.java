package com.rosendo.loja_virtual.domain.marcaProduto;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "tb_MarcaProduto")
public class MarcaProduto implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
