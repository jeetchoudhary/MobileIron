package com.mobileiron.client;

import com.mobileiron.exceptions.TLVException;
import com.mobileiron.processing.TLVProcessing;

public class TLVProcessingClient {


	public static void main(String[] args) throws TLVException {
		TLVProcessing client = new TLVProcessing();
		client.processData();
	}
}
