package br.com.tresmaria.ws.enumerate;

import java.util.HashMap;
import java.util.Map;

public enum SituacaoEnum {
    ATIVO(1),
    INATIVO(2),
    CANCELADO(3);

    private Integer id;

    private SituacaoEnum(Integer value){
        id = value;
    }

    private static final Map<Integer, SituacaoEnum> lookup = new HashMap<Integer, SituacaoEnum>();
    static{
        for(SituacaoEnum situacao: SituacaoEnum.values())
            lookup.put(situacao.getValue(), situacao);
    }

    public Integer getValue(){
        return id;
    }

    public static SituacaoEnum getKey(Integer value){
        return lookup.get(value);
    }
}
