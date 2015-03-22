package br.com.ufpb.projetopoo;

import java.io.Serializable;

public class Aluno extends Pessoa implements Serializable{
	public Aluno(){
		super("sem nome","sem matricula");
	}
	public Aluno(String nome, String matricula){
		super(nome, matricula);
	}
	public String toString(){
		return "Nome: "+super.getNome()+", Matricula: "+super.getMatricula();
	}
}