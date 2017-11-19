package ru.stas.jira.plugins.cint.impl.webwork;

import com.atlassian.jira.web.action.JiraWebActionSupport;
import ru.stas.jira.plugins.cint.api.PluginSettingsService;

import javax.inject.Inject;
import javax.inject.Named;

@Named
public class CintConfiguration extends JiraWebActionSupport {

    private static final String CINT_URL = "cinturl";
    private static final String CINT_USER_NAME = "cintusername";
    private static final String CINT_WORD = "cintpassword";
    private transient final PluginSettingsService pluginSettingsService;

    @Inject
    public CintConfiguration(PluginSettingsService pluginSettingsService) {
        this.pluginSettingsService = pluginSettingsService;
    }


    @Override
    public String doExecute() {
        return SUCCESS;
    }

    public String doSave() {

       pluginSettingsService.setSettingValue(CINT_URL, this.getParameter(CINT_URL));
       pluginSettingsService.setSettingValue(CINT_USER_NAME, this.getParameter(CINT_USER_NAME));
       pluginSettingsService.setSettingValue(CINT_WORD, this.getParameter(CINT_WORD));
       return SUCCESS;
    }

    private String getParameter(String key) {
        String[] strings;
        if (this.getHttpRequest().getParameterMap().get(key) !=null) {
            strings = this.getHttpRequest().getParameterMap().get(key);
            if (strings.length > 0) {
                return strings[0];
            }
        }
        return null;
    }

    public String getCinturl() {
       return pluginSettingsService.getSettingValue(CINT_URL);
    }
    public String getCintusername() {
       return pluginSettingsService.getSettingValue(CINT_USER_NAME);
    }
    public String getCintpassword() {
        return pluginSettingsService.getSettingValue(CINT_WORD);
    }
}
