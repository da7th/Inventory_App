package com.example.android.inventoryapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

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




    }


    public void addData() {

        setContentView(R.layout.add_item);

        addItemB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //this inserts the data into the database created above and changes the values to
                // string, the return value of insertData is boolean so it will tell us whether the
                // data was inserted or not
                boolean isInserted = myDb.insertData(editName.getText().toString(), Integer.parseInt(editPrice.getText().toString()),
                        Integer.parseInt(editQuantity.getText().toString()), editPicture.getText().toString());
                if (isInserted == true) {
                    Toast.makeText(MainActivity.this, "Data inserted", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MainActivity.this, "Data not inserted", Toast.LENGTH_SHORT).show();
                }
            }
        });

        setContentView(R.layout.activity_main);
    }


}
