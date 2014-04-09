package org.codepond.wizardroid.infrastructure;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;

import org.codepond.wizardroid.Wizard;

public class DisableableScrollViewPager extends ViewPager {
	private Wizard wizard;
	private float x1, y1;


	public DisableableScrollViewPager(Context context) {
		super(context);
	}

	public DisableableScrollViewPager(Context context, AttributeSet attrs) {
		super(context, attrs);
	}

	public void setWizard(Wizard wizard) {
		this.wizard = wizard;
	}

	@Override
	public boolean onInterceptTouchEvent(MotionEvent event) {


		// Never allow swiping to switch between pages


		return super.onInterceptTouchEvent(event);
	}

	@Override
	public boolean onTouchEvent(MotionEvent event) {

		if (wizard != null && !wizard.canGoNext()) {
			float x2, y2, dx, dy;

			switch (event.getAction()) {
				case (MotionEvent.ACTION_DOWN):
					x1 = event.getX();
					y1 = event.getY();

					return true;

				case (MotionEvent.ACTION_MOVE):

					x2 = event.getX();
					y2 = event.getY();
					dx = x2 - x1;
					dy = y2 - y1;


					if (Math.abs(dx) > Math.abs(dy)) {
						if (dx < 0) {
							return false;
						}
					}
					break;

				case (MotionEvent.ACTION_UP):
					x1 = 0;
					y1 = 0;
					break;

			}

		}
		return super.onTouchEvent(event);
	}
}
