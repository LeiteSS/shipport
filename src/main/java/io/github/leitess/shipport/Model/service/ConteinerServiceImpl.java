package io.github.leitess.shipport.Model.service;

import io.github.leitess.shipport.Model.entity.Conteiner;
import io.github.leitess.shipport.Model.entity.enums.CategoriaConteiner;
import io.github.leitess.shipport.Model.repository.ConteinerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ConteinerServiceImpl implements ConteinerService{

    @Autowired
    private ConteinerRepository repository;

    @Override
    public List<Conteiner> listaConteineres(String palavraChave) {

        if (palavraChave != null) {
            return repository.searchByPalavraChave(palavraChave);
        }

        return repository.findAllByOrderByIdDesc();
    }

    @Override
    public Conteiner salvarConteiner(Conteiner conteiner) throws Exception {

        validaNumero(conteiner.getNumero());

        Optional<Conteiner> conteinerOpt = repository.findByNumero(conteiner.getNumero());

        if(conteinerOpt.isPresent()) {
            throw new Exception("Conteiner já está cadastrado!");
        }

        return repository.save(conteiner);
    }



    @Override
    public Conteiner atualizarCOnteinr(Conteiner conteiner) {
        return repository.save(conteiner);
    }

    @Override
    public Long totalCategoria(CategoriaConteiner categoria) {
        return repository.countByCategoria(categoria);
    }

    @Override
    public Long totalMovimentacao() {
        return repository.count();
    }

    @Override
    public Conteiner encontraConteinerPeloId(Long id) {
        return repository.getReferenceById(id); // getById(id)
    }

    @Override
    public void deletaPeloId(Long id) {
        repository.deleteById(id);
    }

    private void validaNumero(String numero) throws Exception {

        String maiusculo = numero.toUpperCase();
        String mascara = "[A-Z]{4}[0-9]{7}";

        boolean valida = maiusculo.matches(mascara);

        if (!valida) {
            throw new Exception("Numero do conteiner no formato errado!"); // bloco da verdade
        }
    }
}
