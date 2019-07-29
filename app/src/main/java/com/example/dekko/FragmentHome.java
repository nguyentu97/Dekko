package com.example.dekko;

import android.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.dekko.Util.Util;
import com.squareup.picasso.Picasso;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class FragmentHome extends Fragment {

    TextView tvTitleNews1, tvTitleNews2, tvTitleNews3,tvTitleNews4,
            tvNameUser, tvPhoneUser, tvPoint,tvTitlePromotion1,tvTitlePromotion2;
    ImageView imgNews1, imgNews2, imgNews3, imgNews4,imgPromotion1,imgPromotion2;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_home, container, false);
        init(view);
        prepaData();
        return view;
    }

    private void prepaData() {
        JSONObject jsonHOme = Util.filetoJson(R.raw.home, this);
        Log.d("", "");
        try {
            JSONObject resultJson = jsonHOme.getJSONObject("result");
            JSONObject customerDetail = resultJson.getJSONObject("customerDetail");
            String name = customerDetail.getString("customerName");
            String phone = customerDetail.getString("phone");
            int point = customerDetail.getInt("point");
            tvNameUser.setText(name);
            tvPhoneUser.setText("(" + phone + ")");
            tvPoint.setText(point + "");

            //doc Json Tin tuc

            JSONArray listNewsJsonArray = resultJson.getJSONArray("listNews");
            JSONObject firstNews = listNewsJsonArray.getJSONObject(0);
            String titleNew = firstNews.getString("title");
            String url = firstNews.getString("urlImage");
            tvTitleNews1.setText(titleNew);
            Picasso.get().load(url).into(imgNews1);

            JSONObject secondNews = listNewsJsonArray.getJSONObject(1);
            titleNew = secondNews.getString("title");
            url = secondNews.getString("urlImage");
            tvTitleNews2.setText(titleNew);
            Picasso.get().load(url).into(imgNews2);

            JSONObject thirdNews = listNewsJsonArray.getJSONObject(2);
            titleNew = thirdNews.getString("title");
            url = thirdNews.getString("urlImage");
            tvTitleNews3.setText(titleNew);
            Picasso.get().load(url).into(imgNews3);

            JSONObject FourNews = listNewsJsonArray.getJSONObject(3);
            titleNew = FourNews.getString("title");
            url = FourNews.getString("urlImage");
            tvTitleNews4.setText(titleNew);
            Picasso.get().load(url).into(imgNews4);

            //doc json khuyen mai

            JSONArray listPromotionJson = resultJson.getJSONArray("listPromotion");
            JSONObject firstPromotion = listPromotionJson.getJSONObject(0);
            String titlePomotion = firstPromotion.getString("title");
            String urlPromotion = firstPromotion.getString("urlImage");
            tvTitlePromotion1.setText(titlePomotion);
            Picasso.get().load(urlPromotion).into(imgPromotion1);

            JSONObject secondPromotion = listPromotionJson.getJSONObject(1);
            titlePomotion = secondPromotion.getString("title");
            urlPromotion = secondPromotion.getString("urlImage");
            tvTitlePromotion2.setText(titlePomotion);
            Picasso.get().load(urlPromotion).into(imgPromotion2);



        } catch (JSONException e) {
            e.printStackTrace();
        }


    }

    private void init(View view) {
        tvTitleNews1 = view.findViewById(R.id.tv_title_news1);
        tvTitleNews2 = view.findViewById(R.id.tv_title_news2);
        tvTitleNews3 = view.findViewById(R.id.tv_title_news3);
        tvTitleNews4 = view.findViewById(R.id.tv_title_news4);
        tvNameUser = view.findViewById(R.id.tv_name_user);
        tvPhoneUser = view.findViewById(R.id.tv_phone_user);
        tvPoint = view.findViewById(R.id.tv_point);
        tvTitlePromotion1 = view.findViewById(R.id.tv_title_promotion1);
        tvTitlePromotion2 = view.findViewById(R.id.tv_title_promotion2);
        imgNews1 = view.findViewById(R.id.img_news1);
        imgNews2 = view.findViewById(R.id.img_news2);
        imgNews3 = view.findViewById(R.id.img_news3);
        imgNews4 = view.findViewById(R.id.img_news4);
        imgPromotion1 = view.findViewById(R.id.img_promotion1);
        imgPromotion2 = view.findViewById(R.id.img_promotion2);
    }
}
