package validators;

import com.registeration.beans.ContactInformation;

public class ContactInformationValidator {
	String errorMessage;
	public ContactInformationValidator() {
		this.errorMessage = "";
	}

	public String validateContactInformation(ContactInformation cinfo) {
		
		ContactInformation information = cinfo;
		
		if (information.getAddress() == null || information.getAddress().equals("")) {
			errorMessage += "Address is invalid";
		} else if (information.getCity() == null || information.getCity().equals("")) {
			errorMessage += "City is invalid";
		} else if (information.getState() == null || information.getState().equals("")) {
			errorMessage += "State is invalid";
		} else if (information.getZip() == null || information.getZip().equals("") || information.getZip().length()!= 5) {
			errorMessage += "Zip Code is invalid";
		}else if (information.getCountry() == null || information.getCountry().equals("")) {
			errorMessage += "Country is invalid";
		}else if (information.getPhone() == null || information.getPhone().equals("") || information.getPhone().length() != 10) {
			errorMessage += "Phone Number is invalid";
		}
		
		return this.errorMessage;
	}
}

