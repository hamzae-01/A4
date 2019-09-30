package a4;

public class MonochromePicture implements Picture {
	
	private int _width;
	private int _height;
	private Pixel _value;
	
	public MonochromePicture(int width, int height, Pixel value) {
		if (width <= 0 || height <= 0) {
			throw new IllegalArgumentException();
		}
		if (value == null) {
			throw new IllegalArgumentException();
		}
		this._width = width;
		this._height = height;
		this._value = value;
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
				
		return _value;
	}

	/*@Override
	public Picture paint(int x, int y, Pixel p) {
		// TODO Auto-generated method stub

		return null;
	}
*/
	@Override
	public Picture paint(int x, int y, Pixel p, double factor) {
		if (x < 0 || x>= _width || y < 0 || y>= _height) {
			throw new IllegalArgumentException();
		}
		if (p==null) {
			throw new IllegalArgumentException();
		}
		if (factor < 0 || factor > 1.0) {
			throw new IllegalArgumentException();
		}
		
		Picture _first = new MutablePixelArrayPicture(_width, _height, _value);
		return _first.paint(x, y, p, factor);
	}
	/*@Override
	public Picture paint(int ax, int ay, int bx, int by, Pixel p) {
		Picture _fourth = this;
		for (int k = ax; k <= bx; k++) {
			for (int m = ay; m <= by; m++) {
				_fourth.paint(k, m, p);
			}
		}
		return _fourth;
	}

	@Override
	public Picture paint(int ax, int ay, int bx, int by, Pixel p, double factor) {
		Picture _first = this;
		for (int k = ax; k < bx; k++) {
			for (int m = ay; m < by; m++) {
				_first.paint(k, m, p, factor);
				// Pixel blend2 = _pixel_array [k][m].blend(p, factor);
			}
		}
		return _first;
	}

	@Override
	public Picture paint(int cx, int cy, double radius, Pixel p) {
		Picture _second = this;
		for (int u = cx; u < radius; u++) {
			for (int l = cy; l < radius; l++) {
				if (Math.sqrt(u*u+l*l) <= radius) {
				_second.paint(u, l, p);
				}
			}
		}
		return _second;
	}

	@Override
	public Picture paint(int cx, int cy, double radius, Pixel p, double factor) {
		Picture _third = this;
		for (int u = cx; u < radius; u++) {
			for (int l = cy; l < radius; l++) {
				if (Math.sqrt(u*u+l*l) <= radius) {
				_third.paint(u, l, p, factor);
				}
			}
		}
		return _third;
	}
*/
}