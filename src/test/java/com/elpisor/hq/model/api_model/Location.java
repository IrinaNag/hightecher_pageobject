package com.elpisor.hq.model.api_model;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@ToString
@EqualsAndHashCode
public class Location {
    private String city;
    private String country;
}
