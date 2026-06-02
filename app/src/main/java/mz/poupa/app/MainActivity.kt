package mz.poupa.app

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import android.webkit.WebSettings
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.activity.ComponentActivity
import androidx.activity.OnBackPressedCallback

class MainActivity : ComponentActivity() {

    private lateinit var webView: WebView

    @SuppressLint("SetJavaScriptEnabled")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        webView = WebView(this)
        setContentView(webView)

        // Ecrã cheio limpo
        webView.systemUiVisibility = View.SYSTEM_UI_FLAG_LAYOUT_STABLE

        webView.settings.apply {
            javaScriptEnabled = true          // a app precisa de JS
            domStorageEnabled = true          // localStorage (guardar dados!)
            databaseEnabled = true
            cacheMode = WebSettings.LOAD_DEFAULT
            loadWithOverviewMode = true
            useWideViewPort = true
            allowFileAccess = true
        }

        webView.webViewClient = WebViewClient()

        // Carrega a app embutida em assets
        webView.loadUrl("file:///android_asset/index.html")

        // Botão voltar do Android = voltar no WebView, se possível
        onBackPressedDispatcher.addCallback(this, object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                if (webView.canGoBack()) webView.goBack()
                else finish()
            }
        })
    }
}
