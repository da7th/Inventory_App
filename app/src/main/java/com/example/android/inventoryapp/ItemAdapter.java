package com.example.android.inventoryapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by da7th on 7/29/2016.
 */
public class ItemAdapter extends ArrayAdapter<Item> {

    public ItemAdapter(MainActivity context, ArrayList<Item> resource) {
        super(context, 0, resource);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View listView = convertView;
        if (listView == null) {
            listView = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);
        }

        Item currentItem = getItem(position);

        TextView nameTV = (TextView) listView.findViewById(R.id.product_name_text_view);
        nameTV.setText(currentItem.getName());

        TextView priceTV = (TextView) listView.findViewById(R.id.price_text_view);
        priceTV.setText(currentItem.getPrice());

        TextView quantityTV = (TextView) listView.findViewById(R.id.quantity_text_view);
        quantityTV.setText(currentItem.getQuantity());

        TextView pictureTV = (TextView) listView.findViewById(R.id.picture_text_view);
        pictureTV.setText(currentItem.getPicture());

        return listView;

    }
}
