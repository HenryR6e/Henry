package com.henry.henry;

import android.content.Context;
import android.content.res.Configuration;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;

public class MainActivity extends AppCompatActivity {

    String[] items={"Fruits","Foods"};
    String[] item1={"Fruits","Foods"};

    private Context ct;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ct = MainActivity.this;


        int configuration=getResources().getConfiguration().orientation;
        if(configuration== Configuration.ORIENTATION_PORTRAIT){
            setContentView(R.layout.potrait);
            ListView listView= (ListView) findViewById(R.id.itemlist);

            ListAdapter adt=new ArrayAdapter<String>(ct,android.R.layout.simple_list_item_1,items);
            listView.setAdapter(adt);

            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

                RelativeLayout relLay1= (RelativeLayout) findViewById(R.id.pt);
                RelativeLayout relLay2= (RelativeLayout) findViewById(R.id.pt2);


                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    String user_chose=String.valueOf(parent.getItemAtPosition(position));
                    switch (user_chose){
                        case "Fruits":

                            relLay1.setVisibility(View.VISIBLE);
                            relLay2.setVisibility(View.INVISIBLE);
                            break;
                        case "Foods":

                            relLay1.setVisibility(View.INVISIBLE);
                            relLay2.setVisibility(View.VISIBLE);
                            break;
                    }
                }
            });

        }
        else if(configuration== Configuration.ORIENTATION_LANDSCAPE){
            setContentView(R.layout.land);
            ListView listView= (ListView) findViewById(R.id.itemlistland);

            ListAdapter adapter=new ArrayAdapter<String>(ct,android.R.layout.simple_list_item_1,item1);
            listView.setAdapter(adapter);

            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

                RelativeLayout relLay1= (RelativeLayout) findViewById(R.id.rt);
                RelativeLayout relLay2= (RelativeLayout) findViewById(R.id.rt2);


                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    String user_chose=String.valueOf(parent.getItemAtPosition(position));
                    switch (user_chose){
                        case "Fruits":
                            relLay1.setVisibility(View.VISIBLE);
                            relLay2.setVisibility(View.INVISIBLE);

                            break;
                        case "Foods":

                            relLay1.setVisibility(View.INVISIBLE);
                            relLay2.setVisibility(View.VISIBLE);
                            break;
                    }
                }
            });
        }
    }
}
