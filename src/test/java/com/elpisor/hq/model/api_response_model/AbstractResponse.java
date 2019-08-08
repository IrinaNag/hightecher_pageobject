package com.elpisor.hq.model.api_response_model;

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
