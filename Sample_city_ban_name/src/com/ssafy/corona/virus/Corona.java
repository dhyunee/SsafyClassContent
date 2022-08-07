package com.ssafy.corona.virus;

import java.util.Objects;

public class Corona extends Virus{
	public int spreadSpeed;

	Corona() {}
	public Corona(String name, int level, int spreadSpeed) {
		setName(name);
		setLevel(level);
		setSpreadSpeed(spreadSpeed);
	}
	
	public int getSpreadSpeed() {
		return spreadSpeed;
	}
	public void setSpreadSpeed(int spreadSpeed) {
		this.spreadSpeed = spreadSpeed;
	}	
	
	@Override
	public String toString() {
		StringBuilder sb=new StringBuilder();
		sb.append(super.toString()).append("\t")
		  .append(getSpreadSpeed());
		return sb.toString();
	}
	@Override
	public boolean equals(Object obj) {
		if(obj!=null&&obj instanceof Mers) {
			Corona vr=(Corona)obj;
			if(vr.getName().equals(super.getName())&&vr.spreadSpeed==this.spreadSpeed&&vr.getLevel()==this.getLevel())return true;
			return false;
		}
		return false;

	}
	
	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return Objects.hash(this.getName(),this.getLevel(),this.spreadSpeed);
	}
}