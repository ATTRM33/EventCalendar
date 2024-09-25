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
    private static final Dimension PANEL_SIZE = new Dimension(300, 200);

    public EventsPanel(Event event) {

        this.event = event;

        //change panel colors based on deadline or meeting
        if (event instanceof Meeting) {
            setBackground(Color.BLUE);
            setBorder(BorderFactory.createLineBorder(Color.WHITE));

        } else if (event instanceof Deadline) {
            setBackground(Color.RED);
            setBorder(BorderFactory.createLineBorder(Color.WHITE));
        }

        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setPreferredSize(PANEL_SIZE);
        setMaximumSize(PANEL_SIZE);
        setMinimumSize(PANEL_SIZE);

        //label for Event name
        nameLabel = new JLabel(event.getName());
        nameLabel.setFont(new Font(FONT, Font.PLAIN, 20));
        nameLabel.setForeground(Color.WHITE);
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
        dateLabel.setForeground(Color.WHITE);
        add(dateLabel);

        //label for time
        timeLabel = new JLabel("Time: " + formatTime);
        timeLabel.setFont(new Font(FONT, Font.PLAIN, 20));
        timeLabel.setForeground(Color.WHITE);
        add(timeLabel);

        if (event instanceof Meeting) {
            Meeting meeting = (Meeting) event;
            Duration duration = meeting.getDuration();
            durationLabel = new JLabel("Duration: " + duration.toMinutes() + " minutes");
            durationLabel.setFont(new Font(FONT, Font.PLAIN, 20));
            durationLabel.setForeground(Color.WHITE);
            add(durationLabel);
        }

        if (event instanceof Meeting) {
            Meeting meeting = (Meeting) event;
            locationLabel = new JLabel("Location: " + meeting.getLocation());
            locationLabel.setFont(new Font(FONT, Font.PLAIN, 20));
            locationLabel.setForeground(Color.WHITE);
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
            statusLabel.setForeground(Color.WHITE);
            add(statusLabel);

        }

        if (event instanceof Completable) {
            completeButton = new JButton("Complete");
            completeButton.setFont(new Font(FONT, Font.PLAIN, 15));
            completeButton.setForeground(Color.BLACK);
            completeButton.setBackground(Color.WHITE);

            completeButton.addActionListener((new ActionListener() {

                public void actionPerformed(ActionEvent e) {
                    ((Completable) event).complete(true);

                    remove(completeButton);
                    statusLabel.setText("Status: Complete");
                    updateUI();
                }
            }));

            add(completeButton,BorderLayout.EAST);

        }



    }



}
