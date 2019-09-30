package a4;

public class GradientPicture implements Picture {
	
	private int _width;
	private int _height;
	private Pixel _upperLeft;
	private Pixel _upperRight;
	private Pixel _lowerLeft;
	private Pixel _lowerRight;
	
	public GradientPicture(int width, int height, Pixel upper_left, Pixel upper_right, Pixel lower_left, Pixel lower_right) {
		if (width <= 0 || height <= 0) {
			throw new IllegalArgumentException();
		}
		if (upper_left == null || upper_right == null || lower_left == null || lower_right == null) {
			throw new IllegalArgumentException();
		}
		this._width = width;
		this._height =height;
		this._upperLeft = upper_left;
		this._upperRight = upper_right;
		this._lowerLeft = lower_left;
		this._lowerRight = lower_right;
	}

	@Override
	public int getWidth() {
		// TODO Auto-generated method stub
		return _width;
	}

	@Override
	public int getHeight() {
		// TODO Auto-generated method stub
		return _height;
	}

	@Override
	public Pixel getPixel(int x, int y) {
		// TODO Auto-generated method stub
		if (x < 0 || x>= _width || y < 0 || y>= _height) {
			throw new IllegalArgumentException();
		}
		return null;
	}

	@Override
	public Picture paint(int x, int y, Pixel p, double factor) {
		// TODO Auto-generated method stub
		return null;
	}

}
