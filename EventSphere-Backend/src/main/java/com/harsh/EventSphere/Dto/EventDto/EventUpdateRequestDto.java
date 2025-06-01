package com.harsh.EventSphere.Dto.EventDto;

import com.harsh.EventSphere.Enum.EventCategory;
import com.harsh.EventSphere.Enum.EventStatus;
import lombok.Data;

import java.sql.Timestamp;

@Data
public class EventUpdateRequestDto {

    private String title;
    private String description;
    private String location;
    private Timestamp startTime;
    private Timestamp endTime;
    private String contact;
    private Integer quantity;
    private Integer price;
    private String imageUrl;
    private EventCategory category;
    private EventStatus status;
}
