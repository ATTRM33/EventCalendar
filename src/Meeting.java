import java.time.LocalDateTime;
import java.util.Date;

public class Meeting extends Event implements Completable {
    private Date endDateTime = new Date();
    private String Location;

    public void complete() {
        this.complete = true;
    }

    @Override
    public boolean isComplete() {
        return true;
    }

    public boolean isCompleted() {
        return true;
    }

    public Date getEndTime() {
        return endDateTime;
    }

    public int getDuration() {
        //startTime object
        Date startTime = new Date();

        return (int)(startTime.getTime() - endDateTime.getTime());
    }

    public String getLocation() {
        return Location;
    }

    public void setEndTime(Date endDateTime) {
        this.endDateTime = endDateTime;
    }

    public void setLocation(String Location) {
        this.Location = Location;
    }


}
