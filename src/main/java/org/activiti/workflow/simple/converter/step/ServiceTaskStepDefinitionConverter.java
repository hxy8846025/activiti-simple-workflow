package org.activiti.workflow.simple.converter.step;

import org.activiti.bpmn.model.ServiceTask;
import org.activiti.workflow.simple.converter.ConversionConstants;
import org.activiti.workflow.simple.converter.WorkflowDefinitionConversion;
import org.activiti.workflow.simple.definition.ServiceTaskStepDefinition;
import org.activiti.workflow.simple.definition.StepDefinition;

public class ServiceTaskStepDefinitionConverter extends BaseStepDefinitionConverter<ServiceTaskStepDefinition, ServiceTask> {
	private static final long serialVersionUID = 1L;

	@Override
	public Class<? extends StepDefinition> getHandledClass() {
		// TODO Auto-generated method stub
		return ServiceTaskStepDefinition.class;
	}

	@Override
	protected ServiceTask createProcessArtifact(ServiceTaskStepDefinition stepDefinition,WorkflowDefinitionConversion conversion) {
		ServiceTask serviceTask=new ServiceTask();
		serviceTask.setId(conversion.getUniqueNumberedId(ConversionConstants.SERVICE_TASK_ID_PREFIX));
		serviceTask.setName(stepDefinition.getName());
		if (stepDefinition.getImplementationType() != null) {
			serviceTask.setImplementationType(stepDefinition.getImplementationType());
		      } else {
		    	  //default java class type
		    	  serviceTask.setImplementationType("class");
		  }
		serviceTask.setImplementation(stepDefinition.getImplementation());
		
		addFlowElement(conversion,serviceTask,true);
		
		return serviceTask;
	}

}
