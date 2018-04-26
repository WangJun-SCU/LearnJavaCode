import java.util.Scanner;

public class Wuziqi {
	
	final String NO_CHESS = "➕";
	final String BLACK_CHESS = "▪️️";
	final String WHITE_CHESS = "o";
	
	final int N = 20;
	
	String[][] qipan;

	public static void main(String[] args) {
		Wuziqi wzq = new Wuziqi();
		wzq.init(wzq.N); //初始化棋盘
		
		wzq.run();
	}
	
	/**
	 * 初始化棋盘
	 * @param n 入参，表示n*n的棋盘
	 */
	public void init(int n) {
		qipan = new String[n][n];
		for(int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				qipan[i][j] = NO_CHESS;
			}
		}
		print();
	}
	
	public void print() {
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				System.out.print(qipan[i][j]);
			}
			System.out.println();
		}
	}
	
	/**
	 * 开始下棋
	 */
	public void run() {
		System.out.print("请输入棋子的坐标','号分开:");
		Scanner s = new Scanner(System.in);
		String input = s.nextLine();
		
		String[] zuobiao = input.split(",");
		int heng = Integer.parseInt(zuobiao[0]) - 1;
		int zong = Integer.parseInt(zuobiao[1]) - 1;
		
		if(!NO_CHESS.equals(qipan[heng][zong])) {
			System.out.println("这个位子已有棋子！");
		}{
			qipan[heng][zong] = BLACK_CHESS;
			print();
		}
		if(isEnd(heng, zong)) {
			return;
		}
		run();
	}
	
	/**
	 * 校验是否已经五子连珠
	 * @param heng 刚下的棋子的横坐标
	 * @param zong 刚下的棋子的纵坐标
	 */
	public boolean isEnd(int heng, int zong) {
		//校验横向左边
		int hengCount = 1;
		int hengTem = heng;
		while(--hengTem >= 0) {
			if(!NO_CHESS.equals(qipan[hengTem][zong])) {
				hengCount++;
			}else {
				break;
			}
		}
		//校验横向右边
		hengTem = heng;
		while(++hengTem < N) {
			if(!NO_CHESS.equals(qipan[hengTem][zong])) {
				hengCount++;
			}else {
				break;
			}
		}
		if(hengCount >=5 ) {
			System.out.println("游戏结束，黑方胜！");
			return true;
		}
		
		//校验纵向上边
		int zongCount = 1;
		int zongTem = zong;
		while(--zongTem >= 0) {
			if(!NO_CHESS.equals(qipan[heng][zongTem])) {
				zongCount++;
			}else {
				break;
			}
		}
		//校验纵向下边
		zongTem = zong;
		while(++zongTem < N) {
			if(!NO_CHESS.equalsIgnoreCase(qipan[heng][zongTem])) {
				zongCount++;
			}else {
				break;
			}
		}
		if(zongCount >= 5) {
			System.out.println("游戏结束，黑方胜！");
			return true;
		}
		
		//校验左上-右下 左上
		hengTem = heng;
		zongTem = zong;
		int count2 = 1;
		while(--hengTem >= 0 && --zongTem >= 0) {
			if(!NO_CHESS.equals(qipan[hengTem][zongTem])) {
				count2++;
			}else {
				break;
			}
		}
		//校验左上-右下 右下
		hengTem = heng;
		zongTem = zong;
		while(++hengTem < N && zongTem < N) {
			if(!NO_CHESS.equals(qipan[hengTem][zongTem])) {
				count2++;
			}else {
				break;
			}
		}
		if(count2 >=5 ) {
			System.out.println("游戏结束，黑方胜！");
			return true;
		}
		
		//校验右上-左下 右上
		hengTem = heng;
		zongTem = zong;
		int count3 = 1;
		while(--hengTem >= 0 && ++zongTem < N) {
			if(!NO_CHESS.equals(qipan[hengTem][zongTem])) {
				count3++;
			}else {
				break;
			}
		}
		//校验右上-左下 左下
		hengTem = heng;
		zongTem = zong;
		while(++hengTem < N && --zongTem >= 0) {
			if(!NO_CHESS.equals(qipan[hengTem][zongTem])) {
				count3++;
			}else {
				break;
			}
		}
		if(count3 >= 5) {
			System.out.println("游戏结束，黑方胜！");
			return true;
		}
		
		return false;
	}

}
