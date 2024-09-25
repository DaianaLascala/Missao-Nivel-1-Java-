package model;

import java.io.*;
import java.util.ArrayList;

public class PessoaFisicaRepo {
    private ArrayList<PessoaFisica> listaPessoaFisica = new ArrayList<>();

  
    public void inserir(PessoaFisica pessoaFisica) {
        listaPessoaFisica.add(pessoaFisica);
    }


    public void alterar(PessoaFisica pessoaFisica) {
        PessoaFisica existente = buscar(pessoaFisica.getId());
        if (existente != null) {
            existente.setNome(pessoaFisica.getNome());
            existente.setCpf(pessoaFisica.getCpf());
            existente.setIdade(pessoaFisica.getIdade());
        }
    }

  
    public void excluir(int id) {
        PessoaFisica pessoa = buscar(id);
        if (pessoa != null) {
            listaPessoaFisica.remove(pessoa);
        }
    }

   
    public PessoaFisica buscar(int id) {
        for (PessoaFisica pessoa : listaPessoaFisica) {
            if (pessoa.getId() == id) {
                return pessoa;
            }
        }
        return null;
    }

  
    public ArrayList<PessoaFisica> exibirTodos() {
        return listaPessoaFisica;
    }

 
    public void persistir(String nomeArquivo) throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(nomeArquivo))) {
            oos.writeObject(listaPessoaFisica);
        }
    }

    
    @SuppressWarnings("unchecked")
    public void recuperar(String nomeArquivo) throws IOException, ClassNotFoundException {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(nomeArquivo))) {
            listaPessoaFisica = (ArrayList<PessoaFisica>) ois.readObject();
        }
    }

   
    public PessoaFisica buscarPorId(int id) {
        
        for (PessoaFisica pessoa : listaPessoaFisica) {
            if (pessoa.getId() == id) {
                return pessoa;
            }
        }
        return null; 
    }

    void remover(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
