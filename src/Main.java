import javax.swing.*;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;
import java.awt.*;

public class Main {

    public static final int WINDOW_WIDTH = 1600;
    public static final int WINDOW_HEIGHT = 1024;
    private static SimulationPanel simulationPanel = new SimulationPanel();

    public static void main(String[] args) {
        simulationPanel.simulate(2000);//Integer.parseInt(JOptionPane.showInputDialog("Time Scale?"))););
        // Simulation Window setup:
        JFrame mainWindow = new JFrame("Traffic Simulator");
        mainWindow.setLayout(new BorderLayout());
        mainWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainWindow.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);

        //Status Bar
        JPanel bottomPanel = new JPanel();
        bottomPanel.setLayout(new GridLayout(1, 0));
        bottomPanel.setBorder(BorderFactory.createLoweredSoftBevelBorder());
        JLabel modeLabel = new JLabel("Mode: ");
        bottomPanel.add(modeLabel);
        JLabel statusLabel = new JLabel("Status: ");
        bottomPanel.add(statusLabel);
        mainWindow.add(bottomPanel, BorderLayout.SOUTH);

        //Editor Panel
        JPanel placeholder = new JPanel();
        placeholder.setBackground(Color.GRAY);
        mainWindow.add(placeholder);

        //Menu bar:
        JMenuBar menuBar = new JMenuBar();
        mainWindow.add(menuBar, BorderLayout.NORTH);

        JMenu editMenu = new JMenu("City Editor");
        MenuListener cityLis = new MenuListener() {
            @Override
            public void menuSelected(MenuEvent e) {
                modeLabel.setText("Mode: Editor");
            }

            @Override
            public void menuDeselected(MenuEvent e) {
                mainWindow.repaint();
            }

            @Override
            public void menuCanceled(MenuEvent e) {
            }
        };
        editMenu.addMenuListener(cityLis);
        menuBar.add(editMenu);

        JMenu simMenu = new JMenu("Simulation");
        MenuListener simLis = new MenuListener() {
            @Override
            public void menuSelected(MenuEvent e) {
                modeLabel.setText("Mode: Simulation");
            }

            @Override
            public void menuDeselected(MenuEvent e) {
            }

            @Override
            public void menuCanceled(MenuEvent e) {
            }
        };
        simMenu.addMenuListener(simLis);

        JMenuItem startSimItem = new JMenuItem("Start");
        startSimItem.addActionListener(e -> {
            mainWindow.remove(placeholder);
            mainWindow.add(simulationPanel, BorderLayout.CENTER);
            simulationPanel.setStop(false);
            statusLabel.setText("Status: Simulation Running");
            mainWindow.validate();
            mainWindow.repaint();
        });
        simMenu.add(startSimItem);

        JMenuItem stopSimItem = new JMenuItem("Stop");
        stopSimItem.addActionListener(e -> {
            simulationPanel.setStop(true);
            statusLabel.setText("Status: Simulation Stopped");
            mainWindow.validate();
            mainWindow.repaint();
        });
        simMenu.add(stopSimItem);

        JMenuItem resetSimItem = new JMenuItem("Reset");
        resetSimItem.addActionListener(e -> {
            mainWindow.remove(simulationPanel);
            mainWindow.remove(placeholder);
            simulationPanel = new SimulationPanel();
            mainWindow.add(simulationPanel, BorderLayout.CENTER);
            simulationPanel.simulate(2000);//Integer.parseInt(JOptionPane.showInputDialog("Time Scale?")));
            statusLabel.setText("Status: Simulation Reset");
            mainWindow.validate();
            mainWindow.repaint();
        });
        simMenu.add(resetSimItem);

        menuBar.add(simMenu);


        mainWindow.setLocationRelativeTo(null);
        mainWindow.setVisible(true);

    }
}
