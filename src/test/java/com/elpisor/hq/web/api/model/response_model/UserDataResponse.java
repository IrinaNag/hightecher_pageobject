package com.elpisor.hq.web.api.model.response_model;

import com.elpisor.hq.web.api.model.UserData;
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
