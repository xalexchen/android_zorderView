package com.example.zorder;

import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

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
	private AbsoluteLayout.LayoutParams params;
	public ZView (View child,AbsoluteLayout.LayoutParams params) {
		this.child = child;
		this.params = params;
	}
	public View getView() {
		return child;
	}
	public LayoutParams getParams() {
		return params;
	}
}

public class MainActivity extends Activity {
	@SuppressWarnings("deprecation")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		AbsoluteLayout layout = new AbsoluteLayout(this);
		Map<Integer,ZView> zMap = new TreeMap<Integer,ZView>();

		
		TextView z1 = new TextView(this);
		z1.setBackgroundColor(Color.parseColor("red"));
		AbsoluteLayout.LayoutParams lpz1 = new AbsoluteLayout.LayoutParams(
				500,
				500,
				300,
				300);
		ZView z1View = new ZView(z1, lpz1);
		zMap.put(2, z1View);
		
		TextView z2 = new TextView(this);
		z2.setBackgroundColor(Color.parseColor("green"));
		AbsoluteLayout.LayoutParams lpz2 = new AbsoluteLayout.LayoutParams(
				300,
				300,
				400,
				100);
		ZView z2View = new ZView(z2, lpz2);
		zMap.put(5, z2View);
		
		TextView z0 = new TextView(this);
		z0.setBackgroundColor(Color.parseColor("blue"));
		AbsoluteLayout.LayoutParams lpz0 = new AbsoluteLayout.LayoutParams(
				500,
				500,
				0,
				0);
		ZView z0View = new ZView(z0, lpz0);
		zMap.put(9, z0View);
		
		for (Integer s :zMap.keySet()){
			layout.addView(zMap.get(s).getView(), zMap.get(s).getParams());
		}
		setContentView(layout);
	}
}
