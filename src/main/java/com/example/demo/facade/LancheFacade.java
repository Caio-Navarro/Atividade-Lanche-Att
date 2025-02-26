package com.example.demo.facade;

import com.example.demo.applications.LancheApplication;
import com.example.demo.entities.Lanche;
import java.util.List;

public class LancheFacade {
    private LancheApplication lancheApplication;

    public LancheFacade(LancheApplication lancheApplication) {
        this.lancheApplication = lancheApplication;
    }

    public void cadastrar(Lanche lanche) {
        this.lancheApplication.cadastrar(lanche);
    }

    public List<Lanche> buscar() {
        return this.lancheApplication.buscar();
    }

    public Lanche buscarPorCodigo(int codigo) {
        return this.lancheApplication.buscarPorCodigo(codigo);
    }

    public double calcularLanche(Lanche lanche, int quantidade) {
        return this.lancheApplication.calcularLanche(lanche, quantidade);
    }

    public void excluir(int codigo, Lanche lanche) {
        this.lancheApplication.excluirLanche(codigo, lanche);
    }

    public void atualizar(int codigo, Lanche lanche, String nome, double preco, String imagem) {
        this.lancheApplication.atualizarLanche(codigo, lanche, nome, preco, imagem);
    }

}
