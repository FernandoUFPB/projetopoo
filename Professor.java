package br.com.ufpb.projetopoo;

public class Professor extends Pessoa{
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
