import java.time.LocalDateTime;

public class Deadline extends Event implements Completable {

    private boolean complete;

    Deadline(String name, LocalDateTime deadline) {
        this.setName(name);
        this.setDateTime(deadline);
    }

    public void complete() {
        this.complete = false;
    }

    public boolean isComplete() {
        return complete;
    }

    public String details(){
        return "Deadline: " + getName() + " by " + getDateTime();
    }
}
