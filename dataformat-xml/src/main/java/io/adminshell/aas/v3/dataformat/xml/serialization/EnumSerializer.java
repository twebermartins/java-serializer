package io.adminshell.aas.v3.dataformat.xml.serialization;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import io.adminshell.aas.v3.dataformat.json.ReflectionHelper;

/**
 * Serializes enum values. If enum is part of the AAS Java model, the name will
 * be converted from SCREAMING_SNAKE_CASE to UpperCamelCase, else default
 * serialization will be used
 */
public class EnumSerializer extends JsonSerializer<Enum> {

    protected static final char UNDERSCORE = '_';

    @Override
    public void serialize(Enum value, JsonGenerator gen, SerializerProvider provider) throws IOException {
        if (ReflectionHelper.ENUMS.contains(value.getClass())) {
            gen.writeString(translate(value.name()));
        } else {
            provider.findValueSerializer(Enum.class).serialize(value, gen, provider);
        }
    }

    protected String translate(String input) {
        String result = "";
        boolean capitalize = true;
        for (int i = 0; i < input.length(); i++) {
            char currentChar = input.charAt(i);
            if (UNDERSCORE == currentChar) {
                capitalize = true;
            } else {
                result += capitalize
                        ? currentChar
                        : Character.toLowerCase(currentChar);
                capitalize = false;
            }
        }
        return result;
    }
}
