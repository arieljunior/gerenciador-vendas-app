package br.edu.infnet.gerenciador_vendas_app.model.service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class LerArquivo{

	public static List<String[]> executar(String caminhoArquivo) throws IOException{
		
		FileReader arquivo = new FileReader(caminhoArquivo);		
		BufferedReader leitura = new BufferedReader(arquivo);
		
		List<String[]> linhas = new ArrayList<String[]>();

		String linha = leitura.readLine();
		while(linha != null) {
			
			String[] campos = linha.split(";");
			linhas.add(campos);
			
			linha = leitura.readLine();
		}

		leitura.close();
		
		return linhas;
	}

}
