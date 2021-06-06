package com.example.project_chi

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import de.hdodenhof.circleimageview.CircleImageView

class ConfirmBooking : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_confirm_booking)

        val name = intent.getStringExtra("name")
        val job = intent.getStringExtra("job")
        val fee = intent.getStringExtra("fee")
        val imageId = intent.getIntExtra("imageId", R.drawable.prof3)

        val photo = findViewById<CircleImageView>(R.id.profile_pic)
        val proname = findViewById<TextView>(R.id.profName)
        val projob = findViewById<TextView>(R.id.profJob)

        photo.setImageResource(imageId)
        proname.setText(name.toString())
        projob.setText(job.toString())

        val txtSure = findViewById<TextView>(R.id.payment_sure)
        txtSure.setText("Your session with ${name.toString()} - ${job.toString()} has been confirmed!")

        val btnConfirm = findViewById<AppCompatButton>(R.id.button5)

        btnConfirm.setOnClickListener {

            val intent = Intent(applicationContext, ProfilesActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
            intent.putExtra("EXIT", true)
            startActivity(intent)

        }

    }
}