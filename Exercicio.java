package br.com.ufpb.projetopoo;

<<<<<<< HEAD
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
=======

import java.util.ArrayList;
import java.util.List;
public class Exercicio {
	private int numExercicio;
	private Professor professor;
	private List<Questao> questoes;
	private List<Resposta> respostas;
	private List<RespostaExercicio> respostasExercicio;
	public Exercicio(int numExercicio){
		this.numExercicio = numExercicio;
		this.professor = null;
		this.respostas = new ArrayList<Resposta>();
		this.respostasExercicio = new ArrayList<RespostaExercicio>();
		this.questoes = new ArrayList<Questao>();
	}
	public void setNumExercicio(int num){
		this.numExercicio = num;
	}
	public long getNumExercicio(){
		return numExercicio;
	}
	public Professor getProfessor(){
		return this.professor;
	}
	public void setProfessor(Professor prof){
		this.professor = prof;
>>>>>>> 2b67ff6f0bd4e86e7813be14fcc1d813d383ddcc
	}
	public List<Questao> getQuestoes(){
		return this.questoes;
	}
<<<<<<< HEAD
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
	
=======
	public void cadastrarQuestaoDeVouF(int numero, String questao, TipoQuestao tipo){
		this.questoes.add(new Questao(numero, questao, tipo));
	}
	public void cadastrarQuestaoDissertativa(int numero, String questao, TipoQuestao tipo){
		this.questoes.add(new Questao(numero, questao, tipo));			
	}
	public void cadastrarQuestaoDeMultiplaEscolha(int numero, String questao, TipoQuestao tipo){
		this.questoes.add(new Questao(numero, questao, tipo));	
	}
	public Questao pesquisaQuestaoDeExercicio(int numQuestao)throws QuestaoInexistenteException{
		for(Questao i: this.questoes){
			if(i.getNumQuestao() == numQuestao){
				return i;
			}
		}
		throw new QuestaoInexistenteException("Questao Inexistente"+numQuestao);
	}
	
	public void cadastrarRespostaDeAluno(RespostaExercicio r){
		this.respostasExercicio.add(r);
	}
	public List<RespostaExercicio> getRespostasExercicio(){
		return this.respostasExercicio;
	}
	public List<Resposta> getRespostas(){
		return respostas;
	}
>>>>>>> 2b67ff6f0bd4e86e7813be14fcc1d813d383ddcc
}
