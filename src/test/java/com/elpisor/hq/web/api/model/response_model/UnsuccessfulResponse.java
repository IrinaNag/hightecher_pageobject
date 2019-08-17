package com.elpisor.hq.web.api.model.response_model;

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
