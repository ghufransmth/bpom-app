package tiara.anggreyani.bpom;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.Manifest;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Adapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.karumi.dexter.Dexter;
import com.karumi.dexter.PermissionToken;
import com.karumi.dexter.listener.PermissionDeniedResponse;
import com.karumi.dexter.listener.PermissionGrantedResponse;
import com.karumi.dexter.listener.PermissionRequest;
import com.karumi.dexter.listener.single.PermissionListener;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import tiara.anggreyani.bpom.adapter.AdapterProduct;
import tiara.anggreyani.bpom.model.product.DataProduct;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    @BindView(R.id.verified)
    LinearLayout verified;

    @BindView(R.id.verified_gray)
    LinearLayout verified_gray;

    @BindView(R.id.report)
    LinearLayout report;

    @BindView(R.id.report_gray)
    LinearLayout report_gray;

    @BindView(R.id.rv)
    RecyclerView rv;

    private static final int REQUEST_CODE_QR_SCAN = 101;
    String[] product;
    ImageView home, qr, setting;
    List<DataProduct> listAllData = new ArrayList<>();
    AdapterProduct myAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        home = findViewById(R.id.home);
        qr = findViewById(R.id.qr);
        setting = findViewById(R.id.setting);

        rv.setLayoutManager(new LinearLayoutManager(this));
        myAdapter = new AdapterProduct(this,rv,listAllData);

        addItem();

        verified_gray.setOnClickListener(this);
        report_gray.setOnClickListener(this);

        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, MainActivity.class));
            }
        });

        qr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, ScanQRActivity.class));
            }
        });

        // inisialisasi view
        View decorView = getWindow().getDecorView();
        // Hide the status bar.
        decorView.setSystemUiVisibility(View.SYSTEM_UI_FLAG_FULLSCREEN);
        // Hide ActionBar
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }

//        btnCoba.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Dexter.withContext(getApplicationContext())
//                        .withPermission(Manifest.permission.CAMERA)
//                        .withListener(new PermissionListener() {
//                            @Override
//                            public void onPermissionGranted(PermissionGrantedResponse permissionGrantedResponse) {
//                                Intent i = new Intent(MainActivity.this, QrCodeActivity.class);
//                                startActivityForResult( i,REQUEST_CODE_QR_SCAN);
//                            }
//
//                            @Override
//                            public void onPermissionDenied(PermissionDeniedResponse permissionDeniedResponse) {
//                                permissionDeniedResponse.getRequestedPermission();
//                            }
//
//                            @Override
//                            public void onPermissionRationaleShouldBeShown(PermissionRequest permissionRequest, PermissionToken permissionToken) {
//
//                            }
//                        });
//                startActivity(new Intent(MainActivity.this, ScanDetailActivity.class));
//            }
//        });
    }

    @Override
    public void onClick(View view) {
        switch (view.getId())
        {
            case R.id.verified_gray:
                verified.setVisibility(View.VISIBLE);
                verified_gray.setVisibility(View.GONE);
                report.setVisibility(View.GONE);
                report_gray.setVisibility(View.VISIBLE);
                rv.setVisibility(View.VISIBLE);
                break;

            case R.id.report_gray:
                verified.setVisibility(View.GONE);
                verified_gray.setVisibility(View.VISIBLE);
                report.setVisibility(View.VISIBLE);
                report_gray.setVisibility(View.GONE);
                rv.setVisibility(View.GONE);
                break;


        }
    }

    public void addItem() {
        product = getResources().getStringArray(R.array.item_product);

        for(int i=0; i < product.length;i++) {
            Log.d("TEST",""+product[i]);
            DataProduct dataProduct = new DataProduct(product[i]);
            listAllData.add(dataProduct);
        }

        rv.setAdapter(myAdapter);
        myAdapter.notifyDataSetChanged();
        myAdapter.setLoaded();
    }

//
//    @Override
//    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
//
//        super.onActivityResult(requestCode, resultCode, data);
//        if (resultCode != Activity.RESULT_OK) {
//
//            //Getting the passed result
//            String result = data.getStringExtra("com.blikoon.qrcodescanner.error_decoding_image");
//            if (result != null) {
//                AlertDialog alertDialog = new AlertDialog.Builder(MainActivity.this).create();
//                alertDialog.setTitle("Scan Error");
//                alertDialog.setMessage("QR Code could not be scanned");
//                alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
//                        new DialogInterface.OnClickListener() {
//                            public void onClick(DialogInterface dialog, int which) {
//                                dialog.dismiss();
//                            }
//                        });
//                alertDialog.show();
//            }
//            return;
//
//        }
//        if (requestCode == REQUEST_CODE_QR_SCAN) {
//            if (data == null)
//                return;
//            //Getting the passed result
//            String result = data.getStringExtra("com.blikoon.qrcodescanner.got_qr_scan_relult");
//            AlertDialog alertDialog = new AlertDialog.Builder(MainActivity.this).create();
//            alertDialog.setTitle("Hasil Scan");
//            alertDialog.setMessage(result);
//            alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
//                    new DialogInterface.OnClickListener() {
//                        public void onClick(DialogInterface dialog, int which) {
//                            dialog.dismiss();
//                        }
//                    });
//            alertDialog.show();
//
//        }
//    }
}