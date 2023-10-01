package com.example.hw1.controller;

import com.example.hw1.Ticket;
import com.example.hw1.dao.TicketDAO;
import com.example.hw1.service.TicketService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
public class TicketController {
    private TicketService ticketService = new TicketService();

    public TicketController() {
    }

    @GetMapping("/getAllTickets")
    public String getAllTickets() {
        return ticketService.getAllTickets();
    }

    @GetMapping("/getUnBookedTickets")
    public String getUnBookedTickets() {
        return ticketService.getUnBookedTickets();
    }

    @GetMapping("/getBookedTickets")
    public String getBookedTickets() {
        return ticketService.getBookedTickets();
    }

    @PostMapping("/ticketBooking")
    public String ticketBooking(@RequestBody Ticket body) {
        return ticketService.ticketBooking(body.getSrc(), body.getDest(), body.getDateTime());
    }

    @Override
    public String toString() {
        return "TicketController{" +
                "ticketService=" + ticketService +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TicketController that = (TicketController) o;
        return Objects.equals(ticketService, that.ticketService);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ticketService);
    }
}
