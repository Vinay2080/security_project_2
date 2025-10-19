package org.example.security_project_2.mapper;

import org.example.security_project_2.dto.request.authentication.RegisterRequest;
import org.example.security_project_2.model.AppUser;
import org.mapstruct.*;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface RegisterRequestMapper {

    @Mapping(target = "role", constant = "USER")
    @Mapping(target = "id", ignore = true)
    AppUser registerRequestToUser(RegisterRequest registerRequest);

}