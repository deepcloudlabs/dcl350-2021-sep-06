package com.example.hr.domain;

import java.util.Base64;
import java.util.Objects;

@ValueObject
public final class BiometricPhoto {
	private final byte[] values;

	private BiometricPhoto(byte[] values) {
		this.values = values;
	}

	public byte[] getValues() {
		return values;
	}

	public String getBase64Values() {
		return Base64.getEncoder().encodeToString(values);
	}

	public static BiometricPhoto valueOf(byte[] values) {
		Objects.requireNonNull(values);
		return new BiometricPhoto(values);
	}

	public static BiometricPhoto valueOf(String values) {
		Objects.requireNonNull(values);
		return new BiometricPhoto(Base64.getDecoder().decode(values));
	}

}
