package br.com.ufpb.projetopoo;

public class AlunoJaExisteException extends Exception{
	public AlunoJaExisteException(String mensagem){
		super(mensagem);
	}
}
//public class GerenteDeFeedback {
//	private List<Pessoa> feedbacks;
//	public GerenteDeFeedback(){
//		this.feedbacks = new ArrayList<Pessoa>();
//	}
//	
//	public void enviarFeedbackParaAluno(String nome, String matricula, String comentario) {
//		this.feedbacks.add(new Aluno(nome, matricula, comentario));
//	}
//	public void enviarFeedbackParaProfessor(String nome, String matricula, String comentario) {
//		this.feedbacks.add(new Professor(nome, matricula, comentario));
//	}
//	public String pesquisarFeedback(String matricula) throws FeedbackInexistenteException{
//		for(Pessoa p : feedbacks){
//			if(p.getMatricula().equals(matricula)){
//				return p.getTexto();
//			}
//		}
//		throw new FeedbackInexistenteException("feedback inexistente");
//	}
//}

//public class FeedbackFacade {
//	private GerenteDeFeedback gerenteDeFeedback;
//	public FeedbackFacade(){
//		this.gerenteDeFeedback = new GerenteDeFeedback();
//	}
//	public void enviarFeedbackParaAluno(String nome, String matricula, String comentario) {
//		this.gerenteDeFeedback.enviarFeedbackParaAluno(nome, matricula, comentario);
//	}
//	public void enviarFeedbackParaProfessor(String nome, String matricula, String comentario) {
//		this.gerenteDeFeedback.enviarFeedbackParaProfessor(nome, matricula, comentario);
//	}
//	public String pesquisarFeedback(String matricula) throws FeedbackInexistenteException{
//		return this.gerenteDeFeedback.pesquisarFeedback(matricula);
//	}
//}

