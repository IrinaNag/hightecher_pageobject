package com.elpisor.hq.model.api_model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@ToString
@EqualsAndHashCode//(exclude = {"password","uid"})
public class User {
    private String uid;
    private Boolean active;
    private Integer degree;
    private String email;
    private List<Location> hiringRegions;
    private Location homeLocation;
    private String name;
    private Integer notificationBy;
    private NotificationTime notificationTime;
    //@JsonIgnore
    private String password;
    private String phone;
    private List<Skill> skills;
    private String surname;
    private String timeZone;
    private String username;
    private String authorities;

}
