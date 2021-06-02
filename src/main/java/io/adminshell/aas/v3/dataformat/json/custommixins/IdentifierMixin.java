package io.adminshell.aas.v3.dataformat.json.custommixins;

import com.fasterxml.jackson.annotation.JsonProperty;

public interface IdentifierMixin {

    @JsonProperty("id")
    public void setIdentifier(String identifier);

    @JsonProperty("id")
    public String getIdentifier();
}