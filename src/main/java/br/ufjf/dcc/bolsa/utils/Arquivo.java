package br.ufjf.dcc.bolsa.utils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author gleiph
 */
public class Arquivo {
    
    
    
    public static void gravarArquivo(String path, String content) throws IOException{
        
        FileWriter fileWriter = new FileWriter(path, false);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        bufferedWriter.write(content);
        bufferedWriter.close();
        fileWriter.close();
                
    }
    
    public static String lerArquivo(String path) throws IOException{
        
        FileReader fileReader = new FileReader(path);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        StringBuilder content = new StringBuilder();
        
        while (bufferedReader.ready()) {
            content.append(bufferedReader.readLine()).append("\n");
        }

        bufferedReader.close();
        fileReader.close();
                
        return content.toString();
    }
    
}

