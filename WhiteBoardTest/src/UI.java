import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;


public class UI extends JFrame {

	// Presenter presenter;
	DShape presenter;
	static Canvas canvas = new Canvas();
	private static int shapeCounter = 0;
	private String[] columnNames={"X","Y","Widt","Height"};
	private static Object[][] data= {{4,5,6,7},{4,5,6,7},{4,5,6,7},{4,5,6,7},{4,5,6,7}};
	
	public UI(DShape presenter) {
		this.presenter = presenter;
		presenter.attachView(this);
		showUI();
	}

	private void showUI() {

		// canvas

		// addPanel
		JPanel addPanel = new JPanel(new GridLayout(1, 5));
		addPanel.add(new JLabel("Add"));
		// Rect
		JButton rect = new JButton("Rect");
		rect.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				DRect rect = new DRect(50, 50, 10, 20, Color.blue);
				canvas.addShapes(rect);
				canvas.paintComponent();
				data[shapeCounter] = rect.getArray();
				shapeCounter++;
			}

		});
		addPanel.add(rect);
		// Oval
		JButton oval = new JButton("Oval");
		oval.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				DOval oval = new DOval(60, 10, 10, 20, Color.red);
				canvas.addShapes(oval);
				canvas.paintComponent();
				data[shapeCounter] = oval.getArray();
				shapeCounter++;
			}

		});
		addPanel.add(oval);

		// colorPanel
		// textPanel
		// posPanel
		// tablePanel: doesn't update unless u click on the entry
		
		JTable table = new JTable(data, columnNames);
		JScrollPane tablePane = new JScrollPane(table);

		// controls={addPanel, colorPanel,textPanel,posPanel, tablePanel}
		JPanel controls = new JPanel();
		controls.setLayout(new GridLayout(5, 1));
		controls.add(addPanel);
		controls.add(new JButton("www"));
		controls.add(new JButton("xxx"));
		controls.add(new JButton("ggg"));
		controls.add(tablePane);

		this.setTitle("WhiteBoard test");
		this.setLayout(new BorderLayout());
		this.add(controls, BorderLayout.WEST);
		this.add(canvas, BorderLayout.CENTER);
		// control should use same canvas as WhiteBoard
		setSize(800, 400);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}

	public static Canvas getCanvas() {
		return canvas;
	}
	


	
	
}
