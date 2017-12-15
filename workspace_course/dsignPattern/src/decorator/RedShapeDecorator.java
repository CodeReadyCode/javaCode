package decorator;

public class RedShapeDecorator extends ShapeDecorator {
	
	public RedShapeDecorator(Shape shape) {
		super(shape);
	}

	@Override
	public void draw() {
		super.draw();
		redColorBorder(shape);
		
	}

	private void redColorBorder(Shape shape) {
		// TODO Auto-generated method stub
		
	}
	
}
