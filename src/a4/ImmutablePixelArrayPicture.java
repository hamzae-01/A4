package a4;

public class ImmutablePixelArrayPicture implements Picture {
	
	int _width;
	int _height;
	Pixel[][] _pixel_array;
	
	public ImmutablePixelArrayPicture(Pixel[][] pixel_array) {
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
	
	public ImmutablePixelArrayPicture(int width, int height, Pixel initial_value) {
		this(width, height);

		for (int i = 0; i < _width; i++) {
			for (int j = 0; j < _height; j++) {
				_pixel_array[i][j] = initial_value;
			}
		}

	}
	
	ImmutablePixelArrayPicture(int width, int height){
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
		return _pixel_array[x][y];
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
		
		return (new MutablePixelArrayPicture(_pixel_array)).paint(x, y, p);
	}

}
