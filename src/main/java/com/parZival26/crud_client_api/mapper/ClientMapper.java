package com.parZival26.crud_client_api.mapper;

import com.parZival26.crud_client_api.dto.ClientCreateDTO;
import com.parZival26.crud_client_api.dto.ClientUpdateDTO;
import com.parZival26.crud_client_api.entity.Client;
import org.mapstruct.*;

@Mapper(componentModel = "spring",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface ClientMapper {
    @Mapping(target = "id", ignore = true)
    Client toEntity(ClientCreateDTO createDTO);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateClientFromDTO(ClientUpdateDTO updateDTO, @MappingTarget Client client);
}