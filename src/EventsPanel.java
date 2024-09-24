import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.Duration;

public class EventsPanel extends JPanel {
    private Event event;
    private JButton completeButton;
    private JLabel nameLabel;
    private JLabel dateTimeLabel;
    private JLabel durationLabel;
    private JLabel locationLabel;
    private JLabel statusLabel;
    private String FONT = "Futura";

    public EventsPanel(Event event) {
        this.event = event;
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        //label for Event name
        nameLabel = new JLabel("Event: " + event.getName());
        nameLabel.setFont(new Font(FONT, Font.PLAIN, 20));
        add(nameLabel);

        //label for date
        dateTimeLabel = new JLabel("Date: " + event.getDateTime());
        dateTimeLabel.setFont(new Font(FONT, Font.PLAIN, 20));
        add(dateTimeLabel);

        if(event instanceof Meeting) {
            Meeting meeting = (Meeting) event;
            Duration duration = meeting.getDuration();
            durationLabel = new JLabel("Duration: " + duration.toMinutes() + " minutes");
            durationLabel.setFont(new Font(FONT, Font.PLAIN, 20));
            add(durationLabel);
        }

        if(event instanceof Meeting) {
            Meeting meeting = (Meeting) event;
            locationLabel = new JLabel("Location: " + meeting.getLocation());
            locationLabel.setFont(new Font(FONT, Font.PLAIN, 20));
            add(locationLabel);
        }

        if(event instanceof Completable completable) {

            String complete;

            if(completable.isComplete()) {
                complete = "Complete";
            }
            else {
                complete = "Not Complete";
            }
            statusLabel = new JLabel("Status: " + complete);
            statusLabel.setFont(new Font(FONT, Font.PLAIN, 20));
            add(statusLabel);

        }

        if (event instanceof Completable) {
            completeButton = new JButton("Complete");
            completeButton.addActionListener((new ActionListener() {

                public void actionPerformed(ActionEvent e) {
                    ((Completable) event).complete();

                    completeButton.setEnabled(false);
                    completeButton.setText("Complete");
                    repaint();
                    revalidate();
                }
            }));

            add(completeButton);
        }
    }



}
