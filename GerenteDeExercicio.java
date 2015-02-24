package br.com.ufpb.projetopoo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;


public class GerenteDeExercicio {
	private List < Exercicio > exercicios;
	public GerenteDeExercicio(){
		this.exercicios = new LinkedList<Exercicio>();
	}
	public void cadastrarExercicio(Exercicio e){
		this.exercicios.add(e);
	}
	
	//+++++++++++++++++++++++++++++++++++++++++++++++++++++++
	public void gravarQuestoesEmArquivo(String nomeArquivo)
			throws IOException {
		BufferedWriter gravador = null;
		try {
			gravador = new BufferedWriter(new FileWriter(nomeArquivo));
			for (Exercicio e: this.exercicios){
				//gravador.write(e.getNomeExercicio()+"\n");
				
				for(Questao e2: e.getQuestoes()){
					
					gravador.write(e2.getNumQuestao()+"\n");
					
					gravador.write(e2.getQuestao()+"\n");
					//gravador.write(e2.toString()+"\n");
					gravador.write(e2.getTipo()+"\n");
				}
			}
		} finally {
			if (gravador!=null){
				gravador.close();
			}
		}		
	}
	
	/*public void carregarDisciplinasDeArquivo(String nomeArquivo)
			throws QuestaoInexistenteException, IOException {
		BufferedReader leitor=null;
		try{
			leitor = new BufferedReader(new FileReader(nomeArquivo));
			String nomeExercicio=null;
			do{
				nomeExercicio=leitor.readLine();
				if(nomeExercicio!=null){
					int num = Integer.parseInt(leitor.readLine());
					String questao = leitor.readLine();
					String tipo = leitor.readLine();//===========
		//			this.cadastrarQuestao(new Questao(num,questao,TipoQuestao tipo));
				}
			} while(nomeExercicio!=null);
			
			
		}finally{
			if(leitor!=null){
				leitor.close();
			}
		}
			
	}*/
		
	
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