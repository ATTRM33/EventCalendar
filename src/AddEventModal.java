import javax.swing.*;
import java.awt.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.chrono.ChronoLocalDate;
import java.time.format.DateTimeFormatter;

public class AddEventModal extends JDialog {
    private JTextField nameField;
    private JTextField dateField;
    private JTextField startTimeField;
    private JTextField endTimeField;
    private JTextField locationField;
    private JComboBox<String> eventTypeDropDown;
    private JButton addButton, cancelButton;
    private EventListPanel eventListPanel;
    private int panelWidth = 400;
    private int panelHeight = 200;

    public AddEventModal(Frame owner, EventListPanel eventListPanel) {
        super(owner, "Add New Event", true);
        this.eventListPanel = eventListPanel;

        setLayout(new BorderLayout());

        //form fields
        JPanel formPanel = new JPanel(new GridLayout(6, 2, 10,10));
        formPanel.setBorder(BorderFactory.createEmptyBorder(8, 8, 8, 8));
        formPanel.setPreferredSize(new Dimension(panelWidth, panelHeight));
        formPanel.setBackground(Color.WHITE);

        //name panel
        formPanel.add(new JLabel("Event Name:"));
        nameField = new JTextField();
        formPanel.add(nameField);


        //event type panel
        formPanel.add(new JLabel("Event Type:"));
        eventTypeDropDown = new JComboBox<>(new String[]{"Meeting", "Deadline","Other"});
        formPanel.add(eventTypeDropDown);

        //event date
        formPanel.add(new JLabel("Event Date (yyyy-mm-dd):"));
        dateField = new JTextField();
        formPanel.add(dateField);

        //start time panel
        formPanel.add(new JLabel("Start Time (hh:mm)"));
        startTimeField = new JTextField();
        formPanel.add(startTimeField);

        //end time panel
        formPanel.add(new JLabel("End Time (hh:mm):"));
        endTimeField = new JTextField();
        formPanel.add(endTimeField);

        //location panel for meetings
        formPanel.add(new JLabel("Location:"));
        locationField = new JTextField();
        toggleLocationField();
        formPanel.add(locationField);

        //add and cancel buttons
        addButton = new JButton("Add");
        addButton.setBackground(Color.white);

        cancelButton = new JButton("Cancel");
        cancelButton.setBackground(Color.white);

        //panel for buttons
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(addButton);
        buttonPanel.add(cancelButton);

        // listeners for buttons
        addButton.addActionListener(e -> addEvent());
        cancelButton.addActionListener(e -> dispose());

        add(formPanel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);

        pack();
        setLocationRelativeTo(owner);
    }

    //add event to the list of events
    private void addEvent() {

        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm");

        String eventName = nameField.getText();
        String eventType = (String) eventTypeDropDown.getSelectedItem();
        String eventDate = dateField.getText();
        String startTime = startTimeField.getText();
        String endTime = endTimeField.getText();
        String location = locationField.getText();

        LocalDateTime startDateTime = LocalDateTime.parse(eventDate + "T" + startTime, DateTimeFormatter.ISO_LOCAL_DATE_TIME);
        LocalDateTime endDateTime = LocalDateTime.parse(eventDate + "T" + endTime, DateTimeFormatter.ISO_LOCAL_DATE_TIME);

        Event newEvent;
        if (eventType.equals("Meeting")) {
            newEvent = new Meeting(eventName, startDateTime, endDateTime, location);

        } else {
            newEvent = new Deadline(eventName, LocalDateTime.now());
        }

        eventListPanel.addEvent(newEvent);
        dispose();
    }

    private void toggleLocationField() {
        if (eventTypeDropDown.getSelectedItem().equals("Meeting")) {
            locationField.setEnabled(true);
        } else {
            locationField.setEnabled(false);
            locationField.setText("");
        }
    }
}
