package br.com.ufpb.projetopoo;

import java.io.Serializable;
import java.util.List;
public class Questao implements Serializable{
	private int numQuestao;
	private String questao;
	private List<String> alternativas;
	private String resposta; 
	private TipoQuestao tipo;
	public Questao(int numQuestao, String questao, String resposta, TipoQuestao tipo){
		this.numQuestao = numQuestao;
		this.questao = questao;
		this.resposta = resposta;
		this.tipo = tipo;
	}
	public Questao(int numQuestao, String questao, List<String> alternativas, String resposta, TipoQuestao tipo){
		this.numQuestao = numQuestao;
		this.questao = questao;
		this.alternativas = alternativas;
		this.resposta = resposta;
		this.tipo = tipo;		
	}
	public int getNumQuestao(){
		return numQuestao;
	}
	public void setNumQuestao(int num){
		this.numQuestao = num;
	}
	public String getQuestao(){
		return questao;
	}
	public void setQuestao(String questao){
		this.questao = questao;
	}
	public String getResposta(){
		return resposta;
	}
	public void setResposta(String resposta){
		this.resposta = resposta;
	}
	public List<String> getAltenativas(){
		return alternativas;
	}
	public void setAlternativas(List<String> alternativas){
		this.alternativas = alternativas;
	}
	public TipoQuestao getTipo(){
		return tipo;
	}
	public void setTipo(TipoQuestao tipo){
		this.tipo = tipo;
	}
}


