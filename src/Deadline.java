import java.time.LocalDateTime;

public class Deadline extends Event implements Completable {

    private boolean complete;

    Deadline(String name, LocalDateTime deadline) {
        this.setName(name);
        this.setDateTime(deadline);
    }

    @Override
    public void complete(boolean complete) {
        this.complete = complete;
    }

    public boolean isComplete() {
        return complete;
    }


}
