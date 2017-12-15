package decorator;

import java.io.IOException;

public class main {

//Decorator pattern allows a user to add new functionality
//to an existing object without altering its structure. 
	
	public static void main(String[] args) {
	      Shape redCircle = new RedShapeDecorator(new Circle());
	      redCircle.draw();
	}
	
}
