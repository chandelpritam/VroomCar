package com.vroomcar.VroomCar.beans;

public class SumOfNumbers {
	public int sum(int[] numbers) {
		int sum = 0;
		for (int i : numbers) {
			sum += i;
		}
		return sum;
	}
}