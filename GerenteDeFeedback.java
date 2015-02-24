package br.com.ufpb.projetopoo;

import java.util.ArrayList;
import java.util.List;
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
	
}