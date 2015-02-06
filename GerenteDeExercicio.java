package poo;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
public class GerenteDeExercicio {
	private List < Exercicio > exercicios;
	public GerenteDeExercicio(){
		this.exercicios = new LinkedList<Exercicio>();
	} 
	public void cadastrarExercicio(Exercicio e){
		this.exercicios.add(e);
	}
	public List<Exercicio> listarExerc�ciosCadastrados() {
		return exercicios;
	}

	public void corrigirExercicio(int numExercicio, String matriculaAluno) {
		// TODO Auto-generated method stub
	
	}
	public void atualizarExerc�cio() {
		// TODO Auto-generated method stub
		
	}
	public Exercicio sortearExerc�cio() {
		// altera a ordem aleat�riamente
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

//altera a ordem aleat�riamente
//Collections.shuffle(exercicios);
//Random rnd = new Random();
//int quantElemento = exercicios.size();
//int numSorteior = rnd.nextInt(quantElemento);//Gera um n�mero aleat�rio (0 � n)
//pega qualquer indice. pegamos o primeiro para conveniencia.
//return exercicios.get(numSorteior);
