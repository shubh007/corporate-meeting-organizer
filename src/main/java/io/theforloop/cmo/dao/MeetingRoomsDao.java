package io.theforloop.cmo.dao;

import io.theforloop.cmo.Entity.MeetingRoom;
import io.theforloop.cmo.Entity.Schedule;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author Shubham
 */

@Component
public class MeetingRoomsDao {
    private static Map<String , MeetingRoom> meetingRoomsMap = new HashMap<>();

    public MeetingRoom addOrUpdateMeetingRoom(MeetingRoom meetingRoom){
        meetingRoomsMap.put(meetingRoom.getName(),meetingRoom);
        return meetingRoom;
    }
    public MeetingRoom getMeetingRoom(String meetingRoom){
        return meetingRoomsMap.get(meetingRoom);
    }
    public List<MeetingRoom> getAvailableMeetingRoomsWithMinCapacity(int capacity, Schedule schedule){
        return meetingRoomsMap.values().stream()
                .filter(room -> room.getCapacity() >= capacity && room.isAvailable(schedule))
                .collect(Collectors.toList());
    }
    public List<MeetingRoom> getAllMeetingRooms(){
        return new ArrayList<>(meetingRoomsMap.values());
    }

}
