package br.com.ufpb.projetopoo;


import java.util.Collection;
import java.util.List;
public class ExercicioFacade {
	private GerenteDeAluno gerenteDeAluno;
	private GerenteDeExercicio gerenteDeExercicio;
	private GerenteDeFeedback gerenteDeFeedback;
	private GerenteDeProfessor gerenteDeProfessor;
	public ExercicioFacade(){
		this.gerenteDeExercicio = new GerenteDeExercicio();
		this.gerenteDeAluno = new GerenteDeAluno();
		this.gerenteDeProfessor = new GerenteDeProfessor();
		this.gerenteDeFeedback = new GerenteDeFeedback();
	}
	public void cadastrarProfessor(String nome, String matricula)
			throws ProfessorJaExisteException {
		this.gerenteDeProfessor.cadastrarProfessor(nome, matricula);
	}
	public void alocaProfessorAExercicio(int numExercicio, String matriculaProf)
			throws ProfessorInexistenteException, ExercicioInexistenteException{
		Professor prof = this.gerenteDeProfessor.pesquisaProfessorPelaMatricula(matriculaProf);
		Exercicio e = this.pesquisarExercicio(numExercicio);
		e.setProfessor(prof);
	}
	public void removeProfessor(String matriculaProf)
			throws ProfessorInexistenteException {
		this.gerenteDeProfessor.removeProfessor(matriculaProf);
	}
	public Professor pesquisaProfessorPelaMatricula(String matricula)
			throws ProfessorInexistenteException {
		return this.gerenteDeProfessor.pesquisaProfessorPelaMatricula(matricula);
	}
	public List<Professor> obterListaDeProfessores() {
		return this.gerenteDeProfessor.obterListaDeProfessores();
	}
	
	public void cadastraAluno(String nome, String matricula)
			throws AlunoJaExisteException {
		this.gerenteDeAluno.cadastraAluno(nome, matricula);
	}
	public Aluno pesquisaAlunoPelaMatricula(String matricula)
			throws AlunoInexistenteException {
		return this.gerenteDeAluno.pesquisaAlunoPelaMatricula(matricula);
	}
	public void removeAluno(String matricula) throws AlunoInexistenteException {
		this.gerenteDeAluno.removeAluno(matricula);
	}
	public Collection<Aluno> obterListaDeAlunos() {
		return this.gerenteDeAluno.obterListaDeAlunos();
	}
	
	public void cadastrarExercicio(Exercicio e){
		this.gerenteDeExercicio.cadastrarExercicio(e);
	}
	public List<Exercicio> listarExercíciosCadastrados() {
		return this.gerenteDeExercicio.listarExercíciosCadastrados();
	}

	public void corrigirExercicio(int numExercicio, String matriculaAluno) {
		// TODO Auto-generated method stub
	
	}
	public Exercicio sortearExercício() {
		return this.gerenteDeExercicio.sortearExercício();
	}
	public void atualizarExercício() {
		// TODO Auto-generated method stub
		
	}
	public Exercicio pesquisarExercicio(int numExercicio)
			throws ExercicioInexistenteException {
		return this.gerenteDeExercicio.pesquisarExercicio(numExercicio);
	}
	
	public void enviarFeedbackParaAlunos() {
		// TODO Auto-generated method stub
	}
	public void enviarFeedbackParaProfessor(String texto,
			String emailRemetente, String emailDestinatario) {
		// TODO Auto-generated method stub
	}
}