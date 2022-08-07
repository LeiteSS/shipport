package io.github.leitess.shipport.Model.entity;

import io.github.leitess.shipport.Model.entity.enums.CategoriaConteiner;
import io.github.leitess.shipport.Model.entity.enums.StatusConteiner;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "conteiner_tb")
public class Conteiner {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false, columnDefinition = "VARCHAR(150)")
    private String cliente;

    @Column(nullable = false, columnDefinition = "VARCHAR(11)")
    private String numero;

    @Column(nullable = false, columnDefinition = "INT")
    private Integer tipo;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, columnDefinition = "VARCHAR(5)")
    private StatusConteiner status;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, columnDefinition = "VARCHAR(10)")
    private CategoriaConteiner categoria;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinTable(name = "conteiner_movimentacao", joinColumns = {
            @JoinColumn(name = "conteiner_id", referencedColumnName = "id")
    }, inverseJoinColumns = {
            @JoinColumn(name = "movimentacao_id", referencedColumnName = "id")
    })
    private Movimentacao movimentacao;
}
