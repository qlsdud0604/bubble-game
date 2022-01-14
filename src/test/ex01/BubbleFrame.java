package test.ex01;

import javax.swing.JFrame;

public class BubbleFrame extends JFrame {

	public BubbleFrame() {
		setSize(1000, 640);
		getContentPane().setLayout(null);
		setVisible(true);
	}

	public static void main(String[] args) {
		new BubbleFrame();

	}

}

// 1. JFrame 클래스를 상속받으면 해당 클래스는 Frame이 됨
// 2. Frame은 하나의 Panel을 소유하고 있음
