package br.com.appzica.appzica;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.HashMap;
import java.util.Map;

import br.com.appzica.appzica.bo.Ocorrencia;

public class CadastrarOcorrenciaActivity extends Activity {

    Ocorrencia ocorrencia;
    RequestQueue queue;

    Button btnRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastrar_ocorrencia);


        Button bLocal = (Button) findViewById(R.id.bLocal);
        bLocal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        btnRegister = (Button) findViewById(R.id.cadastrarOcorrencia);
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText descricao = (EditText) findViewById(R.id.editDesc);
                EditText tipo = (EditText) findViewById(R.id.editTipo);

                ocorrencia = new Ocorrencia();
                ocorrencia.setDescription(descricao.getText().toString());
                ocorrencia.setType(tipo.getText().toString());

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

            }
        });
    }
}
