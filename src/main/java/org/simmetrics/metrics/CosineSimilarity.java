/*
 * SimMetrics - SimMetrics is a java library of Similarity or Distance Metrics,
 * e.g. Levenshtein Distance, that provide float based similarity measures
 * between String Data. All metrics return consistent measures rather than
 * unbounded similarity scores.
 * 
 * Copyright (C) 2014 SimMetrics authors
 * 
 * This file is part of SimMetrics. This program is free software: you can
 * redistribute it and/or modify it under the terms of the GNU General Public
 * License as published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful, but WITHOUT ANY
 * WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR
 * A PARTICULAR PURPOSE. See the GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License along with
 * SimMetrics. If not, see <http://www.gnu.org/licenses/>.
 */
package org.simmetrics.metrics;

import java.util.HashSet;
import java.util.Set;

import org.simmetrics.TokenSetMetric;

import static java.lang.Math.pow;

/**
 * Implements the Cosine Similarity algorithm providing a similarity measure
 * between two strings from the angular divergence within term based vector
 * space
 * 
 * @author Sam Chapman
 * @version 1.1
 */
public class CosineSimilarity implements TokenSetMetric {

	@Override
	public float compare(Set<String> str1Tokens, Set<String> str2Tokens) {

		final Set<String> allTokens = new HashSet<>();
		allTokens.addAll(str1Tokens);
		allTokens.addAll(str2Tokens);

		final int commonTerms = (str1Tokens.size() + str2Tokens.size())
				- allTokens.size();

		// return CosineSimilarity
		return (commonTerms)
				/ (float) (pow(str1Tokens.size(), 0.5) * pow(str2Tokens.size(),
						0.5));
	}

	@Override
	public String toString() {
		return "CosineSimilarity";
	}

}
