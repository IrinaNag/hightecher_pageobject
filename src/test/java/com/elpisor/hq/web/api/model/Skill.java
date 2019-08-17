package com.elpisor.hq.web.api.model;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@ToString
@EqualsAndHashCode
public class Skill {
    private String exp_since;
    private Integer id;
    private String skillName;
}
