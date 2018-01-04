/**
 * 
 */
package com.mobileiron.processing;

import com.mobileiron.exceptions.TLVException;
import com.mobileiron.readers.InputReader;

/**
 * @author jjikumar
 *
 */
public interface DataProcessing {
	
	public void setInputType(InputReader reader);

	public void processData() throws TLVException;
	
}
