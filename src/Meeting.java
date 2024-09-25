import java.time.Duration;
import java.time.LocalDateTime;


public class Meeting extends Event implements Completable {

    //instance variables
    private LocalDateTime endTime;
    private String Location;
    private Duration Duration;
    private boolean complete;

    Meeting(String name, LocalDateTime start, LocalDateTime end, String location)
    {   this.setName(name);
        this.setDateTime(start);;
        this.endTime = end;
        this.Location = location;
        this.complete = false;
    }


    @Override
    public void complete(boolean complete) {
        this.complete = complete;
    }

    @Override
    public boolean isComplete() {
        return complete;
    }


    public LocalDateTime getEndDateTime() {
        return this.endTime;
    }

    public Duration getDuration() {
        return java.time.Duration.between(this.getDateTime(), getEndDateTime());
    }

    public String getLocation() {
        return Location;
    }

    public void setEndDateTime( LocalDateTime endDateTime ) {
        this.endTime = endDateTime;
    }

    public void setLocation(String Location) {
        this.Location = Location;
    }

}
