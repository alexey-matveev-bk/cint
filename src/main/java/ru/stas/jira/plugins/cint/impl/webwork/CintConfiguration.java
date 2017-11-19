package ru.stas.jira.plugins.cint.impl.webwork;

import com.atlassian.jira.web.action.JiraWebActionSupport;

import java.util.Enumeration;


public class CintConfiguration extends JiraWebActionSupport {




    @Override
    public String doExecute() {
        return SUCCESS;
    }

    public String doSave() {
        log.error("Entering doExecute");
        for (Enumeration e = request.getParameterNames(); e.hasMoreElements() ;) {
            String n = (String)e.nextElement();
            String[] vals = request.getParameterValues(n);
            log.error("name " + n + ": " + vals[0]);
        }

        return SUCCESS;
    }
}
