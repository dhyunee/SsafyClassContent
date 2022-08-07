package com.ssafy.corona.virus;

import java.util.Objects;

public class Virus {
	private String name;
	private int level;

	public Virus() {}
	public Virus(String name, int level) {
		setName(name);
		setLevel(level);
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}	
	@Override
	public String toString() {
		StringBuilder sb=new StringBuilder();
		sb.append(getName()).append("\t")
		  .append(getLevel());
		return sb.toString();
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj!=null&&obj instanceof Virus) {
			Virus vr=(Virus)obj;
			if(vr.getName().equals(this.name))return true;
			return false;
		}
		return false;
	}
	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return Objects.hash(this.level ,this.name);
	}
}
