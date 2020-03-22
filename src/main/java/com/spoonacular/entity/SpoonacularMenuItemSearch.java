package com.spoonacular.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

import javax.annotation.Generated;

/**
 * Defines Spoonacular menu item searchs.
 * @author Matt Anderson
 * @version 11
 */
@Generated("com.robohorse.robopojogenerator")
@Data
public class SpoonacularMenuItemSearch {

	@JsonProperty("totalMenuItems")
	private int totalMenuItems;

	@JsonProperty("number")
	private int number;

	@JsonProperty("expires")
	private String expires;

	@JsonProperty("offset")
	private int offset;

	@JsonProperty("processingTimeMs")
	private int processingTimeMs;

	@JsonProperty("menuItems")
	private List<SpoonacularMenuItem> menuItems;

	@JsonProperty("type")
	private String type;

	@JsonProperty("isStale")
	private boolean isStale;

	/**
	 * Instantiates a new Spoonacular menu item search.
	 */
	public SpoonacularMenuItemSearch() {
		menuItems = new ArrayList<>();
	}

	/**
	 * Instantiates a new Spoonacular menu item search.
	 *
	 * @param totalMenuItems   the total menu items
	 * @param number           the number
	 * @param expires          the expires
	 * @param offset           the offset
	 * @param processingTimeMs the processing time ms
	 * @param menuItems        the menu items
	 * @param type             the type
	 * @param isStale          the is stale
	 */
	public SpoonacularMenuItemSearch(int totalMenuItems, int number, String expires, int offset, int processingTimeMs, List<SpoonacularMenuItem> menuItems, String type, boolean isStale) {
		this();
		this.totalMenuItems = totalMenuItems;
		this.number = number;
		this.expires = expires;
		this.offset = offset;
		this.processingTimeMs = processingTimeMs;
		this.menuItems = menuItems;
		this.type = type;
		this.isStale = isStale;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		SpoonacularMenuItemSearch that = (SpoonacularMenuItemSearch) o;
		return totalMenuItems == that.totalMenuItems &&
				number == that.number &&
				offset == that.offset &&
				isStale == that.isStale &&
				Objects.equals(menuItems, that.menuItems) &&
				Objects.equals(type, that.type);
	}

	@Override
	public int hashCode() {
		return Objects.hash(totalMenuItems, number, offset, menuItems, type, isStale);
	}
}