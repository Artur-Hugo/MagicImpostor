package com.devoliga.MagicImpostor.model;
import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class Cla implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idi;
    private String nome;
    
    @OneToMany
    @JoinColumn(name="ID_Personagem")
    private List<Personagem> personagem;

	public int getId() {
		return idi;
	}

	public void setId(int id) {
		this.idi = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Personagem> getPersonagem() {
		return personagem;
	}

	public void setPersonagem(List<Personagem> personagem) {
		this.personagem = personagem;
	}

	@Override
	public String toString() {
		return "Cla [id=" + idi + ", nome=" + nome + ", personagem=" + personagem + "]";
	}

    
}