package br.com.ufpb.projetopoo;

import java.io.Serializable;

public class Professor extends Pessoa implements Serializable{
	public Professor(){
		super("sem nome", "sem matricula");
	}
	public Professor(String nome, String matricula){
		super(nome, matricula);
	}
	public String toString(){
		return "Nome: "+super.getNome()+", Matricula: "+super.getMatricula();
	}
}