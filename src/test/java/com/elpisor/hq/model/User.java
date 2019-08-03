package com.elpisor.hq.model;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@ToString
@EqualsAndHashCode(exclude = "password")
public class User {
    private Boolean active;
    private Integer degree;
    private String email;
    private Location[] hiringRegions;
    private Location homeLocation;
    private String name;
    private Integer notificationBy;
    private NotificationTime notificationTime;
    private String password;
    private String phone;
    private Skill skills;
    private String surname;
    private String timeZone;
    private String username;

}
