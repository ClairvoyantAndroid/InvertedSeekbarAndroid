package android.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;

/** Create a Custom Class which Extends SeekBar*/

public class VerticalSeekBar_Reverse extends SeekBar {

    public VerticalSeekBar_Reverse(Context context) {
        super(context);
    }

    public VerticalSeekBar_Reverse(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    public VerticalSeekBar_Reverse(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(h, w, oldh, oldw);
    }

    @Override
    protected synchronized void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(heightMeasureSpec, widthMeasureSpec);
        setMeasuredDimension(getMeasuredHeight(), getMeasuredWidth());
    }
    
    /** Override the onDraw to rotate the Canvas which in turn rotates our SeekBar object based on
     * the Rotation Parameters*/
    
    protected void onDraw(Canvas c) {
        c.rotate(90);
        c.translate(0, -getWidth());
        super.onDraw(c);
    }

    /** Override the onTouchEvent to get hold of the Motion Events 
     * And In the Action Up Calculate the progress percent and set The Progress*/
    
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (!isEnabled()) {
            return false;
        }

        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
            case MotionEvent.ACTION_MOVE:
            case MotionEvent.ACTION_UP:
            	int i=0;
            	i=getMax() - (int) (getMax() * event.getY() / getHeight());
                setProgress(100-i);
                Log.i("Progress",getProgress()+"");
                onSizeChanged(getWidth(), getHeight(), 0, 0);
                break;

            case MotionEvent.ACTION_CANCEL:
                break;
        }
        return true;
    }
    
}