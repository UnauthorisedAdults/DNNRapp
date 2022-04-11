package com.unauthorisedadults.dnnr.views;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.unauthorisedadults.dnnr.R;

public class StartGroupActivity extends AppCompatActivity {

    TextView groupIdDisplay, groupMemberBox;
    Button start, cancel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.groupactivity);

        Toolbar toolbar = findViewById(R.id.DNNR_Toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setIcon(R.drawable.ic_logo_smaller);
        getSupportActionBar().setTitle("");


        groupIdDisplay = findViewById(R.id.GroupIdDisplay);
        groupMemberBox = findViewById(R.id.GroupMembersBox);
        start = findViewById(R.id.startButton);
        cancel = findViewById(R.id.cancelButton);
    }

    public void startSwiping(View view) {
        //viewmodel.start
        //Noget med et intent
    }

    public void cancelGroup(View view)
    {
        //viewModel.canselgroup
        //Intent sender bruger tilbage til home
    }
}
