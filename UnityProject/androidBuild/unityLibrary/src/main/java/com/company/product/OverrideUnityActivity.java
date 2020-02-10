package com.company.product;
import android.os.Bundle;
import android.widget.FrameLayout;

import com.unity3d.player.UnityPlayerActivity;

public abstract class OverrideUnityActivity extends UnityPlayerActivity
{
    public static OverrideUnityActivity instance = null;
    public static String message = null;

    abstract protected void showMainActivity();

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        // only for Nougat and newer versions
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.N) {
            instance = this;
        }else{
            message = "This Feature Requires OS version Nougat and above";
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        instance = null;
    }
}
