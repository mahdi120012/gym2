package ir.alizadehclub.gym;

import android.content.Context;
import android.content.Intent;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.squareup.picasso.Picasso;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import ir.alizadehclub.gym.custumClasses.EnglishNumberToPersian;
import ir.alizadehclub.gym.custumClasses.SharedPrefrencesClass;
import ir.alizadehclub.gym.custumClasses.TimeKononi;
import ir.alizadehclub.gym.activities.MainUserProfile;

public class SendRecive {
    Context c;


    public void loadDarbareyeBshgah(final Context c, String clubId, final TextView txAddress,
                                    final TextView txPhone,final TextView txShahriyeh,
                                    final TextView txDarbareyeBashgah) {


        final String url = "http://alizadehclub.ir/option/getOptionMobile/?club_id="+clubId;

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url,
                null, new Response.Listener<JSONObject>() {

            @Override
            public void onResponse(JSONObject response) {


                if (response.length() <= 0) {
                    //Toast.makeText(c, "اطلاعاتی موجود نیست.", Toast.LENGTH_SHORT).show();
                    return;
                }
                //String id = null;
                String address = null;
                String phone = null;
                String darbareyeBashgah = null;
                String shahriyeh = null;

                for (int i = 0; i < response.length(); i++) {
                    try {
                        JSONObject jsonObject = new JSONObject(response.toString());
                        address = jsonObject.getString("address");
                        phone = jsonObject.getString("phone");
                        darbareyeBashgah = jsonObject.getString("about");
                        shahriyeh = jsonObject.getString("tituion");

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }

                txAddress.setText(new EnglishNumberToPersian().convert(address));
                txPhone.setText(new EnglishNumberToPersian().convert(phone));
                txDarbareyeBashgah.setText(new EnglishNumberToPersian().convert(darbareyeBashgah));
                txShahriyeh.setText(new EnglishNumberToPersian().convert(shahriyeh) + " تومان");


            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                Toast.makeText(c, "دسترسی به اینترنت موجود نیست!", Toast.LENGTH_SHORT).show();

            }
        });

        MySingleton.getInstance(c).addToRequestQueue(jsonObjectRequest);
    }


    public void loadProfile(final Context c, String phoneNumber, final ImageView imgProfile,final TextView txName
            ,final TextView txEtebar,final TextView txPhoneNumber,final TextView txUserId,
            final TextView txVaziyat,final TextView txTarikhTavallod, final TextView txCodeMeli,
            final TextView txTarikhOzviyat,final TextView txAddress,final TextView txParentName) {


        final String url = "http://alizadehclub.ir/member/getMemberMobile/?isMobile=fasf&mobile="+phoneNumber;

        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, url,
                null, new Response.Listener<JSONArray>() {

            @Override
            public void onResponse(JSONArray response) {


                if (response.length() <= 0) {
                    //Toast.makeText(c, "اطلاعاتی موجود نیست.", Toast.LENGTH_SHORT).show();
                    return;
                }
                String id = null;
                String code_meli = null;
                String sex = null;
                String birthday = null;
                String dateCreat = null;
                String family = null;
                String parentname = null;
                String Address = null;
                String description = null;
                String useridOrUserPicture = null;
                String mobile = null;
                String statusId = null;
                String end_date = null;
                String clubId = null;

                for (int i = 0; i < response.length(); i++) {
                    try {
                        JSONObject jsonObject = response.getJSONObject(i);

                        //id = jsonObject.getString("id");
                        code_meli = jsonObject.getString("code_meli");
                        //sex = jsonObject.getString("sex");
                        birthday = jsonObject.getString("birthday");
                        dateCreat = jsonObject.getString("dateCreat");
                        family = jsonObject.getString("family");
                        parentname = jsonObject.getString("parentname");
                        Address = jsonObject.getString("Address");
                        //description = jsonObject.getString("description");
                        useridOrUserPicture = jsonObject.getString("userid");
                        mobile = jsonObject.getString("mobile");
                        statusId = jsonObject.getString("title");
                        end_date = jsonObject.getString("end_date");
                        clubId = jsonObject.getString("club_id");

                        SharedPrefrencesClass sharedPrefrencesClass = new SharedPrefrencesClass(c);
                        sharedPrefrencesClass.setUserProfile("club_id",clubId);

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                TimeKononi timeKononi = new TimeKononi();


                String persianNumberMobile = new EnglishNumberToPersian().convert(mobile);
                String persianNumberStatusId = new EnglishNumberToPersian().convert(statusId);
                String persianNumberCode_meli = new EnglishNumberToPersian().convert(code_meli);
                String persianNumberAddress = new EnglishNumberToPersian().convert(Address);
                String persianNumberUseridOrUserPicture = new EnglishNumberToPersian().convert(useridOrUserPicture);
                    
                String persianDateCreat = timeKononi.changeGregorianToPersian(dateCreat);
                String persianEnd_date = timeKononi.changeGregorianToPersian(end_date);
                String persianBirthday = timeKononi.changeGregorianToPersian(birthday);


                txName.setText(family);
                txEtebar.setText(persianEnd_date);
                txPhoneNumber.setText(persianNumberMobile);
                txUserId.setText(persianNumberUseridOrUserPicture);
                txVaziyat.setText(persianNumberStatusId);
                txTarikhTavallod.setText(persianBirthday);
                txCodeMeli.setText(persianNumberCode_meli);
                txTarikhOzviyat.setText(persianDateCreat);
                txAddress.setText(persianNumberAddress);
                txParentName.setText(parentname);

                //txCountNotReadMessage.setText(tedadPayamKhangeNashode);
            String userPictureLink = "http://alizadehclub.ir/public/img/member/"+useridOrUserPicture+"/pic.jpg";
             if (useridOrUserPicture.isEmpty()) {

                    Picasso.get()
                            .load(R.drawable.no_image)
                            .centerInside()
                            .fit()
                            .error(R.drawable.no_image)
                            .placeholder(R.drawable.no_image)
                            .into(imgProfile);

                }else{
                    Picasso.get()
                            .load(userPictureLink)
                            .centerInside()
                            .fit()
                            .error(R.drawable.no_image)
                            .placeholder(R.drawable.no_image)
                            .into(imgProfile);
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                Toast.makeText(c, "دسترسی به اینترنت موجود نیست!", Toast.LENGTH_SHORT).show();

            }
        });

        MySingleton.getInstance(c).addToRequestQueue(jsonArrayRequest);
    }


    public void login(final Context c, final String mobile, final String password){
        this.c = c;

        final String url = "http://alizadehclub.ir/login/checkUserMobile?mobile="+mobile+"&password="+password;

        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        if (response.toString().matches("1")){

                            //// To Save a value
                            SharedPrefrencesClass sharedPrefrencesClass = new SharedPrefrencesClass(c);
                            sharedPrefrencesClass.setUserProfile("phone_number",mobile);
                            sharedPrefrencesClass.setUserProfile("password", password);

                            Intent intent = new Intent(c, MainUserProfile.class);
                            c.startActivity(intent);



                        }else {
                            Toast.makeText(c, "شماره همراه یا رمز عبور اشتباه است", Toast.LENGTH_SHORT).show();
                        }
                    }

                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(c, "دسترسی به اینترنت موجود نیست!", Toast.LENGTH_SHORT).show();
            }
        });

        MySingleton.getInstance(c).addToRequestQueue(stringRequest);

    }
}
