package snake;

import java.util.ArrayList;

public class Snake {
	
	public ArrayList<Element> body;
	public Element head;
	
	public Snake(int[] cord){
		body=new ArrayList<>();
		body.add(new Element(cord[0],cord[1],Element.TYPE.SNAKE));
		head = body.get(0);
	}
	
	public void move(int[] dir){
		rShift();
		head.setXY(dir);
	}
	
	public void rShift(){
		if(body.size() < 2) return;
		for(int i=1;i<body.size();i++){
			body.set(i, body.get(i-1));
		}
	}
	
	public void eat(int[] cord){
		body.add(0, new Element(cord[0],cord[1],Element.TYPE.SNAKE));
		head = body.get(0);
	}

	
}
