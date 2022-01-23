package test.ex08;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Bubble extends JLabel {

	private Player player;

	/** 물방울 위치 */
	private int x;
	private int y;

	/** 물방울 움직임 상태 */
	private boolean left;
	private boolean right;
	private boolean up;

	/** 적을 맞춘 상태 */
	private int state;

	private ImageIcon bubble; // 일반 물방울
	private ImageIcon bubbled; // 적을 가둔 물방울
	private ImageIcon bomb; // 물방울이 터진 상태

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
