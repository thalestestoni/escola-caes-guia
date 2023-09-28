package hkeller.escolacaesguia.common.mapper;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class GenericMapper <E, D>{
  public E toEntity(D fromDto, Class<E> entityClass) {
    try {
      E entity = entityClass.getDeclaredConstructor().newInstance();
      BeanUtils.copyProperties(fromDto,entity);
      return entity;
    } catch (Exception e) {
      throw new RuntimeException("Erro ao mapear DTO para entidade", e);
    }
  }

  public D toDto(E fromEntity, Class<D> dtoClass) {
    try {
      D dto = dtoClass.getDeclaredConstructor().newInstance();
      BeanUtils.copyProperties(fromEntity, dto);
      return dto;
    } catch (Exception e) {
      throw new RuntimeException("Erro ao mapear entidade para DTO", e);
    }
  }
}
