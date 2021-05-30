package services;

import dao.implementation.TicketDAO;
import entities.Ticket;

public class TicketService {

    TicketDAO ticketDAO = new TicketDAO();

    public Ticket save(Ticket ticket) {

        return ticketDAO.saveOrUpdate(ticket);
    }
}
