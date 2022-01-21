package test.ex08;

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

	private void initListener() {
		addKeyListener(new KeyAdapter() {

			/** 키보드 클릭 이벤트 핸들러 */
			@Override
			public void keyPressed(KeyEvent e) {
				switch (e.getKeyCode()) {
				case 74: // left
					if (!player.isLeft() && !player.isLeftWallCrash()) {
						player.left();
					}
					break;
				case 76: // right
					if (!player.isRight() && !player.isRightWallCrash()) {
						player.right();
					}
					break;
				case 73: // up
					if (!player.isUp() && !player.isDown()) {
						player.up();
					}
					break;
				}
			}

			/** 키보드 해제 이벤트 핸들러 */
			@Override
			public void keyReleased(KeyEvent e) {
				switch (e.getKeyCode()) {
				case 74: // left
					player.setLeft(false);
					break;
				case 76: // right
					player.setRight(false);
					break;
				case 73: // up
					break;
				}
			}
		});
	}

	public static void main(String[] args) {
		new BubbleFrame();
	}
}
