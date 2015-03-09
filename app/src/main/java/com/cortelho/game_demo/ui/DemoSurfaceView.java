package com.cortelho.game_demo.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.util.AttributeSet;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import com.cortelho.game_demo.R;

/**
 * Created by martinho on 3/9/15.
 */
public class DemoSurfaceView extends SurfaceView {
    private DemoDrawThread drawingThread;
    private SurfaceHolder holder = null;
    private Bitmap bitmap = null;

    public DemoSurfaceView(Context context, AttributeSet attrs) {
        super(context, attrs);
        holder = getHolder();
        holder.addCallback(new SurfaceHolder.Callback() {

            @Override
            public void surfaceDestroyed(SurfaceHolder holder) {
            }

            @Override
            public void surfaceCreated(SurfaceHolder holder) {
                Canvas c = holder.lockCanvas(null);
                onDraw(c);
                holder.unlockCanvasAndPost(c);
            }

            @Override
            public void surfaceChanged(SurfaceHolder holder, int format,
                                       int width, int height) {
            }
        });

        //drawingThread = new DemoDrawThread();
        bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.soldier_sprite);
    }

    @Override
    public void onDraw(Canvas canvas) {
        Log.e("CARALLO", "RED");
        canvas.drawColor(Color.RED);
        canvas.drawBitmap(bitmap, 50, 50, null);
    }
}
