package br.com.ufpb.projetopoo;

public class QuestaoInexistenteException extends Exception {
	public QuestaoInexistenteException(String mensagem){
		super(mensagem);
	}
}
