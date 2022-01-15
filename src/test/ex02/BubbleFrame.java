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
		setContentPane(backgroundMap); // JLabel을 JPanel로 설정

		player = new Player();
		add(player);

	}

	private void initSetting() {
		setSize(1000, 640);
		setLayout(null); // absolute 레이아웃 (자유롭게 그림을 그릴 수 있음)
		setLocationRelativeTo(null); // JFrame을 가운데로 배치
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // x 버튼 클릭시 JVM 같이 종료
	}

	public static void main(String[] args) {
		new BubbleFrame();
	}
}
