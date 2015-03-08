package br.com.ufpb.projetopoo;

public abstract class Pessoa {
	private String nome;
	private String matricula;
	public Pessoa(String nome, String matricula){
		this.nome = nome;
		this.matricula = matricula;
	}
	public String getNome(){
		return nome;
	}
	public void setNome(String n){
		this.nome = n;
	}
	public String getMatricula(){
		return matricula;
	}
	public void setMatricula(String m){
		this.matricula = m;
	}
}
