package br.com.ufpb.projetopoo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
public class GerenteDeExercicio {
	private List <Exercicio> exercicios;
	private List <RespostaDoExercicio> respostaDoExercicio;	
	public GerenteDeExercicio(){
		this.exercicios = new LinkedList<Exercicio>();
		this.respostaDoExercicio = new ArrayList<RespostaDoExercicio>();
	}
	public void cadastrarExercicio(Exercicio e){
		this.exercicios.add(e);
	}
	public void removeExercicio(String nomeExercicio)throws ExercicioInexistenteException{
		boolean inexistente = false;
		for(Exercicio e : this.exercicios){
			if(e.getNomeExercicio().equals(nomeExercicio)){
				this.exercicios.remove(e);
				inexistente = true;
				break;
			}
		}
		if(!inexistente){
			throw new ExercicioInexistenteException("Não existe exercicio com esse nome: "+nomeExercicio);
		}
	}
	public Questao pesquisaQuestaoDeExercicio(String nomeExercicio, int numQuestao)
			throws QuestaoInexistenteException, ExercicioInexistenteException{
		Exercicio e = this.pesquisarExercicio(nomeExercicio);
		for(Questao y: e.getQuestoes()){
			if(y.getNumQuestao() == numQuestao){
				return y;
			}
		}
		throw new QuestaoInexistenteException("Não existe questão com esse numero: "+numQuestao);
	}
	public Exercicio pesquisarExercicio(String nomeExercicio)
			throws ExercicioInexistenteException {
		for(Exercicio e : this.exercicios){
			if(e.getNomeExercicio().equals(nomeExercicio)){
				return e;
			}
		}
		throw new ExercicioInexistenteException("Não existe exercicio com esse nome: "+nomeExercicio);
	}
	public List<Exercicio> listarExercíciosCadastrados() {
		return exercicios;
	}
	public Exercicio sortearExercício() {
		Random rnd = new Random();
		int quantElemento = exercicios.size();
		int numSorteior = rnd.nextInt(quantElemento);//Gera um número aleatório (0 – n)
		return exercicios.get(numSorteior);
	}
	public void atualizarExercicio(String nomeExercicio, int numQuestao, String novaQuestao) 
			throws ExercicioInexistenteException{
		boolean exercicioInexistente = false;
		for(Exercicio e : this.exercicios){
			if(e.getNomeExercicio().equals(nomeExercicio)){
				for(Questao q: e.getQuestoes()){
					if(q.getNumQuestao()==numQuestao){
						q.setQuestao(novaQuestao);
						exercicioInexistente = true;
						break;
					} 
				}
			}
		}
		if(!exercicioInexistente){
			throw new ExercicioInexistenteException("Não existe exercicio com esse nome: "+nomeExercicio);
		}
	}
	public String enviarFeedbackParaAlunos(String nomeExercicio, String matriculaAluno) 
			throws ExercicioInexistenteException{
		Exercicio e = this.pesquisarExercicio(nomeExercicio);
		String txt = "\n";
		for(RespostaDoExercicio r: this.respostaDoExercicio){
		    if(r.getAluno().getMatricula().equals(matriculaAluno) && r.getExercicio().getNomeExercicio().equals(nomeExercicio)){
		    	txt += "Resposta do(a) aluno(a): "+r.getAluno().toString()+"\n";
			    for(int i=0; i < e.getQuestoes().size(); i++){
			    	if(e.getQuestoes().get(i).getTipo().equals(TipoQuestao.QUESTAO_DISSERTATIVA)){
			    		txt += "\nA Questão cadastrada foi: "+e.getQuestoes().get(i).getNumQuestao()+" "+e.getQuestoes().get(i).getQuestao()+" Sua Resposta para essa questão Dissertativa foi: "+r.getResposta().get(i).getResposta()+" A resposta do professor foi: "+e.getQuestoes().get(i).getResposta();
			    	}else if(e.getQuestoes().get(i).getTipo().equals(TipoQuestao.QUESTAO_V_OU_F)){
			    		if(e.getQuestoes().get(i).getResposta().equals(r.getResposta().get(i).getResposta())){
			    			txt += "\nA Questão cadastrada foi: "+e.getQuestoes().get(i).getNumQuestao()+" "+e.getQuestoes().get(i).getQuestao()+" Sua Resposta para essa questão V ou F foi: "+r.getResposta().get(i).getResposta()+" Resposta da questão V ou F está CORRETA";
			    		}else{
			    			txt += "\nA Questão cadastrada foi: "+e.getQuestoes().get(i).getNumQuestao()+" "+e.getQuestoes().get(i).getQuestao()+" Sua Resposta para essa questão V ou F foi: "+r.getResposta().get(i).getResposta()+" Resposta da questão V ou F está INCORRETA, A resposta do professor foi: "+e.getQuestoes().get(i).getResposta();
			    		}
			    	}else{
			    		if(e.getQuestoes().get(i).getResposta().equals(r.getResposta().get(i).getResposta())){
			    			txt += "\nA Questão cadastrada foi: "+e.getQuestoes().get(i).getNumQuestao()+" "+e.getQuestoes().get(i).getQuestao()+" Sua Resposta para essa questão  Multipla Escolha foi: "+r.getResposta().get(i).getResposta()+" Resposta da questão Multipla Escolha esta CORRETA";
			    		}else{
			    			txt += "\nA Questão cadastrada foi: "+e.getQuestoes().get(i).getNumQuestao()+" "+e.getQuestoes().get(i).getQuestao()+" Sua Resposta para essa questão Multipla Escolha foi:  "+r.getResposta().get(i).getResposta()+" Resposta da questão Multipla Escolha está INCORRETA, A resposta do professor foi: "+e.getQuestoes().get(i).getResposta();
			    		}
			    	}			    
			    }
		    }
		}
		return txt;
    }
	public String enviarFeedbackParaProfessor(String nomeExercicio) 
			throws ExercicioInexistenteException{
		int quantDeAlunosRespostaVouFCorreta = 0;
		int quantDeAlunosRespostaVouFIncorreta = 0;
		int quantDeAlunosRespostaMultiplaEscolhaCorreta  = 0;
		int quantDeAlunosRespostaMultiplaEscolhaInCorreta  = 0;
		int quantDeAlunosRespostaDissertativas = 0;
		Exercicio e = this.pesquisarExercicio(nomeExercicio);
		String respostasDasQuestoesDissertativas = "";
		for(RespostaDoExercicio r: this.respostaDoExercicio){
			if(e.getNomeExercicio().equals(r.getExercicio().getNomeExercicio())){
			    for(int i=0; i < e.getQuestoes().size(); i++){
			    	if(e.getQuestoes().get(i).getTipo().equals(TipoQuestao.QUESTAO_DISSERTATIVA)){
			    		quantDeAlunosRespostaDissertativas ++;
			    		respostasDasQuestoesDissertativas += "\n"+r.getResposta().get(i).getNumResposta()+" "+r.getResposta().get(i).getResposta();
			    	}else if(e.getQuestoes().get(i).getTipo().equals(TipoQuestao.QUESTAO_V_OU_F)){
			    		if(e.getQuestoes().get(i).getResposta().equals(r.getResposta().get(i).getResposta())){
			    			quantDeAlunosRespostaVouFCorreta  ++;
			    		}else{
			    			quantDeAlunosRespostaVouFIncorreta ++;
			    		}
			    	}else{
			    		if(e.getQuestoes().get(i).getResposta().equals(r.getResposta().get(i).getResposta())){
			    			quantDeAlunosRespostaMultiplaEscolhaCorreta ++;
			    		}else{
			    			quantDeAlunosRespostaMultiplaEscolhaInCorreta ++;
			    		}
			    	}
			    }
		    }
		}
		
		return "\n"+
		quantDeAlunosRespostaVouFCorreta+" Alunos responderam as questão V ou F Corretas\n"+
		quantDeAlunosRespostaVouFIncorreta+" Alunos responderam as questão V ou F Incorretas\n"+
		quantDeAlunosRespostaMultiplaEscolhaCorreta+" Alunos responderam as questão Multipla Escolha Corretas\n"+
		quantDeAlunosRespostaMultiplaEscolhaInCorreta+" Alunos responderam as questão Multipla Ecolha Incorretas\n"+
		quantDeAlunosRespostaDissertativas+" Alunos responderam as questão Dissertativas\n"+
		"\nAs respostas dos alunos da questão Dissertativas foi:\n "+respostasDasQuestoesDissertativas;
	}
	public int corrigirExercicio(String nomeExercicio, String matriculaAluno) 
			throws ExercicioInexistenteException{
		Exercicio e = this.pesquisarExercicio(nomeExercicio);
		int quantAcertos = 0;
		for(RespostaDoExercicio r: this.respostaDoExercicio){
		    if(r.getAluno().getMatricula().equals(matriculaAluno)){
			    for(int i=0; i < e.getQuestoes().size(); i++){
		    		if(e.getQuestoes().get(i).getResposta().equals(r.getResposta().get(i).getResposta())){
		    			quantAcertos ++;
		    		}			    
		        }   
		    }
		}
		return quantAcertos;
	}
	public void cadastrarRespostaDoExercicio(RespostaDoExercicio r){
		this.respostaDoExercicio.add(r);
	}
	
	
	public void gravarExerciciosEmArquivo(String nomeArquivo) throws IOException {
		BufferedWriter gravador = null;
		try {
			gravador = new BufferedWriter(new FileWriter(nomeArquivo));
			for (Exercicio exercicio: this.exercicios){
				gravador.write(exercicio.getNomeExercicio()+"\n");
				gravador.write(exercicio.getQuestoes()+"\n");
				
			}
		} finally {
			if (gravador!=null){
				gravador.close();
			}
		}		
	}
	
	public void lerExerciciosEmArquivo(String nomeArquivo) throws IOException {
		BufferedReader leitor = null;
		try {
			leitor = new BufferedReader(new FileReader(nomeArquivo));
			leitor.readLine();
		} finally {
			if (leitor!=null){
				leitor.close();
			}
		}		
	}
}