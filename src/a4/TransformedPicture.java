package a4;

public class TransformedPicture extends ImmutablePixelArrayPicture {

	private Picture source;
	private PixelTransformation xform;
	
	public TransformedPicture(Picture source, PixelTransformation xform){
	super(source.getWidth(), source.getHeight());
	this.source = source;
	this.xform = xform;
	}
	


	
	public void setPixel(int x, int y, Pixel p) {
	throw new UnsupportedOperationException ();

	}

	
	public Pixel getPixel(int x, int y) {
	  Pixel p = source.getPixel(x, y);
	  return xform.transform(p);
	}



	public TransformedPicture transform(PixelTransformation xform){
		return new TransformedPicture (this, xform);
	}

	
	
}
