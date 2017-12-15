package facade;

public class DrawShape {
	
	private Circle circle;
	private Ringtangle ringtangle;
	private Squere squere;
	
	
	public DrawShape() {
		circle = new Circle();
		ringtangle = new Ringtangle();
		squere = new Squere();
	}
	
	
	public void drawCircle(){
		circle.draw();
	}
	
	public void drawRingtangle(){
		ringtangle.draw();
	}
	
	public void drawSquere(){
		squere.draw();
	}
	

}
