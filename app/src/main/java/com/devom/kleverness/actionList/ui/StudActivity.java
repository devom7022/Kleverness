package com.devom.kleverness.actionList.ui;

import android.graphics.Point;
import android.os.Bundle;
import android.view.Display;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.devom.kleverness.actionList.R;
import com.devom.kleverness.actionList.adapters.StudAdapter;
import com.devom.kleverness.actionList.adapters.StudAdapterView;
import com.devom.kleverness.actionList.app.BaseApplication;
import com.devom.kleverness.actionList.model.Device;
import com.devom.kleverness.actionList.model.StudResponse;
import com.google.android.material.snackbar.Snackbar;

import javax.inject.Inject;

public class StudActivity extends AppCompatActivity implements StudView, StudAdapterView {

    private ProgressBar progressBar;
    private static long back_pressed;
    private static final long SECONDS_LAPSE = 2000;
    private View v;

    @Inject
    StudPresenter presenter;

    @Inject
    StudAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ((BaseApplication) getApplication()).plusPresenterSubComponent().inject(this);

        v = findViewById(android.R.id.content);

        progressBar = findViewById(R.id.pb_progress);

        Toolbar toolbar = findViewById(R.id.tb_toolbar);
        if (toolbar != null) {
            setSupportActionBar(toolbar);
        }

        Display display = getWindowManager().getDefaultDisplay();//SizeScreen, obtenemos las medidas del dispositivo para asignar la altura
        Point sizeScreen = new Point();
        display.getSize(sizeScreen);

        adapter.setView(this, sizeScreen.x, 2);//Funge como presenter ya que ahí mismo se encuentra su funcionamiento
        GridLayoutManager layoutManager = new GridLayoutManager(this, 2);//new GridLayoutManager(getContext(), 3);//Setup de layout

        RecyclerView rvCity = findViewById(R.id.rv_city);
        rvCity.setAdapter(adapter);
        rvCity.setLayoutManager(layoutManager);

        presenter.setView(this);
        presenter.getData();
    }

    @Override
    public void showProgress() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgress() {
        progressBar.setVisibility(View.GONE);

    }

    @Override
    public void setItemsOnAdapters(StudResponse response) {
        adapter.setData(response.getHub().getDevice());
    }

    @Override
    public void onFailure(String error) {
        Snackbar snackbar = Snackbar.make(v, error, Snackbar.LENGTH_SHORT);
        View snackView = snackbar.getView();
        TextView textView = snackView.findViewById(com.google.android.material.R.id.snackbar_text);
        textView.setTextColor(getResources().getColor(R.color.colorSecondaryLight));
        snackbar.show();
    }

    @Override
    protected void onDestroy() {
        presenter.onDestroy();
        super.onDestroy();
    }

    @Override
    public void onBackPressed() {
        if (back_pressed + SECONDS_LAPSE > System.currentTimeMillis()) super.onBackPressed();
        else
            Toast.makeText(getBaseContext(), getText(R.string.msj_exit_app), Toast.LENGTH_SHORT).show();
        back_pressed = System.currentTimeMillis();
    }

    @Override
    public void setItemOnClick(Device device, ImageView ivThumbnail) {

    }
}
