package hr.fer.inf.sus.gstarbe.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PointSystemRequestDto {
    Long resultTypeId;
    Integer value;
}
