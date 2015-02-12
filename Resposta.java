package br.com.ufpb.projetoDisciplinaPOO;

import projetopoo.TipoQuestao;

public class Resposta {
	private int numQuestao;
	private String resposta;
	private TipoQuestao tipo;
	public Resposta(){
		
	}
	public Resposta(int numQuestao, String resposta, TipoQuestao tipo){
		this.numQuestao = numQuestao;
		this.resposta = resposta;
		this.tipo = tipo;
	}
	public TipoQuestao getTipo(){
		return tipo;
	}
	public void setNumQuestao(int num){
		this.numQuestao = num;
	}
	public int getNumQuestao(){
		return numQuestao;
	}
	public void setResposta(String resposta){
		this.resposta = resposta;
	}
	public String getResposta(){
		return resposta;
	}
}
