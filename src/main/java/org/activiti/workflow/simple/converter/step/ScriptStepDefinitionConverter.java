package org.activiti.workflow.simple.converter.step;

import org.activiti.bpmn.model.ScriptTask;
import org.activiti.workflow.simple.converter.ConversionConstants;
import org.activiti.workflow.simple.converter.WorkflowDefinitionConversion;
import org.activiti.workflow.simple.definition.ScriptStepDefinition;
import org.activiti.workflow.simple.definition.StepDefinition;

public class ScriptStepDefinitionConverter extends BaseStepDefinitionConverter<ScriptStepDefinition, ScriptTask> {
	
	private static final long serialVersionUID = 1L;
	  
	@Override
	public Class<? extends StepDefinition> getHandledClass() {

		 return ScriptStepDefinition.class;
	}
	
	@Override
	protected ScriptTask createProcessArtifact(ScriptStepDefinition stepDefinition,WorkflowDefinitionConversion conversion) {
		
	    ScriptTask scriptTask = new ScriptTask();
	    scriptTask.setId(conversion.getUniqueNumberedId(ConversionConstants.SCRIPT_TASK_ID_PREFIX));
	    scriptTask.setName(stepDefinition.getName());
	    scriptTask.setScript(stepDefinition.getScript());
	    
	    if (stepDefinition.getScriptLanguage() != null) {
	        scriptTask.setScriptFormat(stepDefinition.getScriptLanguage());
	      } else {
	        scriptTask.setScriptFormat("JavaScript");
	      }
	    addFlowElement(conversion,scriptTask,true);
	    
		return scriptTask;
	}
}
