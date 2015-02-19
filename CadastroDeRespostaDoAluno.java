package br.com.ufpb.projetopoo;

import java.util.LinkedList;
import java.util.List;
public class CadastroDeRespostaDoAluno{
	private Aluno aluno;
	private List<Resposta> respostas;
	public CadastroDeRespostaDoAluno(){
		this.respostas = new LinkedList<Resposta>();
		this.aluno= null;
	}
	public void cadastrarRespostaDeQuestao(int numero, String resposta, TipoQuestao tipo){
		this.respostas.add(new Resposta(numero, resposta, tipo));
	}
	public void setAluno(Aluno a){
		this.aluno = a;
	}
	public Pessoa getAluno(){
		return aluno;
	}	
	public List<Resposta> getResposta(){
		return this.respostas;
	}
}
