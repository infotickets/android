package com.infotickets.android;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.view.View;

import com.facebook.FacebookSdk;
import com.infotickets.android.databinding.ActivityWellcomeBinding;

public class WellcomeAct extends BaseAct {
    ActivityWellcomeBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    //    FacebookSdk.sdkInitialize(getApplicationContext());
        binding = DataBindingUtil.setContentView(this,R.layout.activity_wellcome);
        binding.signInButtonFacebook.setOnClickListener(listener);
        binding.signInButtonFacebook.setOnClickListener(listener);


    }


    View.OnClickListener listener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent intent = new Intent(getApplicationContext(),MainActivity.class);
            startActivity(intent);
        }
    };


}
