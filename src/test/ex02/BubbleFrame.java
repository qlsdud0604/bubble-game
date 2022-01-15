package test.ex02;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class BubbleFrame extends JFrame {

	private JLabel backgroundMap;
	private Player player;

	public BubbleFrame() {
		initObject();
		initSetting();
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

	public static void main(String[] args) {
		new BubbleFrame();
	}
}
