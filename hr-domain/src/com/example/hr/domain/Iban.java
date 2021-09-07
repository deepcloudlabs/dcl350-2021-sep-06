package com.example.hr.domain;

import java.util.Objects;

@ValueObject
public final class Iban {
	private final String value;
	private static final long MAX = 999999999;
	private static final long MODULUS = 97;

	private Iban(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

	public static Iban of(String value) {
		Objects.requireNonNull(value);
		if (!isValid(value))
			throw new IllegalArgumentException("This is not a valid iban.");
		return new Iban(value);
	}

	private static boolean isValid(String value) {
		if (value == null || value.length() < 5) {
			return false;
		}
		try {
			int modulusResult = calculateModulus(value);
			return (modulusResult == 1);
		} catch (Exception ex) {
			return false;
		}
	}

	private static int calculateModulus(String code) throws Exception {
		String reformattedCode = code.substring(4) + code.substring(0, 4);
		long total = 0;
		for (int i = 0; i < reformattedCode.length(); i++) {
			int charValue = Character.getNumericValue(reformattedCode.charAt(i));
			if (charValue < 0 || charValue > 35) {
				throw new Exception("Invalid Character[" + i + "] = '" + charValue + "'");
			}
			total = (charValue > 9 ? total * 100 : total * 10) + charValue;
			if (total > MAX) {
				total = (total % MODULUS);
			}
		}
		return (int) (total % MODULUS);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((value == null) ? 0 : value.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Iban other = (Iban) obj;
		if (value == null) {
			if (other.value != null)
				return false;
		} else if (!value.equals(other.value))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Iban [value=" + value + "]";
	}

}
