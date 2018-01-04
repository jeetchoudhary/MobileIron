/**
 * 
 */
package com.mobileiron.readers;

import java.io.IOException;

/**
 * @author jjikumar
 *
 */
public interface InputReader {

	public String readData() throws IOException;
	public Boolean hasMoreData() throws IOException;
}
