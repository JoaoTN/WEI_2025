package br.jus.tst.esocial.validacao;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CheckDateValidator implements ConstraintValidator<CheckDate, String> {
	String[] dateFormat = null;

	@Override
	public void initialize(CheckDate constraintAnnotation) {
		dateFormat = constraintAnnotation.dateFormat();
	}

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		return validate(value);
	}

	private boolean validate(String dateString) {
    if (dateString == null || dateString.isEmpty()) {
        return true;
    }

    for (String format : dateFormat) {
        if (isValidFormat(dateString, format)) {
            return true;
        }
    }

    return false;
}

private boolean isValidFormat(String dateString, String format) {
    SimpleDateFormat sdf = new SimpleDateFormat(format);
    sdf.setLenient(false);

    try {
        sdf.parse(dateString);
        return true;
    } catch (ParseException e) {
        return false;
    }
}

	}

	private boolean validateFormat(String dateString, boolean valid, String format, String validFormat,
			String dateFormat) {

		if (!valid && (format.isEmpty() || validFormat.equalsIgnoreCase(format))) {
			valid = isValidDate(dateString, dateFormat);
		}
		
		return valid;
	}

	private boolean isValidDate(String dateString, String pattern) {
		boolean valid = true;
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		sdf.setLenient(false);
		try {
			sdf.parse(dateString.trim());
		} catch (ParseException e) {
			valid = false;
		}
		return valid;
	}
}