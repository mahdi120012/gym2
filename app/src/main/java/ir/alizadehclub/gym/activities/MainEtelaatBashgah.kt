package ir.alizadehclub.gym.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import ir.alizadehclub.gym.R
import ir.alizadehclub.gym.SendRecive
import kotlinx.android.synthetic.main.main_etelaat_bashgah.*

class MainEtelaatBashgah : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_etelaat_bashgah)

        var sendeRecive = SendRecive()
        sendeRecive.loadDarbareyeBshgah(this,"1",txAddress,txPhone,txShahriyeh,
                                        txDarbareyeBashgah)

        imgBack.setOnClickListener{
            finish()
        }

    }
}
