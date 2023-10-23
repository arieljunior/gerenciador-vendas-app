package br.edu.infnet.model.service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class LerArquivo{

	public static List<String[]> run(String caminhoArquivo) throws IOException{
		
		FileReader file = new FileReader(caminhoArquivo);		
		BufferedReader leitura = new BufferedReader(file);
		
		String linha = leitura.readLine();

		List<String[]> linhas = new ArrayList<String[]>();

		while(linha != null) {
			
			String[] campos = linha.split(";");
			linhas.add(campos);
			
			linha = leitura.readLine();
		}

		
		leitura.close();
		return linhas;
	}

}
