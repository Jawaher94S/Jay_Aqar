package qa.edu.qu.cmps312.jayaqar;

import android.app.Activity;
import android.app.DownloadManager;
import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Base64;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Hashtable;
import java.util.Map;

/**
 * Created by almesaifri on 12/28/16.
 */

public class CreateAccount extends Activity {

    EditText title, minimumPriceTxt, extraInfo;
    RadioButton rentProp, saleProp, yesPrice, noPrice;
    RadioGroup propertyType, miniPrice;
    ImageView propertyImg;
    Spinner city;
    Button loctionBtn;
    Bitmap bitmap;

    int PICK_IMAGE_REQUEST = 94;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.create_account);

        title = (EditText)findViewById(R.id.propertytitle);
        minimumPriceTxt = (EditText)findViewById(R.id.minipriceTxt);
        extraInfo = (EditText)findViewById(R.id.moreinfoTxt);

        rentProp = (RadioButton)findViewById(R.id.rentRBtn);
        saleProp = (RadioButton)findViewById(R.id.saleRBtn);
        noPrice = (RadioButton)findViewById(R.id.noRBtn);
        yesPrice = (RadioButton)findViewById(R.id.yesRBtn);

        propertyType = (RadioGroup)findViewById(R.id.propertyType);
        miniPrice = (RadioGroup)findViewById(R.id.minPrice);

        propertyImg = (ImageView)findViewById(R.id.propertyImg);

        city = (Spinner)findViewById(R.id.cities_list);
        loctionBtn = (Button)findViewById(R.id.locationBtn);



    }

    public void addToDB(){

        // All variables here to be send to the database.
        String title_DB = title.getText().toString();
        String propType_DB =null, minPrice_DB=null;
        if (rentProp.isChecked())
            propType_DB = "Rent";
        if(saleProp.isChecked())
            propType_DB = "Sale";
        if(yesPrice.isChecked())
            minPrice_DB = minimumPriceTxt.getText().toString();

        String city_DB = city.getSelectedItem().toString();
        // Map to get selected place by lang and long
        String extraInfo_DB = extraInfo.getText().toString();

    }

    // https://www.simplifiedcoding.net/android-volley-tutorial-to-upload-image-to-server/

/*    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == PICK_IMAGE_REQUEST && resultCode == RESULT_OK && data != null && data.getData() != null) {
            Uri filePath = data.getData();
            try {
                //Getting the Bitmap from Gallery
                bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), filePath);
                //Setting the Bitmap to ImageView
                propertyImg.setImageBitmap(bitmap);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    private void showFileChooser() {
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(Intent.createChooser(intent, "Select Picture"), PICK_IMAGE_REQUEST);
    }

    public void setProperty(View view){


    }

    public String getStringImage(Bitmap bmp){
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        bmp.compress(Bitmap.CompressFormat.JPEG, 100, baos);
        byte[] imageBytes = baos.toByteArray();
        String encodedImage = Base64.encodeToString(imageBytes, Base64.DEFAULT);
        return encodedImage;
    }

    private void uploadImage(){
        //Showing the progress dialog
        final ProgressDialog loading = ProgressDialog.show(this,"Uploading...","Please wait...",false,false);
        StringRequest stringRequest = new StringRequest(DownloadManager.Request.Method.POST, UPLOAD_URL,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String s) {
                        //Disimissing the progress dialog
                        loading.dismiss();
                        //Showing toast message of the response
                        Toast.makeText(MainActivity.this, s , Toast.LENGTH_LONG).show();
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError volleyError) {
                        //Dismissing the progress dialog
                        loading.dismiss();

                        //Showing toast
                        Toast.makeText(MainActivity.this, volleyError.getMessage().toString(), Toast.LENGTH_LONG).show();
                    }
                }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                //Converting Bitmap to String
                String image = getStringImage(bitmap);

                //Getting Image Name
                String name = editTextName.getText().toString().trim();

                //Creating parameters
                Map<String,String> params = new Hashtable<String, String>();

                //Adding parameters
                params.put(KEY_IMAGE, image);
                params.put(KEY_NAME, name);

                //returning parameters
                return params;
            }
        };

        //Creating a Request Queue
        RequestQueue requestQueue = Volley.newRequestQueue(this);

        //Adding request to the queue
        requestQueue.add(stringRequest);
    }*/
}
