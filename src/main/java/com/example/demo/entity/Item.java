package com.example.demo.entity;

import java.math.BigDecimal;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "item")
public class Item {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long itemID;
	@Column(nullable = false)
	private String title;
	@Column(nullable = false)
	private BigDecimal price;

	public Long getItemID() {
		return itemID;
	}

	public void setItemID(Long itemID) {
		this.itemID = itemID;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		Item item = (Item) o;
		return Objects.equals(itemID, item.itemID);
	}

	@Override
	public int hashCode() {
		return Objects.hash(itemID);
	}

	@Override
	public String toString() {
		return "Item{" +
				"itemID=" + itemID +
				", title='" + title + '\'' +
				", price=" + price +
				'}';
	}
}
