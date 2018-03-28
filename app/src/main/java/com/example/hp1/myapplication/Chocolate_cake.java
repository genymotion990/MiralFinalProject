package com.example.hp1.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class Chocolate_cake extends AppCompatActivity implements View.OnClickListener{

    ListView lvchoclateing;// list view ta3 el share7(ingredients) adwat lt7der 3l chocolate cake
    ArrayList<String> arrchocolateing = new ArrayList<String>();

    ListView lvchocolateins;// listview ta3 el share7 (instruction)lkef b3mlo lk3ke
    ArrayAdapter<String> adapter;
    ArrayList<String> arrchoclateins = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chocolate_cake);

        lvchoclateing = (ListView) findViewById(R.id.lvchoclateing);

        arrchocolateing.add("butter and flour for coating and dusting the cake pan\n" +
                "3 cups all-purpose flour\n" +
                "3 cups granulated sugar\n" +
                "1½ cups unsweetened cocoa powder\n" +
                "1 tablespoon baking soda\n" +
                "1½ teaspoons baking powder\n" +
                "1½ teaspoons salt\n" +
                "4 large eggs\n" +
                "1½ cups buttermilk\n" +
                "1½ cups warm water\n" +
                "½ cup vegetable oil\n" +
                "2 teaspoons vanilla extract");

        adapter = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1, arrchocolateing);
        lvchoclateing.setAdapter(adapter);


        lvchocolateins = (ListView) findViewById(R.id.lvchocolateins);

        arrchoclateins.add("Preheat oven to 350 degrees.\n" +
                "Butter three 9-inch cake rounds. Dust with flour and tap out the excess. (see cooking lesson below)\n" +
                "Mix together flour, sugar, cocoa, baking soda, baking powder, and salt in a stand mixer using a low speed until combined.\n" +
                "Add eggs, buttermilk, warm water, oil, and vanilla. Beat on a medium speed until smooth. This should take just a couple of minutes.\n" +
                "Divide batter among the three pans. I found that it took just over 3 cups of the batter to divide it evenly.\n" +
                "Bake for 30-35 minutes until the cake meets the toothpick test (stick a toothpick in and it comes out clean).\n" +
                "Cool on wire racks for 15 minutes and then turn out the cakes onto the racks and allow to cool completely.\n" +
                "Frost with your favorite frosting and enjoy!");

        adapter = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1, arrchoclateins);
        lvchocolateins.setAdapter(adapter);


    }

    @Override
    public void onClick(View v) {

    }


}
