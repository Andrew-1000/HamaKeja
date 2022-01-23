package com.example.hamakeja.utils;

import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;

import com.example.hamakeja.model.Truck;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class QueryUtils {
    private static final String LOG_TAG = QueryUtils.class.getSimpleName();
    private QueryUtils() {

    }

    public static List<Truck> fetchTruckData(String requestUrl) {
        URL url = createURL(requestUrl);
        String jsonResponse = null;
        try {
            jsonResponse = makeHttpRequest(url);
        } catch (IOException e) {
            Log.e(LOG_TAG, "Problem making HTTP Request", e);
        }

        List<Truck> truckList = extractFeatureFromJson(jsonResponse);
        return truckList;
    }

    private static String makeHttpRequest(URL url) throws IOException{

        String jsonResponse = "";

        if (url == null) {
            return jsonResponse;
        }
        HttpURLConnection urlConnection = null;
        InputStream inputStream = null;
        try {
            urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setReadTimeout(Constants.READ_TIMEOUT);
            urlConnection.setConnectTimeout(Constants.CONNECT_TIMEOUT);
            urlConnection.setRequestMethod(Constants.REQUEST_METHOD_GET);
            urlConnection.connect();

            if (urlConnection.getResponseCode() == Constants.SUCCESS_RESPONSE_CODE){
                inputStream = urlConnection.getInputStream();
                jsonResponse = readFromStream(inputStream);
            } else {
                Log.e(LOG_TAG, "Error response code: " + urlConnection.getResponseCode());
            }
        } catch (IOException e) {
            Log.e(LOG_TAG, "Problem retrieving the Trucks JSON results", e);
        } finally {
            if (urlConnection != null) {
                urlConnection.disconnect();

            }if (inputStream != null) {
                inputStream.close();
            }
        }
        return jsonResponse;
    }

    private static String readFromStream(InputStream inputStream) throws IOException {
        StringBuilder output = new StringBuilder();
        if (inputStream != null) {
            InputStream in;
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream, StandardCharsets.UTF_8);
            File file;
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            String line = bufferedReader.readLine();
            while (line != null) {
                output.append(line);
                line = bufferedReader.readLine();
            }
        }
        return output.toString();
    }

    private static List<Truck> extractFeatureFromJson(String truckJSON) {
        if (TextUtils.isEmpty(truckJSON)){
            return null;
        }
        List<Truck> truckList = new ArrayList<>();
        try {
            JSONObject baseJsonResponse = new JSONObject(truckJSON);

            JSONObject responseJsonObject = baseJsonResponse.getJSONObject(Constants.JSON_KEY_RESPONSE);

            JSONArray resultJsonArray = responseJsonObject.getJSONArray(Constants.JSON_KEY_RESULTS);

            for (int i = 0; i< resultJsonArray.length(); i++) {
                JSONObject currentTruck = resultJsonArray.getJSONObject(i);
                String truckNumber = currentTruck.getString(Constants.JSON_KEY_TRUCK_NUMBER);
                String parkedLocation = currentTruck.getString(Constants.JSON_KEY_PARKED_LOCATION);
                String imageName = null;
                if (currentTruck.has(Constants.JSON_KEY_FIELDS)) {
                    JSONObject fieldsJsonObject = currentTruck.getJSONObject(Constants.JSON_KEY_FIELDS);
                    if (fieldsJsonObject.has(Constants.JSON_KEY_THUMBNAIL)){
                        imageName = fieldsJsonObject.getString(Constants.JSON_KEY_THUMBNAIL);
                    }
                }
                String contactNumber = currentTruck.getString(Constants.JSON_KEY_CONTACT_NUMBER);
                String overallSize = currentTruck.getString(Constants.JSON_KEY_OVERALL_SIZE);
                String carryingCapacity = currentTruck.getString(Constants.JSON_KEY_CARRYING_CAPACITY);
                Truck truck = new Truck(truckNumber, parkedLocation, imageName, contactNumber, overallSize, carryingCapacity);

                truckList.add(truck);
            }

        } catch (JSONException e) {
            Log.e(LOG_TAG, "Problem parsing the trucks JSON results",  e);
        }
        return truckList;
    }

    private static URL createURL(String requestUrl) {
        URL url = null;
        try {
            url = new URL(requestUrl);
        } catch (MalformedURLException e) {
            Log.e(LOG_TAG, "Problem building the URL", e);
        }
        return url;
    }
}
