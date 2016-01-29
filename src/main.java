import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import snake.Game;
import snake.World;

public class main implements ActionListener {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Game gm = new Game();
		gm.setVisible(true);

		World myworld = new World();
		for(int i=0;i<myworld.WIDTH;i++){
			for(int j=0;j<myworld.HEIGHT;j++){
				System.out.print(myworld.getFrame()[i][j]);
			}
			System.out.println(" ");
		}
		
		myworld.move("UP");
		
		System.out.println("------------------------------------------------------------- ");
		
		for(int i=0;i<myworld.WIDTH;i++){
			for(int j=0;j<myworld.HEIGHT;j++){
				System.out.print(myworld.getFrame()[i][j]);
			}
			System.out.println(" ");
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}
