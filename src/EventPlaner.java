import javax.swing.*;
import java.awt.*;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class EventPlaner {
    public static void main(String[] args) {


        final int WINDOW_WIDTH = 1200;
        final int WINDOW_HEIGHT = 900;

        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("EventPlanner");
        frame.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);

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
        int currentHour = LocalDateTime.now().getHour();
        int currentMinute = LocalDateTime.now().getMinute();
        int oneHourAhead = LocalDateTime.now().plusHours(1).getHour();

        //default events
        events.add(new Meeting("Quarterly Meeting", LocalDateTime.of(currentYear,currentMonth,currentDay,currentHour,currentMinute), LocalDateTime.of(currentYear,currentMonth,currentDay,oneHourAhead, currentMinute), "Office"));
        events.add(new Deadline("End of Quarter", LocalDateTime.of(currentYear,currentMonth,30,16,0)));


    }

}
