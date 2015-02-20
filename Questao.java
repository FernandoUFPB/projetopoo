package br.com.ufpb.projetopoo;
<<<<<<< HEAD

=======
>>>>>>> 2b67ff6f0bd4e86e7813be14fcc1d813d383ddcc
public class Questao {
	private int numQuestao;
	private String questao;
	private TipoQuestao tipo;
	public Questao(int numQuestao, String questao, TipoQuestao tipo){
<<<<<<< HEAD
		this.numQuestao = numQuestao;
=======
		this.numQuestao = numQuestao;	
>>>>>>> 2b67ff6f0bd4e86e7813be14fcc1d813d383ddcc
		this.questao = questao;
		this.tipo = tipo;
	}
	public TipoQuestao getTipo(){
		return tipo;
	}
<<<<<<< HEAD
	public void getTipo(TipoQuestao tipo){
		this.tipo = tipo;
	}
=======
>>>>>>> 2b67ff6f0bd4e86e7813be14fcc1d813d383ddcc
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
}

<<<<<<< HEAD

=======
>>>>>>> 2b67ff6f0bd4e86e7813be14fcc1d813d383ddcc
