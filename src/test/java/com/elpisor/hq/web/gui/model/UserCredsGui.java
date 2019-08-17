package com.elpisor.hq.web.gui.model;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class UserCredsGui {
    String email;
    String password;

}
