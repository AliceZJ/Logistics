package com.check;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.WuliuCheck.R;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends Activity {

	//访问web服务器
	public static String URL = "http://192.168.3.222/aaaaaa/AppseverServlet";
	EditText id ;
	Button cx_btn ;
	int uid = -1;
	JSONArray json = null;
	
	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        id = (EditText)findViewById(R.id.uid);
    }
	
	public void onClick(View v){
		new Thread() {
			public void run() {
				json = testJson();
			}
		}.start();
		while (null == json) {

		}
		show(json);
	}
	
	private JSONArray testJson() {
		Log.e("mainActivity", "user------------");

		JSONArray ja = new JSONArray();
		try {
			HttpParams paramsw = createHttpParams();
			DefaultHttpClient httpClient = new DefaultHttpClient(paramsw);
			HttpPost post = new HttpPost(URL+"?uid="+id.getText().toString());
			Log.e("0", URL+"?uid="+id.getText().toString());
			StringBuilder result = new StringBuilder();

			HttpResponse httpResponse = httpClient.execute(post);
			int httpCode = httpResponse.getStatusLine().getStatusCode();
			Log.e("0", String.valueOf(httpCode));
			if (httpCode == HttpURLConnection.HTTP_OK && httpResponse != null) {
				HttpEntity entity = httpResponse.getEntity();
				InputStream inputStream = entity.getContent();
				InputStreamReader inputStreamReader = new InputStreamReader(
						inputStream);
				BufferedReader reader = new BufferedReader(inputStreamReader);
				String s;
				while (((s = reader.readLine()) != null)) {
					result.append(s);
				}
				reader.close();
				ja = new JSONArray(result.toString());
			} else {
				Log.e("aaaa", "Error Response"
						+ httpResponse.getStatusLine().toString());
			}
		} catch (ClientProtocolException e) {
			Log.e("mainActivity2", e.getMessage());
		} catch (IOException e) {
			Log.e("mainActivity3", e.getMessage());
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return ja;
	}


	public void show(final JSONArray ja) {
		setContentView(R.layout.showlist_page);
		ListView lv = (ListView)findViewById(R.id.showlist_page);		
		BaseAdapter bp = new BaseAdapter() {			
			@Override
			public View getView(int arg0, View arg1, ViewGroup arg2) {
				if(null == arg1){
					arg1 = View.inflate(MainActivity.this,R.layout.list_item, null);
				}
				TextView name =(TextView)arg1.findViewById(R.id.uname);
				TextView id =(TextView)arg1.findViewById(R.id.uid);
				TextView role =(TextView)arg1.findViewById(R.id.urole);
				try {
					JSONObject jo = ja.getJSONObject(arg0);
					name.setText(jo.getString("uid"));
					id.setText(jo.getString("uname"));
					role.setText(jo.getString("urole"));
				} catch (JSONException e) {
					e.printStackTrace();
				}
				return arg1;
			}
			
			@Override
			public long getItemId(int arg0) {
				return 0;
			}
			
			@Override
			public Object getItem(int arg0) {
				try {
					return ja.get(arg0);
				} catch (JSONException e) {
					e.printStackTrace();
				}
				return null;
			}
			@Override
			public int getCount() {
				return ja.length();
			}
		};
		lv.setAdapter(bp);
	}

	public static final HttpParams createHttpParams() {
		final HttpParams params = new BasicHttpParams();
		//参数设置是否启用旧连接检查，默认是开启的。关闭这个旧连接检查可以提高一点点性能，但是增加了I/O错误的风险（当服务端关闭连接时）
		HttpConnectionParams.setStaleCheckingEnabled(params, false);
		//进行连接超时设置
		HttpConnectionParams.setConnectionTimeout(params, 10000);
		//表示如果对方连接状态1秒没有收到数据的话强制断开客户端
		HttpConnectionParams.setSoTimeout(params, 10000);
		//设置缓冲区大小
		HttpConnectionParams.setSocketBufferSize(params, 8192 * 5);
		return params;
	}
	

	@Override
	public void recreate() {
		super.recreate();
	}

	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		// 返回事件
		if(keyCode==KeyEvent.KEYCODE_BACK && event.getRepeatCount()==0)
		{
			recreate();
		}
		return true;
	}

}
