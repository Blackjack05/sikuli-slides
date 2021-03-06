package org.sikuli.slides.driver;

import org.sikuli.api.ScreenRegion;
import org.sikuli.api.Target;
import org.sikuli.api.robot.Keyboard;
import org.sikuli.api.robot.Mouse;
import org.sikuli.api.robot.desktop.DesktopKeyboard;
import org.sikuli.api.robot.desktop.DesktopMouse;
import org.sikuli.api.visual.Canvas;
import org.sikuli.api.visual.DesktopCanvas;

import com.google.common.base.Objects;

class DefaultWidget implements Widget {

	private Target target;
	private String label;
	private ScreenRegion screenRegion = null;
	
	private Mouse mouse = new DesktopMouse();
	private Keyboard keyboard = new DesktopKeyboard();
	private Canvas canvas = new DesktopCanvas();
	
	public DefaultWidget(){
		
	}

	public DefaultWidget(Target t, String label){
		this.target = t;
		this.label = label;
	}

	public Target getTarget() {
		return target;
	}

	public String getLabel() {
		return label;
	}	
	
	public void click(){
		ScreenRegion r = getScreenRegion();
		if (r != null){
			mouse.click(r.getCenter());
		}
	}
	
	@Override
	public void doubeClick() {
		ScreenRegion r = getScreenRegion();
		if (r != null){
			mouse.doubleClick(r.getCenter());
		}		
	}
	
	@Override
	public void type(String text) {
		ScreenRegion r = getScreenRegion();
		if (r != null){
			mouse.click(r.getCenter());
			keyboard.type(text);
		}	
	}	
	
	@Override
	public void paste(String text) {
		ScreenRegion r = getScreenRegion();
		if (r != null){
			mouse.click(r.getCenter());
			keyboard.paste(text);
		}	
	}		
	
	public String toString(){
		return Objects.toStringHelper(getClass().getSimpleName())
				.add("label", label)
				.add("target", target)				
				.toString();
	}
	
	@Override
	public void setScreenRegion(ScreenRegion screenRegion) {
		this.screenRegion = screenRegion;
	}
	
	@Override
	public ScreenRegion getScreenRegion(){
		return screenRegion;
	}

	@Override
	public void highlight() {
		ScreenRegion r = getScreenRegion();
		if (r != null){
			canvas.clear();
			canvas.add().box().around(r);
			canvas.display(1);
		}
	}

	@Override
	public void rightClick() {
		ScreenRegion r = getScreenRegion();
		if (r != null){
			mouse.rightClick(r.getCenter());
		}		
	}

	@Override
	public void hover() {
		ScreenRegion r = getScreenRegion();
		if (r != null){
			mouse.hover(r.getCenter());
		}	
	}

	@Override
	public void drag() {
		ScreenRegion r = getScreenRegion();
		if (r != null){
			mouse.drag(r.getCenter());
		}			
	}

	@Override
	public void drop() {
		ScreenRegion r = getScreenRegion();
		if (r != null){
			mouse.drop(r.getCenter());
		}			
	}	
	
}