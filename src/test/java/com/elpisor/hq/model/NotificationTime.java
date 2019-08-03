package com.elpisor.hq.model;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@ToString
@EqualsAndHashCode
public class NotificationTime {
    private String[] sun;
    private String[] mon;
    private String[] tue;
    private String[] wed;
    private String[] thu;
    private String[] fri;
    private String[] sat;
}
