package com.tyss;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Marker {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String colour;
	private double price;
	@CreationTimestamp
	private LocalDateTime creationTime;
	@UpdateTimestamp
	private LocalDateTime updateTime;
	
	public Marker() {
		
	}

	public Marker(String colour, double price) {
		this.colour = colour;
		this.price = price;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getColour() {
		return colour;
	}

	public void setColour(String colour) {
		this.colour = colour;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public LocalDateTime getCreationTime() {
		return creationTime;
	}

	public void setCreationTime(LocalDateTime creationTime) {
		this.creationTime = creationTime;
	}

	public LocalDateTime getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(LocalDateTime updateTime) {
		this.updateTime = updateTime;
	}

	@Override
	public String toString() {
		return "Marker [id=" + id + ", colour=" + colour + ", price=" + price + ", creationTime=" + creationTime
				+ ", updateTime=" + updateTime + "]";
	}

}
