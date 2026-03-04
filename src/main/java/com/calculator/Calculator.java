package com.calculator;

public class Calculator {

	public double sqrt(double x) {
		return Math.sqrt(x);
	}

	public long factorial(int n) {
		long result = 1;
		for(int i = 1; i <= n; i++) {
			result*=i;
		}
		return result;
	}

	public double ln(double x){
		return Math.log(x);
	}

	public double power(double a, double b) {
		return Math.pow(a,b);
	}
}
