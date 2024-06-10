package ru.rsreu.VerbickayaStepanova03.resource;

import java.util.ResourceBundle;

public class ConfigurationManager {
	private final static ResourceBundle resourceBundle = ResourceBundle.getBundle("resources.config");

	// ����� ��������� ���������� �� ����� config.properties
	private ConfigurationManager() { }

	public static String getProperty(String key) {
		return resourceBundle.getString(key);
	}
}
