package com.wangjun.datastructure;

public class GraphTest {
	private final int MaxNum = 5; // 最大顶点数
	
	public static void main(String[] args) {
		GraphTest gt = new GraphTest();
		GraphMatrix gm = gt.new GraphMatrix();
		gt.createGraph(gm);
		gt.outGraph(gm);
		gt.deepTraGraph(gm);
	}
	

	// 定义邻接矩阵结构
	class GraphMatrix {
		char[] Vertex = new char[MaxNum]; // 保存顶点信息，数字或者字母
		int GType; // 类型，0：无向图，1：有向图
		int vertexNum; // 顶点的数量
		int EdgeNum; // 边的数量
		int[][] EdgeWeight = new int[MaxNum][MaxNum]; // 保存边的权
		int[] isTrav = new int[MaxNum]; // 遍历标志
	}

	// 创建邻接矩阵图
	// 这里创建手动创建一个5节点的图
	public void createGraph(GraphMatrix gm) {
		gm.Vertex[0] = '1';
		gm.Vertex[1] = '2';
		gm.Vertex[2] = '3';
		gm.Vertex[3] = '4';
		gm.Vertex[4] = '5';

		gm.GType = 0;
		gm.vertexNum = 5;
		gm.EdgeNum = 6;
		gm.EdgeWeight[0][1] = 1;
		gm.EdgeWeight[1][0] = 1;
		gm.EdgeWeight[0][2] = 1;
		gm.EdgeWeight[2][0] = 1;
		gm.EdgeWeight[0][4] = 1;
		gm.EdgeWeight[4][0] = 1;
		gm.EdgeWeight[2][4] = 1;
		gm.EdgeWeight[4][2] = 1;
		gm.EdgeWeight[1][3] = 1;
		gm.EdgeWeight[3][1] = 1;
		gm.EdgeWeight[3][4] = 1;
		gm.EdgeWeight[4][3] = 1;
	}

	// 清空图
	public void clearGraph(GraphMatrix gm) {
		for (int i = 0; i < MaxNum; i++) {
			for (int j = 0; i < MaxNum; j++) {
				gm.EdgeWeight[i][j] = 0;
			}
		}
	}

	// 显示图，即显示邻接矩阵
	public void outGraph(GraphMatrix gm) {
		// 输出顶点信息
		System.out.println("顶点：");
		for (int i = 0; i < MaxNum; i++) {
			System.out.print(gm.Vertex[i] + "  ");
		}
		System.out.println();
		// 输出边的信息
		System.out.println("边：");
		for (int i = 0; i < MaxNum; i++) {
			for (int j = 0; j < MaxNum; j++) {
				System.out.print(gm.EdgeWeight[i][j] + "  ");
			}
			System.out.println();
		}
	}

	/*
	 * 遍历图，即逐个访问图的顶点，使用isTrav数组标志该节点是否被遍历过 
	 * 常用的遍历图方法：广度优先遍历法和深度优先遍历法 此函数以深度优先遍历法为例
	 * 深度遍历法类似于树的先序遍历，具体执行过程如下： 
	 * 1）从isTrav数组中选择一个未被访问的顶点Vi，将其标记为1，表示已访问过
	 * 2）从Vi的一个未被访问过的邻接点出发进行深度优先遍历 
	 * 3）重复步骤2），直至图中所有和Vi有路径相通的顶点都被访问过
	 * 4）重复步骤1）至3）的操作，直至图中所有的顶点都被访问过 
	 * 深度优先遍历法是一个递归过程
	 */
	public void deepTraGraph(GraphMatrix gm) {
		// 清除顶点访问标志
		for (int i = 0; i < gm.vertexNum; i++) {
			gm.isTrav[i] = 0;
		}
		System.out.println("深度优先遍历节点：");
		for (int i = 0; i < gm.vertexNum; i++) {
			// 若该节点未遍历
			if (gm.isTrav[i] == 0) {
				System.out.println("调用");
				deepTraOne(gm, i);// 调用函数遍历
			}
		}
	}

	//深度遍历的执行函数
	public void deepTraOne(GraphMatrix gm, int n) {
		// 从第n个节点开始，深度遍历图
		gm.isTrav[n] = 1;
		// 输出节点数据
		System.out.println("node:" + gm.Vertex[n] + "  ");

		// 添加处理节点的操作
		for (int i = 0; i < gm.vertexNum; i++) {
			if (gm.EdgeWeight[n][i] != 0 && gm.isTrav[i] == 0) {
				deepTraOne(gm, i);// 递归进行遍历
			}
		}
	}

}
