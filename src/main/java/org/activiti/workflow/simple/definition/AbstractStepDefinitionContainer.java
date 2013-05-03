/* Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.activiti.workflow.simple.definition;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.activiti.bpmn.model.ActivitiListener;

/**
 * @author Joram Barrez
 */
@SuppressWarnings("unchecked")
public abstract class AbstractStepDefinitionContainer<T> implements StepDefinitionContainer<T> {
  
  protected List<StepDefinition> steps;
  
  public AbstractStepDefinitionContainer() {
    this.steps = new ArrayList<StepDefinition>();
  }
  
  public void addStep(StepDefinition stepDefinition) {
    steps.add(stepDefinition);
  }

  public List<StepDefinition> getSteps() {
    return steps;
  }
  
  // Human step

  public T addHumanStep(String name, String assignee) {
    return (T) addHumanStep(name, assignee, false);
  }

  public T addHumanStepForWorkflowInitiator(String name) {
    return (T) addHumanStep(name, null, true);
  }
  
  public T addHumanStep(String name, String assignee,String implementation) {
	  createHumanStepDefinition(name, assignee,implementation);
	    return (T) this;
   }
  
  public T addHumanStepForGroup(String name, List<String> groups) {
    HumanStepDefinition humanStepDefinition = createHumanStepDefinition(name);
    humanStepDefinition.setCandidateGroups(groups);
    return (T) this;
  }
  
  public T addHumanStepForGroup(String name, String...groups) {
    return addHumanStepForGroup(name, Arrays.asList(groups));
  }

  protected T addHumanStep(String name, String assignee, boolean initiator) {
    createHumanStepDefinition(name, assignee, initiator,null,null,null);
    return (T) this;
  }
 
  protected HumanStepDefinition createHumanStepDefinition(String name) {
    return createHumanStepDefinition(name, null);
  }
  
  protected HumanStepDefinition createHumanStepDefinition(String name, String assignee) {
    return createHumanStepDefinition(name, assignee, false,null,null,null);
  }
  
  protected HumanStepDefinition createHumanStepDefinition(String name, String assignee,String implementation) {
	   return createHumanStepDefinition(name, assignee, false,null,null,implementation);
  }
	 
  protected HumanStepDefinition createHumanStepDefinition(String name, String assignee, boolean initiator,String event, String implementationType,String implementation) {
    HumanStepDefinition humanStepDefinition = new HumanStepDefinition();
    if (name != null) {
      humanStepDefinition.setName(name);
    }
    if (assignee != null) {
      humanStepDefinition.setAssignee(assignee);
    }
    humanStepDefinition.setAssigneeIsInitiator(initiator);
    if(!(null==event&&null==implementationType&&null==implementation)){
    	addHumanListener(humanStepDefinition,event,implementationType,implementation);
    }
    addStep(humanStepDefinition);
    return humanStepDefinition;
  }
  //for the humanStep add human listener
  protected HumanStepDefinition addHumanListener(HumanStepDefinition humanStepDefinition,String event, String implementationType,String implementation) {
	  ActivitiListener activtiListener=new ActivitiListener();
	   if (event != null) {
		  activtiListener.setEvent(event);
	    }else{
	    	activtiListener.setEvent("complete");
	    }
	    if (implementationType != null) {
	    	activtiListener.setImplementationType(implementationType);
	    }else{
	    	activtiListener.setImplementationType("class");
	    }
	    if (implementation != null) {
	    	activtiListener.setImplementation(implementation);
	    }
	    if(null!=humanStepDefinition.getTaskListeners())
	    {    
	    	humanStepDefinition.getTaskListeners().add(activtiListener);
	    }else
	    {
	    	List<ActivitiListener>taskListeners=new ArrayList<ActivitiListener>();
	    	taskListeners.add(activtiListener);
	    	humanStepDefinition.setTaskListeners(taskListeners);
	    }
	    return humanStepDefinition;
	  }
  
  // Feedback step
  
  public T addFeedbackStep(String name, String initiator) {
    return addFeedbackStep(name, initiator, null);
  }
  
  public T addFeedbackStep(String name, String initiator, List<String> feedbackProviders) {
    FeedbackStepDefinition feedbackStepDefinition = new FeedbackStepDefinition();
    feedbackStepDefinition.setName(name);
    feedbackStepDefinition.setFeedbackInitiator(initiator);
    
    if (feedbackProviders != null) {
      feedbackStepDefinition.setFeedbackProviders(feedbackProviders);
    }
    
    addStep(feedbackStepDefinition);
    
    return (T) this;
  }
  
 /**
  *Script step
  */
  public T addScriptStep(String script) {
	  
    return addScriptStep(null, script);
  }
  public T addScriptStep(String name, String script) {
	    ScriptStepDefinition scriptStepDefinition = new ScriptStepDefinition();
	    scriptStepDefinition.setName(name);
	    scriptStepDefinition.setScript(script);
	    addStep(scriptStepDefinition); 
	    return (T) this;
	  }
  
  /**
   * Service step
   */
  
  public T addServiceTaskStep(String name) {
	  
	    return addScriptStep(name, null);
	  }
  public T addServiceTaskStep(String name, String className) {
	  ServiceTaskStepDefinition serviceTaskStepDefinition = new ServiceTaskStepDefinition();
	  serviceTaskStepDefinition.setName(name);
	  serviceTaskStepDefinition.setImplementation(className);
	  addStep(serviceTaskStepDefinition); 
	  return (T) this;
	  }
  
}
