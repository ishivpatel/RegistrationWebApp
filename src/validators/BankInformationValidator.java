package validators;

import com.registeration.beans.BankInformation;

public class BankInformationValidator {
	String errorMessage;
	public BankInformationValidator() {
		this.errorMessage = "";
	}

	public String validateBankInformation(BankInformation binfo) {
		
		BankInformation information = binfo;
		
		if (information.getBankname() == null || information.getBankname().equals("")) {
			errorMessage +="Bank Name is invalid";
		} else if (information.getAccountnumber() == null || information.getAccountnumber().equals("")) {
			errorMessage +="Account Number is invalid";
		} else if (information.getRoutingnumber() == null || information.getRoutingnumber().equals("")) {
			errorMessage +="Routing Number is invalid";
		} else if (information.getSsn() == null || information.getSsn().equals("")) {
			errorMessage +="SSN is invalid";
		}
		
		return this.errorMessage;
	}
}
