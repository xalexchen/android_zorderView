package com.example.zorder;

import java.util.ArrayList;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.AbsoluteLayout;
import android.widget.AbsoluteLayout.LayoutParams;
import android.widget.TextView;

@SuppressWarnings("deprecation")
class ZView {
	private View child;
	private LayoutParams params;
	private int z;
	public void addView (View child,LayoutParams params,int z) {
		this.child = child;
		this.params = params;
		this.z = z;
	}
	public View getView() {
		return child;
	}
	public LayoutParams getParams() {
		return params;
	}
	public int getZ() {
		return z;
	}
}

public class MainActivity extends Activity {
	private ArrayList<ZView> zview;
	@SuppressWarnings("deprecation")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		zview = new ArrayList<ZView>();
		AbsoluteLayout layout = new AbsoluteLayout(this);
		
		
		TextView z1 = new TextView(this);
		z1.setBackgroundColor(Color.parseColor("red"));
		AbsoluteLayout.LayoutParams lpz1 = new AbsoluteLayout.LayoutParams(
				500,
				500,
				300,
				300);
		ZView z1View = new ZView();
		z1View.addView(z1, lpz1,1);
		zview.add(z1View);
		
		
		TextView z2 = new TextView(this);
		z2.setBackgroundColor(Color.parseColor("green"));
		AbsoluteLayout.LayoutParams lpz2 = new AbsoluteLayout.LayoutParams(
				300,
				300,
				400,
				100);
		ZView z2View = new ZView();
		z2View.addView(z2, lpz2,2);
		zview.add(z2View);
		
		
		TextView z0 = new TextView(this);
		z0.setBackgroundColor(Color.parseColor("blue"));
		AbsoluteLayout.LayoutParams lpz0 = new AbsoluteLayout.LayoutParams(
				500,
				500,
				0,
				0);
		ZView z0View = new ZView();
		z0View.addView(z0, lpz0,0);
		zview.add(z0View);
		
		// according to z order ,add into viewgroup
		for(int z = 0; z < zview.size();z++) {
			for (ZView view:zview) {
				if (z == view.getZ()) {
					layout.addView(view.getView(), view.getParams());
				}
			}
		}
		zview = null;
		setContentView(layout);
	}
}
