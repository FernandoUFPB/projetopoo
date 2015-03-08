package br.com.ufpb.projetopoo;

public class FeedbackFacade {
	private GerenteDeFeedback gerenteDeFeedback;
	public FeedbackFacade(){
		this.gerenteDeFeedback = new GerenteDeFeedback();
	}
	public void enviarFeedback(String nomeExercicio, String matricula, String comentario) {
		gerenteDeFeedback.enviarFeedback(nomeExercicio, matricula, comentario);
	}
	public String pesquisaFeedback(String nomeExercicio, String matricula) throws FeedbackInexistenteException{
		return gerenteDeFeedback.pesquisaFeedback(nomeExercicio, matricula);
	}
}
