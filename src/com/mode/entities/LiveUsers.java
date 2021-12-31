package com.mode.entities;

public class LiveUsers {
	private String State;
	private int count;
	
	@Override
	public String toString() {
		return "LiveUsers [State=" + State + ", count=" + count + "]";
	}
	
	public LiveUsers(String State, int count) {
		this.State = State;
		this.count = count;
	}
	
	public String getState() {
		return State;
	}
	public void setState(String state) {
		State = state;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	
}
