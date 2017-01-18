package com.upversionlab.veganapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.google.zxing.Result;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import me.dm7.barcodescanner.zxing.ZXingScannerView;

public class BarcodeScannerActivity extends AppCompatActivity implements ZXingScannerView.ResultHandler {

    private static final Logger LOG = LoggerFactory.getLogger(BarcodeScannerActivity.class);

    private ZXingScannerView scannerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_barcode_scanner);

        scannerView = (ZXingScannerView) findViewById(R.id.activity_barcode_scanner_scanner_view);
    }

    @Override
    public void onResume() {
        super.onResume();
        scannerView.setResultHandler(this);
        scannerView.startCamera();
    }

    @Override
    public void onPause() {
        super.onPause();
        scannerView.stopCamera();
    }

    @Override
    public void handleResult(Result rawResult) {
        String result = rawResult.getText();
        LOG.debug("Retrieved barcode: [{}]", result);
        Toast.makeText(this, result, Toast.LENGTH_LONG).show();
    }
}
