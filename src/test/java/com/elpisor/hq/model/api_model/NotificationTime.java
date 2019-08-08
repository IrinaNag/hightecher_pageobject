package com.elpisor.hq.model.api_model;

import lombok.*;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@ToString
@EqualsAndHashCode
public class NotificationTime{
	private List<String> sun;
	private List<String> mon;
	private List<String> tue;
	private List<String> wed;
	private List<String> thu;
	private List<String> fri;
	private List<String> sat;
}