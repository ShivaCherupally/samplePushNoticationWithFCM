//package com.example.ruchitiwari.facebookexample;
//
//import android.support.v7.app.AppCompatActivity;
//import android.os.Bundle;
//import android.util.Log;
//import android.widget.TextView;
//
//import com.android.volley.Request;
//import com.android.volley.RequestQueue;
//import com.android.volley.Response;
//import com.android.volley.VolleyError;
//import com.android.volley.toolbox.StringRequest;
//import com.android.volley.toolbox.Volley;
//import com.example.ruchitiwari.facebookexample.data.ServerResponseData;
//import com.example.ruchitiwari.facebookexample.data.ServerResponseData2;
//import com.example.ruchitiwari.facebookexample.serverapis.ApiRequest;
//import com.example.ruchitiwari.facebookexample.serverapis.ApiRequestHelper;
//import com.example.ruchitiwari.facebookexample.serverapis.ApiRequestManager;
//import com.example.ruchitiwari.facebookexample.serverapis.ApiResponseListener;
//
//import org.json.JSONArray;
//import org.json.JSONObject;
//
//import java.util.HashMap;
//import java.util.Map;
//
//
//public class MainActivity extends AppCompatActivity
//{
//	private Map<String, String> mParams;
//
//	@Override
//	protected void onCreate(Bundle savedInstanceState)
//	{
//		super.onCreate(savedInstanceState);
//		setContentView(R.layout.activity_main);
//		final TextView mTextView = (TextView) findViewById(R.id.text);
//
//		sendRequest(ApiRequestHelper.getReports("SHRAF2510882", "SHRA"));
//
//		// Instantiate the RequestQueue.
//		RequestQueue queue = Volley.newRequestQueue(this);
//		String url = "http://104.211.96.182:91/Service.asmx/Authenticate_User";
//
//		mParams = new HashMap<String, String>();
//		mParams.put("ptntcode", "SHRAF2510882");
//		mParams.put("pwd", "SHRA");
//
//		// Request a string response from the provided URL.
//		StringRequest stringRequest = new StringRequest(Request.Method.POST, url,
//		                                                new Response.Listener<String>()
//		                                                {
//			                                                @Override
//			                                                public void onResponse(String response)
//			                                                {
//				                                                response = response.replace("<?xml version=\"1.0\" encoding=\"utf-8\"?>", "");
//				                                                response = response.replace("<string xmlns=\"http://tempuri.org/\">", "");
//				                                                response = response.replace("<string xmlns=\"http://220.227.57.139:81/\">", "");
//				                                                response = response.replace("</string>", "");
//				                                                Log.e("response", response + "");
//				                                                try
//				                                                {
//					                                                JSONObject jobj = new JSONObject(response);
//					                                                String code = jobj.getString("code");
//					                                                Log.e("code", code + "");
//					                                                String msg = jobj.getString("msg");
//					                                                Log.e("msg", msg + "");
//					                                                JSONArray jsonArray = jobj.getJSONArray("data");
//					                                                Log.e("jsonArray", jsonArray + "");
//					                                                for (int i = 0; i < jsonArray.length(); i++)
//					                                                {
//						                                                String userId = jsonArray.getJSONObject(i).getString("PTNT_CD");
//						                                                Log.e("userId", userId + "");
//						                                                String emailid = jsonArray.getJSONObject(i).getString("EMAIL_ID");
//						                                                Log.e("emailid", emailid + "");
//						                                                String city = jsonArray.getJSONObject(i).getString("CITY");
//						                                                Log.e("city", city + "");
//					                                                }
//
//
////
////
////						OffersListItemData offerlist_data = new OffersListItemData();
////						offerlist_data.setID(jArray.getJSONObject(i).getInt(Constants.offer_id));
////						offerlist_data.setDESCRIPTION(jArray.getJSONObject(i).getString(Constants.offer_description));
////						offerlist_data.setIMAGE_URL(jArray.getJSONObject(i).getString(Constants.offer_image_url));
////						offerlist_data.setCREATED_DATE(jArray.getJSONObject(i).getString(Constants.offer_created_date));
////						offerlist_data.setACTIVE_FLAG(jArray.getJSONObject(i).getString(Constants.offer_active_date));
////						offerlist_data.setNAME(jArray.getJSONObject(i).getString(Constants.offer_name));
////						offerlist_data.setFRM_DT(jArray.getJSONObject(i).getString(Constants.offer_from_date));
////						offerlist_data.setTO_DT(jArray.getJSONObject(i).getLong(Constants.offer_to_date));
////						offerlist_data.setSEQUENCE(jArray.getJSONObject(i).getString(Constants.offer_sequence));
////						offerlist_data.setTESTCODE(jArray.getJSONObject(i).getString(Constants.offer_test_code));
////						offerlist_data.setDISCOUNT_TYPE(jArray.getJSONObject(i).getString(Constants.offer_discount_type));
////						offerlist_data.setPERC_AMT(jArray.getJSONObject(i).getString(Constants.offer_perc_amt));
////						offerlist_data.setACTION(jArray.getJSONObject(i).getString(Constants.offer_action));
////						offerlist_data.setBANNER_FLG(jArray.getJSONObject(i).getString(Constants.offer_banner_flag));
////						if (jArray.getJSONObject(i).getString(Constants.offer_banner_flag).equalsIgnoreCase("N"))
////						{
////							mOffersListItemData.add(offerlist_data);
////						}
////
////					}
//				                                                }
//				                                                catch (Exception e)
//				                                                {
//					                                                e.printStackTrace();
//				                                                }
//
//				                                                // Display the first 500 characters of the response string.
//				                                                mTextView.setText("Response is: " + response);
//			                                                }
//		                                                }, new Response.ErrorListener()
//
//
//		{
//			@Override
//			public void onErrorResponse(VolleyError error)
//			{
//				mTextView.setText("That didn't work!");
//			}
//		})
//		{
//			@Override
//			protected Map<String, String> getParams()
//			{
//				return mParams;
//			}
//		};
//
//// Add the request to the RequestQueue.
//		queue.add(stringRequest);
//	}
//
//
//	private void sendRequest(ApiRequest request)
//	{
//		try
//		{
//			ApiRequestManager.getInstance().sendRequest(this, request, mResponseListener);
//		}catch (Exception e){
//			e.printStackTrace();
//
//		}
//
//	}
//
//
//	private ApiResponseListener<ServerResponseData> mResponseListener = new ApiResponseListener<ServerResponseData>() {
//		@Override
//		public void onResponse(final ApiRequest request, final ServerResponseData serverResponseData) {
//			switch (request.getReferralCode()) {
//				case REPORTS: {
//					if (serverResponseData != null && serverResponseData.getObjectData() != null) {
//						try {
//							JSONObject jobj = serverResponseData.getObjectData().getJSONObject("data");
//							Log.e("jobj", jobj + "");
//
//							if (jobj != null) {
//								ServerResponseData2 serverResponseData2 = new ServerResponseData2();
//								serverResponseData2.setCode(100);
//								serverResponseData2.setMsg("");
//								serverResponseData2.setData(jobj.getJSONArray("data"));
//
//								if (serverResponseData2 != null && serverResponseData2.getData() != null) {
//									Log.e("serverResponseData2", serverResponseData2 + "");
//									//setReportsList(serverResponseData2);
//								}
//							}
//						} catch (Exception e) {
//
//						}
//
//					}
//				}
//				break;
//			}
//		}
//
//		@Override
//		public void onResponseError(final ApiRequest request, final Exception error) {
//
//		}
//	};
//
//}
