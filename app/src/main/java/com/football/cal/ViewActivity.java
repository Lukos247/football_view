package com.football.cal;

import android.Manifest;
import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.Window;
import android.view.WindowManager;
import android.webkit.CookieManager;
import android.webkit.PermissionRequest;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

public class ViewActivity extends AppCompatActivity {

    private static final String EXTRA_PARAM = "ViewActivity.Link";
    private WebView mView;

    private static final int FILECHOOSER_RESULTCODE = 1;
    private static final int REQUEST_SELECT_FILE = 100;

    private ValueCallback<Uri> mUploadMessage;
    private ValueCallback<Uri[]> uploadMessage;

    public static void start(Context context, String link) {
        context.startActivity(new Intent(context, ViewActivity.class).setFlags(Intent.FLAG_ACTIVITY_NEW_TASK));
    }

    @Override
    @SuppressLint("SetJavaScriptEnabled")
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_view);

        String link = getIntent().getStringExtra("test");

        if (TextUtils.isEmpty(link)) { return; }

        //link = "https://track.r10web.com/click?pid=13957&offer_id=380";
        //link = "http://khl.pw/LG8SzN5D";

        mView = findViewById(R.id.view);

        CookieManager cookieManager = CookieManager.getInstance();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            cookieManager.setAcceptThirdPartyCookies(mView,true);
        } else {
            cookieManager.setAcceptCookie(true);
        }


        mView.getSettings().setUseWideViewPort(true);
        mView.getSettings().setLoadWithOverviewMode(true);

        mView.getSettings().setSupportZoom(true);
        mView.getSettings().setBuiltInZoomControls(true);
        mView.getSettings().setDisplayZoomControls(false);

        mView.getSettings().setJavaScriptEnabled(true);
        mView.getSettings().setDomStorageEnabled(true);
        mView.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);

        WebSettings webSettings = mView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webSettings.setDomStorageEnabled(true);
        webSettings.setLoadWithOverviewMode(true);
        webSettings.setUseWideViewPort(true);
        webSettings.setBuiltInZoomControls(true);
        webSettings.setDisplayZoomControls(false);
        webSettings.setSupportZoom(true);
        webSettings.setDefaultTextEncodingName("utf-8");

        mView.getSettings().setJavaScriptEnabled(true);
        mView.getSettings().setDomStorageEnabled(true);

        // WebViewClient
        mView.setWebViewClient(new WebViewClient() {
            @Override
            public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) { }

            @Override
            @TargetApi(23)
            public void onReceivedError(WebView view, WebResourceRequest request, WebResourceError error) {
                onReceivedError(view, error.getErrorCode(), error.getDescription().toString(), request.getUrl().toString());
            }

            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return true;
            }
        });

        // WebChromeClient
        // https://stackoverflow.com/questions/5907369/file-upload-in-webview/11414660

        mView.setWebChromeClient(new WebChromeClient() {

            public void onPermissionRequest(PermissionRequest request) {
                Log.d("MainActivity", "onPermissionRequest");
                //requestPermission(request);

                if (Build.VERSION.SDK_INT >= 23
                        && (ContextCompat.checkSelfPermission(ViewActivity.this, Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED
                        || ContextCompat.checkSelfPermission(ViewActivity.this, Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED)) {

                    ActivityCompat.requestPermissions(ViewActivity.this, new String[] { Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.CAMERA }, REQUEST_SELECT_FILE);
                }
            }

            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            public boolean onShowFileChooser(WebView webView, ValueCallback<Uri[]> filePathCallback, FileChooserParams fileChooserParams) {
                if (uploadMessage != null) {
                    uploadMessage.onReceiveValue(null);
                    uploadMessage = null;
                }

                uploadMessage = filePathCallback;

                Intent intent = fileChooserParams.createIntent();

                try {
                    startActivityForResult(intent, REQUEST_SELECT_FILE);
                } catch (Exception e) {
                    uploadMessage = null;
                    Toast.makeText(getApplicationContext(), "Cannot Open File Chooser", Toast.LENGTH_LONG).show();
                    return false;
                }
                return true;
            }

            protected void openFileChooser(ValueCallback<Uri> uploadMsg) {
                mUploadMessage = uploadMsg;
                Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
                intent.addCategory(Intent.CATEGORY_OPENABLE);
                intent.setType("*/*");
                startActivityForResult(Intent.createChooser(intent, "File Chooser"), FILECHOOSER_RESULTCODE);
            }
        });

        mView.loadUrl(link);
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        //super.onActivityResult(requestCode, resultCode, intent);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            if (requestCode == REQUEST_SELECT_FILE) {
                if (uploadMessage == null) {
                    return;
                }

                Uri[] results = WebChromeClient.FileChooserParams.parseResult(resultCode, data);
                uploadMessage.onReceiveValue(results);
                uploadMessage = null;
            }
        } else if (requestCode == FILECHOOSER_RESULTCODE) {
            if (null == mUploadMessage) {
                return;
            }

            Uri result = (getIntent() == null || resultCode != RESULT_OK) ? null : getIntent().getData();
            mUploadMessage.onReceiveValue(result);
            mUploadMessage = null;
        } else {
            Toast.makeText(getApplicationContext(), "Failed to Upload Image", Toast.LENGTH_LONG).show();
        }
    }


    @Override
    public void onBackPressed() {
        if (mView.canGoBack()) {
            mView.goBack();
        } else {
            super.onBackPressed();
        }
    }
}