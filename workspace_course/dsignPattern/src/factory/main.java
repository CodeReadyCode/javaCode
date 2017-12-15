package factory;

public class main {
//we create object without exposing the creation logic to the
//client and refer to newly created object using a common interface

	public static void main(String[] args) {
		
		ShapeFactory shapeFactory = new ShapeFactory();
		Circle circle = (Circle)shapeFactory.getShape("circle");
		circle.draw();
	}

}
