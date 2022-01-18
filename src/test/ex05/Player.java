package test.ex05;

import javax.swing.ImageIcon;

import javax.swing.JLabel;

import lombok.*;

@Getter
@Setter
public class Player extends JLabel implements Moveable {
	/** 캐릭터 위치 */
	private int x;
	private int y;

	/** 캐릭터 움직임 상태 */
	private boolean left;
	private boolean right;
	private boolean up;
	private boolean down;

	/** 캐릭터 속도 상태 */
	private final int SPEED = 5;
	private final int JUMP_SPEED = 5;

	private ImageIcon playerR;
	private ImageIcon playerL;

	public Player() {
		initObject();
		initSetting();
	}

	private void initObject() {
		playerR = new ImageIcon("images/playerR.png");
		playerL = new ImageIcon("images/playerL.png");
	}

	private void initSetting() {
		x = 55;
		y = 535;

		this.left = false;
		this.right = false;
		this.up = false;
		this.down = false;

		this.setIcon(playerR);
		this.setSize(50, 50);
		this.setLocation(x, y);
	}

	@Override
	public void left() {
		System.out.println("left");

		left = true;
		new Thread(() -> {
			while (left) {
				setIcon(playerL);
				x -= SPEED;
				setLocation(x, y);

				try {
					Thread.sleep(10);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}).start();
	}

	@Override
	public void right() {
		System.out.println("right");

		right = true;
		new Thread(() -> {
			while (right) {
				setIcon(playerR);
				x += SPEED;
				setLocation(x, y);

				try {
					Thread.sleep(10);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}).start();
	}

	@Override
	public void up() {
		System.out.println("up");

		up = true;
		new Thread(() -> {
			for (int i = 0; i < 130 / JUMP_SPEED; i++) {
				y = y - JUMP_SPEED;
				setLocation(x, y);

				try {
					Thread.sleep(10);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}

			up = false;
			down();
		}).start();
	}

	@Override
	public void down() {
		System.out.println("down");

		down = true;
		new Thread(() -> {
			for (int i = 0; i < 130 / JUMP_SPEED; i++) {
				y = y + JUMP_SPEED;
				setLocation(x, y);

				try {
					Thread.sleep(10);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			down = false;
		}).start();
	}
}
