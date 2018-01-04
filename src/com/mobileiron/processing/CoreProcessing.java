package com.mobileiron.processing;

import com.mobileiron.constants.AppConstants;

public class CoreProcessing {

	static void processAndPrintData(String code, String data) {
		if (AppConstants.TLVTypeCodes.REPLCE.toString().equals(code)) {
			System.out.println(AppConstants.TLVTypeCodes.REPLCE+"-"+AppConstants.DISPLAY_TYPE_CODE_REPLACE);
		} else if (AppConstants.TLVTypeCodes.UPPRCS.toString().equals(code)) {
			System.out.println(AppConstants.TLVTypeCodes.UPPRCS + "-" + data.toUpperCase());
		} else {
			System.out.println(AppConstants.DISPLAY_TYPE_CODE_ERROR);
		}
	}
}
