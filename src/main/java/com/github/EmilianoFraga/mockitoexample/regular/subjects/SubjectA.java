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

/*
This is the regular situation.
Because of the INHERITANCE approach, the veryHeavyMethod will be called anyway
 */
public class SubjectA extends VeryHeavy {
	public String doStuffA(String input) {
		final String myStuff = String.join(DELIMITER, "STUFF-A", input);
		return veryHeavyMethod(myStuff);
	}
}
