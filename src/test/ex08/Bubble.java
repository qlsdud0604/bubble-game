package test.ex08;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Bubble extends JLabel {

	private Player player;

	/** ����� ��ġ */
	private int x;
	private int y;

	/** ����� ������ ���� */
	private boolean left;
	private boolean right;
	private boolean up;

	/** ���� ���� ���� */
	private int state;

	private ImageIcon bubble; // �Ϲ� �����
	private ImageIcon bubbled; // ���� ���� �����
	private ImageIcon bomb; // ������� ���� ����

	public Bubble(Player player) {
		this.player = player;
		initObject();
		initSetting();
	}

	private void initObject() {
		bubble = new ImageIcon("images/bubble.png");
		bubbled = new ImageIcon("images/bubbled.png");
		bomb = new ImageIcon("images/bomb.png");
	}

	private void initSetting() {
		left = false;
		right = false;
		up = false;

		this.x = player.getX();
		this.y = player.getY();

		setIcon(bubble);
		setSize(50, 50);

		this.state = 0;
	}

}
