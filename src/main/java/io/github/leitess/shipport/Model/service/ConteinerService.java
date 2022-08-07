package io.github.leitess.shipport.Model.service;

import io.github.leitess.shipport.Model.entity.Conteiner;
import io.github.leitess.shipport.Model.entity.enums.CategoriaConteiner;

import java.util.List;

public interface ConteinerService {

    List<Conteiner> listaConteineres(String palavraChave);
    Conteiner salvarConteiner(Conteiner conteiner) throws Exception;
    Conteiner atualizarCOnteinr(Conteiner conteiner);
    Long totalCategoria(CategoriaConteiner categoria);
    Long totalMovimentacao();
    Conteiner encontraConteinerPeloId(Long id);
    void deletaPeloId(Long id);
}
