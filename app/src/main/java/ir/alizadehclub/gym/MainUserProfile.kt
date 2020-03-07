package ir.alizadehclub.gym

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.main_user_profile.*

class MainUserProfile : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_user_profile)

        var phoneNumber = SharedPrefrencesClass.getUserProfile("phone_number")
        var password = SharedPrefrencesClass.getUserProfile("password")

        textView3.setText(phoneNumber)

    }
}
