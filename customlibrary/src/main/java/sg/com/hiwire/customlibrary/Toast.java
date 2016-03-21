package sg.com.hiwire.customlibrary;

import android.content.Context;

public class Toast {
    private Context context;
    private static int duration = android.widget.Toast.LENGTH_SHORT;

    public Toast(Context mContext) {
        if (mContext != null) {
            context = mContext;
        }
    }

    public void show(String message) {
        if (context != null) {
            if (message != null) {
                android.widget.Toast.makeText(context, message, duration);
            }
        }
    }

    public void show(String message, boolean longerDuration) {
        if (context != null) {
            if (message != null) {
                int myDuration = (longerDuration ? android.widget.Toast.LENGTH_LONG : duration);
                android.widget.Toast.makeText(context, message, myDuration);
            }
        }
    }
}
