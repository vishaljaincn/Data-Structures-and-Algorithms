package com.inheri;

public class Bicycle {
	int speed;
	int gear;

	public Bicycle(int startspeed, int startgear) {
		speed = startspeed;
		gear = startgear;
	}

	public void applyBreak(int breakvalue) {
		speed -= breakvalue;
	}

	public void speedUp(int speedvalue) {
		speed += speedvalue;
	}

}
