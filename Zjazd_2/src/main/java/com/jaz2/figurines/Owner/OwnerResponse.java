package com.jaz2.figurines.Owner;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
public class OwnerResponse {
    private UUID id;
    private String name;
    private String surname;
    private String email;
    private String address;
    private String phone;
}
