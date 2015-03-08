package br.com.ufpb.projetopoo;

public class Questao {
	private int numQuestao;
	private String questao;
	private String resposta;
	private TipoQuestao tipo;
	public Questao(int numQuestao, String questao, String resposta, TipoQuestao tipo){
		this.numQuestao = numQuestao;
		this.questao = questao;
		this.resposta = resposta;
		this.tipo = tipo;
	}
	public Questao(){
		
	}
	public TipoQuestao getTipo(){
		return tipo;
	}
	public void setTipo(TipoQuestao tipo){
		this.tipo = tipo;
	}
	public void setNumQuestao(int num){
		this.numQuestao = num;
	}
	public int getNumQuestao(){
		return numQuestao;
	}
	public void setQuestao(String questao){
		this.questao = questao;
	}
	public String getQuestao(){
		return questao;
	}
	public String toString(){
		return this.numQuestao+" Questão: "+this.questao;
	}
	public String getResposta(){
		return resposta;
	}
	public void setResposta(String resposta){
		this.resposta = resposta;
	}
}


