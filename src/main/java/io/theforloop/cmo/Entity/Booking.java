package io.theforloop.cmo.Entity;

import java.util.Set;

/**
 * @author Shubham
 */
public class Booking {
    private Schedule schedule;
    private String meetingRoom;
    private String subject;
    private String organizer;
    private Set<String> participants;

    public Schedule getSchedule() {
        return schedule;
    }
    public String getMeetingRoom() {
        return meetingRoom;
    }
    public void setMeetingRoom(String  meetingRoom) {
        this.meetingRoom = meetingRoom;
    }
    public void setSchedule(Schedule schedule) {
        this.schedule = schedule;
    }
    public String getSubject() {
        return subject;
    }
    public void setSubject(String subject) {
        this.subject = subject;
    }
    public String getOrganizer() {
        return organizer;
    }
    public void setOrganizer(String organizer) {
        this.organizer = organizer;
    }
    public Set<String> getParticipants() {
        return participants;
    }
    public void setParticipants(Set<String> participants) {
        this.participants = participants;
    }

    @Override
    public String toString() {
        return "Booking{" +
                "schedule=" + schedule +
                ", meetingRoom='" + meetingRoom + '\'' +
                ", subject='" + subject + '\'' +
                ", organizer='" + organizer + '\'' +
                ", participants=" + participants +
                '}';
    }
}
