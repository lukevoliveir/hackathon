package br.com.appzica.appzica;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import br.com.miniature.bean.Miniature;

public class OcorrenciaAdapter extends ArrayAdapter<Miniature> {

    Context context;
    int id;
    List<Miniature> lista;

    public OcorrenciaAdapter(Context context, int id, List<Miniature> lista){
        super(context,id,lista);
        this.context = context;
        this.lista = lista;
        this.id = id;
    }

    public View getView(int position, View convertView, ViewGroup parent){
        View view = convertView;
        Miniature miniature;
        ImageView imageView;
        TextView code;
        TextView name;
        final Bitmap raw;
        byte[] imageArray;

        if(view == null){
            LayoutInflater inflater = LayoutInflater.from(context);
            view = inflater.inflate(id, parent, false);
        }

        code = (TextView)view.findViewById(R.id.codeField);
        name = (TextView)view.findViewById(R.id.nameField);
        imageView = (ImageView)view.findViewById(R.id.miniatureImage);

        miniature = lista.get(position);

        code.setText(miniature.getCode());
        name.setText(miniature.getName());
        imageArray = miniature.getImage();

        if(imageArray!=null){
            raw  = BitmapFactory.decodeByteArray(imageArray, 0, imageArray.length);
            imageView.setImageBitmap(raw);
        }

        return view;
    }


}
