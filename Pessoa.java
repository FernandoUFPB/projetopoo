package br.com.ufpb.projetopoo;

<<<<<<< HEAD
=======

>>>>>>> 2b67ff6f0bd4e86e7813be14fcc1d813d383ddcc
public abstract class Pessoa {
	private String nome;
	private String matricula;
	private String emailRemetente;
	private String emailDestinatario;
	private String texto;
	public Pessoa(String nome, String matricula){
		this.nome = nome;
		this.matricula = matricula;
	}
	public Pessoa(String texto2, String emailRemetente2, String emailDestinatario2) {
		this.texto = texto2;
		this.emailRemetente = emailRemetente2;
		this.emailDestinatario = emailDestinatario2;
	}
	public void setEmailDestinatario(String email){
		this.emailDestinatario = email;
	}
	public String getEmailDestinatario(){
		return emailDestinatario;
	}
	public void setTexto(String texto){
		this.texto = texto;
	}
	public String getTexto(){
		return texto;
	}
	public String getEmailRemetente(){
		return emailRemetente;
	}
	public void setEmailRemetente(String email){
		this.emailRemetente = email;
	}
	public String getNome(){
		return nome;
	}
	public String getMatricula(){
		return matricula;
	}
	public void setNome(String n){
		this.nome = n;
	}
	public void setMatricula(String m){
		this.matricula = m;
	}
	public abstract String getDescricao();
	
	public abstract String getFeedbackAExibir();
}
