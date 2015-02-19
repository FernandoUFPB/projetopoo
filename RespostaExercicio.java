package br.com.ufpb.projetopoo;

import java.util.ArrayList;
import java.util.List;


public class RespostaExercicio {
	private Aluno aluno;
	private List<Resposta> respostas;
	public RespostaExercicio(){
		this.respostas = new ArrayList<Resposta>();
		this.aluno = null;
	}
	public void setAluno(Aluno a){
		this.aluno = a;
	}
	public Aluno getAluno(){
		return aluno;
	}
	public void cadastrarRespostaDeQuestaoVouF(Resposta r){
		this.respostas.add(r);
	}
	public void cadastrarRespostaDeQuestaoDissertativa(Resposta r){
		this.respostas.add(r);
	}
	public void cadastrarRespostaDeQuestaoMultiplaEscolha(Resposta r){
		this.respostas.add(r);
	}
	public List<Resposta> getRespostas(){
		return respostas;
	}
}
