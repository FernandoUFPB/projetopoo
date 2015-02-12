package br.com.ufpb.projetoDisciplinaPOO;

public class Professor extends Pessoa{

	public Professor(String nome, String matricula){
		super(nome, matricula);
	}
	public Professor(String texto, String emailRemetente, String emailDestinatario){
		super(texto, emailRemetente, emailDestinatario);
	}
	public Professor(){
		super("sem nome", "sem matricula");
	}
	public String getDescricao(){
		return "Professor";
	}
	public String getFeedbackAExibir() {
		return "Mensagem de:"+super.getEmailRemetente()+" para "+getEmailDestinatario()+" Texto "+super.getTexto();
	}
}
