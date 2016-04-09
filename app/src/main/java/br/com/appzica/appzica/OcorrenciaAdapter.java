package br.com.appzica.appzica;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

import br.com.appzica.appzica.bo.Ocorrencia;

public class OcorrenciaAdapter extends ArrayAdapter<Ocorrencia> {

    Context context;
    int id;
    List<Ocorrencia> lista;

    public OcorrenciaAdapter(Context context, int id, List<Ocorrencia> lista){
        super(context,id,lista);
        this.context = context;
        this.lista = lista;
        this.id = id;
    }

    public View getView(int position, View convertView, ViewGroup parent){
        View view = convertView;
        Ocorrencia ocorrencia;
        TextView local;
        TextView tipo;
        TextView descricao;
        final Bitmap raw;

        if(view == null){
            LayoutInflater inflater = LayoutInflater.from(context);
            view = inflater.inflate(id, parent, false);
        }

        tipo = (TextView)view.findViewById(R.id.tipo);
        descricao = (TextView)view.findViewById(R.id.descricao);
//        local = (TextView)view.findViewById(R.id.localizacao);

        ocorrencia = lista.get(position);

        tipo.setText(ocorrencia.getType());
        descricao.setText(ocorrencia.getDescription());
//        local.setText(Double.valueOf(ocorrencia.getCoordinates()).toString());


        return view;
    }


}
