package br.com.appzica.appzica.bo;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by marcelo on 09/04/16.
 */
public class Ocorrencia {


    public Ocorrencia() {
    }

    public Ocorrencia(JSONObject jsonPhoto) throws JSONException {
        this.id = (String) jsonPhoto.optString("_id");
        this.description = (String) jsonPhoto.optString("description");
        this.type = (String) jsonPhoto.optString("type");
//        this.coordinates = (Double) jsonPhoto.optString("coordinates");
//        this.description = (String) jsonPhoto.optString("description");
//        this.height = (String) jsonPhoto.optString("height");
//        this.width = (String) jsonPhoto.optString("width");
//        this.url = (String) jsonPhoto.optString("url");
//        this.image400Url = (String) jsonPhoto.optJSONObject("images").optString("normal");
    }

    private String id;

    private Double[] coordinates;

    private String type;

    private String description;

    private Date datetime;

    private String[] images;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Double[] getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(Double[] coordinates) {
        this.coordinates = coordinates;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDatetime() {
        return datetime;
    }

    public void setDatetime(Date datetime) {
        this.datetime = datetime;
    }

    public String[] getImages() {
        return images;
    }

    public void setImages(String[] images) {
        this.images = images;
    }

    public static ArrayList<Ocorrencia> converterOcorrenciasList(String ocorrenciaData)
            throws JSONException, NullPointerException {
        ArrayList<Ocorrencia> ocorrencias = new ArrayList<Ocorrencia>();
        JSONArray shots = new JSONArray(ocorrenciaData);
        for (int i = 0; i < shots.length(); i++) {
            JSONObject photo = (JSONObject) shots.get(i);
            Ocorrencia ocorrencia = new Ocorrencia(photo);
            ocorrencias.add(ocorrencia);
        }
        return ocorrencias;
    }



}
