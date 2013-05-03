package org.activiti.workflow.simple.listeners;

import org.activiti.engine.delegate.DelegateTask;
import org.activiti.engine.delegate.TaskListener;

public class HumanStepTwoListener implements TaskListener {

	@Override
	public void notify(DelegateTask delegateTask) {
		System.out.println("HumanStepTwoListener has call completed...");
		String name=(String) delegateTask.getExecution().getVariable("name");
		System.out.println("name= "+name);
		String age=(String) delegateTask.getExecution().getVariable("age");
		System.out.println("age= "+age);
	}

}
