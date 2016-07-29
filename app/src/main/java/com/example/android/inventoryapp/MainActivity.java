package com.example.android.inventoryapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    TextView productNameTV, priceTV, quantityTV;
    EditText editName, editPrice, editQuantity, editPicture;
    Button addItemB, submitB;
    ItemDbHelper myDb;
    private String LOG_TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myDb = new ItemDbHelper(this);

        addItemB = (Button) findViewById(R.id.add_item_button);
        submitB = (Button) findViewById(R.id.submit_item_button);

        productNameTV = (TextView) findViewById(R.id.product_name_text_view);
        priceTV = (TextView) findViewById(R.id.price_text_view);
        quantityTV = (TextView) findViewById(R.id.quantity_text_view);


        final ListView listView = (ListView) findViewById(R.id.list);


        ArrayList<Item> items = new ArrayList<Item>();
        final ItemAdapter itemAdapter = new ItemAdapter(this, items);
        listView.setAdapter(itemAdapter);

        listView.setOnItemClickListener(
                new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                        Item currentItem = itemAdapter.getItem(i);

                        //send the current item to its details screen

                    }
                }
        );


        addData();

    }


    public void addData() {

        addItemB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent addItemIntent = new Intent(MainActivity.this, AddItemFragment.class);
                startActivity(addItemIntent);

            }
        });
    }


}
