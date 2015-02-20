package br.com.ufpb.projetopoo;

public class FeedbackFacade {
	private GerenteDeFeedback gerenteDeFeedback;
	
	public FeedbackFacade(){
		this.gerenteDeFeedback = new GerenteDeFeedback();
	}
	
	public void CadastraFeedback(String nomeExer, String matricula, String comentario) {
		gerenteDeFeedback.CadastarFeedback(nomeExer, matricula, comentario);
	}
	public String PesquisaFeedback(String nomeExer, String matricula) throws FeedbackInexistenteException{
		return gerenteDeFeedback.PesquisaFeedback(nomeExer, matricula);
	}
}
