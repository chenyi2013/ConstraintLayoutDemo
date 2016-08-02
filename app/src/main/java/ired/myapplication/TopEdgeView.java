package ired.myapplication;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;

public class TopEdgeView extends View {
	
	Paint paint = new Paint();
	int padding = 20;
	int d = 3;
	int r = 4;
	int h = 5;
	boolean isOverDay = false;
	
	int normalColor = Color.parseColor("#ff5b73");
	int overDayColor = Color.parseColor("#aaaaaa");
	
	Rect rect = new Rect();
	
	private int dpToPx(int dp){
		return (int)TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP
				, dp
				, getContext().getResources().getDisplayMetrics());
	}
	
	
	
	public int getPadding() {
		return padding;
	}



	public void setPadding(int padding) {
		this.padding = padding;
		invalidate();
	}



	public int getD() {
		return d;
	}



	public void setD(int d) {
		this.d = d;
		invalidate();
	}



	public int getR() {
		return r;
	}



	public void setR(int r) {
		this.r = r;
		invalidate();
	}



	public int getH() {
		return h;
	}



	public void setH(int h) {
		this.h = h;
        invalidate();
	}



	public int getNormalColor() {
		return normalColor;
	}



	public void setNormalColor(int normalColor) {
		this.normalColor = normalColor;
		invalidate();
	}



	public int getOverDayColor() {
		return overDayColor;
	}



	public void setOverDayColor(int overDayColor) {
		this.overDayColor = overDayColor;
		invalidate();
	}



	public void setOverDay(boolean isOverDay){
		this.isOverDay = isOverDay;
		invalidate();
		
	}

	public TopEdgeView(Context context) {
		super(context);
		init();
	}

	public TopEdgeView(Context context, AttributeSet attrs) {
		super(context, attrs);
		init();
	}

	public TopEdgeView(Context context, AttributeSet attrs, int defStyleAttr) {
		super(context, attrs, defStyleAttr);
		init();
	}
	
	private void init(){
		padding = dpToPx(padding);
		d = dpToPx(d);
		r = dpToPx(r);
		h = dpToPx(h);
		paint.setAntiAlias(true);
		paint.setDither(true);
		
	}
	
	@Override
	protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
		super.onMeasure(widthMeasureSpec, heightMeasureSpec);
		int w = MeasureSpec.getSize(widthMeasureSpec);
		setMeasuredDimension(w, r+h);
	}


	@Override
	protected void onDraw(Canvas canvas) {
		super.onDraw(canvas);
		
		if(isOverDay){
			paint.setColor(overDayColor);
		}else{
			paint.setColor(normalColor);
		}
		
		rect.set(0,0,getWidth(),h);
		int x = (int) ((getWidth()-2*padding-r)/(2*(r+d)*1.0));
		for(int i = 0;i <= x;i++){
			canvas.drawCircle(padding+2*(r+d)*i+r, h, r, paint);
		}
		canvas.drawRect(rect, paint);
	}

}
