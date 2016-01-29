package snake;

import java.util.HashMap;

public class World {
	
	public static final int WIDTH = 6;
	public static final int HEIGHT = 6;
	
	public boolean isGame = false;

	public Snake snake;
	public Element[][] field;
	
	public HashMap<String, int[]> direction = new HashMap<String, int[]>(){/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

	{
		put("UP",new int[] {0,1});
		put("DOWN",new int[] {0,-1});
		put("RIGHT",new int[] {1,0});
		put("LEFT",new int[] {-1,0});
	}};
	
	public HashMap<String, Integer> state = new HashMap<String, Integer>(){/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

	{
		put("GameOver",0);
		put("Eat",1);
		put("Pass",2);
	}};
	
	
	public void move(String dir){
		int ch = check(direction.get(dir));
		if (ch == 0) {
			isGame = false;
			return;
		}
		if (ch == 1){
			snake.eat(sum(snake.head.getXY(),direction.get(dir)));
		}
		if (ch == 2){
			snake.move(sum(snake.head.getXY(),direction.get(dir)));
		}
	}
	
	public int check(int[] dir){
		int[] bak = sum(dir,snake.head.getXY());
		if(bak[0] >=0 && bak[0] < World.WIDTH &&
				bak[1]>=0 && bak[1] < World.HEIGHT){
			if(field[bak[0]][bak[1]].type == Element.TYPE.FOOD){
				return state.get("Eat");
			}
			else if(field[bak[0]][bak[1]].type == Element.TYPE.EMPTY){
				return state.get("Pass");
			}
			else if(field[bak[0]][bak[1]].type == Element.TYPE.WALL){
				return state.get("GameOver");
			}
			else{
				return state.get("GameOver");
			}
		}
		else{
			return state.get("GameOver");
		}
	}
	
	public int[] sum(int[] a,int[] b){
		int[] answ=new int[]{-1,-1};
		if(a.length == b.length){
			answ[0]=a[0]+b[0];
			answ[1]=a[1]+b[1];
		}
		return answ;
	}
	
	public void startGame(){isGame = true;}
	
	public World(){
		field = new Element[WIDTH][HEIGHT];
		for(int i=0;i<WIDTH;i++)
			for(int j=0;j<HEIGHT;j++)
			{
				if(i==0 || j==0 || i==WIDTH-1 || j==HEIGHT-1)
					field[i][j] = new Element(i,j,Element.TYPE.WALL);
				else
					field[i][j] = new Element(i,j,Element.TYPE.EMPTY);
			}
		snake = new Snake(new int[]{WIDTH/2,HEIGHT/2});
	}
	
	//провести оптимизацию чтоб не копировать каждый раз веь мир
	public int[][] getFrame(){
		int[][] frame = new int[WIDTH][HEIGHT];
		for(int i=0;i<WIDTH;i++)
			for(int j=0;j<HEIGHT;j++)
			{
				if(field[i][j].type == Element.TYPE.WALL){
					frame[i][j]=0;
				}
				if(field[i][j].type == Element.TYPE.EMPTY){
					frame[i][j]=1;
				}
			}
		
		for(int i=0;i<snake.body.size();i++)
			frame[snake.body.get(i).x][snake.body.get(i).y] = 2;
		
		return frame;
	}

}
