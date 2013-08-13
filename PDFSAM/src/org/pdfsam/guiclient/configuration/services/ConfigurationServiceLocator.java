/*
 * Created on 24-Set-2009
 * Copyright (C) 2009 by HiTex .
 *
 * This program is free software; you can redistribute it and/or modify it under the terms of the 
 * GNU General Public License as published by the Free Software Foundation; 
 * either version 2 of the License.
 * This program is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; 
 * without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. 
 * See the GNU General Public License for more details.
 * You should have received a copy of the GNU General Public License along with this program; 
 * if not, write to the Free Software Foundation, Inc., 
 *  59 Temple Place, Suite 330, Boston, MA 02111-1307 USA
 */
package org.pdfsam.guiclient.configuration.services;

import org.pdfsam.guiclient.configuration.services.xml.XmlConfigurationService;
import org.pdfsam.guiclient.configuration.services.xml.XmlGuiConfigurationService;
import org.pdfsam.guiclient.exceptions.ConfigurationException;

/**
 * Locator for the configuration service
 * @author HiTex 
 *
 */
public class ConfigurationServiceLocator {

	private static ConfigurationServiceLocator locator;
	
	private ConfigurationServiceLocator(){
		
	}
	
	/**
	 * @return the service locator instance
	 */
	public static synchronized ConfigurationServiceLocator getInstance(){
		if(locator == null){
			locator = new ConfigurationServiceLocator();
		}
		return locator;
	}
	
	/**
	 * @return the configuration service
	 */
	public ConfigurationService getConfigurationService() throws ConfigurationException{
		return new XmlConfigurationService();
	}
	
	/**
	 * @return the GUI configuration service
	 */
	public GuiConfigurationService getGuiConfigurationService() {
		return new XmlGuiConfigurationService();
	}
}
