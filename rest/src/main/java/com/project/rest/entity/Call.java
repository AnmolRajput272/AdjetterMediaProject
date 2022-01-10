package com.project.rest.entity;

import org.springframework.stereotype.Repository;


public class Call {
	public int Id;
	public long From_number;
	public String Start_time;
	public String End_time;
	public int Duration;
	
	Call(int id, long from_number, String start_time, String end_time, int duration) {
		this.Id = id;
		this.From_number = from_number;
		this.Start_time = start_time;
		this.End_time = end_time;
		this.Duration = duration;
	}
	
	@Override
	public String toString() {
		return "Call [Id=" + Id + ", From_number=" + From_number + ", Start_time=" + Start_time + ", Duration="
				+ Duration + "]";
	}
	
}
