package com.example.memeshare

import android.content.Intent
import android.graphics.drawable.Drawable
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.target.Target



import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.ProgressBar
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest
import com.bumptech.glide.Glide

class MainActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        loadMeme()
    }

    private var currentImageUrl: String? = null


    private fun loadMeme(){

        val memeimageView: ImageView = findViewById(R.id.memeimageView)
        val progressBar: ProgressBar = findViewById(R.id.progressBar)

        progressBar.visibility = View.VISIBLE
        // Instantiate the RequestQueue.
        val currentImageUrl = "https://meme-api.herokuapp.com/gimme"
// Request a string response from the provided URL.
        val jsonRequest = JsonObjectRequest(
            Request.Method.GET, currentImageUrl, null,
            Response.Listener { response ->
                val url = response.getString("url")

                Glide.with(this).load(url).listener(object : RequestListener<Drawable> {
                    override fun onLoadFailed(
                        e: GlideException?,
                        model: Any?,
                        target: Target<Drawable>?,
                        isFirstResource: Boolean
                    ): Boolean {
                        progressBar.visibility = View.GONE
                        return false
                    }

                    override fun onResourceReady(
                        resource: Drawable?,
                        model: Any?,
                        target: Target<Drawable>?,
                        dataSource: DataSource?,
                        isFirstResource: Boolean
                    ): Boolean {
                        progressBar.visibility = View.GONE
                        return false
                    }

                }).into(memeimageView)


            },
            Response.ErrorListener {

            })

    // Add the request to the RequestQueue.
        MySingleton.getInstance(this).addToRequestQueue(jsonRequest)
    }

    fun sharememe(view: View) {
        val intent = Intent(Intent.ACTION_SEND)
        intent.type = "text/plain"
        intent.putExtra(Intent.EXTRA_TEXT, "Hey, CheckOut this new meme $currentImageUrl")
        val choose = Intent.createChooser(intent, "share this meme using...")
        startActivity(choose)
    }
    fun nextmeme(view: View) {
        loadMeme()
    }
}