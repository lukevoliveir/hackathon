package br.com.appzica.appzica.rest;

import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;


import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.util.HashMap;
import java.util.Map;

public class OcorrenciaRestHelper {
	/*

//	public final String[] get(String url) {
//
//		String[] result = new String[2];
//		HttpGet httpget = new HttpGet(url);
//		HttpResponse response;
//
//		try {
//			response = HttpClientSingleton.getHttpClientInstace().execute(httpget);
//			HttpEntity entity = response.getEntity();
//
//			if (entity != null) {
//				result[0] = String.valueOf(response.getStatusLine().getStatusCode());
//				InputStream instream = entity.getContent();
//				result[1] = toString(instream);
//				instream.close();
//				Log.i("get", "Result from post JsonPost : " + result[0] + " : " + result[1]);
//			}
//		} catch (Exception e) {
//			Log.e("NGVL", "Falha ao acessar Web service", e);
//			result[0] = "0";
//			result[1] = "Falha de rede!";
//		}
//		return result;
//	}
//
//	private String toString(InputStream is) throws IOException {
//
//		byte[] bytes = new byte[1024];
//		ByteArrayOutputStream baos = new ByteArrayOutputStream();
//		int lidos;
//		while ((lidos = is.read(bytes)) > 0) {
//			baos.write(bytes, 0, lidos);
//		}
//		return new String(baos.toByteArray());
//	}

	public String[] post(String url, String ocorrenciaJSON) {
		String[] result = new String[2];
//		try {
//			HttpPost httpPost = new HttpPost(new URI(url));
//			httpPost.setHeader("Content-type", "application/json");
//				StringEntity sEntity = new StringEntity(ocorrenciaJSON, "UTF-8");
//				httpPost.setEntity(sEntity);
//
//				HttpResponse response;
//				response = HttpClientSingleton.getHttpClientInstace().execute(httpPost);
//				HttpEntity entity = response.getEntity();
//
//				if (entity != null) {
//					result[0] = String.valueOf(response.getStatusLine().getStatusCode());
//					InputStream instream = entity.getContent();
//					result[1] = toString(instream);
//					instream.close();
//					Log.d("post", "Result from post JsonPost : " + result[0] + " : " + result[1]);
//				}
//
//
//		} catch (Exception e) {
//			Log.e("NGVL", "Falha ao acessar Web service", e);
//			result[0] = "0";
//			result[1] = "Falha de rede!";
//		}





		return result;
	}

	private String toString(InputStream is) throws IOException {

		byte[] bytes = new byte[1024];
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		int lidos;
		while ((lidos = is.read(bytes)) > 0) {
			baos.write(bytes, 0, lidos);
		}
		return new String(baos.toByteArray());
	}
	
	public void delete(String url, String hotwheelJSON) {
		try {

			HttpDelete httpDelete = new HttpDelete(new URI(url));

			HttpClientSingleton.getHttpClientInstace().execute(httpDelete);

		} catch (Exception e) {
			Log.e("NGVL", "Falha ao acessar Web service", e);
		}
	}
	*/
}

