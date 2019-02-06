package com.widsons.pklproj.custom;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.RelativeLayout;

import com.widsons.pklproj.R;

/**
 * Created on : February/06/2019
 * Author     : Muhammad Fahmi Hidayah
 * Company    : PiXilApps
 * Project    : PklProj
 */
public class SwitchCustomView extends RelativeLayout {

    private View viewToggle;
    private boolean isChecked;

    private OnChangeListener onChangeListener = new OnChangeListener() {
        @Override
        public void onChange(boolean isChecked) {

        }
    };

    public SwitchCustomView(Context context) {
        super(context);
        initial(context, null);
    }

    public SwitchCustomView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initial(context, attrs);
    }

    public SwitchCustomView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initial(context, attrs);
    }

    private void initial(Context context, AttributeSet attrs) {
        RelativeLayout viewGroup = (RelativeLayout) LayoutInflater.from(context).inflate(R.layout.switch_custom_view, this, false);
        addView(viewGroup);
        viewToggle = viewGroup.findViewById(R.id.view_toggle);
        setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                setChecked(!isChecked);
                if(isChecked) {
                    RelativeLayout.LayoutParams layoutParams = (LayoutParams) viewToggle.getLayoutParams();
                    layoutParams.removeRule(RelativeLayout.ALIGN_PARENT_START);
                    layoutParams.addRule(RelativeLayout.ALIGN_PARENT_END);
                    viewToggle.setLayoutParams(layoutParams);
                    onChangeListener.onChange(isChecked);
                }
                else {
                    RelativeLayout.LayoutParams layoutParams = (LayoutParams) viewToggle.getLayoutParams();
                    layoutParams.addRule(RelativeLayout.ALIGN_PARENT_START);
                    layoutParams.removeRule(RelativeLayout.ALIGN_PARENT_END);
                    viewToggle.setLayoutParams(layoutParams);
                    onChangeListener.onChange(isChecked);
                }
            }
        });
    }

    public void setChecked(boolean checked) {
        isChecked = checked;
    }

    public boolean isChecked() {
        return isChecked;
    }

    public void setOnChangeListener(OnChangeListener onChangeListener) {
        this.onChangeListener = onChangeListener;
    }

    public interface OnChangeListener {
        void onChange(boolean isChecked);
    }
}
