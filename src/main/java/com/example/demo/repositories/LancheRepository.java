package com.example.demo.repositories;

import com.example.demo.entities.Lanche;

import java.util.ArrayList;
import java.util.List;

public class LancheRepository {
    private List<Lanche> lanches = new ArrayList<>();

    public Lanche buscarPorCodigo(int codigo) {
        Lanche lanche = lanches
                .stream()
                .filter(p -> p.getCodigo() == codigo)
                .findFirst()
                .get();

        return lanche;
    }

    public List<Lanche> buscar() {
        return lanches;
    }

    public void adicionar(Lanche lanche) {
        lanches.add(lanche);
    }

    public void remover(int codigo) {
        lanches.removeIf(p -> p.getCodigo() == codigo);
    }

    public void atualizar(int codigo, Lanche lanche) {
        Lanche LancheInMemory = this.buscarPorCodigo(codigo);

        LancheInMemory.setNome(lanche.getNome());
        LancheInMemory.setImagem(lanche.getImagem());
        LancheInMemory.setPreco(lanche.getPreco());
    }
}
