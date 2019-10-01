package a4;

public class GammaCorrect implements PixelTransformation {

	
	private double _gamma;
	
	public GammaCorrect (double gamma){
	this._gamma = gamma;
	}
	
	public Pixel transform(Pixel p) {
	 double gammaRed = Math.pow(p.getRed(), (1.0/_gamma));
	 double gammaGreen = Math.pow(p.getGreen(), (1.0/_gamma));
	 double gammaBlue = Math.pow(p.getBlue(), (1.0/_gamma));
	 p = new ColorPixel(gammaRed, gammaGreen, gammaBlue);
	 return p;
	}

}
