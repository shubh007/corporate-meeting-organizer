package io.theforloop.cmo.controller;

import io.theforloop.cmo.Entity.Schedule;
import io.theforloop.cmo.pojo.BookingReq;
import io.theforloop.cmo.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Shubham
 */

@RestController
public class BookingController {

    @Autowired
    private BookingService bookingService;

    @PostMapping("/scheduleMeeting")
    public String scheduleMeeting(@RequestBody BookingReq bookingReq){
        return bookingService.scheduleMeeting(bookingReq);
    }

    @GetMapping("/getScheduleForMeetingRoom")
    public List<Schedule> getScheduleForMeetingRoom(@RequestParam String name,@RequestParam String date){
        return bookingService.getScheduleForMeetingRoom(name,date);
    }

    @GetMapping("/getScheduleForEmployee")
    public List<Schedule> getScheduleForEmployee(@RequestParam String emp, @RequestParam String date){
        return bookingService.getScheduleForEmployee(emp,date);
    }

}
