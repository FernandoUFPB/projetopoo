package br.com.ufpb.projetopoo;

import java.util.ArrayList;
import java.util.List;
public class Exercicio {
	private Professor professor;
	private String nomeExercicio;
	private List<Questao> questoes;
	public Exercicio(){
		this.questoes = new ArrayList<Questao>();
		this.nomeExercicio = "exercicio indefinido";
		this.professor = null;
	}
	public void setProfessor(Professor p){
		this.professor = p;
	}
	public Professor getProfessor(){
		return professor;
	}
	public void setNomeExercicio(String nome){
		this.nomeExercicio = nome;
	}
	public String getNomeExercicio(){
		return nomeExercicio;
	}
	public List<Questao> getQuestoes(){
		return this.questoes;
	}
	public void cadastrarQuestao(int numero, String questao, String resposta, TipoQuestao tipo){
		this.questoes.add(new Questao(numero, questao, resposta, tipo));
	}
}
