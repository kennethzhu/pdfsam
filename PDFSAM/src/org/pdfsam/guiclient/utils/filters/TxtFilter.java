/*
 * Created on 15-Nov-2007
 * Copyright (C) 2006 by HiTex .
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
package org.pdfsam.guiclient.utils.filters;

/**
 * Filter for the JFileChooser
 * 
 * @author HiTex 
 * 
 */
public class TxtFilter extends AbstractFileFilter {

	private static final String FILE_EXTENSION = "txt";

	public TxtFilter() {
		super();
	}

	public TxtFilter(boolean acceptDirectory) {
		super(acceptDirectory);
	}

	public String getAcceptedExtension() {
		return FILE_EXTENSION;
	}

	public String getDescription() {
		return "txt files";
	}

}
