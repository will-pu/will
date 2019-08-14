package com.neusoft.test;

import java.math.BigDecimal;

public class Demo4 {

	public static void main(String[] args) {
		BigDecimal b=new BigDecimal("35884571277.99");
		double x=b.doubleValue()/20;
		System.out.println(new BigDecimal(x));

	}

}
