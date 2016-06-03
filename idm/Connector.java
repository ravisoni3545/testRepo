package com.idm;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

/**
 * This program performs CRUD operations on a RESTful service. The following
 * operations should be performed using standard HTTP verbs:
 *     * Get a list of entities
 *     * Create an entity
 *     * Update an entity
 *
 * Apache Commons HTTP Core and HTTP Client libraries have been provided in
 * the /lib/ folder but any suitable library may be used.
 *
 * Any RESTful service may be used though we suggest the simple ones defined
 * at: http://jsonplaceholder.typicode.com/
 *
 * There is *no need* to demonstrate serialization and deserialization.
 * There is also *no need* to implement a server or perform data modification.
 *
 * Please *feel free* to use Google during this test.
 **/

public class Connector {
	public static final String REST_URL="http://jsonplaceholder.typicode.com/posts/";
	public static final String DEFAULT_CHARSET="UTF-8";
	static CloseableHttpClient client = HttpClientBuilder.create().build();

	public static void main(String[] args) throws IOException {
		try{
			Connector.getPhotos();
			Connector.createPhoto();
			Connector.updatePhoto();
		}catch(Exception ex){
			System.out.println("Error occured while performing CRUD operation on service url:"+REST_URL);
		}finally {
			client.close();
		}
	}

	public static void getPhotos() {


		HttpGet getRequest = new HttpGet(REST_URL+"1");
		try {
			HttpResponse response = client.execute(getRequest);
			HttpEntity entity = response.getEntity();
			String responseString = EntityUtils.toString(entity, DEFAULT_CHARSET);
			System.out.println("GET Response:"+responseString);

		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void createPhoto() {
		HttpPost postRequest = new HttpPost(REST_URL);

		try {
			postRequest.setEntity(new StringEntity("{\"title\":\"foo\",\"body\":\"bar\"}"));
			HttpResponse response = client.execute(postRequest);
			HttpEntity entity = response.getEntity();
			String responseString = EntityUtils.toString(entity, DEFAULT_CHARSET);
			System.out.println("POST Response:"+responseString);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		}
	}

	public static void updatePhoto() {
		HttpPut postRequest = new HttpPut(REST_URL+"1");

		try {
			postRequest.setEntity(new StringEntity("{\"title\":\"foo\",\"aaa\":\"bar\"}"));
			HttpResponse response = client.execute(postRequest);
			HttpEntity entity = response.getEntity();
			String responseString = EntityUtils.toString(entity, DEFAULT_CHARSET);
			System.out.println("PUT Response"+responseString);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		}
	}
}