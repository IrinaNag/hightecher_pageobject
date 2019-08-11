package com.elpisor.hq.model.api_response_model;

import com.elpisor.hq.model.api_model.UserData;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@ToString(callSuper = true)
public class UserDataResponse extends AbstractResponse{
    @JsonProperty("data")
    UserData userData;

}
