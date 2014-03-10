package org.eclipse.swt.graphics;

public class Color extends Resource {
	private javafx.scene.paint.Color color;
	
	public Color(Device device, RGB rgb) {
		this(device, rgb.red, rgb.green, rgb.blue);
	}
	
	public Color(Device device, int red, int green, int blue) {
		super(device);
		color = javafx.scene.paint.Color.rgb(red, green, blue);
	}
	
	public int getRed() {
		return (int)(color.getRed() * 255);
	}

	public int getGreen() {
		return (int)(color.getGreen() * 255);
	}
	
	public int getBlue() {
		return (int)(color.getBlue() * 255);
	}
	
	public RGB getRGB() {
		return new RGB(getRed(), getGreen(), getBlue());
	}
	
	@Override
	public void dispose() {
		color = null;
	}

	@Override
	public boolean isDisposed() {
		return color == null;
	}

	public javafx.scene.paint.Color internal_getNativeObject() {
		return color;
	}
	
	@Override
	public String toString() {
		return "Color { "+getRed()+", "+getGreen()+","+getBlue()+" }";
	}
}
