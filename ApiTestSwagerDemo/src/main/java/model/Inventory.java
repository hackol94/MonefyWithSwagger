package model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class Inventory{

	@JsonProperty("approved")
	private int approved;

	@JsonProperty("delivered")
	private int delivered;
}