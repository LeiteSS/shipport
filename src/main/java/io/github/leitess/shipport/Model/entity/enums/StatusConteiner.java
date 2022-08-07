package io.github.leitess.shipport.Model.entity.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum StatusConteiner {

    CHEIO("Cheio"),
    VAZIO("Vazio");

    private String statusMovimentacao;
}
