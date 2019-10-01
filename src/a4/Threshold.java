package a4;

public class Threshold implements PixelTransformation {

	private double _threshold;

	public Threshold(double threshold) {
		this._threshold = threshold;
	}

	public Pixel transform(Pixel p) {
		if (p.getIntensity() > _threshold) {
			p = new ColorPixel(1.0, 1.0, 1.0);
			return p;
		} else {
			p = new ColorPixel(0.0, 0.0, 0.0);
			return p;
		}
	}

}
