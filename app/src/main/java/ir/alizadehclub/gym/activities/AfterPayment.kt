package ir.alizadehclub.gym.activities

import android.content.Intent
import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import ir.alizadehclub.gym.R
import ir.alizadehclub.gym.activities.MainUserProfile

class AfterPayment : AppCompatActivity() {

    override fun onCreate(savedInstanceState:Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.after_payment_act)

        /*imgIconToolbarTop.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.trash))
        toolbarTopaa.setBackgroundColor(Color.parseColor("#efefef"))*/

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            val window = window
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
            window.statusBarColor = Color.parseColor("#bfbfbf")
        }

       /* txOnvanInActionBar.setTextColor(Color.parseColor("#4a4a4a"))
        txOnvanInActionBar.text = "محصولات سالم"
        imgNavigationTop.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.back1))

        imgNavigationTop.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
            overridePendingTransition(
                R.transition.enter_left_to_right,
                R.transition.exit_left_to_right
            )
            finish()
        }

        imgIconToolbarTop.setOnClickListener {

        }*/

       /* var userName = SharedPrefrencesClass.getUserProfile("phone_number")
        LoadData.resultAfterPayment(
            this, clWifiState, txVaziyat,txDate,txSaAt,txVaziyat2,txDate2,txSaAt2,txCodeErja,txCodeTarakonesh,txMablagh
        ,userName)
        */

    }

    override fun onBackPressed() {
        startActivity(Intent(this, MainUserProfile::class.java))
        finish()
    }
}
