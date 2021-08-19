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
package io.adminshell.aas.v3.dataformat.aml.deserialization;

import io.adminshell.aas.v3.dataformat.aml.model.caex.CAEXFile;
import io.adminshell.aas.v3.dataformat.aml.model.caex.CAEXObject;

/**
 * Wraps an AML file and provides a pointer to the current position within that
 * file
 *
 * @author jab
 */
public class AmlParser {

    private final CAEXFile content;
    private CAEXObject current;

    public AmlParser(CAEXFile content) {
        this.content = content;
    }

    /**
     * Gets the AML file the parser represents
     *
     * @return the AML file the parser represents
     */
    public CAEXFile getContent() {
        return content;
    }

    /**
     * Gets the CAEXObject that currently is being processed, i.e. a point to
     * the current position within the AML file
     *
     * @return the current object
     */
    public CAEXObject getCurrent() {
        return current;
    }

    /**
     * Sets the CAEXObject that currently is being processed.
     *
     * @param current the object currently being processed
     */
    public void setCurrent(CAEXObject current) {
        this.current = current;
    }

}