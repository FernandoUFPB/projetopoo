package br.com.ufpb.projetopoo;

public class RespostaDeQuestao {
	private int numResposta;
	private String resposta;
	private TipoQuestao tipo;
	public RespostaDeQuestao(int numQuestao, String resposta, TipoQuestao tipo){
		this.numResposta = numQuestao;
		this.resposta = resposta;
		this.tipo = tipo;
	}
	public RespostaDeQuestao(){
		
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
	public String getResposta(){
		return resposta;
	}
	public void setResposta(String resposta){
		this.resposta = resposta;
	}
	public String toString(){
		return this.numResposta+" Resposta: "+this.resposta;
	}
}