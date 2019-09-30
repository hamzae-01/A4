package a4;

public class MutablePixelArrayPicture implements Picture {

	int _width;
	int _height;
	Pixel[][] _pixel_array;

	public MutablePixelArrayPicture(Pixel[][] pixel_array) {
		
		if(pixel_array == null) {
			throw new IllegalArgumentException();
		}
		if(pixel_array.length == 0 || pixel_array[0].length == 0) {
			throw new IllegalArgumentException();
		}
		
		this._width = pixel_array.length;
		this._height = pixel_array[0].length;
		this._pixel_array = pixel_array;
		
		for (int a = 0; a < _width; a++) {
			if ((pixel_array[a] == null) || (pixel_array[a].length != _height)) {
				throw new IllegalArgumentException();
			}
			for (int s = 0; s < _height; s++) {
				if ( pixel_array[a][s] == null) {
					throw new IllegalArgumentException();
				}
			}
		}
	}

	public MutablePixelArrayPicture(int width, int height, Pixel initial_value) {

		this(width, height);
		
		for (int i = 0; i < _width; i++) {
			for (int j = 0; j < _height; j++) {
				_pixel_array[i][j] = initial_value;
			}
		}

	}

	public MutablePixelArrayPicture(int width, int height) {
		this._width = width;
		this._height = height;
		this._pixel_array = new Pixel[width][height];
		
		if(width == 0 || height == 0) {
			throw new IllegalArgumentException();
		}

		for (int h = 0; h < _pixel_array.length; h++) {
			for (int g = 0; g < _pixel_array[h].length; g++) {
				_pixel_array[h][g] = new GrayPixel(0.5);
			}
		}

	}

	@Override
	public int getWidth() {

		return _width;
	}

	@Override
	public int getHeight() {

		return _height;
	}

	@Override
	public Pixel getPixel(int x, int y) {
		if (x < 0 || x>= _width || y < 0 || y>= _height) {
			throw new IllegalArgumentException();
		}
		return _pixel_array[x][y];
	}

	/*@Override
	public Picture paint(int x, int y, Pixel p) {
		if (x < 0 || x>= _width || y < 0 || y>= _height) {
			throw new IllegalArgumentException();
		}
		_pixel_array[x][y] = p;
		return this;
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
		_pixel_array[x][y] = _pixel_array[x][y].blend(p, factor);
		return this;
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
				if (Math.sqrt((u-cx)*(u-cx)+(l-cy)*(l-cy)) <= radius) {
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
				if (Math.sqrt((u-cx)*(u-cx)+(l-cy)*(l-cy)) <= radius) {
				_third.paint(u, l, p, factor);
				}
			}
		}
		return _third;
	}
*/
}
