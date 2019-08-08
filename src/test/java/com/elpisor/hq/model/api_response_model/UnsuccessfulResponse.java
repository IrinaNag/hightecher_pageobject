package com.elpisor.hq.model.api_response_model;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@ToString(callSuper = true)
public class UnsuccessfulResponse extends AbstractResponse {
    private String data;

}
