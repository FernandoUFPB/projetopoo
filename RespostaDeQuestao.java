package br.com.ufpb.projetopoo;

import java.io.Serializable;

public class RespostaDeQuestao implements Serializable{
	private int numResposta;
	private String resposta;
	private TipoQuestao tipo;
	public RespostaDeQuestao(int numQuestao, String resposta, TipoQuestao tipo){
		this.numResposta = numQuestao;
		this.resposta = resposta;
		this.tipo = tipo;
	}
	public String getResposta(){
		return resposta;
	}
	public void setResposta(String resposta){
		this.resposta = resposta;
	}
	public TipoQuestao getTipo(){
		return tipo;
	}
	public void setTipo(TipoQuestao tipo){
		this.tipo = tipo;
	}
	public int getNumResposta(){
		return numResposta;
	}
	public void setNumResposta(int num){
		this.numResposta = num;
	}
}
