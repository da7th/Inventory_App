package com.example.android.inventoryapp;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by da7th on 7/29/2016.
 */
public class DetailsFragment extends AppCompatActivity {


    Integer i;
    ItemDbHelper myDb;
    TextView idTV, nameTV, priceTV, quantityTV, pictureTV;
    Button sellB, restockB, deleteB;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail_item);

        idTV = (TextView) findViewById(R.id.detail_product_id_text_view);
        nameTV = (TextView) findViewById(R.id.detail_product_name_text_view);
        priceTV = (TextView) findViewById(R.id.detail_product_price_text_view);
        quantityTV = (TextView) findViewById(R.id.detail_product_quantity_text_view);
        pictureTV = (TextView) findViewById(R.id.detail_product_picture_text_view);

        sellB = (Button) findViewById(R.id.sell_details_button);
        restockB = (Button) findViewById(R.id.restock_details_button);
        deleteB = (Button) findViewById(R.id.delete_details_button);

        myDb = new ItemDbHelper(this);

        Log.e("the value of i: ", "this stage");

        Intent thisIntent = getIntent();
        ArrayList<Integer> integers = thisIntent.getIntegerArrayListExtra("integerList");
        Integer i = integers.get(0);

        Log.e("the value of i: ", i.toString());
        Cursor res = myDb.readAllData();

        res.moveToPosition(i);

        int count = res.getCount();
        Log.e("the value of getCount: ", "= " + count);
        String idTVData;
        String nameTVData;
        Integer priceTVData;
        Integer quantityTVData;
        String pictureTVData;

        if (res.getCount() > 0) {

            idTV.setText(res.getString(0));
            nameTV.setText(res.getString(1));
            priceTV.setText(res.getString(2));
            quantityTV.setText(res.getString(3));
            pictureTV.setText(res.getString(4));

            idTVData = res.getString(0);
            nameTVData = res.getString(1);
            priceTVData = Integer.parseInt(res.getString(2));
            quantityTVData = Integer.parseInt(res.getString(3));
            pictureTVData = res.getString(4);

            sell(idTVData, nameTVData, priceTVData, quantityTVData, pictureTVData);

        } else {
            Toast.makeText(this, "nothing in the given resource", Toast.LENGTH_SHORT);
        }

    }

    public void sell(final String idTVData, final String nameTVData, final Integer priceTVData, final Integer quantityTVData, final String pictureTVData) {
        sellB.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        Integer quantityDecrement = quantityTVData - 1;

                        myDb.updateData(idTVData, nameTVData, priceTVData, quantityDecrement, pictureTVData);

                        Intent returnToMainIntent = new Intent(DetailsFragment.this, MainActivity.class);
                        startActivity(returnToMainIntent);
                    }
                }
        );

    }

    public void restock() {

    }

    public void deleteProduct() {

    }

}
