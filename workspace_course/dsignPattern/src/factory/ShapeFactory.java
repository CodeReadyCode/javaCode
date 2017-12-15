package factory;

public class ShapeFactory {
	
	public  Shape getShape(String shapeName){
		Shape shape = null;
		if(shapeName.equals("Circle")){
			shape =  new Circle();
		}else if(shapeName.equals("ringtangle")){
			shape = new Ringtangle();
			
		}else if(shapeName.equals("Squere")){
			shape = new Squere();
		}
		
		return shape;
	}

}
