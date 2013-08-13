/*
 * Created on 16-Jan-2009
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
package org.pdfsam.guiclient.utils;
/**
 * Conversion utility
 * @author HiTex 
 *
 */
public class ConversionUtility {

	public static final double INCH = 2.54d;
	public static final double CM = 0.393700787d;
	
	/**
	 * @param cm
	 * @return the inches value
	 */
	public static double toInches(double cm){
		return cm*CM;
	}
	
	/**
	 * @param inches
	 * @return the centimeters value
	 */
	public static double toCentimeters(double inches){
		return inches*INCH;
	}
}
