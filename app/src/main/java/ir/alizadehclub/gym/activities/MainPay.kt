package ir.alizadehclub.gym.activities

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import ir.alizadehclub.gym.R
import kotlinx.android.synthetic.main.main_pay.*
import kotlinx.android.synthetic.main.main_pay.txShahriyeh

class MainPay : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_pay)

        var shahriyeh = intent.getStringExtra("shahriyeh")
        txShahriyeh.setText(shahriyeh)

        imgBack.setOnClickListener{
            finish()
        }

        imgSabtSefaresh.setOnClickListener {
            val intent = Intent(this,Payment::class.java)
            intent.putExtra("shahriyeh",shahriyeh)
            startActivity(intent)
        }

    }

}
