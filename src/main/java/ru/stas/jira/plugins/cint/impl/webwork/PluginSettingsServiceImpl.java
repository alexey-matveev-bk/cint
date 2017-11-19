package ru.stas.jira.plugins.cint.impl.webwork;

import com.atlassian.plugin.spring.scanner.annotation.imports.ComponentImport;
import com.atlassian.sal.api.pluginsettings.PluginSettings;
import com.atlassian.sal.api.pluginsettings.PluginSettingsFactory;
import ru.stas.jira.plugins.cint.api.PluginSettingsService;

import javax.inject.Inject;
import javax.inject.Named;

@Named
public class PluginSettingsServiceImpl implements PluginSettingsService{

    private final PluginSettingsFactory pluginSettingsFactory;
    private static final String PLUGIN_STORAGE_KEY = "ru.stas.jira.plugins.cint.cint";


    @Inject
    public PluginSettingsServiceImpl(@ComponentImport PluginSettingsFactory pluginSettingsFactory) {
        this.pluginSettingsFactory = pluginSettingsFactory;
    }

    public void setSettingValue(String setting, String value) {
        PluginSettings pluginSettings = pluginSettingsFactory.createGlobalSettings();
        if (value != null && setting != null) {
            pluginSettings.put(PLUGIN_STORAGE_KEY + setting, value);
        }
    }

    public String getSettingValue(String setting) {
        PluginSettings pluginSettings = pluginSettingsFactory.createGlobalSettings();
        if (pluginSettings.get(PLUGIN_STORAGE_KEY + setting) != null) {
            return pluginSettings.get(PLUGIN_STORAGE_KEY + setting).toString();
        }
        return "";
    }
}
