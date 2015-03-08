package br.com.ufpb.projetopoo;

import java.util.LinkedList;
import java.util.List;
public class RespostaDoExercicio{
	private Aluno aluno;
	private List<RespostaDeQuestao> respostas;
	public RespostaDoExercicio(){
		this.respostas = new LinkedList<RespostaDeQuestao>();
		this.aluno= null;
	}
	public void cadastrarRespostaDeQuestao(int numero, String resposta, TipoQuestao tipo){
		this.respostas.add(new RespostaDeQuestao(numero, resposta, tipo));
	}
	public void setAluno(Aluno a){
		this.aluno = a;
	}
	public Pessoa getAluno(){
		return aluno;
	}	
	public List<RespostaDeQuestao> getResposta(){
		return this.respostas;
	}
}
