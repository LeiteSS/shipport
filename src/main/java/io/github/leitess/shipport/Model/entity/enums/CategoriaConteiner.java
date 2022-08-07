package io.github.leitess.shipport.Model.entity.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum CategoriaConteiner {

    IMPORTACAO("Importacao"),
    EXPORTACAO("Exportacao");

    private String categoriaConteiner;
}
