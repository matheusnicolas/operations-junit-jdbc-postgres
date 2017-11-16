package sisalfa.android.com.appsisalfa;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.facebook.AccessToken;
import com.facebook.Profile;
import com.facebook.login.LoginManager;


public class FacebookActivity extends AppCompatActivity {

    private TextView infoNome;
    private TextView infoId;
    private TextView linkUri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_facebook);
        infoNome = (TextView)findViewById(R.id.info1);
        infoId = (TextView)findViewById(R.id.info2);
        linkUri = (TextView)findViewById(R.id.info3);
        if (AccessToken.getCurrentAccessToken() == null){
            goLoginScreen();
        }
        Bundle bundle = getIntent().getExtras();
        String nome = bundle.get("nome").toString();
        String id = bundle.get("id").toString();
        String uri = bundle.get("linkUri").toString();
        String img = bundle.get("image").toString();
        infoNome.setText(nome);
        infoId.setText(id);
        linkUri.setText(uri);

    }














    private void goLoginScreen() {
        Intent intent = new Intent(this, FacebooklinActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }

    public void logout(View view) {
        LoginManager.getInstance().logOut();
        goLoginScreen();
    }
}
