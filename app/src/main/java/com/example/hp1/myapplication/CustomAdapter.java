package com.example.hp1.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

/**
 * Created by Hp1 on 28/09/2017.
 */

public class CustomAdapter extends ArrayAdapter<Recipe> {
    ///
    private int resource;

    public CustomAdapter(Context context, int resource, List<Recipe> objects) {
        super(context, resource, objects);
        this.resource = resource;
    }
    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        LayoutInflater imageInflater = LayoutInflater.from(getContext());
        View cuView = imageInflater.inflate(resource, parent, false );

        Recipe recipe = getItem(position);
        TextView title = (TextView) cuView.findViewById(R.id.tvRecipeTitle);

        title.setText(recipe.getTitle());

        return cuView;
    }
}
