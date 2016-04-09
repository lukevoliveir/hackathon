package br.com.appzica.appzica;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import br.com.appzica.appzica.bo.Ocorrencia;
import br.com.appzica.appzica.rest.OcorrenciaRest;

public class CadastrarOcorrenciaActivity extends AppCompatActivity {

    Ocorrencia ocorrencia;

    RequestQueue queue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastrar_ocorrencia);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        Button bLocal = (Button) findViewById(R.id.bLocal);
        bLocal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });


        Button cadastrar = (Button) findViewById(R.id.cadastrarOcorrencia);
        cadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText id = (EditText) findViewById(R.id.editText);
                EditText descricao = (EditText) findViewById(R.id.editText2);
                EditText localizacao = (EditText) findViewById(R.id.editText3);
                ImageView foto = (ImageView) findViewById(R.id.foto);

                ocorrencia = new Ocorrencia();
                ocorrencia.setId(id.getText().toString());
                ocorrencia.setDescription(descricao.getText().toString());
//                ocorrencia.setCoordinates(Double.valueOf(localizacao.getText().toString()));

                RequestQueue queue = Volley.newRequestQueue(getApplicationContext());

                StringRequest postRequest = new StringRequest(Request.Method.POST, "http://gdgsjc-hackathon-aedes.herokuapp.com/api/ocorrencias/team/1",
                        new Response.Listener<String>()
                        {
                            @Override
                            public void onResponse(String response) {
                                // response
                                Log.d("Response", response);
                            }
                        },
                        new Response.ErrorListener()
                        {
                            @Override
                            public void onErrorResponse(VolleyError error) {
                                // error
                                Log.d("Error.Response", error.getMessage());
                            }
                        }
                ) {
                    @Override
                    protected Map<String, String> getParams()
                    {
                        Map<String, String>  params = new HashMap<String, String>();
                        params.put("coordinates", "[1,0]");
                        params.put("type", ocorrencia.getType());
                        params.put("description", ocorrencia.getDescription());

                        return params;
                    }
                };

                queue.add(postRequest);

//                CRUDOcorrencias crudOcorrencias = new CRUDOcorrencias();
//                crudOcorrencias.execute();

            }
        });
    }


    /**
     * Created by marcelo on 16/03/16.
     */
    public class CRUDOcorrencias extends AsyncTask<String, String, Long> {

        @Override
        protected void onPreExecute() {
        }

        @Override
        protected void onPostExecute(Long result) {

        }

        @Override
        protected Long doInBackground(String... params) {
            GsonBuilder builder = new GsonBuilder();
            Gson gson = builder.create();
//                Object resposta = OcorrenciaRest.inserirOcorrencia(gson.toJson(ocorrencia));

            RequestQueue queue = Volley.newRequestQueue(getApplicationContext());

            StringRequest postRequest = new StringRequest(Request.Method.POST, "http://gdgsjc-hackathon-aedes.herokuapp.com/api/ocorrencias/team/1",
                    new Response.Listener<String>()
                    {
                        @Override
                        public void onResponse(String response) {
                            // response
                            Log.d("Response", response);
                        }
                    },
                    new Response.ErrorListener()
                    {
                        @Override
                        public void onErrorResponse(VolleyError error) {
                            // error
                            Log.d("Error.Response", error.getMessage());
                        }
                    }
            ) {
                @Override
                protected Map<String, String> getParams()
                {
                    Map<String, String>  params = new HashMap<String, String>();
                    params.put("description", "teste testte 2");
                    params.put("type", "0");
                    params.put("coordinates", "[1,0]");

                    return params;
                }
            };

            queue.add(postRequest);

            return 0l;
        }
    }
}
