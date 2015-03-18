package br.com.ufpb.projetopoo;

import java.util.LinkedList;
import java.util.List;
public class RespostaDoExercicio{
	private Aluno aluno;
	private Exercicio exercicio;
	private List<RespostaDeQuestao> respostas;
	public RespostaDoExercicio(){
		this.respostas = new LinkedList<RespostaDeQuestao>();
		this.aluno= null;
		this.exercicio = null;
	}
	public void cadastrarRespostaQuestao(int numero, String resposta, TipoQuestao tipo){
		this.respostas.add(new RespostaDeQuestao(numero, resposta, tipo));
	}
	public Exercicio getExercicio(){
		return exercicio;
	}
	public void setExercicio(Exercicio e){
		this.exercicio = e;
	}
	public Aluno getAluno(){
		return aluno;
	}
	public void setAluno(Aluno a){
		this.aluno = a;
	}	
	public List<RespostaDeQuestao > getResposta(){
		return respostas;
	}
}