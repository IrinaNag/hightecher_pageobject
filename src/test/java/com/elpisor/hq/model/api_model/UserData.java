package com.elpisor.hq.model.api_model;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@ToString
public class UserData {
    private String name;
    private String surname;
    private String email;
    private String phone;
}
