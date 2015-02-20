package br.com.ufpb.projetopoo;

import java.util.ArrayList;
import java.util.List;
<<<<<<< HEAD
public class GerenteDeFeedback {
	private List<Feedback> feedbacks;
	public GerenteDeFeedback(){
		this.feedbacks = new ArrayList<Feedback>();
	}
	
	public void CadastarFeedback(String nomeExer, String matricula, String comentario) {
		this.feedbacks.add(new Feedback(nomeExer, matricula, comentario));
	}
	public String PesquisaFeedback(String nomeExer, String matricula) throws FeedbackInexistenteException{
		for(Feedback f : this.feedbacks){
			if(f.getNomeExercicio().equals(nomeExer) && f.getMatricula().equals(matricula)){
				return f.getFeedback();
			}
		}
		throw new FeedbackInexistenteException("Não existe feedback para  esta matricula!");
	}
	
=======

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
>>>>>>> 2b67ff6f0bd4e86e7813be14fcc1d813d383ddcc
}