package ru.netology;

public class Ticket implements Comparable<Ticket> {
  int id;
  int price;
  String from;
  String to;
  int travelTime;

  public Ticket(int id, int price, String from, String to, int travelTime) {
    this.id = id;
    this.price = price;
    this.from = from;
    this.to = to;
    this.travelTime = travelTime;
  }

  @Override
  public int compareTo(Ticket o) {
    return Integer.compare(this.price, o.price);
  }

  public int getId() {
    return id;
  }

  public String getDepartureAirport() {
    return from;
  }

  public String getArrivalAirport() {
    return to;
  }

  public boolean matches(String from, String to) {
    if (getDepartureAirport().contains(from)) {
      return getArrivalAirport().contains(to);
    } else return false;
  }

  public int getTravelTime() {
    return travelTime;
  }
}
