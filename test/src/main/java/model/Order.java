package model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Order{

	@JsonProperty("petId")
	private int petId;

	@JsonProperty("quantity")
	private int quantity;

	@JsonProperty("id")
	private int id;

	@JsonProperty("shipDate")
	private String shipDate;

	@JsonProperty("complete")
	private boolean complete;

	@JsonProperty("status")
	private String status;
}