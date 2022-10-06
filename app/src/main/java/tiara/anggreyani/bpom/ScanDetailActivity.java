package tiara.anggreyani.bpom;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class ScanDetailActivity extends AppCompatActivity {

    ImageView gambarBarang, btnBack, btnBackHome;
    TextView namaBarang, deskBarang, principle, tipe, kategori, kodeProduk, expDate, lokasi, waktu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scan_detail);

        gambarBarang = findViewById(R.id.gambarBarang);
        btnBack = findViewById(R.id.btnBack);
        btnBackHome = findViewById(R.id.btnBackHome);

        namaBarang = findViewById(R.id.namaBarang);
        deskBarang = findViewById(R.id.deskBarang);
        principle = findViewById(R.id.principle);
        tipe = findViewById(R.id.tipe);
        kategori = findViewById(R.id.kategori);
        kodeProduk = findViewById(R.id.kodeProduksi);
        expDate = findViewById(R.id.expDate);

        lokasi = findViewById(R.id.lokasi);
        waktu = findViewById(R.id.waktu);

        // inisialisasi view
        View decorView = getWindow().getDecorView();
        // Hide the status bar.
        decorView.setSystemUiVisibility(View.SYSTEM_UI_FLAG_FULLSCREEN);
        // Hide ActionBar
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ScanDetailActivity.super.onBackPressed();
            }
        });

        btnBackHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ScanDetailActivity.this, MainActivity.class));
            }
        });
    }
}