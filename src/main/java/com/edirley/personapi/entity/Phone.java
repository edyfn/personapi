package com.edirley.personapi.entity;

import com.edirley.personapi.enums.PhoneType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Id;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Phone {

    @Id
    private Long id;

    private PhoneType type;

    private String number;
}
