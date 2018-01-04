/**
 * 
 */
package com.mobileiron.processing;

import java.io.IOException;

import com.mobileiron.constants.AppConstants;
import com.mobileiron.exceptions.TLVException;
import com.mobileiron.readers.InputReader;
import com.mobileiron.readers.StandardInputReader;

/**
 * @author jjikumar
 *
 */
public class TLVProcessing implements DataProcessing {

	InputReader reader;
	
	public TLVProcessing() {
		super();
		StandardInputReader reader = new StandardInputReader();
		setInputType(reader);
	}
	
	public TLVProcessing(InputReader reader){
		super();
		setInputType(reader);
	}

	/* (non-Javadoc)
	 * @see com.mobileiron.processing.DataProcessing#setInputType(com.mobileiron.readers.InputReader)
	 */
	@Override
	public void setInputType(InputReader reader) {
		this.reader = reader;
	}

	/* (non-Javadoc)
	 * @see com.mobileiron.processing.DataProcessing#processData()
	 */
	@Override
	public void processData() throws TLVException{
		String data= "";
		try 
		{
			while((data = reader.readData()) !=null)
			{
				tokenizeInputData(data);
			}
		} catch (IOException e) {
			throw new TLVException("Failure in processing Data, Invalid format : "+e.getMessage());
		}

	}
	
	private void tokenizeInputData(String input){
		while(true)
		{
			input = input.trim();
			if(input.length()<1){
				return;
			}
			if(input.length()<= AppConstants.DEFAULT_FORMAT_TYPE_SIZE+AppConstants.DEFAULT_FORMAT_LENGHT_SIZE+1)
			{
				System.out.println(AppConstants.DISPLAY_TYPE_CODE_ERROR);
				return;
			}
			String code = input.substring(0, AppConstants.DEFAULT_FORMAT_TYPE_SIZE);
			Integer size = Integer.parseInt(input.substring(AppConstants.DEFAULT_FORMAT_LENGHT_SIZE+3, AppConstants.DEFAULT_FORMAT_TYPE_SIZE+AppConstants.DEFAULT_FORMAT_LENGHT_SIZE+1));
			String data = input.substring(AppConstants.DEFAULT_FORMAT_TYPE_SIZE+AppConstants.DEFAULT_FORMAT_LENGHT_SIZE+2);
			if(data.length()>=size){
				input = data.substring(size);
				data = data.substring(0, size);
				CoreProcessing.processAndPrintData(code, data);
			}else if(data.length()==size){
				input = "";
			}
		}
	}
}
