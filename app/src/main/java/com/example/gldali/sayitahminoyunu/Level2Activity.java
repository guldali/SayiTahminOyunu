package com.example.gldali.sayitahminoyunu;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Level2Activity extends AppCompatActivity {
    public Button tahminYap;
    public TextView  cevapBildir;
    public EditText tahmin;
    int bulunacakSayi;
    int yapilanTahmin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level2);

        bulunacakSayi = (int) (Math.random() * 200);

        tahminYap=findViewById(R.id.btn1);
        cevapBildir=findViewById(R.id.cevap);
        tahmin = findViewById(R.id.yaz);

        tahminYap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                yapilanTahmin=Integer.parseInt(tahmin.getText().toString());

                if (yapilanTahmin > bulunacakSayi) {
                    cevapBildir.setText(" in.");
                    cevapBildir.setBackgroundColor(Color.parseColor("#FFFF00"));


                } else if (yapilanTahmin < bulunacakSayi) {
                    cevapBildir.setText(" çık.");
                    cevapBildir.setBackgroundColor(Color.parseColor("#FF0000"));


                } else {
                    cevapBildir.setText("Tebrikler.");
                    cevapBildir.setBackgroundColor(Color.parseColor("#00FF00"));


                }
            }
        });
    }


}