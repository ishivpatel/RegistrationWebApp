package validators;

import com.registeration.beans.PersonalInformation;

public class PersonalInformationValidator {

	String errorMessage;
	public PersonalInformationValidator() {
		this.errorMessage = "";
	}

	public String validatePersonalInformation(PersonalInformation pinfo) {
		
		PersonalInformation information = pinfo;
		
		if (information.getFirstName() == null || information.getFirstName().equals("")) {
			errorMessage += "\nFirst Name is invalid ";
		} else if (information.getMiddleName() == null || information.getMiddleName().equals("")) {
			errorMessage += "\nMiddle Name is invalid";
		} else if (information.getLastName() == null || information.getLastName().equals("")) {
			errorMessage += "\nLast Name is invalid";
		} else if (information.getGender() == null || information.getGender().equals("")) {
			errorMessage += "\nGender is invalid";
		}
		
		return this.errorMessage;
	}
	
}
