package facade;

public class main {

//Facade pattern hides the complexities of the system and provides an interface 
//to the client using which the client can access the system
	
	public static void main(String[] args) {
		DrawShape drawShape = new DrawShape();
		drawShape.drawCircle();
		drawShape.drawRingtangle();
		drawShape.drawSquere();
	}
}
