import javax.swing.*;

class ControlPanel extends JPanel {
    private JSpinner animalCarnivoreCountSpinner;
    private JSpinner animalHerbivoreCountSpinner;
    private JSpinner animalOmnivoreCountSpinner;
    private JSpinner plantCountSpinner;
    private JSpinner plantGenerationRateSpinner;
    private JButton resetSimulationButton;
    private JButton pauseButton;

    private GameBoard board;

    public ControlPanel(GameBoard board) {
        this.board = board;
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        animalCarnivoreCountSpinner = new JSpinner(new SpinnerNumberModel(5, 0, 50, 1));
        animalHerbivoreCountSpinner = new JSpinner(new SpinnerNumberModel(5, 0, 50, 1));
        animalOmnivoreCountSpinner = new JSpinner(new SpinnerNumberModel(5, 0, 50, 1));
        plantCountSpinner = new JSpinner(new SpinnerNumberModel(20, 0, 100, 1));
        plantGenerationRateSpinner = new JSpinner(new SpinnerNumberModel(10, 0, 100, 1));
        resetSimulationButton = new JButton("Reset Simulation");
        pauseButton = new JButton("Pause");



        add(createLabeledSpinner("Carnivore animal Count", animalCarnivoreCountSpinner));
        add(createLabeledSpinner("Herbivore animal Count", animalHerbivoreCountSpinner));
        add(createLabeledSpinner("Omnivore animal Count", animalOmnivoreCountSpinner));
        add(createLabeledSpinner("Plant Count", plantCountSpinner));
        add(createLabeledSpinner("Plant Generation Rate (%)", plantGenerationRateSpinner));
        add(resetSimulationButton);
        add(pauseButton);


        setupListeners();
    }

    private JPanel createLabeledSpinner(String label, JSpinner spinner) {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
        panel.add(new JLabel(label));
        panel.add(spinner);
        return panel;
    }

    private void setupListeners() {

        pauseButton.addActionListener(e -> {
            board.togglePause();
            pauseButton.setText(board.isPaused() ? "Resume" : "Pause");
        });

        resetSimulationButton.addActionListener(e -> {
            int animalCarnivoreCount = (int) animalCarnivoreCountSpinner.getValue();
            int animalHerbivoreCount = (int) animalHerbivoreCountSpinner.getValue();
            int animalOmnivoreCount = (int) animalOmnivoreCountSpinner.getValue();
            int plantCount = (int) plantCountSpinner.getValue();
            int plantGenerationRate = (int) plantGenerationRateSpinner.getValue();
            board.resetSimulation(animalCarnivoreCount, animalHerbivoreCount, animalOmnivoreCount,  plantCount, plantGenerationRate);
        });
    }
}
