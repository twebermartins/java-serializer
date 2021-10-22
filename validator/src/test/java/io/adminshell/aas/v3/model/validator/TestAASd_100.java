/*
 * Copyright (c) 2021 Fraunhofer-Gesellschaft zur Foerderung der angewandten Forschung e. V.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.adminshell.aas.v3.model.validator;

import io.adminshell.aas.v3.model.Referable;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

/**
 * Tests the following constraint:
 * <p>
 * <i> An attribute with data type "string" is not allowed to be empty. </i>
 * </p>
 *
 * @author bader, chang
 *
 */

public class TestAASd_100 {
    @Test
    public void idShortWithNotAllowedCharacters() throws ValidationException {
        Referable wrongReferable = ConstraintTestHelper.createSubmodel(new ArrayList<>());


        wrongReferable.setIdShort("");
        try {
            ShaclValidator.getInstance().validate(wrongReferable);
            fail();
        } catch (ValidationException e) {
            assertTrue(e.getMessage().endsWith("starting mandatory with a letter. I.e. [a-zA-Z][a-zA-Z0-9_]+."));
        }


    }

    @Test
    public void idShortWithAllowedCharacters() throws ValidationException {
        Referable referable = ConstraintTestHelper.createSubmodel(new ArrayList<>());
        referable.setIdShort("id_Short");
        ShaclValidator.getInstance().validate(referable);
    }
}
