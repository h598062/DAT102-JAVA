import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class SimpleTaskList {
	private final JFrame mainWindow;
	private final Container content;
	private final JTextField newTaskInputField;
	private JPanel selectedParent;
	ButtonGroup parentSelectButtonGroup = new ButtonGroup();

	public SimpleTaskList() {
		mainWindow = new JFrame();
		newTaskInputField = new JTextField(30);
		JButton newTaskConfirmBtn = new JButton("Add");

		mainWindow.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		content = mainWindow.getContentPane();
		content.setLayout(new BoxLayout(content, BoxLayout.Y_AXIS));

		JPanel newTaskInputPanel = new JPanel();
		newTaskInputPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
		newTaskInputPanel.add(newTaskInputField);
		newTaskInputPanel.add(newTaskConfirmBtn);

		content.add(newTaskInputPanel);

		newTaskInputField.addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent e) {
				// not using dis but it needs to be implemented anyways
			}

			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					addTaskItem(selectedParent);
				}
			}

			@Override
			public void keyReleased(KeyEvent e) {
				// not using dis but it needs to be implemented anyways
			}
		});

		newTaskConfirmBtn.addActionListener(e -> addTaskItem(selectedParent));

		mainWindow.setSize(420, 80);
		mainWindow.setVisible(true);
	}

	private void addTaskItem(JPanel parent) {
		JCheckBox checkbox = new JCheckBox(newTaskInputField.getText());
		JRadioButton parentSelectRadioButton = new JRadioButton();
		parentSelectButtonGroup.add(parentSelectRadioButton);

		JPanel panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

		JPanel taskItem = new JPanel() {
			@Override
			protected void paintComponent(Graphics g) {
				super.paintComponent(g);
				g.setColor(Color.RED);
				g.drawRect(0, 0, getWidth() - 1, getHeight() - 1);
			}
		};
		panel.add(taskItem);
		taskItem.setLayout(new FlowLayout(FlowLayout.LEFT));
		panel.add(Box.createHorizontalGlue());
		taskItem.add(Box.createHorizontalGlue());
		taskItem.add(checkbox);
		taskItem.add(parentSelectRadioButton);
		parentSelectRadioButton.setVisible(false);

		checkbox.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (e.getButton() == MouseEvent.BUTTON3) {
					content.remove(panel);
					parentSelectButtonGroup.remove(parentSelectRadioButton);
					selectedParent = null;
					reDraw();
				}
			}
		});
		/* MouseAdapter parentChkbxShowOnHoverMouseEvent = new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				parentSelectRadioButton.setVisible(true);
				reDraw();
			}

			@Override
			public void mouseExited(MouseEvent e) {
				if (!parentSelectRadioButton.isSelected()) {
					parentSelectRadioButton.setVisible(false);
				}
			}
		};
		panel.addMouseListener(parentChkbxShowOnHoverMouseEvent);
		checkbox.addMouseListener(parentChkbxShowOnHoverMouseEvent);
		parentSelectRadioButton.addMouseListener(parentChkbxShowOnHoverMouseEvent); */

		if (parent == null) {
			content.add(panel);
		} else {
			parent.add(panel);
		}

		/* parentSelectRadioButton.addActionListener(e -> {
			if (selectedParent == panel) {
				selectedParent = null;
				parentSelectRadioButton.setSelected(false);
			} else {
				selectedParent = panel;
			}
			reDraw();
		}); */

		newTaskInputField.setText("");
		reDraw();
	}

	public static void main(String[] args) {
		new SimpleTaskList();
	}

	private void reDraw() {
		mainWindow.revalidate();
		mainWindow.repaint();
		mainWindow.pack();
	}
}
