package jl.prive.mydaily.view;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupWindow;
import android.widget.TextView;

import jl.prive.mydaily.R;

/**
 * Created by Administrator on 2016/3/31.
 */
public class HeadPicPopupWindow extends PopupWindow {
    private TextView mPicSetTakeTextView,mPicSetGalleryTextView,mPicSetCancelTextView;
    private View mPicSetView;

    public HeadPicPopupWindow(Activity context , View.OnClickListener itemsOnClick){
        super(context);
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        mPicSetView = inflater.inflate(R.layout.headpic_popupwindow, null);
        mPicSetTakeTextView = (TextView) mPicSetView.findViewById(R.id.pic_set_take);
        mPicSetGalleryTextView = (TextView) mPicSetView.findViewById(R.id.pic_set_gallery);
        mPicSetCancelTextView = (TextView) mPicSetView.findViewById(R.id.pic_set_cancel);
        //取消按钮
        mPicSetCancelTextView.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                //销毁弹出框
                dismiss();
            }
        });
        //设置按钮监听
        mPicSetTakeTextView.setOnClickListener(itemsOnClick);
        mPicSetGalleryTextView.setOnClickListener(itemsOnClick);

        //设置PopupWindow的View
        this.setContentView(mPicSetView);
        //设置PopupWindow弹出窗体的宽
        DisplayMetrics dm = new DisplayMetrics();
        context.getWindowManager().getDefaultDisplay().getMetrics(dm);
        this.setWidth(dm.widthPixels-40);
        //设置PopupWindow弹出窗体的高
        this.setHeight(ViewGroup.LayoutParams.WRAP_CONTENT);

        //设置PopupWindow是否可聚焦--当为false的时候发现，点击外部时自己不会消失，外部也可响应
//        this.setFocusable(false);
        this.setOutsideTouchable(false);//---为false的，Focusable不设置时，点击外部
        //设置PopupWindow弹出窗体动画效果---暂时不设置
//        this.setAnimationStyle(R.style.AnimBottom);
        //实例化一个ColorDrawable颜色为半透明
        ColorDrawable dw = new ColorDrawable(0xb0000000);
        //设置SelectPicPopupWindow弹出窗体的背景
//        this.setBackgroundDrawable(dw);
        //mMenuView添加OnTouchListener监听判断获取触屏位置如果在选择框外面则销毁弹出框
        mPicSetView.setOnTouchListener(new View.OnTouchListener() {

            public boolean onTouch(View v, MotionEvent event) {

                int height = mPicSetView.findViewById(R.id.pic_set_layout).getTop();
                int y=(int) event.getY();
                if(event.getAction()==MotionEvent.ACTION_UP){
                    if(y<height){
                        dismiss();
                    }
                }
                return true;
            }
        });

    }

}