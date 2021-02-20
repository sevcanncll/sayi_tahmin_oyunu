package tr.com.sevcan.tahminoyunu;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    public Button tahminYap, yeniOyun;
    public EditText txtTahmin;
    public TextView durum;
    public int sayac = 0;
    double bulunacakSayi = 0;
    public TextView yazdir;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*Programın başında da çalışabilmesi ve hata almamak açısından bulunacakSayi yani sistemin akıldan tuttuğu sayıyı oluşturduk.*/
        bulunacakSayi = Math.ceil(Math.random() * 100);

        /*Hatırlarsanız ID' leri tanımlamıştık. O ID' leri kullanarak View' lara ulaştık.*/
        tahminYap = (Button) findViewById(R.id.btnTahmin);
        yeniOyun = (Button) findViewById(R.id.yeniOyunBaslat);
        txtTahmin = (EditText) findViewById(R.id.txtTahmin);
        durum = (TextView) findViewById(R.id.txtDurum);
        yazdir = (TextView) findViewById(R.id.yazdir);

        durum.setText("1 ile 100 arasında bir tahminde bulunun");
        /*Tahmin butonuna tıklanması için gerekli fonksiyonumuz.*/
        tahminYap.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {

                /*Kullanıcının tahminini bulunduran veriyi önce String, ardından double veri türüne dönüştürerek sayıyı kontrol edebiliriz.*/
                double yapilanTahmin = Double.parseDouble(txtTahmin.getText().toString());
                sayac += 1;
                yazdir.setText(String.valueOf(sayac));

                /*Kullanıcı tahmini ve sistemin tuttuğu sayıya göre oluşacak durumları değerlendirerek, durum içeriğine yazdırdık.*/
                if (yapilanTahmin > bulunacakSayi) {
                    durum.setText("Biraz daha küçük bir sayı girmelisiniz.");
                    txtTahmin.setText("");
                }
                if (yapilanTahmin < bulunacakSayi) {
                    durum.setText("Biraz daha büyük bir sayı girmelisiniz.");
                    txtTahmin.setText("");
                }
                if (yapilanTahmin == bulunacakSayi) {
                    durum.setText("Tebrikler, doğru tahmin.");
                    txtTahmin.setText("");
                }
            }
        });

        /*Yeni Oyun butonuna tıklanabilirlik işlemini kazandırdık.*/
        yeniOyun.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                /*Sistemin tuttuğu sayıyı yenileyerek oyunu yeniden başlattık ve durum içeriğine bilgiyi yazdırdık.*/
                bulunacakSayi = Math.ceil(Math.random() * 100);
                durum.setText("Yeni bir oyun başlattınız. 100 ile 1 arasındaki değeri bulunuz.");
                sayac=0;

                txtTahmin.setText("");
                yazdir.setText("");
            }
        });
    }
}
