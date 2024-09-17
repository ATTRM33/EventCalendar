import java.util.Date;

public abstract class Event {
    private String name;
    private Date dateTime = new Date();

    public String getName(){
        return name;
    }

    public Date getDateTime(){
        return dateTime;
    }

    public void setDateTime(Date dateTime) {
        this.dateTime = dateTime;
    }

    public void setName(String name){
        this.name = name;
    }

    public int compareTo(Event e) {
        return this.dateTime.compareTo(e.dateTime);
    }
}
