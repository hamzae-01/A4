package a4;

public class GradientPicture implements Picture {
	
	int _width;
	int _height;
	Pixel _upperLeft;
	Pixel _upperRight;
	Pixel _lowerLeft;
	Pixel _lowerRight;
	//Picture _picture;
	//Pixel [][] _pixel_array;
	
	public GradientPicture(int width, int height, Pixel upper_left, Pixel upper_right, Pixel lower_left, Pixel lower_right) {
		if (width <= 0 || height <= 0) {
			throw new IllegalArgumentException();
		}
		if (upper_left == null || upper_right == null || lower_left == null || lower_right == null) {
			throw new IllegalArgumentException();
		}
		this._width = width;
		this._height = height;
		this._upperLeft = upper_left;
		this._upperRight = upper_right;
		this._lowerLeft = lower_left;
		this._lowerRight = lower_right;

	/*	_pixel_array = new Pixel[_width][_height];
		for (int y = 0; y < _height; y++) {
			for (int x = 0; x < _width; x++) {
				if (y == 0) {
					double factorDiv = 0;
					if (x == 0) {
						factorDiv = 0;
					} else {
						factorDiv = 1 / x;
					}

					_pixel_array[x][y] = _upperLeft.blend(_upperRight, factorDiv);
				} else {
					Pixel beginningOfRow = _upperLeft.blend(_lowerLeft, 1 / y);
					Pixel endOfRow = _upperRight.blend(_lowerRight, 1 / y);
					double factorDiv = 0;
					if (x == 0) {
						factorDiv = 0;
					} else {
						factorDiv = 1 / x;
					}
					_pixel_array[x][y] = beginningOfRow.blend(endOfRow, factorDiv);
				}
			}
		}

		this._picture = new ImmutablePixelArrayPicture(_pixel_array);
*/
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
		
		double factor = ((double) y) / ((double) (_height - 1));
		
		
		Pixel begRow = _upperLeft.blend(_lowerLeft, factor);
		Pixel endRow = _upperRight.blend(_lowerRight, factor);
		
		factor = ((double) x) / ((double) (_width - 1));
		
		
		return begRow.blend(endRow, factor);
	}

	@Override
	public Picture paint(int x, int y, Pixel p, double factor) {
		// TODO Auto-generated method stub
		if (x < 0 || x>= _width || y < 0 || y>= _height) {
			throw new IllegalArgumentException();
		}
		if (p==null) {
			throw new IllegalArgumentException();
		}
		if (factor < 0 || factor > 1.0) {
			throw new IllegalArgumentException();
		}
		
		Pixel [][] _pix_val = new Pixel [_width][_height];
		for (int f=0; f<_width; f++) {
			for (int d=0; d<_height; d++) {
				_pix_val[f][d] = getPixel(f,d);
			}
		}
				return (new MutablePixelArrayPicture(_pix_val)).paint(x, y, p);
	}

}
