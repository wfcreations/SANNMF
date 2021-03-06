/*
 * Copyright (c) Welsiton Ferreira (wfcreations@gmail.com)
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without modification,
 * are permitted provided that the following conditions are met:
 *
 *  Redistributions of source code must retain the above copyright notice, this
 *  list of conditions and the following disclaimer.
 *
 *  Redistributions in binary form must reproduce the above copyright notice, this
 *  list of conditions and the following disclaimer in the documentation and/or
 *  other materials provided with the distribution.
 *
 *  Neither the name of the WFCreation nor the names of its
 *  contributors may be used to endorse or promote products derived from
 *  this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND
 * ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
 * WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE FOR
 * ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
 * (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
 * LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON
 * ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package br.com.wfcreations.sannmf.learning.stopcondition;

import br.com.wfcreations.sannmf.learning.ErrorCorrectionLearning;

public class ErrorDecreases implements IStopCondition {

	private static final long serialVersionUID = 1L;

	public static double DEFAULT_RATE = 0.00001;

	protected ErrorCorrectionLearning learningRule;

	protected double rate = DEFAULT_RATE;

	public ErrorDecreases(ErrorCorrectionLearning learningRule, double rate) {
		this.setLearningRule(learningRule);
	}

	public ErrorDecreases(ErrorCorrectionLearning learningRule) {
		this.setLearningRule(learningRule);
	}

	@Override
	public boolean isReached() {
		return Math.abs(learningRule.getTotalNetworkError() - learningRule.getPreviousEpochError()) < this.rate;
	}

	public ErrorCorrectionLearning getLearningRule() {
		return learningRule;
	}

	public ErrorDecreases setLearningRule(ErrorCorrectionLearning learningRule) {
		this.learningRule = learningRule;
		return this;
	}

	public double getRate() {
		return rate;
	}

	public ErrorDecreases setRate(double rate) {
		this.rate = rate;
		return this;
	}
}