package org.activiti.workflow.simple.listeners;

import org.activiti.engine.delegate.DelegateTask;
import org.activiti.engine.delegate.TaskListener;

public class HumanStepOneListener implements TaskListener {
	@Override
	public void notify(DelegateTask delegateTask) {
		System.out.println("HumanStepOneListener has call completed...");
		String name=(String) delegateTask.getExecution().getVariable("name");
		System.out.println("name= "+name);
		String age=(String) delegateTask.getExecution().getVariable("age");
		System.out.println("age= "+age);
		delegateTask.getExecution().setVariable("age", "30");
	}
}
