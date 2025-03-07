package com.example.demo.controller;

import com.example.demo.applications.LancheApplication;
import com.example.demo.entities.Lanche;
import com.example.demo.facade.LancheFacade;
import com.example.demo.repositories.LancheRepository;
import com.example.demo.services.LancheService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class LancheController {

    private static LancheRepository lancheRepository;
    private static LancheService lancheService;
    private static LancheApplication lancheApplication;
    private static LancheFacade lancheFacade;

    private static void injetarDependencias() {
        lancheRepository = new LancheRepository();
        lancheService = new LancheService();
        lancheApplication = new LancheApplication(lancheService, lancheRepository);
        lancheFacade = new LancheFacade(lancheApplication);
    }

    public LancheController() {
        injetarDependencias();

        Lanche lanche1 = new Lanche(1, "Lanche 1", 10.0, "");
        Lanche lanche2 = new Lanche(2, "Lanche 2", 10.0, "");
        Lanche lanche3 = new Lanche(3, "Lanche 3", 10.0, "");

        this.lancheFacade.cadastrar(lanche1);
        this.lancheFacade.cadastrar(lanche2);
        this.lancheFacade.cadastrar(lanche3);
    }

    @GetMapping("/listar")
    public List<Lanche> get(){
        return lancheFacade.buscar();
    }

    @GetMapping("/{idLanche}")
    public Lanche getLanche(@PathVariable int idLanche){
        return lancheFacade.buscarPorCodigo(idLanche);
    }

    @PostMapping("/cadastrar")
    public Lanche cadastrar(@RequestBody Lanche lanche) {
        return lancheFacade.cadastrar(lanche);
    }

    @PutMapping("/atualizar/{idLanche}")
    public Lanche atualizar(@PathVariable int idLanche, @RequestBody Lanche lanche) {
        return lancheFacade.atualizar(idLanche, lanche);
    }

    @DeleteMapping("/deletar/{idLanche}")
    public void deletar(@PathVariable int idLanche) {
        lancheFacade.excluir(idLanche);
    }

    @PutMapping("/comprar/{idLanche}/{quantidade}")
    public String comprar(@PathVariable int idLanche, @PathVariable int quantidade) {
        Lanche lanche = lancheFacade.buscarPorCodigo(idLanche);

        return  "Número de lanches: " + quantidade + "\nValor total: R$" + lancheFacade.calcularLanche(lanche, quantidade);
    }

}
