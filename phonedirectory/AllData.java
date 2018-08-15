
public class AllData {

	private String first_N;

	private String last_N;

	private String digits;

	public AllData() {

	}

	public AllData(String F, String L, String P) {
		first_N = F;

		last_N = L;

		digits = P;
	}

	public void setFirstName(String setFirstName) {
		first_N = setFirstName;

	}

	public void setLastName(String setLastName) {

		last_N = setLastName;
	}

	public void setDigits(String pDigits) {
		digits = pDigits;
	}

	public String getFirst() {
		return first_N;
	}

	public String getLast() {
		return last_N;
	}

	public String getDigits() {
		return digits;
	}
}
