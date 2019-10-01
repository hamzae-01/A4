package a4;

public class TransformedPicture extends ImmutablePixelArrayPicture {

	private Picture _source;
	private PixelTransformation x_form;
	
	public TransformedPicture(Picture source, PixelTransformation xform){
	super(source.getWidth(), source.getHeight());
	this._source = source;
	this.x_form = xform;
	}
	


	
	public void setPixel(int x, int y, Pixel p) {
	throw new UnsupportedOperationException ();

	}

	
	public Pixel getPixel(int x, int y) {
	  Pixel p = _source.getPixel(x, y);
	  return x_form.transform(p);
	}



	public TransformedPicture transform(PixelTransformation xform){
		return new TransformedPicture (this, xform);
	}

	
	
}
