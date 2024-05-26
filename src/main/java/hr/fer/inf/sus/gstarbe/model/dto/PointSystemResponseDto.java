package hr.fer.inf.sus.gstarbe.model.dto;

import lombok.Data;

@Data
public class PointSystemResponseDto {
    Long psId;
    KeyValueDto resultType;
    Integer value;
}
