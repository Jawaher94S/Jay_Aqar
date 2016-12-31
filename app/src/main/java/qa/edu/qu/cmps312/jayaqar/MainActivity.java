package qa.edu.qu.cmps312.jayaqar;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    // In this activity will do the login system for user.
    //      1. chech the user exist in the database.

    // ToDo: create classes for each tab or create on class for all tabs and it will includes function for all tabs.
    // ToDo: replace the fragment dynamicly so it will show the priority for each tab (All, sale, rent).

        EditText username;
        EditText userpass;
        CheckBox rememberPass;
        SharedPreferences prefs;
        String userEntered;
        String passEntered;
        String isAuthenticatedString;
        boolean isChecked = false;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);

            //ToDo: instanciate object of dataBase Helper.
            //dbHelper = new DatabaseOpenHelper(this);

            username = (EditText) findViewById(R.id.username);
            userpass = (EditText) findViewById(R.id.password);

            prefs = getPreferences(MODE_PRIVATE);


            // ToDo: this block will keep user login until he/she logout.

            /*
            isChecked = b; //so next time it login automatically
            SharedPreferences.Editor editor = prefs.edit();
            editor.putBoolean("isChecked", isChecked);
            editor.apply();
*/
            //Log.i("TAG", String.valueOf(isChecked));

            //then go login automatically
            //or we can check whether there is anything in shared prefs


        }


        public void userLogin(View view) {

            userEntered = username.getText().toString();

            // retrieve password from user.

            passEntered = userpass.getText().toString();

            // send password and username to database and check the availiablity.

           // isAuthenticatedString = dbHelper.authenticate(userEntered, passEntered);

            if (null != isAuthenticatedString) {

                    SharedPreferences.Editor editor = prefs.edit();
                    editor.putString("USERNAME", userEntered);
                    editor.putString("NAME", isAuthenticatedString);
                    editor.putString("PASSWORD", passEntered);
                    //editor.clear();
                    editor.apply();

                    Intent intent = new Intent(this, offerActivity.class);
                    startActivity(intent);

            }


        }

    /*   public void NewUser(View view) {
            startActivity(new Intent(this, CreateAccount.class));
        }
*/
    public void getClick(View view) {

        switch (view.getId()) {
            case R.id.createTxtV:
                startActivity(new Intent(this, CreateAccount.class));
                break;
            case R.id.gustBtn:
                startActivity(new Intent(this, offerActivity.class));
                break;
            default:
                userLogin(view);
        }

    }

}
