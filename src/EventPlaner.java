import javax.swing.*;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class EventPlaner {
    public static void main(String[] args) {


        final int WINDOW_WIDTH = 800;
        final int WINDOW_HEIGHT = 600;

        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("EventPlanner");
        frame.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);

        ArrayList<Event> events = new ArrayList<Event>();
        addDefaultEvents(events);

        EventListPanel eventListPanel = new EventListPanel(events);
        frame.add(eventListPanel);

        frame.setVisible(true);
    }

    public static void addDefaultEvents(ArrayList<Event> events) {
        int currentMonth = LocalDateTime.now().getMonthValue();
        int currentYear = LocalDateTime.now().getYear();
        int currentDay = LocalDateTime.now().getDayOfMonth();

        //default events
        events.add(new Meeting("Quarterly Meeting", LocalDateTime.of(currentYear,currentMonth,currentDay,4,41), LocalDateTime.of(currentYear,currentMonth,currentDay,5,41), "Office"));
        events.add(new Deadline("End of Quarter", LocalDateTime.of(currentYear,currentMonth,30,3,0)));


    }
}
