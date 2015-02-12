package br.com.ufpb.projetopoo;

import java.util.ArrayList;
import java.util.List;

import projetopoo.Pessoa;
import projetopoo.Professor;


public class GerenteDeFeedback {
	private List<Pessoa> feedbacks;
	public GerenteDeFeedback(){
		this.feedbacks = new ArrayList<Pessoa>();
	}
	public void enviarFeedbackParaAlunos() {
		// TODO Auto-generated method stub
		
		
	}
	public void enviarFeedbackParaProfessor(String texto, String emailRemetente, String emailDestinatario) {
		//TODO
		
	}
	public List<Pessoa> pesquisaTodosFeedbacks(){
		return null;
	}
}