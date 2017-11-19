package ru.stas.jira.plugins.cint.impl.webwork;

import com.atlassian.jira.web.action.JiraWebActionSupport;

public class CintConfiguration extends JiraWebActionSupport {

    @Override
    public String doExecute() {
        return SUCCESS;
    }
}
