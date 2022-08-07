package io.github.leitess.shipport.Model.repository;

import io.github.leitess.shipport.Model.entity.Conteiner;
import io.github.leitess.shipport.Model.entity.enums.CategoriaConteiner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface ConteinerRepository extends JpaRepository<Conteiner, Long> {

    Optional<Conteiner> findByNumero(String numero);
    List<Conteiner> findAllByOrderByIdDesc();
    Long countByCategoria(CategoriaConteiner categoria);

    @Query("SELECT c FROM Conteiner c WHERE c.cliente LIKE %?1% OR c.numero LIKE %?1% OR c.movimentacao.tipo LIKE %?1%")
    List<Conteiner> searchByPalavraChave(String palavraChave);
}
