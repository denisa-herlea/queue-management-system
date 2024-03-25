
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class View extends JFrame {

	private JLabel nLabel,qLabel,simulationTimeLabel,minArrivalLabel,maxArrivalLabel,minServiceLabel,maxServiceLabel,  titleLabel;
	private JTextField nTextField, qTextField,simulationTimeTextArea,minArrivalTextArea, minServiceTextArea, maxArrivalTextArea,maxServiceTextArea;
	private JButton startButton;


	public View(){
		this.setBounds(100, 100, 500, 535);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.getContentPane().setLayout(null);

		nLabel = new JLabel("Number of clients");
		nLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		nLabel.setBounds(50, 102, 106, 14);
		this.getContentPane().add(nLabel);

        qLabel = new JLabel("Number of queues");
		qLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		qLabel.setBounds(50, 132, 120, 18);
		this.getContentPane().add(qLabel);

        simulationTimeLabel = new JLabel("Simulation Interval");
		simulationTimeLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		simulationTimeLabel.setBounds(50, 173, 132, 17);
		this.getContentPane().add(simulationTimeLabel);

        minArrivalLabel = new JLabel("Min Arrival Time");
		minArrivalLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		minArrivalLabel.setBounds(50, 253, 106, 14);
		this.getContentPane().add(minArrivalLabel);

		maxArrivalLabel = new JLabel("Max Arrival Time");
		maxArrivalLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		maxArrivalLabel.setBounds(50, 281, 106, 14);
		this.getContentPane().add(maxArrivalLabel);

        minServiceLabel = new JLabel("Min Service Time");
		minServiceLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		minServiceLabel.setBounds(50, 337, 99, 14);
		this.getContentPane().add(minServiceLabel);

        maxServiceLabel = new JLabel("Max Service Time");
		maxServiceLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		maxServiceLabel.setBounds(50, 362, 105, 14);
		this.getContentPane().add(maxServiceLabel);

        nTextField = new JTextField();
		nTextField.setBounds(200, 99, 86, 20);
		this.getContentPane().add(nTextField);
		nTextField.setColumns(10);

        qTextField = new JTextField();
		qTextField.setBounds(200, 130, 86, 20);
		this.getContentPane().add(qTextField);
		qTextField.setColumns(10);

        simulationTimeTextArea = new JTextField();
		simulationTimeTextArea.setBounds(200, 172, 86, 20);
		this.getContentPane().add(simulationTimeTextArea);
		simulationTimeTextArea.setColumns(10);

        minArrivalTextArea = new JTextField();
		minArrivalTextArea.setBounds(200, 251, 86, 20);
		this.getContentPane().add(minArrivalTextArea);
		minArrivalTextArea.setColumns(10);

        minServiceTextArea = new JTextField();
		minServiceTextArea.setBounds(200, 324, 86, 20);
		this.getContentPane().add(minServiceTextArea);
		minServiceTextArea.setColumns(10);

        maxArrivalTextArea = new JTextField();
		maxArrivalTextArea.setBounds(200, 279, 86, 20);
		this.getContentPane().add(maxArrivalTextArea);
		maxArrivalTextArea.setColumns(10);

        maxServiceTextArea = new JTextField();
		maxServiceTextArea.setBounds(200, 360, 86, 20);
		this.getContentPane().add(maxServiceTextArea);
		maxServiceTextArea.setColumns(10);

        titleLabel = new JLabel("Queue Simulation");
		titleLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		titleLabel.setBounds(180, 23, 147, 34);
		this.getContentPane().add(titleLabel);

		startButton = new JButton("START");
		startButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		startButton.setBounds(128, 416, 178, 39);
		this.getContentPane().add(startButton);

		this.setVisible(true);
}

	public String getnTextField() {
		return nTextField.getText();
	}

	public String getqTextField() {
		return qTextField.getText();
	}

	public String getSimulationTimeTextArea() {
		return simulationTimeTextArea.getText();
	}

	public String getMinArrivalTextArea() {
		return minArrivalTextArea.getText();
	}

	public String getMinServiceTextArea() {
		return minServiceTextArea.getText();
	}

	public String getMaxArrivalTextArea() {
		return maxArrivalTextArea.getText();
	}

	public String getMaxServiceTextArea() {
		return maxServiceTextArea.getText();
	}

	public void addStartListener(ActionListener action){
		startButton.addActionListener(action);
	}


}
