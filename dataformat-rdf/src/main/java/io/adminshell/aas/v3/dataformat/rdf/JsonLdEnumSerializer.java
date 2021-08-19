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

package io.adminshell.aas.v3.dataformat.rdf;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import io.adminshell.aas.v3.model.annotations.IRI;

import java.io.IOException;

public class JsonLdEnumSerializer extends JsonSerializer<Enum<?>> {


    @Override
    public void serialize(Enum value, JsonGenerator gen, SerializerProvider provider) throws IOException {
        if(value.getClass().isEnum() && value.getClass().getName().startsWith("io.adminshell.aas."))
        {
            if(value.getClass().getAnnotation(IRI.class) != null && value.getClass().getAnnotation(IRI.class).value().length > 0)
            {
                gen.writeStartObject();
                gen.writeStringField("@type", value.getClass().getAnnotation(IRI.class).value()[0]);
                gen.writeStringField("@id", translate(value.getClass(), value.name()));
                gen.writeEndObject();
            }
            else
            {
                gen.writeString(translate(value.getClass(), value.name()));
            }


        } else {
            provider.findValueSerializer(Enum.class).serialize(value, gen, provider);
        }
    }



    public static String translate(Class<?> enumClass, String input) {
        String[] iriValues = enumClass.getAnnotation(IRI.class).value();
        String result = "";
        if(iriValues.length > 0)
        {
            result = iriValues[0];
            if(!result.endsWith("/"))
            {
                result += "/";
            }
        }
        result += input;
        return result;
    }
}