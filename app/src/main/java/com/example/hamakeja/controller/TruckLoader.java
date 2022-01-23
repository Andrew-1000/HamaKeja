package com.example.hamakeja.controller;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.loader.content.AsyncTaskLoader;

import com.example.hamakeja.model.Truck;
import com.example.hamakeja.utils.QueryUtils;

import java.util.List;

public class TruckLoader extends AsyncTaskLoader<List<Truck>> {

    private static final String LOG_TAG = TruckLoader.class.getName();
    private final String mUrl;


    public TruckLoader(@NonNull Context context, String url) {
        super(context);
        mUrl = url;
    }

    @Override
    protected void onStartLoading() {
        forceLoad();
    }

    @Nullable
    @Override
    public List<Truck> loadInBackground() {
        if (mUrl == null) {
            return null;
        }
        return QueryUtils.fetchTruckData(mUrl);
    }
}
