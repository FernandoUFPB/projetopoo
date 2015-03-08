package br.com.ufpb.projetopoo;

public class Aluno extends Pessoa{
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
