package online.blickle.fractal.ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

public class SierpinskiAnimatedController {

	private Timer timer;
	private SierpinskiAnimatedModel model;
	
	public SierpinskiAnimatedController(ImageModel iModel) {
		model = new SierpinskiAnimatedModel(iModel);
	}
	
	
	public ActionListener getAnimationStartButtonListener() {
		return new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (timer != null ) {
					timer.stop();
				}
				timer = new Timer(10, new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent arg0) {
						model.performSierpinskiGameAnimation();
						
					}
				});
				timer.start();
				
			}
		};
	}
	
	public ActionListener getAnimationStopButtonListener() {
		return new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				 if (timer != null ) {
					 timer.stop();
				 }
			}
		};
	}
	
	public ActionListener getAnimationStepButtonListener() {
		return new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				 if (timer != null ) {
					 timer.stop();
				 }
				model.performSierpinskiGameAnimation();
			}
		};
	}
	
	public ActionListener getClearImageListender() {
		return new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				model.clearImage();
			}
		};
	}
}
