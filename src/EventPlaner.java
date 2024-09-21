import javax.swing.*;

public class EventPlaner {
    public static void main(String[] args) {

        final int WINDOW_WIDTH = 800;
        final int WINDOW_HEIGHT = 600;

        JFrame frame = new JFrame();
        JPanel EventListPanel = new JPanel();
        frame.add(EventListPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("EventPlanner");
        frame.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        frame.setVisible(true);


    }
}
