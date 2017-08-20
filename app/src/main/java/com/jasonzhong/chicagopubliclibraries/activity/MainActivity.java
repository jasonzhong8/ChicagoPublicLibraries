package com.jasonzhong.chicagopubliclibraries.activity;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.RelativeLayout;

import com.android.volley.VolleyError;
import com.jasonzhong.chicagopubliclibraries.R;
import com.jasonzhong.chicagopubliclibraries.adapter.LibraryAdapter;
import com.jasonzhong.chicagopubliclibraries.model.Library;
import com.jasonzhong.chicagopubliclibraries.network.NetworkManager;
import com.jasonzhong.chicagopubliclibraries.util.JsonParser;
import com.jasonzhong.chicagopubliclibraries.util.Util;

import java.util.List;

import static com.jasonzhong.chicagopubliclibraries.R.id.loadingPanel;

public class MainActivity extends AppCompatActivity {

    private String VOLLEY_TAD = "Volley_tag";
    private ListView library_listview;
    private List<Library> libraryList;
    private RelativeLayout loadingPanel;

    private static final String CHICAGO_LIBRARY_URL = "https://data.cityofchicago.org/resource/x8fc-8rcq.json";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.library_list);

        init();
        sendGetChicagoLibrariesInfoVolleyRequest();
    }

    private void init() {
        loadingPanel = (RelativeLayout) findViewById(R.id.loadingPanel);
        library_listview = (ListView) findViewById(R.id.library_listview);
        library_listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position,
                                    long id) {
                Intent i = new Intent(MainActivity.this, LibraryDetailActivity.class);
                i.putExtra("Library", libraryList.get(position));

                startActivity(i);
            }
        });
    }

    protected void sendGetChicagoLibrariesInfoVolleyRequest() {

        NetworkManager.getInstance(this).processVolleyGetRequest(CHICAGO_LIBRARY_URL, new NetworkManager.ResponseHandler() {
            @Override
            public void onSuccess(final String response) {
                ProcessGetChicagoLibrariesInfo(response);
            }

            @Override
            public void onError(final VolleyError error) {
                hideLoadingPanel();
                Util.openAlertDialog(MainActivity.this, "Error", MainActivity.this.getResources().getString(R.string.network_error));
            }
        }, VOLLEY_TAD);
    }

    private void ProcessGetChicagoLibrariesInfo(String result) {

        if (result == null || result.equals("")) {
            hideLoadingPanel();
            return;
        }
        try {
            libraryList = JsonParser.parseLibrary(result);
            if (libraryList != null && libraryList.size() > 0) {
                LibraryAdapter adapter = new LibraryAdapter(this, libraryList);
                library_listview.setAdapter(adapter);
            }
            hideLoadingPanel();
        } catch (Exception e) {
            e.printStackTrace();
            hideLoadingPanel();
        }
    }

    private void hideLoadingPanel() {
        if (loadingPanel != null) {
            loadingPanel.setVisibility(View.GONE);
        }
    }
}
