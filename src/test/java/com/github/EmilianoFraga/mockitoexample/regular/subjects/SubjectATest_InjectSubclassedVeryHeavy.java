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

public class SubjectATest_InjectSubclassedVeryHeavy {

	private SubjectA subjectA;
	private IVeryHeavy mockedVeryHeavy;

	@Before
	public void setUp() {
		mockedVeryHeavy = new MockedVeryHeavy();

		subjectA = new SubjectA(mockedVeryHeavy);
	}

	@Test
	public void doStuffA() {
		// After running this test you will see that there is a veryheavy call in the log output
		String result = subjectA.doStuffA("banana");
		assertEquals("VERY HEAVY::STUFF-A::banana", result);
	}

	// This subclass of VeryHeavy can override the methods we don't want to call
	private static class MockedVeryHeavy extends VeryHeavy {
		@Override
		public String veryHeavyMethod(String input) {
			return String.join(VeryHeavy.DELIMITER, "VERY HEAVY", input);
		}
	}
}