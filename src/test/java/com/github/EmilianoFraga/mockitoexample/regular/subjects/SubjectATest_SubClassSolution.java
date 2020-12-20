// Copyright 2020 Emiliano Vaz Fraga

// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at

// 	http://www.apache.org/licenses/LICENSE-2.0

// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.

package com.github.EmilianoFraga.mockitoexample.regular.subjects;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SubjectATest_SubClassSolution {

	private SubjectA subjectA;

	@Before
	public void setUp() {
		// Sometimes the class being subclasses is too complex for anonymous subclassing.
		// Here a handy the solution might be here to use a private sub class. See below.
		subjectA = new SubjectATestVersion();
	}

	@Test
	public void doStuffA() {
		// After running this test you will see that there is no veryheavy log output
		String result = subjectA.doStuffA("banana");
		assertEquals("VERY HEAVY::STUFF-A::banana", result);
	}

	// Inner Subclass where the very heavy method is "overriden" by one that simply returns the expected result
	private static class SubjectATestVersion extends SubjectA {
		@Override
		public String veryHeavyMethod(String input) {
			return String.join(DELIMITER, "VERY HEAVY", input);
		}
	}
}