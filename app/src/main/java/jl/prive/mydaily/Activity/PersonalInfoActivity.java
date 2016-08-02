package jl.prive.mydaily.Activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.Toast;

import jl.prive.mydaily.MainActivity;
import jl.prive.mydaily.R;
import jl.prive.mydaily.view.HeadPicPopupWindow;

/**
 * Created by Administrator on 2016/3/30.
 */
public class PersonalInfoActivity extends Activity {
    /**
     * 返回主Activity按钮
     */
    private ImageView personalBakButton;

    /**
     * 设置头像的界面
     */
    private HeadPicPopupWindow mHeadPicPopupWindow;
    /**
     * 修改头像
     */
    private FrameLayout editHeadImageFrameLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.personal_info);
        personalBakButton = (ImageView) findViewById(R.id.personal_back);
        personalBakButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(PersonalInfoActivity.this, MainActivity.class));
                finish();
            }
        });
        editHeadImageFrameLayout = (FrameLayout) findViewById(R.id.edit_head);
        /**
         * 实现头像处理
         */
        editHeadImageFrameLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mHeadPicPopupWindow == null){
                    // 实例化布局窗口对象
                    mHeadPicPopupWindow = new HeadPicPopupWindow(PersonalInfoActivity.this,itemsOnclick);
                }
                // 显示窗口
                mHeadPicPopupWindow.showAtLocation(PersonalInfoActivity.this.findViewById(R.id.personal_info), Gravity.CENTER, 0, 0);

            }
        });

    }

    private View.OnClickListener itemsOnclick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            mHeadPicPopupWindow.dismiss();
            switch (v.getId()) {
                case R.id.pic_set_take:
                    Toast.makeText(PersonalInfoActivity.this,"head pic set by cam",Toast.LENGTH_LONG).show();
                    break;
                case R.id.pic_set_gallery:
                    Toast.makeText(PersonalInfoActivity.this,"head pic set by gallery",Toast.LENGTH_LONG).show();
                    break;
                default:
                    break;
            }
        }
    };

}

