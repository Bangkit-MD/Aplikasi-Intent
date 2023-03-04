package com.example.explisitintentapps

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.result.contract.ActivityResultContracts

class MainActivity : AppCompatActivity() {
    private lateinit var tvResult : TextView
    private val resultLauncher = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ){result ->
        if(result.resultCode == MoveResultActivity.RESULT_CODE && result.data != null){
            val selectedValue =
                result.data?.getIntExtra(MoveResultActivity.EXTRA_SELECTED_VALUE, 0)
            tvResult.text = "Hasil: $selectedValue"
        }

    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val btnMoveActivity: Button = findViewById(R.id.move_activity)
        val btnMoveWithData: Button = findViewById(R.id.move_with_data)
        val btnMoveWithObject: Button = findViewById(R.id.move_with_object)
        val btnMoveWithDial: Button = findViewById(R.id.move_with_implicit)
        val btnUrl: Button = findViewById(R.id.url_link)

        tvResult = findViewById(R.id.tv_result)
        val btnWithResult: Button = findViewById(R.id.btn_move_for_result)
        btnWithResult.setOnClickListener {
            val moveResultIntent = Intent(this@MainActivity, MoveResultActivity::class.java)
            resultLauncher.launch(moveResultIntent)
        }

        btnUrl.setOnClickListener {
            val urlSite = "www.kevintekno.com"
            val urlSiteIntent = Intent(this@MainActivity, WebViewActivity::class.java)
            urlSiteIntent.putExtra(WebViewActivity.EXTRA_URL, "https:$urlSite")
            startActivity(urlSiteIntent)
        }

        btnMoveWithDial.setOnClickListener {
            val phoneNumber = "085391192727"
            val moveWithDialIntent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:$phoneNumber"))
            startActivity(moveWithDialIntent)

        }

        btnMoveWithObject.setOnClickListener{
            val person = Person(
                "Kevin Alfito",
                20,
                "kevinalfito@gmail.com",
                "CIrebon"
            )
            val moveWithObjectIntent = Intent(this@MainActivity, MoveWithObjectActivity::class.java)
            moveWithObjectIntent.putExtra(MoveWithObjectActivity.EXTRA_PERSON, person)
            startActivity(moveWithObjectIntent)
        }
        btnMoveWithData.setOnClickListener {
            val moveWithData = Intent(this@MainActivity, MoveWithDataActivity::class.java)
            moveWithData.putExtra(MoveWithDataActivity.EXTRA_AGE,90)
            moveWithData.putExtra(MoveWithDataActivity.EXTRA_NAME,"Kevin Alfito")
            startActivity(moveWithData)
        }

        btnMoveActivity.setOnClickListener {
            val moveIntent = Intent(this@MainActivity, MoveActivity::class.java)
            startActivity(moveIntent)

        }
    }

}