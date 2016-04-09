package br.com.appzica.appzica.rest;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonParser;

import java.util.ArrayList;
import java.util.List;


public class OcorrenciaRest {

	private static final String URL_WS = "http://gdgsjc-hackathon-aedes.herokuapp.com/api/ocorrencias/team/1";

//	public List<Miniatura> getListaHotWheel(String param) throws Exception {
//
//		String[] resposta = new WebServiceHotWheel().get(URL_WS + "buscarMiniaturaByPosition/"+param);
//		//	       String[] resposta = new WebServiceCliente().get(URL_WS + "buscarTodos");
//
//		if (resposta[0].equals("200")) {
////			GsonBuilder builder = new GsonBuilder();
////	        builder.registerTypeHierarchyAdapter(byte[].class, new ByteArray64());
////			Gson gson = builder.create();
//			Gson gson = new Gson();
//			ArrayList<Miniatura> listaMiniatura = new ArrayList<Miniatura>();
//			JsonParser parser = new JsonParser();
//			JsonArray array = parser.parse(resposta[1]).getAsJsonArray();
//
//			for (int i = 0; i < array.size(); i++) {
//				listaMiniatura.add(gson.fromJson(array.get(i), Miniatura.class));
//			}
//			return listaMiniatura;
//		} else {
//			throw new Exception(resposta[1]);
//		}
//	}

	
//	public List<Miniatura> getListaHotWheel(String param) throws Exception {
//
//		String[] resposta = new WebServiceHotWheel().get(URL_WS + "buscarMiniaturaByPosition?position="+param);
//		//	       String[] resposta = new WebServiceCliente().get(URL_WS + "buscarTodos");
//
//		if (resposta[0].equals("200")) {
////			GsonBuilder builder = new GsonBuilder();
////	        builder.registerTypeHierarchyAdapter(byte[].class, new ByteArray64());
////			Gson gson = builder.create();
//			Gson gson = new Gson();
//			ArrayList<Miniatura> listaMiniatura = new ArrayList<Miniatura>();
//			JsonParser parser = new JsonParser();
//			JsonArray array = parser.parse(resposta[1]).getAsJsonArray();
//
//			for (int i = 0; i < array.size(); i++) {
//				listaMiniatura.add(gson.fromJson(array.get(i), Miniatura.class));
//			}
//			return listaMiniatura;
//		} else {
//			throw new Exception(resposta[1]);
//		}
//	}
	public static String inserirOcorrencia(String ocorrenciaJson) throws Exception {

//			String[] resposta = new OcorrenciaRestHelper().post(URL_WS, ocorrenciaJson);
//			//	       String[] resposta = new WebServiceCliente().get(URL_WS + "buscarTodos");
//
////			 if (resposta[0].equals("200")) {
////				 Log.d("post", "inserido com sucesso");
////		     } else {
////		         throw new Exception(resposta[1]);
////		     }
		return "0";
	}



}
