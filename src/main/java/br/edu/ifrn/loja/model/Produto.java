/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifrn.loja.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import org.hibernate.validator.constraints.NotBlank;


/**
 *
 * @author joaon
 */
@Entity
//@SequenceGenerator(name = "produto_seq",sequenceName = "produto_seq")
public class Produto {
    @Id
    //@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "produto_seq")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotBlank(message = "Nome não pode ser vazio")  
    private String nome;

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

    @Override
    public String toString() {
        return "Produto{" + "id=" + id + ", nome=" + nome + '}';
    }

}
