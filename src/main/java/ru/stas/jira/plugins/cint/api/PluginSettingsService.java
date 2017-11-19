package ru.stas.jira.plugins.cint.api;

public interface PluginSettingsService {
    public void setSettingValue(String setting, String value);
    public String getSettingValue(String setting);
}
