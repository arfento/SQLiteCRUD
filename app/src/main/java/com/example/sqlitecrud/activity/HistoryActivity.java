package com.example.sqlitecrud.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.sqlitecrud.R;
import com.example.sqlitecrud.adapter.AssetHistoryAdapter;
import com.example.sqlitecrud.api.ApiClient;
import com.example.sqlitecrud.api.ApiInterface;
import com.example.sqlitecrud.model.PendingItem;
import com.example.sqlitecrud.model.PendingResponse;

import java.util.ArrayList;
import java.util.List;
import java.util.prefs.Preferences;

public class HistoryActivity extends AppCompatActivity {

    private static final String TAG = HistoryActivity.class.getSimpleName();
    RecyclerView recyclerView;;
    AssetHistoryAdapter adapter;
    ApiClient apiServices;
    List<PendingItem> items = new ArrayList<>();
    Preferences preferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);

        recyclerView = findViewById(R.id.rv_list_history);
        getDataHistory();
    }

    private void getDataHistory() {

        ApiInterface apiServices =
                ApiClient.getClient().create(ApiInterface.class);
        Call<PendingResponse> call = apiServices.getDataDetaiPendingNewQR("Admin");
        call.enqueue(new Callback<PendingResponse>() {
            @Override
            public void onResponse(Call<PendingResponse> call, Response<PendingResponse> response) {

                if (response.isSuccessful()){
                    if (response.body().getResult() == 1){
                        items = response.body().getGetData();
                        Log.d(TAG, "onResponse: List Item History : " +items.toString());
                        initUI(items);
                    }
                }

            }

            @Override
            public void onFailure(Call<PendingResponse> call, Throwable t) {
                Toast.makeText(HistoryActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
    private void initUI(List<PendingItem> item) {
        adapter = new AssetHistoryAdapter(this, item);
        adapter.notifyDataSetChanged();
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
    }

    //search function
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.search_nav_menu, menu);
        MenuItem item = menu.findItem(R.id.action_search);
        SearchView searchView = (SearchView) item.getActionView();

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                adapter.getFilter().filter(newText);
                return false;
            }
        });

        return super.onCreateOptionsMenu(menu);
    }



    @Override
    public void onBackPressed(){
        super.onBackPressed();
        this.finish();
    }

    @Override
    public boolean onSupportNavigateUp() {
        this.finish();
        return true;
    }
}