package br.com.ufpb.projetoDisciplinaPOO;
public class Aluno extends Pessoa{
	public Aluno(String nome, String matricula){
		super(nome, matricula);
	}
	public Aluno(String texto, String emailRemetente, String emailDestinatario){
		super(texto, emailRemetente, emailDestinatario);
	}
	public Aluno(){
		super("sem nome","sem matricula");
	}
	public String getDescricao(){
		return "Aluno";
	}
	public String toString(){
		return "nome: "+super.getNome()+", matricula: "+super.getMatricula();
	}
	public String getFeedbackAExibir() {
		return "Mensagem de:"+super.getEmailRemetente()+" para "+getEmailDestinatario()+" Texto "+super.getTexto();
	}
}
