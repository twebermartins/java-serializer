package io.adminshell.aas.v3.dataformat.xml.mixin;



import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeName;

@JsonTypeName("DataSpecificationContent")
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "modelType")
public interface DataSpecificationContentMixin {

}
