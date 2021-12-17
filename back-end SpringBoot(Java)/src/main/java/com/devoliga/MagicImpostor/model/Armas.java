package com.devoliga.MagicImpostor.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.UniqueConstraint;

@Entity
public class Armas implements Serializable {
    
	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int codigo;
    private String nome;
  
    @ManyToMany
    @JoinTable(
        name="clasArmas", 
        uniqueConstraints = @UniqueConstraint(columnNames = { "codigo_armas", "idi_cla" }),
        joinColumns        = @JoinColumn(name = "codigo_armas" ),
        inverseJoinColumns = @JoinColumn(name = "idi_cla")
    )
    private List<Cla> clas;
        

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

  
    
    public List<Cla> getClas() {
		return clas;
	}

	public void setClas(List<Cla> clas) {
		this.clas = clas;
	}

	@Override
    public String toString() {
        return "Professor [codigo=" + codigo + ", nome=" + nome + "]";
    }  

}
