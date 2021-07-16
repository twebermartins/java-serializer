package io.adminshell.aas.v3.dataformat.i4aas.mappers;

import java.util.List;

import org.opcfoundation.ua._2011._03.uanodeset.UAObject;
import org.opcfoundation.ua._2011._03.uanodeset.UAVariable;

import io.adminshell.aas.v3.dataformat.i4aas.mappers.utils.I4aasId;
import io.adminshell.aas.v3.dataformat.i4aas.mappers.utils.MappingContext;
import io.adminshell.aas.v3.model.ModelingKind;
import io.adminshell.aas.v3.model.Property;
import io.adminshell.aas.v3.model.Submodel;
import io.adminshell.aas.v3.model.SubmodelElement;
import io.adminshell.aas.v3.model.SubmodelElementCollection;

public class SubmodelMapper extends IdentifiableMapper<Submodel> {

	public SubmodelMapper(Submodel src, MappingContext ctx) {
		super(src, ctx);
	}

	@Override
	protected UAObject createTargetObject() {
		super.createTargetObject();
		addTypeReference(I4aasId.AASSubmodelType);
		return target;
	}

	@Override
	protected void mapAndAttachChildren() {
		super.mapAndAttachChildren();

		ModelingKind kind = source.getKind();
		UAVariable mappedKind = new I4AASEnumMapper(kind, ctx).map();
		attachAsProperty(target, mappedKind);

		List<SubmodelElement> submodelElements = source.getSubmodelElements();
		for (SubmodelElement submodelElement : submodelElements) {
			if (submodelElement instanceof io.adminshell.aas.v3.model.Capability) {
				throw new UnsupportedOperationException(
						"mapping not implemented for " + submodelElement.getClass().getName());
			}
			if (submodelElement instanceof io.adminshell.aas.v3.model.Blob) {
				throw new UnsupportedOperationException(
						"mapping not implemented for " + submodelElement.getClass().getName());

			}
			if (submodelElement instanceof io.adminshell.aas.v3.model.File) {
				throw new UnsupportedOperationException(
						"mapping not implemented for " + submodelElement.getClass().getName());

			}
			if (submodelElement instanceof io.adminshell.aas.v3.model.MultiLanguageProperty) {
				throw new UnsupportedOperationException(
						"mapping not implemented for " + submodelElement.getClass().getName());

			}
			if (submodelElement instanceof io.adminshell.aas.v3.model.Property) {
				UAObject UAprop = new PropertyMapper((Property) submodelElement, ctx).map();
				attachAsComponent(target, UAprop);
			}
			if (submodelElement instanceof io.adminshell.aas.v3.model.Range) {
				throw new UnsupportedOperationException(
						"mapping not implemented for " + submodelElement.getClass().getName());

			}
			if (submodelElement instanceof io.adminshell.aas.v3.model.ReferenceElement) {
				throw new UnsupportedOperationException(
						"mapping not implemented for " + submodelElement.getClass().getName());

			}
			if (submodelElement instanceof io.adminshell.aas.v3.model.Entity) {
				throw new UnsupportedOperationException(
						"mapping not implemented for " + submodelElement.getClass().getName());

			}
			if (submodelElement instanceof io.adminshell.aas.v3.model.Event) {
				throw new UnsupportedOperationException(
						"mapping not implemented for " + submodelElement.getClass().getName());

			}
			if (submodelElement instanceof io.adminshell.aas.v3.model.EventElement) {
				throw new UnsupportedOperationException(
						"mapping not implemented for " + submodelElement.getClass().getName());

			}

			if (submodelElement instanceof io.adminshell.aas.v3.model.EventMessage) {
				throw new UnsupportedOperationException(
						"mapping not implemented for " + submodelElement.getClass().getName());

			}
			if (submodelElement instanceof io.adminshell.aas.v3.model.Operation) {
				throw new UnsupportedOperationException(
						"mapping not implemented for " + submodelElement.getClass().getName());

			}
			if (submodelElement instanceof io.adminshell.aas.v3.model.RelationshipElement) {
				throw new UnsupportedOperationException(
						"mapping not implemented for " + submodelElement.getClass().getName());

			}
			if (submodelElement instanceof io.adminshell.aas.v3.model.SubmodelElementCollection) {
				UAObject UAprop = new SubmodelElementCollectionMapper((SubmodelElementCollection) submodelElement, ctx).map();
				attachAsComponent(target, UAprop);
			}
			if (submodelElement instanceof io.adminshell.aas.v3.model.Capability) {
				throw new UnsupportedOperationException(
						"mapping not implemented for " + submodelElement.getClass().getName());

			}
			if (submodelElement instanceof io.adminshell.aas.v3.model.Capability) {
				throw new UnsupportedOperationException(
						"mapping not implemented for " + submodelElement.getClass().getName());

			}
			if (submodelElement instanceof io.adminshell.aas.v3.model.Capability) {
				throw new UnsupportedOperationException(
						"mapping not implemented for " + submodelElement.getClass().getName());

			}
			if (submodelElement instanceof io.adminshell.aas.v3.model.Capability) {
				throw new UnsupportedOperationException(
						"mapping not implemented for " + submodelElement.getClass().getName());

			}
		}
	}

}
