package com.jaz2.figurines.Owner;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
public class OwnerCreateRequest {
    private String name;
    private String surname;
    private String email;
    private String address;
    private String phone;
}
