package com.example.vasuki.customlistviewproject;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.appindexing.Thing;
import com.google.android.gms.common.api.GoogleApiClient;

import java.util.ArrayList;

public class CustomizedListView extends AppCompatActivity {

    ArrayList<DataModel> dataModel;
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_model);
        dataModel = new ArrayList<DataModel>();
        dataModel.add(new DataModel("Kitcat", "one", "1", "API1"));
        dataModel.add(new DataModel("Jellibean", "two", "2", "API2"));
        dataModel.add(new DataModel("Nagout", "three", "3", "API3"));
        ListView listView = (ListView) findViewById(R.id.listview);
        CustAdapter adapter = new CustAdapter(CustomizedListView.this, 0);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                DataModel datamodel = dataModel.get(i);
                Intent intent = new Intent(CustomizedListView.this,MainActivity.class);
                startActivity(intent);
                Toast.makeText(CustomizedListView.this,"ListView item has been clicked",Toast.LENGTH_SHORT).show();

            }
        });

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }

    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    public Action getIndexApiAction() {
        Thing object = new Thing.Builder()
                .setName("CustomizedListView Page") // TODO: Define a title for the content shown.
                // TODO: Make sure this auto-generated URL is correct.
                .setUrl(Uri.parse("http://[ENTER-YOUR-URL-HERE]"))
                .build();
        return new Action.Builder(Action.TYPE_VIEW)
                .setObject(object)
                .setActionStatus(Action.STATUS_TYPE_COMPLETED)
                .build();
    }

    @Override
    public void onStart() {
        super.onStart();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client.connect();
        AppIndex.AppIndexApi.start(client, getIndexApiAction());
    }

    @Override
    public void onStop() {
        super.onStop();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        AppIndex.AppIndexApi.end(client, getIndexApiAction());
        client.disconnect();
    }

    class CustAdapter extends ArrayAdapter {
        TextView name, type, versionNumber, feature;

        public CustAdapter(Context context, int resource) {
            super(context, resource);
        }

        @Override
        public int getCount() {
            return dataModel.size();

        }

        @NonNull
        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            if (convertView == null) {
                LayoutInflater inflater = LayoutInflater.from(CustomizedListView.this);
                convertView = inflater.inflate(R.layout.row_item, null);
                name = (TextView) convertView.findViewById(R.id.name);
                type = (TextView) convertView.findViewById((R.id.type));
                versionNumber = (TextView) convertView.findViewById(R.id.version);
                feature = (TextView) convertView.findViewById(R.id.feature);
            }
            name.setText(dataModel.get(position).getName());
            type.setText(dataModel.get(position).getType());
            versionNumber.setText(dataModel.get(position).getVersion_number());
            feature.setText(dataModel.get(position).feature());
            return convertView;

        }
    }
}



