import java.io.*;

public class Tic
{
	private String[][] boardDrawed = new String[3][3];  //字符串数组作为棋盘
	private int[][] board = new int[3][3];              //整型数组，数字棋盘作为画棋盘的依据

	//数字中棋子的0、1、-1分别为未落子、计算机落子、玩家落子
	private final static int COM_CHESS = 1;
	private final static int PLY_CHESS = -1;
	private static int EMPTY = 0;

	//判断棋局胜负
	public static boolean judgeWin(String[][] board)
	{
		//横、竖、对角线计数
		return true;
	}
	
	//初始化棋盘，全部置0
	public void initBoard()
	{		
		for(int i = 0; i < 3; i++)
		{
			for(int j = 0; j < 3; j++)
			{
				board[i][j] = EMPTY;
			}
		}
	}

	//通过数字棋盘来画棋盘
	public void drawBoard(int[][] board)
	{
		for(int i = 0; i < 3; i++)
		{
			for(int j = 0; j < 3; j++)
			{
				switch(board[i][j])
				{
					case COM_CHESS:
					{
						boardDrawed[i][j] = "X";
						break;
					}
					case PLY_CHESS:
					{
						boardDrawed[i][j] = "O";
						break;
					}
					default:
					{
						boardDrawed[i][j] = "╋";
						break;
					}
				}
				System.out.print(boardDrawed[i][j]);
			}
			System.out.print("\n");
		}
	}
	
	public void plyPos() throws IOException
	{
		//获取键盘输入
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String inputStr = null;
		int x, y;   //玩家落子的坐标
		//每当在键盘上输入一行并回车时，读入br中
		while((inputStr = br.readLine()) != null)
		{
			//用户输入的字符串以逗号分隔，分成两个字符串，分别表示玩家落子的行列号
			String[] plyPosStr = inputStr.split(",");
			
			//将两个字符串转换成用户下棋的坐标，棋盘从1开始
			x = Integer.parseInt(plyPosStr[0]) - 1;
			y = Integer.parseInt(plyPosStr[1]) - 1;
			//判断落子是否合法
			if(x < 0 || x > 2 || y < 0 || y > 2)
			{
				System.out.println("您的输入不合法，请输入1到3的整数");
				System.out.println("请重新输入");
				continue;
			}else if(this.board[x][y] != EMPTY)
			{
				System.out.println("您的输入不合法，请落子在空位");
				System.out.println("请重新输入");
				continue;
			}
			//将对应的棋盘元素赋值PLY_CHESS,-1，即O
			this.board[x][y] = PLY_CHESS;
			//更新棋盘
			this.drawBoard(this.board);
			break;
		}
	}
	
	public void comPos()
	{
		
	}

	public static void main(String[] args) throws Exception
	{
		Tic tic = new Tic();
		tic.initBoard();
		tic.drawBoard(tic.board);

		//游戏开始
		while(true)
		{
			System.out.println("请输入您下棋的座标，应以 行,列 的格式：");
			tic.plyPos();
			tic.comPos();
		}
	}
}