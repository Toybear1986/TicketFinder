package ru.netology;

public class TicketRepository {
  protected Ticket[] tickets = new Ticket[0];

  public Ticket[] getTickets() {
    return tickets;
  }

  public void addTicket(Ticket ticket) {
    Ticket[] tmp = new Ticket[tickets.length + 1];
    System.arraycopy(tickets, 0, tmp, 0, tickets.length);
    tmp[tmp.length - 1] = ticket;
    tickets = tmp;
  }

  public Ticket findById(int id) {
    for (Ticket product : tickets) {
      if (id == product.getId()) {
        return product;
      }
    }
    return null;
  }

  public void removeTicketById(int id) {
    if (findById(id) == null) {
      throw new NotFoundException(
              "Element with id: " + id + " not found"
      );
    }
    Ticket[] tmp = new Ticket[tickets.length - 1];
    int copyToIndex = 0;
    for (Ticket Ticket : tickets) {
      if (Ticket.getId() != id) {
        tmp[copyToIndex] = Ticket;
        copyToIndex++;
      }
    }
    tickets = tmp;
  }
}
