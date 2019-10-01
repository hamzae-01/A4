package a4;

public class VerticalStackPicture implements Picture {
	
	Picture Top;
	Picture Bottom;
	
	public VerticalStackPicture(Picture top, Picture bottom) {
		if (top == null || bottom == null) {
			throw new IllegalArgumentException();
		}
		if (top.getWidth() != bottom.getWidth()) {
			throw new IllegalArgumentException();
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
		if (x > Top.getWidth() + Bottom.getWidth()) {
			throw new IllegalArgumentException();
		}
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
		if (y < Top.getHeight()) {
			Top = Top.paint(x,y,p,factor);
		}else {
			Bottom = Bottom.paint(x, y-Top.getHeight(), p, factor);
		}
		
		return this;
}
}
