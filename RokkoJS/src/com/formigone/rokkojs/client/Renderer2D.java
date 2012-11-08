package com.formigone.rokkojs.client;

import com.google.gwt.canvas.client.Canvas;
import com.google.gwt.canvas.dom.client.Context2d;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.ui.Widget;

public class Renderer2D implements Renderer {

	private Canvas canvas;
	private Context2d context;
	private int width;
	private int height;

	public Renderer2D(int width, int height) {
		this.width = width;
		this.height = height;

		canvas = Canvas.createIfSupported();
		canvas.setCoordinateSpaceWidth(width);
		canvas.setCoordinateSpaceHeight(height);
		
		context = this.canvas.getContext2d();
	}

	public Canvas getCanvasElement() {
		return this.canvas;
	}

	public void render2D(Drawable2D drawable) {
		GWT.log("Rendering with my Renderer2D");
		context.fillRect(drawable.getX(), drawable.getY(), drawable.getWidth(), drawable.getHeight());
	}

	@Override
	public void render(Drawable drawable) {
		this.render2D((Drawable2D)drawable);
	}

}