package ir.alizadehclub.gym.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import ir.alizadehclub.gym.R
import ir.alizadehclub.gym.SendRecive
import ir.alizadehclub.gym.custumClasses.SharedPrefrencesClass
import ir.alizadehclub.gym.custumClasses.AppVersionName
import kotlinx.android.synthetic.main.main_user_profile.*
import kotlinx.android.synthetic.main.navigation_items.*
import kotlinx.android.synthetic.main.navigation_main_activity.*

class MainUserProfile : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.navigation_main_activity)

        imgMenu.setOnClickListener {
            if (drawer_layout.isDrawerOpen(Gravity.RIGHT)) {
                drawer_layout.closeDrawer(Gravity.RIGHT)
            } else {
                drawer_layout.openDrawer(Gravity.RIGHT)
            }

        }

        txExit.setOnClickListener{
            SharedPrefrencesClass.clearData(this)
            startActivity(Intent(this, MainActivity::class.java))
        }

        txEtelaatBashgah.setOnClickListener{
            startActivity(Intent(this, MainEtelaatBashgah::class.java))
        }

        txMenuAboutme.setOnClickListener{
            startActivity(Intent(this, MainAboutMe::class.java))
        }

        txMenuPoshtibani.setOnClickListener{
            startActivity(Intent(this, MainPoshtibani::class.java))
        }

        //var link = "http://alizadehclub.ir/public/img/member/110/pic.jpg"
        var phoneNumber =
            SharedPrefrencesClass.getUserProfile("phone_number")
        //var password = SharedPrefrencesClass.getUserProfile("password")


        var senderRecive = SendRecive()
        senderRecive.loadProfile(this@MainUserProfile,phoneNumber,imgProfile,txName,txEtebar,txPhoneNumber,txUserId,
                            txVaziyat,txTarikhTavallod,txCodeMeli,txTarikhOzviyat,txAddress,txParentName)


        //textView3.setText(phoneNumber)

        nav_footer_txVesionCode.text = "نسخه " + AppVersionName.getVersionName(this)
    }

    override fun onBackPressed() {
        if (drawer_layout.isDrawerOpen(Gravity.RIGHT)) {
            drawer_layout.closeDrawer(Gravity.RIGHT)
        } else {
            val intent = Intent(Intent.ACTION_MAIN)
            intent.addCategory(Intent.CATEGORY_HOME)
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            startActivity(intent)
        }
    }

}
