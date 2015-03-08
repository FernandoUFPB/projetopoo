package br.com.ufpb.projetopoo;

import java.util.ArrayList;
import java.util.List;
public class GerenteDeFeedback {
	private List<Feedback> feedbacks;
	public GerenteDeFeedback(){
		this.feedbacks = new ArrayList<Feedback>();
	}
	public void enviarFeedback(String nomeExercicio, String matricula, String comentario) {
		this.feedbacks.add(new Feedback(nomeExercicio, matricula, comentario));
	}
	public String pesquisaFeedback(String nomeExercicio, String matricula) throws FeedbackInexistenteException{
		for(Feedback f : this.feedbacks){
			if(f.getNomeExercicio().equals(nomeExercicio) && f.getMatricula().equals(matricula)){
				return f.getFeedback();
			}
		}
		throw new FeedbackInexistenteException("Feedback Inexistente!");
	}
}