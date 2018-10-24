package es.infotickets.android;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.Task;
import com.pack.networking.handler.ServiceHandler;

import es.infotickets.android.R;
import es.infotickets.android.databinding.ActivityWellcomeBinding;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class WellcomeAct extends BaseAct {
    private static final int RC_SIGN_IN =1 ;
    ActivityWellcomeBinding binding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    //    FacebookSdk.sdkInitialize(getApplicationContext());
        binding = DataBindingUtil.setContentView(this,R.layout.activity_wellcome);
        binding.signInButtonGoogle.setOnClickListener(listener);
    }




    View.OnClickListener listener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            if (view.getId()==R.id.sign_in_button_google){
                goGoogle();
            }else{
                Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent);
            }
        }
    };

    public void goGoogle(){
        Intent signInIntent = mGoogleSignInClient.getSignInIntent();
        startActivityForResult(signInIntent, RC_SIGN_IN);
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == RC_SIGN_IN) {
            // The Task returned from this call is always completed, no need to attach
            // a listener.
            Task<GoogleSignInAccount> task = GoogleSignIn.getSignedInAccountFromIntent(data);
            handleSignInResult(task);
        }
    }


    private void handleSignInResult(Task<GoogleSignInAccount> completedTask) {
        try {
            GoogleSignInAccount account = completedTask.getResult(ApiException.class);

            // Signed in successfully, show authenticated UI.
          //  updateUI(account);

            Toast.makeText(getApplicationContext(),"LOgged!",Toast.LENGTH_LONG).show();


            ServiceHandler serviceHandler = new ServiceHandler(getApplicationContext());
            serviceHandler.signIn(account.getEmail(), account.getId(), new Callback<String>() {
                @Override
                public void onResponse(Call<String> call, Response<String> response) {
                    if (response.code()==200)
                        continueee();
                    else
                        Toast.makeText(getApplicationContext(),"Failed with server!",Toast.LENGTH_LONG).show();
                }
                @Override
                public void onFailure(Call<String> call, Throwable t) {
                    Toast.makeText(getApplicationContext(),"Failed with server!",Toast.LENGTH_LONG).show();
                }
            });
        } catch (ApiException e) {
            // The ApiException status code indicates the detailed failure reason.
            // Please refer to the GoogleSignInStatusCodes class reference for more information.
            Log.w("infotickets", "signInResult:failed code=" + e.getStatusCode());
            ///updateUI(null);
        }
    }

    private void continueee(){
        Intent intent = new Intent(getApplicationContext(),BeforeMainActivity.class);
        startActivity(intent);
        finishAffinity();
    }

}
