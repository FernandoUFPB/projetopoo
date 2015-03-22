package br.com.ufpb.projetopoo;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
public class GravadorDeFacade {	
	public GerenteDeExercicio leGerenteDeExercicio() throws IOException{
        ObjectInputStream in = null;
        try{
        	in = new ObjectInputStream(new FileInputStream("GerenteDeExercicio.txt"));
            return (GerenteDeExercicio) in.readObject();               
        }catch(FileNotFoundException e){
                throw new IOException("Não foi encontrado o arquivo GerenteDeExercicio.txt");
        }catch(IOException e){
                throw e;
        }catch(ClassNotFoundException e){
                throw new IOException("Classe dos objetos gravados no arquivo "
                		+"GerenteDeExercicio.txt não existe",e);               
        }finally{
                if(in!=null){
                        in.close();
                }
        }
	}
	public void gravaGerenteDeExercicio(GerenteDeExercicio exercicios) throws IOException{
        ObjectOutputStream out = null;
        try{
                out = new ObjectOutputStream(new FileOutputStream("GerenteDeExercicio.txt"));
                out.writeObject(exercicios);
        }catch(FileNotFoundException e){
                throw new IOException("Não foi encontrado o arquivo GerenteDeExercicio.txt");
        }catch(IOException e){
                throw e;
        }finally{
                if(out!=null){
                        out.close();
                }
        }
	}
	
	public GerenteDeAluno leGerenteDeAluno() throws IOException{
        ObjectInputStream in = null;
        try{
        	in = new ObjectInputStream(new FileInputStream("GerenteDeAluno.txt"));
            return (GerenteDeAluno) in.readObject();               
        }catch(FileNotFoundException e){
                throw new IOException("Não foi encontrado o arquivo GerenteDeAluno.txt");
        }catch(IOException e){
                throw e;
        }catch(ClassNotFoundException e){
                throw new IOException("Classe dos objetos gravados no arquivo "
                		+"GerenteDeAluno.txt não existe",e);               
        }finally{
                if(in!=null){
                        in.close();
                }
        }
	}
	public void gravaGerenteDeAluno(GerenteDeAluno alunos) throws IOException{
        ObjectOutputStream out = null;
        try{
                out = new ObjectOutputStream(new FileOutputStream("GerenteDeAluno.txt"));
                out.writeObject(alunos);
        }catch(FileNotFoundException e){
                throw new IOException("Não foi encontrado o arquivo GerenteDeAluno.txt");
        }catch(IOException e){
                throw e;
        }finally{
                if(out!=null){
                        out.close();
                }
        }
	}	
	public GerenteDeProfessor leGerenteDeProfessor() throws IOException{
        ObjectInputStream in = null;
        try{
        	in = new ObjectInputStream(new FileInputStream("GerenteDeProfessor.txt"));
            return (GerenteDeProfessor) in.readObject();               
        }catch(FileNotFoundException e){
                throw new IOException("Não foi encontrado o arquivo GerenteDeProfessor.txt");
        }catch(IOException e){
                throw e;
        }catch(ClassNotFoundException e){
                throw new IOException("Classe dos objetos gravados no arquivo "
                		+"GerenteDeProfessor.txt não existe",e);               
        }finally{
                if(in!=null){
                        in.close();
                }
        }
	}
	public void gravaGerenteDeProfessor(GerenteDeProfessor gerenteDeProfessor) throws IOException{
        ObjectOutputStream out = null;
        try{
                out = new ObjectOutputStream(new FileOutputStream("GerenteDeProfessor.txt"));
                out.writeObject(gerenteDeProfessor);
        }catch(FileNotFoundException e){
                throw new IOException("Não foi encontrado o arquivo GerenteDeProfessor.txt");
        }catch(IOException e){
                throw e;
        }finally{
                if(out!=null){
                        out.close();
                }
        }
	}
}
