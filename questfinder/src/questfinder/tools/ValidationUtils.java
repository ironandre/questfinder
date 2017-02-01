package questfinder.tools;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidationUtils {
	public static final Pattern VALID_EMAIL_ADDRESS_REGEX = 
		    Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);

		public static boolean matchesEmailPattern(String emailStr) {
			emailStr = emailStr == null ? "" : emailStr; 
		    Matcher matcher = VALID_EMAIL_ADDRESS_REGEX .matcher(emailStr);
		    return matcher.find();
		}
		public static void main(String[] args) {
			System.out.println(matchesEmailPattern("andre.hehn@web.de"));
		}
}
