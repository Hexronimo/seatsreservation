package com.github.hexronimo.seatsreservation.web.application;

import com.github.hexronimo.seatsreservation.business.service.ReservationService;
import com.github.hexronimo.seatsreservation.data.entity.Customer;
import com.github.hexronimo.seatsreservation.data.entity.EventHappen;
import com.github.hexronimo.seatsreservation.data.entity.Reservation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;

@Controller
@RequestMapping(value = "/")
public class WebController {

    @Autowired
    private ReservationService reservationService;

    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String eventForm(Model model){
        model.addAttribute("rooms",  reservationService.getRooms());
        model.addAttribute("events", reservationService.getEvents());
        return "add";
    }

    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String eventPost(EventHappen eventHappen, Model model){
        reservationService.saveHappen(eventHappen);
        model.addAttribute("to", eventHappen.getDateStart());
        model.addAttribute("from", eventHappen.getDateStart());
        model.addAttribute("happens",reservationService.getFromPeriod(eventHappen.getDateStart(), eventHappen.getDateEnd()));
        return "events";
    }


    @RequestMapping(value = "events", method = RequestMethod.GET)
    public String getHappens(Model model, @RequestParam(required = false) String from, @RequestParam(required = false) String to){
        LocalDate fromDate = null;
        if (from != null && !from.equals("")) {
            fromDate = LocalDate.parse(from);
        }
        LocalDate toDate = null;
        if (to != null && !to.equals("")) {
            toDate = LocalDate.parse(to);
        }

        if(from != null || to != null) {
            if (toDate == null) {
                toDate = fromDate;
            } else if (fromDate == null) {
                fromDate = LocalDate.now();
            }
        }

        if (fromDate != null && toDate != null) {
            model.addAttribute("to", toDate);
            model.addAttribute("from", fromDate);
            model.addAttribute("happens", reservationService.getFromPeriod(fromDate, toDate));

            /*
            Only for test. Generates "Reservations"
            Delete next line if used with real database and data entered by user.
            It's made to add all seats from "Happen" table to "Reservation" table, needed only for pre-generated SQL (if resources/data.sql used).
            */
            reservationService.getFromPeriod(fromDate, toDate).forEach(e -> reservationService.saveHappen(e) );
        }

        return "events";
    }

    @RequestMapping(value = "seats", method = RequestMethod.GET)
    public String getSeats(@RequestParam Long id, Model model) {
        model.addAttribute("reservations", reservationService.getReservationsForHappen(id));
        model.addAttribute("happen", reservationService.getHappen(id).get());
        return "seats";
    }

    @RequestMapping(value = "reserve", method = RequestMethod.GET)
    public String getReserve(@RequestParam Long id, Model model) {
        model.addAttribute("reservation", reservationService.getReservation(id).get());
        return "reserve";
    }

    @RequestMapping(value = "reserve", method = RequestMethod.POST)
    public String postReserve(@RequestParam String postId, Customer customer, Model model) {
        if (customer != null) {
            Long id = Long.parseLong(postId);
            if (reservationService.getReservation(id).isPresent()){
                Reservation reservation = reservationService.getReservation(id).get();

                if (reservationService.getReservation(id).get().getCustomer() == null) {
                    reservation.setCustomer(customer);
                    reservationService.saveReservation(reservation);
                    model.addAttribute("reservation", reservationService.getReservation(id).get());
                    return "reservation-successful";
                } else {
                    model.addAttribute("happenId", reservationService.getReservation(id).get().getEventHappen().getId());
                    return "reservation-failed";
                }
            }
        }
        return "reservation-failed"; // something else needed here
    }
}
