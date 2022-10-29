package services;

import models.CardDetails;
import models.Ticket;

public interface PaymentService {

	public Double getCharges(Ticket Ticket);
	public boolean makePayment(CardDetails card);
}
