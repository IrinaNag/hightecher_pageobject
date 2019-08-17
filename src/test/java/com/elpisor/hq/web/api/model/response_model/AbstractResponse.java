package com.elpisor.hq.web.api.model.response_model;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public abstract class AbstractResponse {
    private Long timestamp;
    private String message;
    private String code;
    private Integer numeric;

}
