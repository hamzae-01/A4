package a4;


public class VerticalStackPicture implements Picture {
	
	Picture Top;
	Picture Bottom;
	
	public VerticalStackPicture(Picture top, Picture bottom) {
		if (top == null || bottom == null) {
			throw new IllegalArgumentException("The values of top or bottom can not be null");
		}
		if (top.getWidth() != bottom.getWidth()) {
			throw new IllegalArgumentException("The Widths of the pictures are not the same");
		}
		this.Bottom = bottom;
		this.Top = top;
	}

	@Override
	public int getWidth() {
		// TODO Auto-generated method stub
		return Top.getWidth();
	}

	@Override
	public int getHeight() {
		// TODO Auto-generated method stub
		return Top.getHeight() + Bottom.getHeight();
	}

	@Override
	public Pixel getPixel(int x, int y) {
		// TODO Auto-generated method stub

		if (y >= Top.getHeight()) {
			y = y - Top.getHeight();
			return Bottom.getPixel(x, y);
		} else {
			return Top.getPixel(x, y);
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
		if (x< Top.getWidth()) {
			Top = Top.paint(x,y,p,factor);
		}else {
			Bottom = Bottom.paint(x-Top.getWidth(), y, p, factor);
		}
		
		return this;
}
}
