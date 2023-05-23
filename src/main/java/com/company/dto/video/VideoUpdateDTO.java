package com.company.dto.video;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class VideoUpdateDTO {

    private String id;
    private String title;
    private String description;
    private String review;

}
