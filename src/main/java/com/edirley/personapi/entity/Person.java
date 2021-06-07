package com.edirley.personapi.entity;

import com.edirley.personapi.enums.localDate;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Person {

    private Long id;

    private String firstName;

    private String lastName;

    private String cpf;

    private localDate birthDate;

    private List<Phone> phones;
}
