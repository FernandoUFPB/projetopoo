package br.com.ufpb.projetopoo;

<<<<<<< HEAD
public class Resposta {
	private int numResposta;
	private String resposta;
	private TipoQuestao tipo;
	public Resposta(int numQuestao, String resposta, TipoQuestao tipo){
		this.numResposta = numQuestao;
=======
import projetopoo.TipoQuestao;

public class Resposta {
	private int numQuestao;
	private String resposta;
	private TipoQuestao tipo;
	public Resposta(){
		
	}
	public Resposta(int numQuestao, String resposta, TipoQuestao tipo){
		this.numQuestao = numQuestao;
>>>>>>> 2b67ff6f0bd4e86e7813be14fcc1d813d383ddcc
		this.resposta = resposta;
		this.tipo = tipo;
	}
	public TipoQuestao getTipo(){
		return tipo;
	}
<<<<<<< HEAD
	public void setTipo(TipoQuestao tipo){
		this.tipo = tipo;
	}
	public int getNumResposta(){
		return numResposta;
	}
	public void setNumResposta(int num){
		this.numResposta = num;
=======
	public void setNumQuestao(int num){
		this.numQuestao = num;
	}
	public int getNumQuestao(){
		return numQuestao;
	}
	public void setResposta(String resposta){
		this.resposta = resposta;
>>>>>>> 2b67ff6f0bd4e86e7813be14fcc1d813d383ddcc
	}
	public String getResposta(){
		return resposta;
	}
<<<<<<< HEAD
	public void setResposta(String resposta){
		this.resposta = resposta;
	}
}
=======
}
>>>>>>> 2b67ff6f0bd4e86e7813be14fcc1d813d383ddcc
