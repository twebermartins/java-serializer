package io.adminshell.aas.v3.dataformat.xml.mixin;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

import io.adminshell.aas.v3.dataformat.xml.AasXmlNamespaceContext;
import io.adminshell.aas.v3.model.AssetKind;
import io.adminshell.aas.v3.model.File;
import io.adminshell.aas.v3.model.IdentifierKeyValuePair;
import io.adminshell.aas.v3.model.Reference;

@JsonPropertyOrder({"defaultThumbnail", "globalAssetId", "assetKind", "billOfMaterials", "specificAssetIds"})
public interface AssetInformationMixin {

    @JacksonXmlProperty(namespace = AasXmlNamespaceContext.AAS_URI, localName = "assetKind")
    public AssetKind getAssetKind();

    @JacksonXmlProperty(namespace = AasXmlNamespaceContext.AAS_URI, localName = "assetKind")
    public void setAssetKind(AssetKind assetKind);

    @JacksonXmlProperty(namespace = AasXmlNamespaceContext.AAS_URI, localName = "globalAssetId")
    public Reference getGlobalAssetId();

    @JacksonXmlProperty(namespace = AasXmlNamespaceContext.AAS_URI, localName = "globalAssetId")
    public void setGlobalAssetId(Reference globalAssetId);

    @JacksonXmlProperty(namespace = AasXmlNamespaceContext.AAS_URI, localName = "specificAssetId")
    @JacksonXmlElementWrapper(namespace = AasXmlNamespaceContext.AAS_URI, localName = "specificAssetIds")
    public List<IdentifierKeyValuePair> getSpecificAssetIds();

    @JacksonXmlProperty(namespace = AasXmlNamespaceContext.AAS_URI, localName = "specificAssetId")
    @JacksonXmlElementWrapper(namespace = AasXmlNamespaceContext.AAS_URI, localName = "specificAssetIds")
    public void setSpecificAssetIds(List<IdentifierKeyValuePair> specificAssetIds);

    @JacksonXmlProperty(namespace = AasXmlNamespaceContext.AAS_URI, localName = "submodelRef")
    @JacksonXmlElementWrapper(namespace = AasXmlNamespaceContext.AAS_URI, localName = "billOfMaterials")
    public List<Reference> getBillOfMaterials();

    @JacksonXmlProperty(namespace = AasXmlNamespaceContext.AAS_URI, localName = "submodelRef")
    @JacksonXmlElementWrapper(namespace = AasXmlNamespaceContext.AAS_URI, localName = "billOfMaterials")
    public void setBillOfMaterials(List<Reference> billOfMaterials);

    @JacksonXmlProperty(namespace = AasXmlNamespaceContext.AAS_URI, localName = "defaultThumbNail")
    public File getDefaultThumbnail();

    @JacksonXmlProperty(namespace = AasXmlNamespaceContext.AAS_URI, localName = "defaultThumbNail")
    public void setDefaultThumbnail(File defaultThumbnail);
}