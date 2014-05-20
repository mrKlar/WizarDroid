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
		return false;
	}

	@Override
	public boolean onTouchEvent(MotionEvent event) {
		return false;
	}
}
