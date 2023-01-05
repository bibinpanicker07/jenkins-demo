package com.axis.springbootdemo.entity;

import java.util.Objects;

public class Cricketer {
	private int cricketerId;
	private String name;
	private int runScored;
	private int balls;
	private int fours;
	private int sixes;
	private int strikeRate;
	public Cricketer(int cricketerId, String name, int runScored, int balls, int fours, int sixes, int strikeRate) {
		super();
		this.cricketerId = cricketerId;
		this.name = name;
		this.runScored = runScored;
		this.balls = balls;
		this.fours = fours;
		this.sixes = sixes;
		this.strikeRate = strikeRate;
	}
	public Cricketer() {
		super();
	}
	public int getCricketerId() {
		return cricketerId;
	}
	public void setCricketerId(int cricketerId) {
		this.cricketerId = cricketerId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getRunScored() {
		return runScored;
	}
	public void setRunScored(int runScored) {
		this.runScored = runScored;
	}
	public int getBalls() {
		return balls;
	}
	public void setBalls(int balls) {
		this.balls = balls;
	}
	public int getFours() {
		return fours;
	}
	public void setFours(int fours) {
		this.fours = fours;
	}
	public int getSixes() {
		return sixes;
	}
	public void setSixes(int sixes) {
		this.sixes = sixes;
	}
	public int getStrikeRate() {
		return strikeRate;
	}
	public void setStrikeRate(int strikeRate) {
		this.strikeRate = strikeRate;
	}
	@Override
	public String toString() {
		return "Cricketer [cricketerId=" + cricketerId + ", name=" + name + ", runScored=" + runScored + ", balls="
				+ balls + ", fours=" + fours + ", sixes=" + sixes + ", strikeRate=" + strikeRate + "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(cricketerId, name);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cricketer other = (Cricketer) obj;
		return cricketerId == other.cricketerId && Objects.equals(name, other.name);
	}
	
	

}
