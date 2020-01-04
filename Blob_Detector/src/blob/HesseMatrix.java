package blob;

import java.awt.image.BufferedImage;
import java.awt.image.Raster;
import java.io.IOException;

import ij.process.FloatProcessor;
import net.sf.image4j.util.ConvertUtil;
import volume.Hessian;

public class HesseMatrix {
	
	BufferedImage image;	

	public HesseMatrix() {				
	}

	BufferedImage changePixelColor(BufferedImage image) throws IOException {
		
		ConvertUtil c = new ConvertUtil();
		BufferedImage bi =  c.convert8(image);

		Hessian h = new Hessian();
		float[] dummy = null;
		int wid, hgt;

		// compute size of the array
		wid = bi.getWidth();
		hgt = bi.getHeight();

		// start getting the pixels
		Raster pixelData;
		pixelData = bi.getData();

		float[] f = pixelData.getPixels(0, 0, wid, hgt, dummy);
		float[] d = h.det(f, bi.getWidth(), 2);		
		
		FloatProcessor fp = new FloatProcessor(bi.getWidth(), bi.getHeight(), d);		
		
		BufferedImage resIm = (BufferedImage) fp.createImage();
		
		return resIm;

	}
		
	
}
