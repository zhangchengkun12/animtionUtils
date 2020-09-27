package com.zhangxuetao;


import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.graphics.Path;
import android.view.View;
import android.view.animation.LinearInterpolator;

class AnimatorPresenter {
    public static final int INFINITE = -1;
    public void OfFloat(View view,String value,float[] startValue,float[] endValue,int[] duration,int repeatCount){
        switch (value.toLowerCase())
        {
            case "alpha":
                alpha(view,startValue,endValue,duration,repeatCount);
                break;
            case "translationy":
                break;
            case "translationx":
                break;
            case "scale":
                break;
            case "xy":
                translationXY(view,startValue,endValue,duration);
                break;
        }
    }
    private void translationy(View view,float[] startValue,float[] endValue,int[] duration,int repeatCount)
    {
        ObjectAnimator animator0 ;
        if (repeatCount==INFINITE)
        {
            animator0= ObjectAnimator.ofFloat(view, "translationY", startValue[0], endValue[0],startValue[0]);
            animator0.setRepeatCount(ValueAnimator.INFINITE);
        }
        else if (repeatCount>0)
        {
            animator0= ObjectAnimator.ofFloat(view, "translationY", startValue[0], endValue[0],startValue[0]);
            animator0.setRepeatCount(repeatCount);
        }
        else {
            animator0= ObjectAnimator.ofFloat(view, "translationY", startValue[0], endValue[0]);        }
        animator0.setDuration(duration[0]);
        if (duration.length>1&&duration[1]>0)
        {
            animator0.setStartDelay(duration[1]);
        }
        animator0.setInterpolator(new LinearInterpolator());
        animator0.start();
    }

    private void translationXY(View view,float[] startValue,float[] endValue,int[] duration)
    {
        Path path = new Path();
        path.moveTo(startValue[0],startValue[1]);
        path.lineTo(endValue[0],endValue[1]);
        ObjectAnimator animator0 ;
        animator0= ObjectAnimator.ofFloat(view, View.X,View.Y,path);
        if (duration.length>0&&duration[1]>0)
        {
            animator0.setDuration(duration[0]);
        }

        if (duration.length>1&&duration[1]>0)
        {
            animator0.setStartDelay(duration[1]);
        }
        animator0.setInterpolator(new LinearInterpolator());
        animator0.start();
    }
    private void alpha(View view,float[] startValue,float[] endValue,int[] duration,int repeatCount)
    {
        ObjectAnimator animator0 ;
        if (repeatCount==INFINITE)
        {
            animator0= ObjectAnimator.ofFloat(view, "alpha", startValue[0], endValue[0],startValue[0]);
            animator0.setRepeatCount(ValueAnimator.INFINITE);
        }
        else if (repeatCount>0)
        {
            animator0= ObjectAnimator.ofFloat(view, "alpha", startValue[0], endValue[0],startValue[0]);
            animator0.setRepeatCount(repeatCount);
        }
        else {
            animator0= ObjectAnimator.ofFloat(view, "alpha", startValue[0], endValue[0]);        }
        animator0.setDuration(duration[0]);
        if (duration.length>1&&duration[1]>0)
        {
            animator0.setStartDelay(duration[1]);
        }
        animator0.setInterpolator(new LinearInterpolator());
        animator0.start();
    }
}
