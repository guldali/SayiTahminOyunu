package com.example.gldali.sayitahminoyunu;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.gldali.sayitahminoyunu.Level2Activity;
import com.example.gldali.sayitahminoyunu.R;


public class MainActivity extends AppCompatActivity {

    public Button tahminYap, yeniOyun,level;
    public TextView durum, cevapBildir;
    public EditText tahmin;
    int bulunacakSayi;
    int yapilanTahmin;
    int sayac = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bulunacakSayi = (int) (Math.random() * 100);

        tahminYap = findViewById(R.id.btn1);
        yeniOyun = findViewById(R.id.btn2);
        durum = findViewById(R.id.soru);
        cevapBildir = findViewById(R.id.cevap);
        tahmin = findViewById(R.id.yaz);
        level=findViewById(R.id.btn3);


        tahminYap.setOnClickListener(new View.OnClickListener() {

            @Override

            public void onClick(View view) {

                sayac++;
                if (sayac < 3) {
                    yapilanTahmin = Integer.parseInt(tahmin.getText().toString());

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

                } else {
                    Toast.makeText(MainActivity.this, "hakkınız bitti yeni oyunu başlatın : " + sayac, Toast.LENGTH_SHORT).show();
                    tahminYap.setEnabled(false);
                    yeniOyun.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            bulunacakSayi = (int) (Math.random() * 100);
                            durum.setText("Yeni bir oyun başlattınız. 100 ile 1 arasındaki değeri bulunuz.");
                            tahminYap.setEnabled(true);
                            sayac = 0;

                        }
                    });
                }



            }


        });


        level.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent gec=new Intent(MainActivity.this,Level2Activity.class);
                startActivity(gec);

            }
        });




    }


}