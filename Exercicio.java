package br.com.ufpb.projetopoo;

import java.util.ArrayList;
import java.util.List;
public class Exercicio {
	private String nomeExercicio;
	private List<Questao> questoes;
	private List<Resposta> resposta;
	private List<CadastroDeRespostaDoAluno> cadastroDeRespostaDoAluno;
	public Exercicio(){
		this.questoes = new ArrayList<Questao>();
		this.resposta = new ArrayList<Resposta>();
		this.nomeExercicio = "exercicio indefinido";
		this.cadastroDeRespostaDoAluno = new ArrayList<CadastroDeRespostaDoAluno>();
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
	public List<Resposta> getResposta(){
		return this.resposta;
	}
	public void cadastrarQuestao(int numero, String questao, TipoQuestao tipo){
		this.questoes.add(new Questao(numero, questao, tipo));
	}
	public void cadastrarRespostaDeQuestao(int numero, String resposta, TipoQuestao tipo){
		this.resposta.add(new Resposta(numero, resposta, tipo));
	} 
	
	public List<CadastroDeRespostaDoAluno> getCadastroDeRespostaDoAluno(){
		return this.cadastroDeRespostaDoAluno;
	}
	public void adicionaCadastroDeRespostaDoAluno(CadastroDeRespostaDoAluno r){
		this.cadastroDeRespostaDoAluno.add(r);
	}
	
}
