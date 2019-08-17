package com.elpisor.hq.web.api.model;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@ToString
public class UserBy {
    private String email;
    private String phone;
    private String uid;
}
