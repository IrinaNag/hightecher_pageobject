package com.elpisor.hq.web.gui.model;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class UserGui {
    private String username;
    private String name;
    private String surname;
    private String email;
    private String phone;
    private String password;
    private String password_confirmation;

}