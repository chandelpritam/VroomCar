package com.vroomcar.VroomCar;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.vroomcar.VroomCar.beans.SumOfNumbers;

@SpringBootTest
public class SumOfNumberstest {
	SumOfNumbers myMath = new SumOfNumbers();

	@Test
	public void sum_with3numbers() {
		System.out.println("Test1");
		assertEquals(9, myMath.sum(new int[] { 1, 2, 6 }));
	}

	@Test
	public void sum_with1number() {
		System.out.println("Test2");
		assertEquals(2, myMath.sum(new int[] { 2 }));
	}

}
