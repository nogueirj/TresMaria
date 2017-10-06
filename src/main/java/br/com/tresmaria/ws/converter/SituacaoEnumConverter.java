package br.com.tresmaria.ws.converter;

import br.com.tresmaria.ws.enumerate.SituacaoEnum;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter(autoApply = true)
public class SituacaoEnumConverter implements AttributeConverter<SituacaoEnum, Integer> {

    @Override
    public Integer convertToDatabaseColumn(SituacaoEnum attribute) {
        return attribute.getValue();
    }

    @Override
    public SituacaoEnum convertToEntityAttribute(Integer dbData) {
        return SituacaoEnum.getKey(dbData);
    }
}
