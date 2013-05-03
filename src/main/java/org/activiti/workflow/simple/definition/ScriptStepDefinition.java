package org.activiti.workflow.simple.definition;

public class ScriptStepDefinition extends AbstractNamedStepDefinition {

	private static final long serialVersionUID = 1L;
	  
	  protected String script;
	  protected String scriptLanguage;

	  public String getScript() {
	    return script;
	  }

	  public void setScript(String script) {
	    this.script = script;
	  }

	  public String getScriptLanguage() {
	    return scriptLanguage;
	  }

	  public void setScriptLanguage(String scriptLanguage) {
	    this.scriptLanguage = scriptLanguage;
	  }


}
