package com.fs.e_extends;

class LOLHero {
	public int hp;
	public int mp;
	
	public LOLHero() {
		System.out.println("无参数构造方法");
	}

	public LOLHero(int hp) {
		this.hp = hp;
		System.out.println("单参数构造方法");
	}

	public LOLHero(int hp, int mp) {
		this.hp = hp;
		this.mp = mp;
		System.out.println("双参数构造方法");
	}
	
	
	
	
}

class VN extends LOLHero {
	public VN() {
		System.out.println("VN类构造方法");
	}
}
public class Dmoe3 {
	public static void main(String[] args) {
		new VN();
	}
}
