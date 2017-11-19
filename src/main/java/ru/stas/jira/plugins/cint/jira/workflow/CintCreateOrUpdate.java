package ru.stas.jira.plugins.cint.jira.workflow;

import java.util.Map;

import com.atlassian.jira.issue.MutableIssue;
import com.atlassian.jira.workflow.function.issue.AbstractJiraFunctionProvider;
import com.opensymphony.module.propertyset.PropertySet;
import com.opensymphony.workflow.WorkflowException;


/**
 * This is the post-function class that gets executed at the end of the transition.
 * Any parameters that were saved in your factory class will be available in the transientVars Map.
 */

public class CintCreateOrUpdate extends AbstractJiraFunctionProvider
{
    public static final String FIELD_MESSAGE = "jsonField";

    public void execute(Map transientVars, Map args, PropertySet ps) throws WorkflowException
    {
        MutableIssue issue = getIssue(transientVars);
        String message = (String) args.get(FIELD_MESSAGE);
        if (null == message) {
            message = "";
        }

        issue.setDescription(issue.getDescription() + message);
    }
}