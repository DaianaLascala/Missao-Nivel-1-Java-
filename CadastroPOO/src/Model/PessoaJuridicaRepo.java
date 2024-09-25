package model;

import java.io.*;
import java.util.ArrayList;

public class PessoaJuridicaRepo {
    private ArrayList<PessoaJuridica> listaPessoaJuridica = new ArrayList<>();

    // Inserir
    public void inserir(PessoaJuridica pessoaJuridica) {
        listaPessoaJuridica.add(pessoaJuridica);
    }

   
    public void alterar(PessoaJuridica pessoaJuridica) {
        PessoaJuridica existente = obter(pessoaJuridica.getId());
        if (existente != null) {
            existente.setNome(pessoaJuridica.getNome());
            existente.setCnpj(pessoaJuridica.getCnpj());
        }
    }

    // Excluir
    public void excluir(int id) {
        PessoaJuridica pessoaJuridica = obter(id);
        if (pessoaJuridica != null) {
            listaPessoaJuridica.remove(pessoaJuridica);
        }
    }

    // Obter (por id)
    public PessoaJuridica obter(int id) {
        for (PessoaJuridica pessoaJuridica : listaPessoaJuridica) {
            if (pessoaJuridica.getId() == id) {
                return pessoaJuridica;
            }
        }
        return null;
    }

    // Obter todos
    public ArrayList<PessoaJuridica> obterTodos() {
        return listaPessoaJuridica;
    }

    // Persistir
    public void persistir(String nomeArquivo) throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(nomeArquivo))) {
            oos.writeObject(listaPessoaJuridica);
        }
    }

    // Recuperar
    @SuppressWarnings("unchecked")
    public void recuperar(String nomeArquivo) throws IOException, ClassNotFoundException {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(nomeArquivo))) {
            listaPessoaJuridica = (ArrayList<PessoaJuridica>) ois.readObject();
        }
    }

    // Buscar por ID
    public PessoaJuridica buscarPorId(int id) {
        for (PessoaJuridica pessoaJuridica : listaPessoaJuridica) {
            if (pessoaJuridica.getId() == id) {
                return pessoaJuridica;
            }
        }
        return null;
    }

    void remover(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
