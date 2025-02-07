package com.java8.streams.census.src;

public class StateRegion {
	
	public String state;
	public String region;
	
	public StateRegion(){
		
	}
	
	public StateRegion(StateRegion a){
		this.region = a.region;
		this.state = a.state;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	
}
