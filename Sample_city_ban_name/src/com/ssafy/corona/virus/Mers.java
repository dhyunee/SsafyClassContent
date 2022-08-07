package com.ssafy.corona.virus;

import java.util.Objects;

public class Mers extends Virus{
	private double infectedRate;
	public Mers() {}
	public Mers(String name, int level, double infectedRate) {
		super(name, level);
		setInfectedRate(infectedRate);
	}
	
	public double getInfectedRate() {
		return infectedRate;
	}
	public void setInfectedRate(double infectedRate) {
		this.infectedRate = infectedRate;
	}	
	
	@Override
	public String toString() {
		StringBuilder sb=new StringBuilder();
		sb.append(super.toString()).append("\t")
		  .append(getInfectedRate());
		return sb.toString();
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj!=null&&obj instanceof Mers) {
			Mers vr=(Mers)obj;
			if(vr.getName().equals(super.getName())&&vr.getInfectedRate()==this.infectedRate&&vr.getLevel()==this.getLevel())return true;
			return false;
		}
		return false;

	}
	
	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return Objects.hash(this.getName(),this.getLevel(),this.infectedRate);
	}
}