package io.github.leitess.shipport.Model.entity.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum TipoMovimentacao {

    EMBARQUE("Embarque"),
    DESCARGA("Descarga"),
    GATE_IN("Gate In"),
    GATE_OUT("Gate Out"),
    REPOSICIONAMENTO("Reposicionamento"),
    PESAGEM("Pesagem"),
    SCANNER("Scanner");

    private String tipoMovimentacao;
}
