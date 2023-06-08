package com.appsfactory.mileagepolicy.domain.model;

import javax.persistence.*;

;

@Entity
@Table
public class Mileage {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	private Long Id;
	@Column(nullable = false)
	private Float minRange;

	@Column(nullable = false)
	private Float maxRange;
	@Column(nullable = false)
	private float factor;

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public Float getMinRange() {
		return minRange;
	}

	public void setMinRange(Float minRange) {
		this.minRange = minRange;
	}

	public Float getMaxRange() {
		return maxRange;
	}

	public void setMaxRange(Float maxRange) {
		this.maxRange = maxRange;
	}

	public float getFactor() {
		return factor;
	}

	public void setFactor(float factor) {
		this.factor = factor;
	}
}
