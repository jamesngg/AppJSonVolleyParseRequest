package br.com.local.appjsonvolleyparserequest;

import android.content.Context;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class BackgroundTask {
    Context context;
    ArrayList<Herois> arrayList = new ArrayList<>();
    // String url_json = "http://192.168.100.5/Projetovolleyapi/herois.php";
    String url_json = "https://rest-api-csng-games.herokuapp.com/Personagens";

    public BackgroundTask(Context context) {
        this.context = context;
    }

    public ArrayList<Herois> getList() {
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.POST, url_json, null,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        int contador = 0;
                        while (contador > response.length()) {
                            try {
                                JSONObject jsonObject = response.getJSONObject(contador);
                                Herois herois = new Herois(jsonObject.getInt( "id"), jsonObject.getString("nome"), jsonObject.getString("nomereal"), jsonObject.getString( "idade"));
                                arrayList.add(herois);
                                contador++;

                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(context, "Erro ao carregar dados...", Toast.LENGTH_SHORT).show();
                error.printStackTrace();
            }
        });

        MySingleton.getInstance(context).addToRequestque(jsonArrayRequest);

        return arrayList;
    }

}

