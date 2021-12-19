package taduc.com.testebook2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.app.UiModeManager;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.net.Uri;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.SearchView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private UiModeManager uiModeManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setTitle("Harry Potter và hòn đá phù thuỷ");
        //Fragment
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        //get the current display info
        DisplayMetrics display = this.getResources().getDisplayMetrics();
        int width = display.widthPixels;
        int height = display.heightPixels;

        //Bundle
        Bundle bundle = new Bundle();
        if (width > height) {
            //landscape mode
            //Add Fragment 1
            Fragment1 fragment1 = new Fragment1();
            fragmentTransaction.replace(R.id.fragmentContainerView3, fragment1);
            //Add Fragment 2
            Fragment2 fragment2 = new Fragment2();
            fragmentTransaction.replace(R.id.fragmentContainerView4, fragment2);
            //send bundle to fragment 1
            bundle.putString("mode", "landscape");
            fragment1.setArguments(bundle);
            //receive data from fragment 1
            Intent intent = getIntent();
            String message = intent.getStringExtra("pdfFileName");
            //send data to fragment 2
            bundle.putString("pdfFileName", "From Activity");
            fragment2.setArguments(bundle);
        } else {
            //portrait mode
            Fragment1 fragment1 = new Fragment1();
            fragmentTransaction.replace(R.id.fragmentContainerView1, fragment1);
            //send bundle to fragment 1
            bundle.putString("mode", "portrait");
            fragment1.setArguments(bundle);
        }
        fragmentTransaction.commit();
    }

    //Menu bar option
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.about:
                AlertDialog.Builder b = new AlertDialog.Builder(this);
                b.setTitle("About us");
                b.setMessage("Tạ Minh Đức -  19021435 \nTrần Tuấn Anh - 19021406 \nĐề tài: Ebook Reader thuộc học phần Lập trình cho thiết bị di động \nCảm ơn thầy Nguyễn Kiêm Hùng đã giúp đỡ bọn em trong quá trình học tập và hoàn thiện đề tài");
                b.setNegativeButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });
                //Tạo Dialog
                AlertDialog al = b.create();
                //Hiển thị
                al.show();
                break;

            case R.id.email:
                Intent intent = new Intent();
                String[] email_address = {"taduchh22@gmail.com"};
                intent.setAction(Intent.ACTION_SENDTO);
                intent.setData(Uri.parse("mailto:"));
                intent.putExtra(Intent.EXTRA_EMAIL, email_address);
                intent.putExtra(Intent.EXTRA_SUBJECT, "Góp ý ứng dụng Ebook Reader");
                startActivity(intent);
                break;

            case R.id.github:
                Intent intent1 = new Intent();
                intent1.setAction(Intent.ACTION_VIEW);
                intent1.setData(Uri.parse("https://github.com/taducuet/testebook2"));
                startActivity(intent1);
                break;

            case R.id.read_more:
                Intent intent2 = new Intent();
                intent2.setAction(Intent.ACTION_VIEW);
                intent2.setData(Uri.parse("https://wattpad.vn/tac-gia/j-k-rowling/"));
                startActivity(intent2);
                break;

            case R.id.dark:
                //AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
                AlertDialog.Builder dark = new AlertDialog.Builder(this);
                dark.setTitle("Choose Theme");
                String[] items = {"Light","Dark","System"};
                int checkedItem = 0;
                int nightModelFlags = getBaseContext().getResources().getConfiguration().uiMode & Configuration.UI_MODE_NIGHT_MASK;
                switch (nightModelFlags){
                    case Configuration.UI_MODE_NIGHT_NO:
                        checkedItem = 0;
                    break;
                    case Configuration.UI_MODE_NIGHT_YES:
                        checkedItem = 1;
                        break;
                }
                dark.setSingleChoiceItems(items, checkedItem, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        switch (which){
                            case 0:
                                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
                                break;
                            case 1:
                                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
                                break;
                            case 2:
                                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_FOLLOW_SYSTEM);
                        }
                    }
                });
                dark.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });
                //Tạo Dialog
                AlertDialog alertDialog = dark.create();
                //Hiển thị
                alertDialog.show();
                break;
        }

        return super.onOptionsItemSelected(item);
    }

    //Alert when exit App
    public void onBackPressed() {
        AlertDialog.Builder c = new AlertDialog.Builder(this);
        c.setMessage("Are you sure want to exit ?");
        c.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish();
            }
        });
        c.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });
        //Tạo Dialog
        AlertDialog al = c.create();
        //Hiển thị
        al.show();
    }
}