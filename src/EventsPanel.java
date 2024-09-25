import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.Duration;
import java.time.format.DateTimeFormatter;

public class EventsPanel extends JPanel {
    private Event event;
    private JButton completeButton;
    private JLabel nameLabel;
    private JLabel dateLabel;
    private JLabel timeLabel;
    private JLabel durationLabel;
    private JLabel locationLabel;
    private JLabel statusLabel;
    private String FONT = "Futura";
    private static final Dimension LABEL_SIZE = new Dimension(200, 30);
    private static final Dimension PANEL_SIZE = new Dimension(400, 400);

    public EventsPanel(Event event) {
        this.event = event;

        setLayout(new FlowLayout());


        //label for Event name
        nameLabel = new JLabel("Event: " + event.getName());
        nameLabel.setFont(new Font(FONT, Font.PLAIN, 20));
        //nameLabel.setPreferredSize(LABEL_SIZE);
        add(nameLabel);

        //format date
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("MMM dd, yyyy");
        DateTimeFormatter timeFormat = DateTimeFormatter.ofPattern("hh:mm a");

        //format date as strings
        String formatDate = event.getDateTime().format(dateFormat);
        String formatTime = event.getDateTime().format(timeFormat);

        //label for date
        dateLabel = new JLabel("Date: " + formatDate);
        dateLabel.setFont(new Font(FONT, Font.PLAIN, 20));
       // dateLabel.setPreferredSize(LABEL_SIZE);
        add(dateLabel);

        //label for time
        timeLabel = new JLabel("Time: " + formatTime);
        timeLabel.setFont(new Font(FONT, Font.PLAIN, 20));
        //timeLabel.setPreferredSize(LABEL_SIZE);
        add(timeLabel);

        if (event instanceof Meeting) {
            Meeting meeting = (Meeting) event;
            Duration duration = meeting.getDuration();
            durationLabel = new JLabel("Duration: " + duration.toMinutes() + " minutes");
            durationLabel.setFont(new Font(FONT, Font.PLAIN, 20));
            //durationLabel.setPreferredSize(LABEL_SIZE);
            add(durationLabel);
        }

        if (event instanceof Meeting) {
            Meeting meeting = (Meeting) event;
            locationLabel = new JLabel("Location: " + meeting.getLocation());
            locationLabel.setFont(new Font(FONT, Font.PLAIN, 20));
            //locationLabel.setPreferredSize(LABEL_SIZE);
            add(locationLabel);
        }

        if (event instanceof Completable completable) {
            String complete;

            if (completable.isComplete()) {
                complete = "Complete";
            } else {
                complete = "Not Complete";
            }
            statusLabel = new JLabel("Status: " + complete);
            statusLabel.setFont(new Font(FONT, Font.PLAIN, 20));
           //statusLabel.setPreferredSize(LABEL_SIZE);
            add(statusLabel);

        }

        if (event instanceof Completable) {
            completeButton = new JButton("Complete");
            completeButton.addActionListener((new ActionListener() {

                public void actionPerformed(ActionEvent e) {
                    ((Completable) event).complete();

                    completeButton.setEnabled(false);
                }
            }));
            add(completeButton);

        }



    }



}
