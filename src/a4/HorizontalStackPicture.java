package a4;

public class HorizontalStackPicture implements Picture {
	
	Picture Left;
	Picture Right;
	
	public HorizontalStackPicture(Picture left, Picture right) {
		if (left == null || right == null ) {
			throw new IllegalArgumentException();
		}
		if(left.getHeight() != right.getHeight()){
			throw new IllegalArgumentException();
			}
		this.Left = left;
		this.Right = right;
	}

	@Override
	public int getWidth() {
		// TODO Auto-generated method stub
		return Left.getWidth() + Right.getWidth();
	}

	@Override
	public int getHeight() {
		// TODO Auto-generated method stub
		return Left.getHeight();
	}

	@Override
	public Pixel getPixel(int x, int y) {
		// TODO Auto-generated method stub
		if (x > Left.getWidth() + Right.getWidth()) {
			throw new IllegalArgumentException();
		}
		if (x >= Left.getWidth()) {
			x = x - Left.getWidth();
			return Right.getPixel(x, y);
		} else {
			return Left.getPixel(x, y);
		}

	}

	@Override
	public Picture paint(int x, int y, Pixel p, double factor) {
		if (x < 0 || x>= getWidth() || y < 0 || y>= getHeight()) {
			throw new IllegalArgumentException();
		}
		if (p==null) {
			throw new IllegalArgumentException();
		}
		if (factor < 0 || factor > 1.0) {
			throw new IllegalArgumentException();	
	}
		if (x< Left.getWidth()) {
			Left = Left.paint(x,y,p,factor);
		}else {
			Right = Right.paint(x-Left.getWidth(), y, p, factor);
		}
		
		return this;
}
}
