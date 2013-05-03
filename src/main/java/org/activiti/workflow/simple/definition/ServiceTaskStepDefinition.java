package org.activiti.workflow.simple.definition;

import java.util.ArrayList;
import java.util.List;

import org.activiti.bpmn.model.FieldExtension;

public class ServiceTaskStepDefinition extends AbstractNamedStepDefinition {

	private static final long serialVersionUID = 1L;
	
	  protected String type;
	
	  protected String implementationType;
	  
	  protected String implementation;
	  
	  protected String resultVariableName;
	  
	  protected List<FieldExtension> fieldExtensions = new ArrayList<FieldExtension>();

	public String getImplementationType() {
		return implementationType;
	}

	public void setImplementationType(String implementationType) {
		this.implementationType = implementationType;
	}

	public String getImplementation() {
		return implementation;
	}

	public void setImplementation(String implementation) {
		this.implementation = implementation;
	}

	public String getResultVariableName() {
		return resultVariableName;
	}

	public void setResultVariableName(String resultVariableName) {
		this.resultVariableName = resultVariableName;
	}

	public List<FieldExtension> getFieldExtensions() {
		return fieldExtensions;
	}

	public void setFieldExtensions(List<FieldExtension> fieldExtensions) {
		this.fieldExtensions = fieldExtensions;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
}
