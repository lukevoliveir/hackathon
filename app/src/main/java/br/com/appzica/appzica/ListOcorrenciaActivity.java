package br.com.appzica.appzica;

import android.app.ListActivity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

import br.com.appzica.appzica.bo.Ocorrencia;

public class ListOcorrenciaActivity extends ListActivity {

    private ListAdapter ListOcorrenciaAdapter;
    private ArrayList<Ocorrencia> ocorrencias;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_ocorrencia);



        RecuperarOcorrencias recuperarOcorrencias = new RecuperarOcorrencias();
        recuperarOcorrencias.execute();

//        String[] lstOcorrencias;
//
//        for (Ocorrencia ocorrencia : ocorrencias ) {
//
//        }



    }


    /**
     * Created by marcelo on 16/03/16.
     */
    public class RecuperarOcorrencias extends AsyncTask<String, String, Long> {

        @Override
        protected void onPreExecute() {
        }

        @Override
        protected void onPostExecute(Long result) {

//            String[] lstEstados = new String[] {" "+ ocorrencias.get(2).getId().toString() + " " + ocorrencias.get(2).getDescription().toString()};

            ListOcorrenciaAdapter = new OcorrenciaAdapter(ListOcorrenciaActivity.this, R.layout.consult_result_list, ocorrencias);
//            ListOcorrenciaAdapter = new ArrayAdapter<String>(getApplication(), android.R.layout.simple_list_item_1, lstEstados);



            setListAdapter(ListOcorrenciaAdapter);

        }

        @Override
        protected Long doInBackground(String... params) {
            HttpURLConnection connection = null;
            try {
                URL dataUrl = new URL("http://gdgsjc-hackathon-aedes.herokuapp.com/api/ocorrencias/team/1");
                connection = (HttpURLConnection) dataUrl.openConnection();
                connection.connect();
                int status = connection.getResponseCode();
                Log.d("connection", "status " + status);
                if (status == 200) {
                    InputStream is = connection.getInputStream();
                    BufferedReader reader = new BufferedReader(new InputStreamReader(is));
                    String responseString;
                    StringBuilder sb = new StringBuilder();
                    while ((responseString = reader.readLine()) != null) {
                        sb = sb.append(responseString);
                    }
                    String ocorrenciasData = sb.toString();
                    ocorrenciasData = ocorrenciasData.substring(24,ocorrenciasData.length() -1);
                    ocorrencias = Ocorrencia.converterOcorrenciasList(ocorrenciasData);
                    Log.d("connection", ocorrenciasData);


                    return (0l);
                } else {
                    return (1l);
                }
            } catch (Exception e) {
                e.printStackTrace();
                return (1l);
            }finally {
                connection.disconnect();
            }
        }
    }


}
