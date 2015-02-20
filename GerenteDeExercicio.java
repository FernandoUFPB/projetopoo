package br.com.ufpb.projetopoo;

<<<<<<< HEAD
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

=======
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
>>>>>>> 2b67ff6f0bd4e86e7813be14fcc1d813d383ddcc
public class GerenteDeExercicio {
	private List < Exercicio > exercicios;
	public GerenteDeExercicio(){
		this.exercicios = new LinkedList<Exercicio>();
<<<<<<< HEAD
	}
	public void cadastrarExercicio(Exercicio e){
		this.exercicios.add(e);
	}
	
	public Questao pesquisaQuestaoDeExercicio(String nomeExercicio, int numQuestao)
			throws QuestaoInexistenteException, ExercicioInexistenteException{
		Exercicio e = this.pesquisarExercicio(nomeExercicio);
		for(Questao y: e.getQuestoes()){
			if(y.getNumQuestao() == numQuestao){
				return y;
			}
		}
		throw new QuestaoInexistenteException("Questao Inexistente"+numQuestao);
	}
	public Exercicio pesquisarExercicio(String nomeExercicio)
			throws ExercicioInexistenteException {
		for(Exercicio e : this.exercicios){
			if(e.getNomeExercicio().equals(nomeExercicio)){
				return e;
			}
		}
		throw new ExercicioInexistenteException("Exercicio Inexistente "+nomeExercicio);
	}
	public List<Exercicio> listarExercíciosCadastrados() {
		return exercicios;
	}
	public Exercicio sortearExercício() {
		//Collections.shuffle(exercicios);// altera a ordem aleatóriamente
		//return exercicios.get(0);// pega qualquer indice. pegamos o primeiro para conveniencia.
		Random rnd = new Random();
		int quantElemento = exercicios.size();
		int numSorteior = rnd.nextInt(quantElemento);//Gera um número aleatório (0 – n)
		return exercicios.get(numSorteior);
	}
	public String atualizarExercicio(String nomeExercicio, int numQuestao, String questao) 
			throws ExercicioInexistenteException{	
		for(Exercicio e : this.exercicios){
			if(e.getNomeExercicio().equals(nomeExercicio)){
				for(Questao q: e.getQuestoes()){
					if(q.getNumQuestao()==numQuestao){
						q.setQuestao(questao);
						return "Exercicio atualizado com sucesso!";
					}
				}
			}
		}
		throw new ExercicioInexistenteException("exercicio não existe");
	}
	public boolean corrigirExercicio(String nomeExercicio, String matriculaAluno) 
			throws ExercicioInexistenteException{
		Exercicio e = this.pesquisarExercicio(nomeExercicio);
		int quantQuestaoCorretas = 0;
	    for(CadastroDeRespostaDoAluno r: e.getCadastroDeRespostaDoAluno()){
	        if(r.getAluno().getMatricula().equals(matriculaAluno)){
	    	    for(int i=0; i<e.getResposta().size(); i++){
				    if(e.getResposta().get(i).getResposta().equals(r.getResposta().get(i).getResposta())){
				    	quantQuestaoCorretas++;
				    }
			    }
	        }
	    }
	    if(quantQuestaoCorretas == e.getResposta().size()){
	    	return true;
	    }else{
	    	return false;
	    }
	}
	
	
}
=======
	} 
	public void cadastrarExercicio(Exercicio e){
		this.exercicios.add(e);
	}
	public List<Exercicio> listarExercíciosCadastrados() {
		return exercicios;
	}

	public void corrigirExercicio(int numExercicio, String matriculaAluno) {
		// TODO Auto-generated method stub
	
	}
	public void atualizarExercício() {
		// TODO Auto-generated method stub
		
	}
	public Exercicio sortearExercício() {
		// altera a ordem aleatóriamente
		Collections.shuffle(exercicios);
		// pega qualquer indice. pegamos o primeiro para conveniencia.
		return exercicios.get(0);
	}		
	public Exercicio pesquisarExercicio(int numExercicio)
			throws ExercicioInexistenteException {
		for(Exercicio e : this.exercicios){
			if(e.getNumExercicio() == numExercicio){
				return e;
			}
		}
		throw new ExercicioInexistenteException("Exercicio Inexistente "+numExercicio);
	}
}

//altera a ordem aleatóriamente
//Collections.shuffle(exercicios);
//Random rnd = new Random();
//int quantElemento = exercicios.size();
//int numSorteior = rnd.nextInt(quantElemento);//Gera um número aleatório (0 – n)
//pega qualquer indice. pegamos o primeiro para conveniencia.
//return exercicios.get(numSorteior);
>>>>>>> 2b67ff6f0bd4e86e7813be14fcc1d813d383ddcc
