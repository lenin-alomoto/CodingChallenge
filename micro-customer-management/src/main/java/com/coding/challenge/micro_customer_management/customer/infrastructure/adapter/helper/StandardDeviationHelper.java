package com.coding.challenge.micro_customer_management.customer.infrastructure.adapter.helper;

import java.util.List;

public class StandardDeviationHelper {
	
	private StandardDeviationHelper() {
		throw new IllegalStateException("Utility class");
	}
	
	public static Double calculateStandardDeviation(List<Integer> valuesAge) {
		var media = calculateTheMedia(valuesAge);
		
		var squaredDifferences = calculateTheSquaredDifferences(valuesAge, media);

		var variance = calculateTheVariance(squaredDifferences, valuesAge.size());

		return Math.sqrt(variance);
	}
	
	private static Double calculateTheMedia(List<Integer> valuesAge) {
		return valuesAge.stream().mapToDouble(Integer::intValue).average().orElse(0);
	}

	private static List<Double> calculateTheSquaredDifferences(List<Integer> valuesAge, Double media) {
		return valuesAge.stream().map(value -> Math.pow(value - media, 2)).toList();
	}

	private static Double calculateTheVariance(List<Double> squaredDifferences, int sizeAllAge) {
		return squaredDifferences.stream().mapToDouble(Double::doubleValue).sum() / (sizeAllAge - 1);
	}
}
