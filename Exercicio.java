package br.com.ufpb.projetopoo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
public class Exercicio implements Serializable{
	private String nomeExercicio;
	private List<Questao> questoes;
	public Exercicio(String nomeExercicio){
		this.nomeExercicio = nomeExercicio;
		this.questoes = new ArrayList<Questao>();
	}
	public String getNomeExercicio(){
		return nomeExercicio;
	}
	public void setNomeExercicio(String nomeExercicio){
		this.nomeExercicio = nomeExercicio;
	}
	public List<Questao> getQuestoes(){
		return questoes;
	}
	public void cadastrarQuestao(int numero, String questao, String resposta, TipoQuestao tipo){
		this.questoes.add(new Questao(numero, questao, resposta, tipo));
	}
	public void cadastrarQuestaoMultiplaEscolha(int numero, String questao, List<String> alternativas, String resposta, TipoQuestao tipo){
		this.questoes.add(new Questao(numero, questao, alternativas, resposta, tipo));
	}
}