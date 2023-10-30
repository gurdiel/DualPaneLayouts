package com.mpd.pmdm.dualpanelayouts

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class DetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        //Recogemos el id del signo clickado del Bunble intent.extras
        val starSignId = intent.extras?.getInt(STAR_SIGN_ID, 0) ?: 0
        //Actualizamos la información del signo
        val detailFragment = supportFragmentManager
            .findFragmentById(R.id.star_sign_detail) as DetailFragment
        detailFragment.setStarSignData(starSignId)
    }
}