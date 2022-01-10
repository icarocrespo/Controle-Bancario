package main;

import java.io.*;

public class Arquivo {

    public static void gravar(String conteudo, String nomeArquivo) throws Exception {
        //abre o arquivo para escrita
        FileOutputStream outFile = new FileOutputStream(new File(nomeArquivo));
        BufferedWriter buff = new BufferedWriter(new OutputStreamWriter(outFile, "UTF-8"));

        //escreve no arquivo
        buff.write(conteudo);

        // fecha o arquivo
        buff.close();
        outFile.close();
    }

    public static void gravar(Object obj, String nomeArquivo) throws Exception {
        ObjectOutputStream output;
        //abre o arquivo para escrita
        output = new ObjectOutputStream(new FileOutputStream(new File(nomeArquivo)));
        //grava o objeto
        output.writeObject(obj);
        //fecha o arquivo
        output.close();
    }

    public static Object ler(String nomeArquivo) throws Exception {
        Object obj;
        ObjectInputStream input;
        //abre o arquivo para leitura
        input = new ObjectInputStream(new FileInputStream(new File(nomeArquivo)));
        //le o objeto
        obj = input.readObject();
        //fecha o arquivo
        input.close();
        return obj;
    }

    public static String[] getLinhas(String nomeArquivo) throws Exception {
        // declaração das variáveis        
        String[] linhas;
        String linha;
        int nlinhas, i = 0;
        //abre o arquivo para leitura
        FileInputStream inFile = new FileInputStream(new File(nomeArquivo));
        BufferedReader buff = new BufferedReader(new InputStreamReader(inFile, "UTF-8"));

        //lê a primeira linha do arquivo (numero de linhas)
        linha = buff.readLine();
        nlinhas = Integer.parseInt(linha);
        linhas = new String[nlinhas + 1];
        linhas[i++] = linha;

        //lê as demais linhas do arquivo
        do {
            linha = buff.readLine();
            if (linha != null) {
                linhas[i++] = linha;
            }
        } while (linha != null);

        //fecha o arquivo
        buff.close();
        inFile.close();

        return linhas;
    }

}
