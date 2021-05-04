package com.fs.c_car;

/**
 * 发动机类
 * @author fStardust
 *
 */
public class Engine {
	private String name;
	private float capacity;
	
	public Engine() {}

	public Engine(String name, float capacity) {
		this.name = name;
		this.capacity = capacity;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public float getCapacity() {
		return capacity;
	}

	public void setCapacity(float capacity) {
		this.capacity = capacity;
	}
	
	
}
