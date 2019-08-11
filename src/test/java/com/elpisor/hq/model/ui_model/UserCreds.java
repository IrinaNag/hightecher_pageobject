package com.elpisor.hq.model.ui_model;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class UserCreds {
    String email;
    String password;
    Boolean returnSecureToken;

}
