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

import java.util.List;

import org.simmetrics.StringMetric;
import org.simmetrics.TokenListMetric;

/**
 * Implements the Monge Elkan algorithm providing an matching style similarity
 * measure between two strings
 * 
 * @author Sam Chapman
 * @version 1.1
 */
public class MongeElkan implements TokenListMetric {

	private final StringMetric metric;

	/**
	 * Constructs a MongeElkan metric with the given tokenizer and metric.
	 *
	 * @param tokenizer
	 *            tokenizer to use
	 * @param metric
	 *            metric to use
	 */
	public MongeElkan(final StringMetric metric) {
		this.metric = metric;
	}


	@Override
	public float compare(List<String> str1Tokens, List<String> str2Tokens) {

		float sumMatches = 0.0f;
		float maxFound;
		for (String str1Token : str1Tokens) {
			maxFound = 0.0f;
			for (String str2Token : str2Tokens) {
				final float found = metric.compare(str1Token, str2Token);
				if (found > maxFound) {
					maxFound = found;
				}
			}
			sumMatches += maxFound;
		}
		return sumMatches / str1Tokens.size();
	}


	@Override
	public String toString() {
		return "MongeElkan [metric=" + metric + "]";
	}

	
}
