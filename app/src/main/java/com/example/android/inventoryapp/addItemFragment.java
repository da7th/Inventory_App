package com.example.android.inventoryapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by da7th on 7/29/2016.
 */
public class AddItemFragment extends AppCompatActivity {

    Button submitB;
    EditText editName, editPrice, editQuantity, editPicture;
    ItemDbHelper myDb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_item);

        myDb = new ItemDbHelper(this);


        editName = (EditText) findViewById(R.id.edit_name_edit_text);
        editPrice = (EditText) findViewById(R.id.edit_price_edit_text);
        editQuantity = (EditText) findViewById(R.id.edit_quantity_edit_text);
        editPicture = (EditText) findViewById(R.id.edit_picture_edit_text);

        submitB = (Button) findViewById(R.id.submit_item_button);

        submitAdd();

    }

    public void submitAdd(){
        submitB.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        //this inserts the data into the database created above and changes the values to
                        // string, the return value of insertData is boolean so it will tell us whether the
                        // data was inserted or not
                        boolean isInserted = myDb.insertData(editName.getText().toString(), Integer.parseInt(editPrice.getText().toString()),
                                Integer.parseInt(editQuantity.getText().toString()), editPicture.getText().toString(), 0);
                        if (isInserted == true) {
                            Toast.makeText(AddItemFragment.this, "Data inserted", Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(AddItemFragment.this, "Data not inserted", Toast.LENGTH_SHORT).show();
                        }

                        Intent returnToMainIntent = new Intent(AddItemFragment.this,MainActivity.class);
                        startActivity(returnToMainIntent);

                    }
                }
        );
    }
}
