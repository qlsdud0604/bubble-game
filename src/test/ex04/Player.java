package test.ex04;

import javax.swing.ImageIcon;

import javax.swing.JLabel;

import lombok.*;

@Getter
@Setter
public class Player extends JLabel implements Moveable {
	private int x;
	private int y;

	private boolean left;
	private boolean right;
	private boolean up;
	private boolean down;

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
		left = true;
		new Thread(() -> {
			while (left) {
				setIcon(playerL);
				x -= 1;
				setLocation(x, y);

				try {
					Thread.sleep(10);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}).start();
	}

	@Override
	public void right() {
		right = true;
		new Thread(() -> {
			while (right) {
				setIcon(playerR);
				x += 1;
				setLocation(x, y);

				try {
					Thread.sleep(10);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}).start();
	}

	@Override
	public void up() {

	}

	@Override
	public void down() {

	}
}
