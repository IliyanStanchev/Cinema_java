package dao.implementation;

import dao.BaseDAO;
import entities.Ticket;

public class TicketDAO extends BaseDAO {

    public TicketDAO() {
        setClass(Ticket.class);
    }
}
