import java.time.LocalDateTime;
import java.time.LocalTime;

public abstract class Event implements Comparable<Event> {
    private String name;;
    private LocalDateTime eventStartDateTime;

    public String getName(){

        return name;
    }

    public LocalDateTime getDateTime(){

        return this.eventStartDateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {

        this.eventStartDateTime = dateTime;
    }

    public void setName(String name){
        this.name = name;
    }

    public int compareTo(Event e) {
        return this.eventStartDateTime.compareTo(e.eventStartDateTime);
    }
}
