package ru.netology;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ManagerTest {
  TicketRepository repository = new TicketRepository();
  TicketManager manager = new TicketManager(repository);

  Ticket ticket1 = new Ticket(1, 10_000, "DME", "KZN", 95);
  Ticket ticket2 = new Ticket(2, 9_500, "SVO", "KZN", 90);
  Ticket ticket3 = new Ticket(3, 5_000, "DME", "KZN", 190);
  Ticket ticket4 = new Ticket(4, 5_000, "SVO", "KZN", 180);
  Ticket ticket5 = new Ticket(5, 15_000, "DME", "TJM", 180);
  Ticket ticket6 = new Ticket(6, 9_500, "SVO", "KZN", 175);
  Ticket ticket7 = new Ticket(7, 20_000, "KZN", "TJM", 210);
  Ticket ticket8 = new Ticket(8, 20_000, "TJM", "KZN", 210);
  Ticket ticket9 = new Ticket(9, 10_000, "KZN", "DME", 95);
  Ticket ticket10 = new Ticket(10, 9_500, "KZN", "SVO", 90);
  Ticket ticket11 = new Ticket(11, 2_500, "SVO", "KZN", 380);

  @BeforeEach
  public void addTickets() {
    repository.addTicket(ticket1);
    repository.addTicket(ticket2);
    repository.addTicket(ticket3);
    repository.addTicket(ticket4);
    repository.addTicket(ticket5);
    repository.addTicket(ticket6);
    repository.addTicket(ticket7);
    repository.addTicket(ticket8);
    repository.addTicket(ticket9);
    repository.addTicket(ticket10);
    repository.addTicket(ticket11);
  }

  @Test
  public void testFindTickets() {

    Ticket[] expectedArray1 = {ticket3, ticket1};
    Assertions.assertArrayEquals(expectedArray1, manager.findAll("DME", "KZN"));

    Ticket[] expectedArray2 = {ticket11, ticket4, ticket2, ticket6};
    Assertions.assertArrayEquals(expectedArray2, manager.findAll("SVO", "KZN"));

    Ticket[] expectedArray3 = {};
    Assertions.assertArrayEquals(expectedArray3, manager.findAll("TJM", "DME"));

    Ticket[] expectedArray4 = {ticket8};
    Assertions.assertArrayEquals(expectedArray4, manager.findAll("TJM", "KZN"));
  }

  @Test
  public void testComparator() {
    TicketByTravelTimeComparator comparator = new TicketByTravelTimeComparator();
    Ticket[] expectedArray1 = {ticket1, ticket3};
    Assertions.assertArrayEquals(expectedArray1, manager.findAll("DME", "KZN",comparator));

    Ticket[] expectedArray2 = {ticket2, ticket6, ticket4, ticket11};
    Assertions.assertArrayEquals(expectedArray2, manager.findAll("SVO", "KZN",comparator));

    Ticket[] expectedArray3 = {};
    Assertions.assertArrayEquals(expectedArray3, manager.findAll("TJM", "DME",comparator));

    Ticket[] expectedArray4 = {ticket8};
    Assertions.assertArrayEquals(expectedArray4, manager.findAll("TJM", "KZN",comparator));
  }
}
