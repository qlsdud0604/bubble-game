package test.ex03;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class BubbleFrame extends JFrame {

	private JLabel backgroundMap;
	private Player player;

	public BubbleFrame() {
		initObject();
		initSetting();
		initListener();
		setVisible(true);
	}

	private void initObject() {
		backgroundMap = new JLabel(new ImageIcon("images/backgroundMap.png"));
		setContentPane(backgroundMap); // JLabel�� JPanel�� ����

		player = new Player();
		add(player);
	}

	private void initSetting() {
		setSize(1000, 640);
		setLayout(null); // absolute ���̾ƿ� (�����Ӱ� �׸��� �׸� �� ����)
		setLocationRelativeTo(null); // JFrame�� ����� ��ġ
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // x ��ư Ŭ���� JVM ���� ����
	}

	private void initListener() {
		addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				switch (e.getKeyCode()) {
				case 74: // left
					player.left();
					break;
				case 76: // right
					player.right();
					break;
				case 73: // up
					player.up();
					break;
				}
			}
		});
	}

	public static void main(String[] args) {
		new BubbleFrame();
	}
}
