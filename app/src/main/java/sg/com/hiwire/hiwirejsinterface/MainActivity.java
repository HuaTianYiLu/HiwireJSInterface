package sg.com.hiwire.hiwirejsinterface;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.JavascriptInterface;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import sg.com.hiwire.customlibrary.AlertDialog;
import sg.com.hiwire.customlibrary.RandomInt;

public class MainActivity extends AppCompatActivity {

    private sg.com.hiwire.customlibrary.AlertDialog alertDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        alertDialog = new AlertDialog(this);
        alertDialog.showMessage("In protected void onCreate(Bundle savedInstanceState) ...");

        // Adapted from page: http://developer.android.com/guide/webapps/webview.html
        // We will use the webview created in activity_main.xml
        WebView myWebView = (WebView) findViewById(R.id.webview);

        WebSettings webSettings = myWebView.getSettings();
        // Enable Javascript to run in web view.
        webSettings.setJavaScriptEnabled(true);
        myWebView.addJavascriptInterface(new WebAppInterface(this), getResources().getString(R.string.javascript_object_name));
        // All user's clicks to a link will be displayed on the web view instead of the
        // default action of launching a mobile browser and showing the link on it.
        myWebView.setWebViewClient(new WebViewClient());
        //String url = getResources().getString(R.string.realapps_url) + "?popup=0&cid=clara&nclient=30";
        // Add random number to force browser not to use the cached version
        String url = getResources().getString(R.string.android_bridge_demo_url) + "?rn=" + RandomInt.get();
        myWebView.loadUrl(url);
    }

    public class WebAppInterface {
        Context mContext;

        WebAppInterface(Context c) {
            mContext = c;
        }

        /**
         * Expose this method to Javascript
         */
        @JavascriptInterface
        public void showToast(String msg) {
            alertDialog.showMessage(msg);
        }
    }
}
