package com.elpisor.hq.web.api.model;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class UserCredsApi {
    String email;
    String password;
    Boolean returnSecureToken;

}
