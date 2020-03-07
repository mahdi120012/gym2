package ir.alizadehclub.gym

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val sharedPrefrencesClass = SharedPrefrencesClass(this)

        var phoneNumber = SharedPrefrencesClass.getUserProfile("phone_number")
        var password = SharedPrefrencesClass.getUserProfile("password")

        if (phoneNumber != null && password != null ){
           var senderRecive = SendRecive()
           senderRecive.login(this,phoneNumber,password)
           finish()
        }

        btnLogin.setOnClickListener {

            if (etPhoneNumber.text == null || etPhoneNumber.text.isEmpty() || etPassword.text == null || etPassword.text.isEmpty() ){

                Toast.makeText(this,"لطفا همه فیلد ها را تکمیل نمایید",Toast.LENGTH_SHORT).show()
            }else{

                var senderRecive = SendRecive()
                senderRecive.login(this,etPhoneNumber.text.toString(),etPassword.text.toString())

            }
        }
    }
}
