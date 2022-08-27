package com.microservice.habits.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="habit")
public class Habit {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="habitsid")
	private Integer habitsId;
	
	@Column(name="name")
	private String name;
	
	@Column(name="successfulldays")
	private Integer successfullDays;
	
	@Column(name="statusbinary")
	private boolean statusBinary;
	
	@Column(name="statuscontinuous")
	private Integer statusContinuous;
	
	// @JoinColumn(name="userid")
	@Column(name="userid")
    // @ManyToOne(cascade = {CascadeType.PERSIST,CascadeType.MERGE,CascadeType.DETACH,CascadeType.REFRESH})
	private Integer userId;

	public Habit(String name, Integer habitsId, Integer successfullDays, boolean statusBinary,
			Integer statusContinuous, Integer userId) {
		super();
		this.name = name;
		this.habitsId = habitsId;
		this.successfullDays = successfullDays;
		this.statusBinary = statusBinary;
		this.statusContinuous = statusContinuous;
		this.userId = userId;
	}
	
	

	public Habit() {
		super();
	}



	public String getName() {
		return name;
	}

	public Integer getHabitId() {
		return habitsId;
	}

	public Integer getSuccessfullDays() {
		return successfullDays;
	}

	public boolean isStatusBinary() {
		return statusBinary;
	}

	public Integer getStatusContinuous() {
		return statusContinuous;
	}

	public Integer getUserId() {
		return userId;
	}
	
	
	
}
