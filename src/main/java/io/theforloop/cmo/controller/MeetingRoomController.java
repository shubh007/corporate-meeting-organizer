package io.theforloop.cmo.controller;

import io.theforloop.cmo.Entity.MeetingRoom;
import io.theforloop.cmo.pojo.MeetingReq;
import io.theforloop.cmo.service.MeetingRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Shubham
 */
@RestController
public class MeetingRoomController {

    @Autowired
    private MeetingRoomService meetingRoomService;

    @PutMapping("/addMeetingRoom")
    public boolean addMeetingRoom(@RequestBody MeetingReq meetingReq){
        return meetingRoomService.addMeetingRoom(meetingReq);
    }

    @GetMapping("/getMeetingRooms")
    public List<MeetingRoom> getMeetingRooms(@RequestParam("date") String date,
                                             @RequestParam("start_time") String startTime,
                                             @RequestParam("end_time") String endTime,
                                             @RequestParam("capacity") int capacity){
        return meetingRoomService.getMeetingRooms(date,startTime,endTime,capacity);
    }

    @GetMapping("/getAllMeetingRooms")
    public List<MeetingRoom> getAllMeetingRooms(){
        return meetingRoomService.getMeetingRooms();
    }
}
