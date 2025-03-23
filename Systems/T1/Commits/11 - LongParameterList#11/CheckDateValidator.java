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
    if (value == null || value.isEmpty()) {
        return true;
    }
    return validate(value);
}

private boolean validate(String dateString) {
    for (String format : dateFormat) {
        boolean valid = validateFormat(dateString, format, "DD-MM-YYYY", "dd-MM-yyyy") ||
                        validateFormat(dateString, format, "YYYY-MM", "yyyy-MM") ||
                        validateFormat(dateString, format, "YYYY", "yyyy");
        if (valid) {
            return true;
        }
    }
    return false;
}

private boolean validateFormat(String dateString, String format, String... patterns) {
    for (String pattern : patterns) {
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        sdf.setLenient(false);
        try {
            sdf.parse(dateString);
            return true;
        } catch (ParseException e) {
            // Continua para o próximo padrão de formato
        }
    }
    return false;
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