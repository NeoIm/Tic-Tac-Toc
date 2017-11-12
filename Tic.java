import java.io.*;

public class Tic
{
	private String[][] boardDrawed = new String[3][3];  //�ַ���������Ϊ����
	private int[][] board = new int[3][3];              //�������飬����������Ϊ�����̵�����

	//���������ӵ�0��1��-1�ֱ�Ϊδ���ӡ���������ӡ��������
	private final static int COM_CHESS = 1;
	private final static int PLY_CHESS = -1;
	private static int EMPTY = 0;

	//�ж����ʤ��
	public static boolean judgeWin(String[][] board)
	{
		//�ᡢ�����Խ��߼���
		return true;
	}
	
	//��ʼ�����̣�ȫ����0
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

	//ͨ������������������
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
						boardDrawed[i][j] = "��";
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
		//��ȡ��������
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String inputStr = null;
		int x, y;   //������ӵ�����
		//ÿ���ڼ���������һ�в��س�ʱ������br��
		while((inputStr = br.readLine()) != null)
		{
			//�û�������ַ����Զ��ŷָ����ֳ������ַ������ֱ��ʾ������ӵ����к�
			String[] plyPosStr = inputStr.split(",");
			
			//�������ַ���ת�����û���������꣬���̴�1��ʼ
			x = Integer.parseInt(plyPosStr[0]) - 1;
			y = Integer.parseInt(plyPosStr[1]) - 1;
			//�ж������Ƿ�Ϸ�
			if(x < 0 || x > 2 || y < 0 || y > 2)
			{
				System.out.println("�������벻�Ϸ���������1��3������");
				System.out.println("����������");
				continue;
			}else if(this.board[x][y] != EMPTY)
			{
				System.out.println("�������벻�Ϸ����������ڿ�λ");
				System.out.println("����������");
				continue;
			}
			//����Ӧ������Ԫ�ظ�ֵPLY_CHESS,-1����O
			this.board[x][y] = PLY_CHESS;
			//��������
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

		//��Ϸ��ʼ
		while(true)
		{
			System.out.println("����������������꣬Ӧ�� ��,�� �ĸ�ʽ��");
			tic.plyPos();
			tic.comPos();
		}
	}
}