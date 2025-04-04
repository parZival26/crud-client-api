package com.parZival26.crud_client_api.dto;
import jakarta.validation.constraints.*;
import lombok.Data;

@Data
public class ClientUpdateDTO {

    @Email(message = "Formato de email inválido")
    private String email;

    @Size(min = 2, max = 100, message = "El nombre debe tener entre 2 y 100 caracteres")
    private String name;

    @Pattern(regexp = "^[0-9]{10}$", message = "El teléfono debe contener 10 dígitos")
    private String phone;
}
