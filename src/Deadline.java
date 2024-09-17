public class Deadline extends Event implements Completable {
    private boolean complete;

    public void complete() {
        this.complete = true;
    }

    public boolean isComplete() {
        return complete;
    }
}
