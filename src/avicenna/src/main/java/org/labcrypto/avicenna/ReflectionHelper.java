/**

 Avicenna Dependency Injection Framework
 Copyright 2015 Kamran Amini

 Licensed under the Apache License, Version 2.0 (the "License");
 you may not use this file except in compliance with the License.
 You may obtain a copy of the License at

 http://www.apache.org/licenses/LICENSE-2.0

 Unless required by applicable law or agreed to in writing, software
 distributed under the License is distributed on an "AS IS" BASIS,
 WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 See the License for the specific language governing permissions and
 limitations under the License.

 */

package org.labcrypto.avicenna;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * A helper class that will ease our reflection related tasks.
 *
 * @author Kamran Amini  kam.cpp@gmail.com
 */
public class ReflectionHelper {

    /**
     * Retrieves all fields in inheritance tree of a class.
     */
    public static List<Field> getFields(Class<?> clazz) {
        return internalGetAllFields(new ArrayList<Field>(), clazz);
    }

    private static List<Field> internalGetAllFields(List<Field> fields, Class<?> type) {
        fields.addAll(Arrays.asList(type.getDeclaredFields()));
        if (type.getSuperclass() != null) {
            fields = internalGetAllFields(fields, type.getSuperclass());
        }
        return fields;
    }
}
