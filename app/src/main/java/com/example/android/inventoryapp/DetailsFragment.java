package com.example.android.inventoryapp;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by da7th on 7/29/2016.
 */
public class DetailsFragment extends AppCompatActivity {


    Integer i;
    ItemDbHelper myDb;
    TextView idTV, nameTV, priceTV, quantityTV, pictureTV;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail_item);


        idTV = (TextView) findViewById(R.id.detail_product_id_text_view);
        nameTV = (TextView) findViewById(R.id.detail_product_name_text_view);
        priceTV = (TextView) findViewById(R.id.detail_product_price_text_view);
        quantityTV = (TextView) findViewById(R.id.detail_product_quantity_text_view);
        pictureTV = (TextView) findViewById(R.id.detail_product_picture_text_view);

        myDb = new ItemDbHelper(this);

        Intent thisIntent = getIntent();
        thisIntent.getIntExtra("i", 0);

        Cursor res = myDb.readData(i);

        if (res.getCount() > 0) {
            idTV.setText(res.getString(1));
            nameTV.setText(res.getString(2));
            priceTV.setText(Integer.parseInt(res.getString(3)));
            quantityTV.setText(Integer.parseInt(res.getString(4)));
            pictureTV.setText(res.getString(5));
        } else {
            Toast.makeText(this, "nothing in the given resource", Toast.LENGTH_SHORT);
        }


    }

}
