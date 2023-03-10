package com.mycom.myhouse.event.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class EventResultDto {
	
	private int result;
	private EventDto event;
	private List<EventDto> eventList;
	
}
