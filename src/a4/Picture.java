package a4;


public interface Picture {
	
	// Getters for the dimensions of a picture.
	// Width refers to the number of columns and 
	// height is the number of rows.
	
	public int getWidth();
	public int getHeight();
	
	// getPixel(x, y) retrieves the pixel at position (x,y) in the
	// picture. The coordinate (0,0) is the upper left
	// corner of the picture. The coordinate (getWidth()-1, getHeight()-1)
	// is the lower right of the picture. An IllegalArgumentException
	// is thrown if x or y are not in range.
	
	public Pixel getPixel(int x, int y);
	
	// The various forms of the paint() method return a new
	// picture object based on this picture with certain pixel
	// positions "painted" with a new value.
	
	// paint(int x, int y, Pixel p) paints the pixel at
	// position (x,y) with the pixel value p. The second 
	// form includes a factor parameter that specifies a
	// blending factor. A factor of 0.0 leaves the specified
	// pixel unchanged. A factor of 1.0 results in replacing
	// the value with the specified pixel value. Values between
	// 0.0 and 1.0 blend proportionally.
	
	default public Picture paint(int x, int y, Pixel p) {
		return paint(x,y,p,1.0);
	}
	public Picture paint(int x, int y, Pixel p, double factor);
	
	
	// paint(int ax, int ay, int bx, int by, Pixel p) paints the
	// rectangular region defined by the positions (ax, ay) and
	// (bx, by) with the specified pixel value. The second form
	// should blend with the specified factor as previously described.
	
	default public Picture paint(int ax, int ay, int bx, int by, Pixel p) {
		return paint(ax,ay,bx,by,p,1.0);
	}
	default public Picture paint(int ax, int ay, int bx, int by, Pixel p, double factor) {
		if (ax < 0 || ax>= getWidth() || ay < 0 || ay>= getHeight()) {
			throw new IllegalArgumentException();
		}
		if (bx < 0 || bx>= getWidth() || by < 0 || by>= getHeight()) {
			throw new IllegalArgumentException();
		}
		if (p==null) {
			throw new IllegalArgumentException();
		}
		if (factor < 0 || factor > 1.0) {
			throw new IllegalArgumentException();
		}
		/*int min_x;
		int max_x;
		int min_y;
		int max_y;
		if (ax<bx) {
			min_x = ax;
					max_x = bx;
		}else {
			min_x = bx;
			max_x = ax;
		}
		if (ay<by) {
			min_y = ay;
					max_y = by;
		}else {
			min_y = by;
			max_y = ay;
		}
		Picture _first = this;
		for (int x=min_x; x<max_x; x++) {
			for (int y=min_y; y<max_y; y++) {
				_first=_first.paint(x,y,p,factor);
			}
		}*/
		Picture _fourth = this;
		for (int k = ax; k <= bx; k++) {
			for (int m = ay; m <= by; m++) {
				_fourth = _fourth.paint(k, m, p, factor);
			}
		}
		return _fourth;
	}

	// paint(int cx, int cy, double radius, Pixel p) sets all pixels in the
	// picture that are within radius distance of the coordinate (cx, cy) to the
	// Pixel value p.  Only positive values of radius should be allowed. Any
	// value of cx and cy should be allowed (even if negative or otherwise
	// outside of the boundaries of the frame). 
	
	// Calculate the distance of a particular (x,y) position to (cx,cy) with
	// the expression: Math.sqrt((x-cx)*(x-cx)+(y-cy)*(y-cy))	

	// The second form with factor, blends as previously described.
	
	default public Picture paint(int cx, int cy, double radius, Pixel p) {
		return paint(cx,cy,radius,p,1.0);
		
	}

	default public Picture paint(int cx, int cy, double radius, Pixel p, double factor) {
		if (radius < 0) {
			throw new IllegalArgumentException();
		}
		if (p == null) {
			throw new IllegalArgumentException();
		}
		if (factor < 0 || factor > 1.0) {
			throw new IllegalArgumentException();
		}
		Picture _second = this;
		for (int u = cx; u < radius; u++) {
			for (int l = cy; l < radius; l++) {
				if (Math.sqrt((u - cx) * (u - cx) + (l - cy) * (l - cy)) <= radius) {
					_second = _second.paint(u, l, p);
				}
			}

		}
		return _second;
	}
}
