import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class EventListPanel extends JPanel {
    private ArrayList<Event> events;
    JPanel controlPanel;
    JPanel displayPanel;
    JComboBox sortDropDown;
    JCheckBox filterDisplay;
    JButton addEventButton;
    int panelWidth = 500;
    int panelHeight = 500;
    int fontSize = 30;

    public EventListPanel(ArrayList<Event> events) {

        this.events = events;

        //main panel layout
        setLayout(new BorderLayout());
        setBackground(Color.BLACK);
        setPreferredSize(new Dimension(panelWidth, panelHeight));

        //control panel
        controlPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        controlPanel.setBackground(Color.GRAY);
        add(controlPanel, BorderLayout.NORTH);

        //display panel
        displayPanel = new JPanel();
        displayPanel.setBackground(Color.WHITE);
        displayPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        displayPanel.setBorder(BorderFactory.createLineBorder(Color.ORANGE));
        JScrollPane displayScrollPane = new JScrollPane(displayPanel);
        add(displayPanel, BorderLayout.CENTER);

        //add Event button
        addEventButton = new JButton("Add Event");
        addEventButton.setFont(new Font("Futura", Font.BOLD, fontSize));
        addEventButton.setLayout(new FlowLayout(FlowLayout.LEFT));
        addEventButton.addActionListener(e ->  {
            //opens textform box
            AddEventModal addEventModal = new AddEventModal(null, this);
            addEventModal.setVisible(true);

        });
        controlPanel.add(addEventButton);

        // sorting drop down box
        sortDropDown = new JComboBox<>(new String[]{"Name","Date","Descending","Oldest"});
        sortDropDown.setFont(new Font("Futura", Font.PLAIN, fontSize));
        sortDropDown.addActionListener(e -> {

            String selection = (String) sortDropDown.getSelectedItem();
            sortEvents(selection);
            updateDisplay();
        });
        controlPanel.add(sortDropDown);

        //filter checkbox
        filterDisplay = new JCheckBox("Hide Completed");
        filterDisplay.setFont(new Font("Futura", Font.PLAIN, fontSize));
        filterDisplay.addActionListener(e -> updateDisplay());
        controlPanel.add(filterDisplay);

        //yay start the display
        updateDisplay();
    }

    //update display
    public void updateDisplay() {
        displayPanel.removeAll();

        //add each event as an EventPanel to the displayPanel
        for (Event event : events) {

            //if filter is active and event is complete continue skip this
            if (filterDisplay.isSelected() && event instanceof Completable && ((Completable) event).isComplete()) {
                continue;
            }
            displayPanel.add(new EventsPanel(event));
        }

        displayPanel.revalidate();
        displayPanel.repaint();
    }

    //sorting for events based on selection
    private void sortEvents(String option) {
        switch (option) {
            case "Name":
                events.sort((e1, e2) -> e1.getName().compareTo(e2.getName()));
                break;
            case "Date":
                events.sort((e1, e2) -> e1.getDateTime().compareTo(e2.getDateTime()));
                break;
            case "Descending":
                events.sort((e1, e2) -> e2.getName().compareTo(e1.getName()));
                break;
            case "Oldest":
                events.sort((e1, e2) -> e2.getDateTime().compareTo(e1.getDateTime()));
                break;
        }
    }

    public void addEvent(Event event) {
        events.add(event);
        updateDisplay();
    }

}
