package Classes;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Classe para leitura dos ficheiros E-mail/Spam e Regras
 * 
 * @author Kevin Corrales nº 73529
 *
 */
public class FileReader {
	
	/**
	 * Ler ficheiro que contém as regras de spam e criar uma lista com estas regras.
	 * 
	 * @param localização do ficheiro
	 * @return lista das regras
	 */
	public List<Rule> getRulesFromFile(String location) {
		Scanner scanner = null;
		List<Rule> rulesList= new ArrayList<Rule>();
			try{
				scanner = new Scanner(new File(location));
				
				while(scanner.hasNextLine()){
					String line = scanner.nextLine();
					List<String> splitLine = Arrays.asList(line.split(" "));
					double weight=0;
					if(splitLine.size()>1)
						weight = Double.parseDouble(splitLine.get(1));
					rulesList.add(new Rule(splitLine.get(0),weight));
				}
				
			}catch(FileNotFoundException e){
				e.printStackTrace();
			}finally{
				scanner.close();
			}
		return rulesList;
	}
	
	/**
	 * Ler ficheiro que contém as regras de spam e criar uma lista com estas regras, ignorando os pesos nesse mesmo ficheiro e 
	 * utilizando os pesos dados como argumento
	 * @author Ricardo Santos 
	 * @param localização do ficheiro
	 * @param vetor de pesos
	 * @return lista das regras
	 */
	public List<Rule> getRulesFromFile(String location,double[] vp) {
		Scanner scanner = null;
		List<Rule> rulesList= new ArrayList<Rule>();
			try{
				scanner = new Scanner(new File(location));
				int iter =0;
				while(scanner.hasNextLine()){
					String line = scanner.nextLine();
					List<String> splitLine = Arrays.asList(line.split(" "));
					if(splitLine.size()>1)
					rulesList.add(new Rule(splitLine.get(0),vp[iter]));
					iter ++ ;
				}
				
			}catch(FileNotFoundException e){
				e.printStackTrace();
			}finally{
				scanner.close();
			}
		return rulesList;
	}
	
	/**
	 * Ler ficheiro que contém os emails ou spams e criar uma lista com estes emails/spams.
	 * @param localização do ficheiro
	 * @return lista de emails ou spams
	 */
	public List<Email> getEmailsFromFile(String location) {
		Scanner scanner = null;
		List<Email> emailList= new ArrayList<Email>();
		
			try{
				scanner = new Scanner(new File(location));
				
				while(scanner.hasNextLine()){
					String line = scanner.nextLine();
					List<String> splitLine = Arrays.asList(line.split("\t"));
					
					Email email = new Email(splitLine.get(0));
						for(int i=1;i<splitLine.size();i++) {
							email.addRule(splitLine.get(i));
						}
					emailList.add(email);
				}
				
			}catch(FileNotFoundException e){
				e.printStackTrace();
			}finally{
				scanner.close();
			}
		return emailList;
	}





/**
 * Converter um ficheiro dado uma localizacao num vetor de doubles
 * @param localização do ficheiro
 * @param linha lida em ficheiro
 * @return lista de emails ou spams
 * 
 * 
 * @author Miguel Rodrigues nº 73541
 */
	public double[] getDoubleVector(String location, int numb){
		Scanner scanner = null;
		List<String> splitNumbers=null;
		
			try{
				scanner = new Scanner(new File(location));
				String line = scanner.nextLine();
				for(int i=0; i<numb-1;i++){
					line = scanner.nextLine();
				}
					splitNumbers = Arrays.asList(line.split(" "));
				
					//resulting= new double[splitNumbers.size()];
			}catch(FileNotFoundException e){
				e.printStackTrace();
			}finally{
				scanner.close();
			}
			double[] resulting= new double[splitNumbers.size()];
			for(int i=0;i<splitNumbers.size();i++) {
				resulting[i]=Double.parseDouble(splitNumbers.get(i));
			}
			
			
		return resulting;
	}

	
	
	/**
	 * Vai ver qual das linhas representa uma maior aproximação a um email profissional
	 * @param localização do ficheiro
	 * @return numero da linhas
	 * 
	 * 
	 * @author Ricardo Santos nº 72973
	 */
	/**
	 * Vai ver qual das linhas representa uma maior aproximação a um email profissional
	 * @param localização do ficheiro
	 * @return numero da linhas
	 * 
	 * 
	 * @author Ricardo Santos nº 72973
	 */
	public int getLine(String location) {
		Scanner scanner = null;
		String[] lines = new String[10];
		double value=1000.0;
		int returner=1; 
		int count=0;
		double[] vet = new double[10];
			try{
				scanner = new Scanner(new File(location));
				while(scanner.hasNextLine()) {
					String line = scanner.nextLine();
					lines[count] = line.split(" ")[1];
					count ++;
				}
			}catch(FileNotFoundException e){
				e.printStackTrace();
			}finally{
				scanner.close();
			}
			for (int i=0;i<count;i++) {
				if(Double.parseDouble(lines[i])<value) {
					
					value=Double.parseDouble(lines[i]);
					returner = i+1;
				}
				
			}
			return returner;
	}
	
	
}