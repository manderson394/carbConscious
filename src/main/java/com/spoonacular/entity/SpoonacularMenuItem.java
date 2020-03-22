package com.spoonacular.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.annotation.Generated;

/**
 * Defines Spoonacular menu items.
 * @author Matt Anderson
 * @version 11
 */
@Generated("com.robohorse.robopojogenerator")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SpoonacularMenuItem {

	@JsonProperty("restaurantChain")
	private String restaurantChain;

	@JsonProperty("image")
	private String image;

	@JsonProperty("id")
	private int id;

	@JsonProperty("readableServingSize")
	private String readableServingSize;

	@JsonProperty("title")
	private String title;

	@JsonProperty("servingSize")
	private String servingSize;

	@JsonProperty("imageType")
	private String imageType;

}