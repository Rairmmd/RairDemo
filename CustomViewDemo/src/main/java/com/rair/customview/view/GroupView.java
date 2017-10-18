package com.rair.customview.view;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import com.rair.customview.R;

public class GroupView extends ViewGroup {
    public GroupView(Context context) {
        this(context, null);
    }

    public GroupView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView(context, attrs);
        addViews(context);
    }

    // 自定义属性对应变量
    private String title;
    private int bgColor;
    private int titleColor;
    private Drawable backDrawable;
    private int titleSize;
    private Paint paint;
    private int screenWidth;

    /**
     * 初始化视图
     *
     * @param context
     * @param attrs
     */
    private void initView(Context context, AttributeSet attrs) {
        // 解析自定义属性
        TypedArray array = context.obtainStyledAttributes(attrs, R.styleable.GroupView);
        title = array.getString(R.styleable.GroupView_title_text);
        bgColor = array.getColor(R.styleable.GroupView_nav_bg, 0x0);
        titleColor = array.getColor(R.styleable.GroupView_title_color, 0xF);
        backDrawable = array.getDrawable(R.styleable.GroupView_back_image);
        titleSize = array.getDimensionPixelSize(R.styleable.GroupView_title_size, 10);
        array.recycle();
        // 设置背景颜色
        this.setBackgroundColor(bgColor);
        // 初始化画笔
        paint = new Paint();
        paint.setAntiAlias(true);
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(bgColor);

        DisplayMetrics metrics = new DisplayMetrics();
        WindowManager windowManager = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        windowManager.getDefaultDisplay().getMetrics(metrics);
        // 屏幕宽度
        screenWidth = metrics.widthPixels;
    }

    private ImageView imageView;
    private TextView tvTitle;

    /**
     * 添加子控件
     */
    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    private void addViews(Context context) {
        imageView = new ImageView(context);
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        imageView.setBackground(backDrawable);
        LayoutParams layoutParam = new LayoutParams(100, 100);
        imageView.setLayoutParams(layoutParam);
        imageView.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (listener != null) {
                    listener.onFinish();
                }
            }
        });

        // 添加一个ImageView
        this.addView(imageView);
        //TextView
        tvTitle = new TextView(context);
        tvTitle.setTextSize(20);
        tvTitle.setText(title);
        tvTitle.setTextColor(titleColor);
        this.addView(tvTitle);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        // 要测量子控件的高度和宽度
        // 计算子控件
        measureChildren(widthMeasureSpec, heightMeasureSpec);
        // 先计量控件的宽度
        int widthMode = MeasureSpec.getMode(widthMeasureSpec);
        int measureWidth = 0;
        // 确切大小 500dp 或者 match_parent
        if (widthMode == MeasureSpec.EXACTLY) {
            measureWidth = MeasureSpec.getSize(widthMeasureSpec);
        }
        // wrap_content
        else if (widthMode == MeasureSpec.AT_MOST) {
            // 设置屏幕的宽度
            measureWidth = screenWidth;
        }
        // 高度计算,获取最高的控件
        int measureHeight = 0;
        int childCount = this.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View child = this.getChildAt(i);
            // child.getMeasuredHeight()能够获取到具体的控件大小
            // 必须先调用measureChildren(widthMeasureSpec,heightMeasureSpec);
            // 判断哪个控件的高度最大，来作为视图容器的高度
            if (child.getMeasuredHeight() > measureHeight) {
                measureHeight = child.getMeasuredHeight();
            }
        }
        //getChildAt(0).getMeasuredHeight();
        setMeasuredDimension(measureWidth, measureHeight + 50);
    }

    /**
     * 当视图初始化，或者视图位置发生改变时候
     *
     * @param changed 是否改变
     * @param l 左
     * @param t 上
     * @param r 右
     * @param b 下
     */
    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        //getWidth()
        // 需要设置子控件显示的位置
        //getChildAt(0).layout();
        // 控件的宽度
        int viewWidth = getMeasuredWidth();
        int viewHeight = getMeasuredHeight();
        int left = 0, top = 0, right = 0, bottom = 0;
        int childCount = this.getChildCount();
        View view = null;
        for (int i = 0; i < childCount; i++) {
            view = this.getChildAt(i);
            if (i == 0) {
                left = view.getMeasuredWidth() / 3;
            } else if (i == 1) {
                left = (viewWidth - view.getMeasuredWidth()) / 2;
            }
            top = (viewHeight - view.getMeasuredHeight()) / 2;
            right = left + view.getMeasuredWidth();
            bottom = top + view.getMeasuredHeight();
            view.layout(left, top, right, bottom);
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                break;
        }
        return super.onTouchEvent(event);
    }

    public interface OnFinishListener {
        void onFinish();
    }

    private OnFinishListener listener;

    public void setOnFinishListener(OnFinishListener listener) {
        this.listener = listener;
    }
}
