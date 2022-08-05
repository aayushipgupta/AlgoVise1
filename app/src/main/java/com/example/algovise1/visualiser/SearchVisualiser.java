package com.example.algovise1.visualiser;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;

import com.example.algovise1.Algorithm;

import java.util.ArrayList;
import java.util.List;

public class SearchVisualiser extends View {
    Paint paint;
    Paint highlightPaint; //blue paint
    Paint highlightPaintTrace; //red paint
    Paint textPaint;
    int[] arr = {3,1,8,4,2,9};
    List<Integer> highlightPositions = new ArrayList<>();
    int highlightPositionTrace = -1;

    public SearchVisualiser(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public SearchVisualiser(Context context) {
        super(context);
        init();
    }

    private void init() {
        paint = new Paint();
        paint.setColor(Color.parseColor("#009688"));
        paint.setStyle(Paint.Style.FILL);
        //paint.setStrokeWidth(lineStrokeWidth);

        highlightPaint = new Paint(paint);
        highlightPaint.setColor(Color.BLUE);

        highlightPaintTrace = new Paint(paint);
        highlightPaintTrace.setColor(Color.RED);

        textPaint = new Paint();
        textPaint.setColor(Color.BLACK);
        textPaint.setTextSize(50);
    }

    @Override
    public void onDraw(Canvas canvas) {
        int x = 30;
        int y = 0, width = 160;
        int newWidth=0;
        Rect rect;

        for(int i=0;i<arr.length;i++)
        {
            rect = new Rect(x+newWidth+10,150,newWidth+width+20,y);
            if(highlightPositions.contains(i)){
                if (highlightPositionTrace != -1 && highlightPositionTrace == i) {
                    canvas.drawRect(rect,highlightPaintTrace);
                }
                else {
                    canvas.drawRect(rect,highlightPaint);
                }
            }
            else {
                if (highlightPositionTrace != -1 && highlightPositionTrace == i) {
                    canvas.drawRect(rect,highlightPaintTrace);
                }
                else {
                    canvas.drawRect(rect,paint);
                }
            }
            canvas.drawText(String.valueOf(arr[i]), rect.centerX()-20, rect.centerY()+20 , textPaint);
            newWidth += x+width;
        }
        super.onDraw(canvas);
        highlightPositions.clear();
        highlightPositionTrace = -1;
    }

    public void highlight(List<Integer> positions) {
        this.highlightPositions.clear();
        this.highlightPositions.addAll(positions);
        invalidate();
    }

    public void highlightTrace(int pos) {
        this.highlightPositionTrace = pos;
        invalidate();
    }
}
