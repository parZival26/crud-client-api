package com.parZival26.crud_client_api.entity;

import  jakarta.persistence.*;
import lombok.Data;


@Data
@Entity
@Table( name = "client" )
public class Client {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    @Column()
    private long id;

    @Column( name = "email", nullable = false, unique = true )
    private String email;

    @Column( name = "name", nullable = false )
    private String name;

    @Column( name = "phone", nullable = false )
    private String phone;

}
