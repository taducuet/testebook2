package taduc.com.testebook2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.util.DisplayMetrics;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Fragment
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        //get the current display info
        DisplayMetrics display = this.getResources().getDisplayMetrics();
        int width = display.widthPixels;
        int height = display.heightPixels;

        //Bundle
        Bundle bundle = new Bundle();
        if(width > height)
        {
            //landscape mode
            //Add Fragment 1
            Fragment1 fragment1 = new Fragment1();
            fragmentTransaction.replace(R.id.fragmentContainerView3,fragment1);
            //Add Fragment 2
            Fragment2 fragment2 = new Fragment2();
            fragmentTransaction.replace(R.id.fragmentContainerView4,fragment2);
            //send bundle
            bundle.putString("mode","landscape");
            fragment1.setArguments(bundle);
            //receive data from fragment 1
            Intent intent = getIntent();
            String message = intent.getStringExtra("pdfFileName");
            //send data to fragment 2
            bundle.putString("pdfFileName","From Activity");
            fragment2.setArguments(bundle);
        }
        else
        {
            //portrait mode
            Fragment1 fragment1 = new Fragment1();
            fragmentTransaction.replace(R.id.fragmentContainerView1,fragment1);
            //send bundle
            bundle.putString("mode","portrait");
            fragment1.setArguments(bundle);
        }
        fragmentTransaction.commit();
    }
}