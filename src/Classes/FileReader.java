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
					rulesList.add(new Rule(line));
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
}
