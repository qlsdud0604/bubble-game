package test.ex08;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

public class BackgroundPlayerService implements Runnable {

	private BufferedImage image;
	private Player player;

	public BackgroundPlayerService(Player player) {
		this.player = player;

		try {
			image = ImageIO.read(new File("images/backgroundMapService.png"));
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	@Override
	public void run() {
		while (true) {
			Color leftColor = new Color(image.getRGB(player.getX() - 10, player.getY() + 25));
			Color rightColor = new Color(image.getRGB(player.getX() + 65, player.getY() + 25));
			int bottomColor = image.getRGB(player.getX() + 10, player.getY() + 55)
					+ image.getRGB(player.getX() + 40, player.getY() + 55);

			/** �ٴ� �浹 ���� */
			if (bottomColor != -2) {
				// System.out.println("�ٴ� �浹");
				player.setDown(false);
			} else {
				if (!player.isUp() && !player.isDown()) {
					player.down();
				}
			}

			/** �ܺ� �浹 ���� */
			if (leftColor.getRed() == 255 && leftColor.getGreen() == 0 && leftColor.getBlue() == 0) {
				// System.out.println("���� �� �浹");
				player.setLeftWallCrash(true);
				player.setLeft(false);
			} else if (rightColor.getRed() == 255 && rightColor.getGreen() == 0 && rightColor.getBlue() == 0) {
				// System.out.println("������ �� �浹");
				player.setRightWallCrash(true);
				player.setRight(false);
			} else {
				player.setLeftWallCrash(false);
				player.setRightWallCrash(false);
			}

			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

	}

}

// 1. ���� ������� Ű���� �̺�Ʈ�� ó���ؾ� �ϱ� ������ �ٻ�
// 2. ��׶��忡�� 
