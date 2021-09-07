package com.example.hr.domain.event;

import com.example.hr.domain.FullName;
import com.example.hr.domain.TcKimlikNo;

/**
 * 
 * @author Binnur Kurt <binnur.kurt@gmail.com>
 *
 */
public class EmployeeHiredEvent extends DomainEvent {

	private final TcKimlikNo identity;
	private final FullName fullName;

	public EmployeeHiredEvent(TcKimlikNo identity, FullName fullName) {
		this.identity = identity;
		this.fullName = fullName;
	}

	public TcKimlikNo getIdentity() {
		return identity;
	}

	public FullName getFullName() {
		return fullName;
	}

	@Override
	public String toString() {
		return "EmployeeHiredEvent [identity=" + identity + ", fullName=" + fullName + ", eventId=" + getEventId()
				+ ", sequence=" + getSequence() + ", timestamp=" + getTimestamp() + "]";
	}

}
