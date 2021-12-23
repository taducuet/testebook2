package taduc.com.testebook2;

import android.content.DialogInterface;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.text.style.BackgroundColorSpan;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import java.io.IOException;
import java.io.InputStream;
import java.util.Objects;

import top.defaults.colorpicker.ColorPickerPopup;

public class Fragment2 extends Fragment {
    TextView txt;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_2, container, false);
        txt = (TextView) view.findViewById(R.id.textView);
        //receive bundle (landscape) from main activity
        Bundle bundle = getArguments();
        loadChapter("Chapter 1.txt");
        //
        String getItem = getActivity().getIntent().getStringExtra("pdfFileName");
        if (Objects.equals(getItem, "Chương 1. Đứa bé vẫn sống")) {
           loadChapter("Chapter 1.txt");
        }
        if (Objects.equals(getItem, "Chương 2. Tấm kính biến mất")) {
            loadChapter("Chapter 2.txt");
        }
        if (Objects.equals(getItem, "Chương 3. Những lá thư không xuất xứ")) {
            loadChapter("Chapter 3.txt");
        }
        if (Objects.equals(getItem, "Chương 4. Người giữ khoá")) {
            loadChapter("Chapter 4.txt");
        }
        if (Objects.equals(getItem, "Chương 5. Hẻm xéo")) {
            loadChapter("Chapter 5.txt");
        }
        if (Objects.equals(getItem, "Chương 6. Hành trình từ sân ga chín - ba - phần - tư")) {
            loadChapter("Chapter 6.txt");
        }
        if (Objects.equals(getItem, "Chương 7. Chiếc nón phân loại")) {
            loadChapter("Chapter 7.txt");
        }
        if (Objects.equals(getItem, "Chương 8. Bậc thầy độc dược")) {
            loadChapter("Chapter 8.txt");
        }
        if (Objects.equals(getItem, "Chương 9. Cuộc giao đấu nửa đêm")) {
            loadChapter("Chapter 9.txt");
        }
        if (Objects.equals(getItem, "Chương 10. Lễ hội ma Halloween")) {
            loadChapter("Chapter 10.txt");
        }
        if (Objects.equals(getItem, "Chương 11. Quidditch")) {
            loadChapter("Chapter 11.txt");
        }
        if (Objects.equals(getItem, "Chương 12. Tấm gương ảo ảnh")) {
            loadChapter("Chapter 12.txt");
        }
        if (Objects.equals(getItem, "Chương 13. Nicolas Flamel")) {
            loadChapter("Chapter 13.txt");
        }
        if (Objects.equals(getItem, "Chương 14. Trứng rồng đen")) {
            loadChapter("Chapter 14.txt");
        }
        if (Objects.equals(getItem, "Chương 15. Khu rừng cấm")) {
            loadChapter("Chapter 15.txt");
        }
        if (Objects.equals(getItem, "Chương 16. Bẫy sập")) {
            loadChapter("Chapter 16.txt");
        }
        if (Objects.equals(getItem, "Chương 17. Người hai mặt")) {
            loadChapter("Chapter 17.txt");
        }
        return view;
    }


    //Settings menu bar
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        setHasOptionsMenu(true);
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
        inflater.inflate(R.menu.second_menu, menu);
        super.onCreateOptionsMenu(menu,inflater);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.size:
                AlertDialog.Builder text_size = new AlertDialog.Builder(getContext());
                text_size.setTitle("Text Size");
                String[] items = {"Large","Medium","Small"};
                int checkedItem = 0;
                text_size.setSingleChoiceItems(items, checkedItem, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        switch (which){
                            case 0:
                                txt.setTextSize(40);
                                break;
                            case 1:
                                txt.setTextSize(20);
                                break;
                            case 2:
                                txt.setTextSize(10);
                                break;
                        }
                    }
                });
                text_size.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });
                //Tạo Dialog
                AlertDialog alertDialog = text_size.create();
                //Hiển thị
                alertDialog.show();
                break;

            case R.id.font:
                AlertDialog.Builder font = new AlertDialog.Builder(getContext());
                font.setTitle("Font");
                String[] items_font = {"Helvetica Neue","Iciel Simplifica","TUV Benchmark","Default"};
                int checkedItem_font = 0;
                font.setSingleChoiceItems(items_font, checkedItem_font, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        switch (which){
                            case 0:
                                Typeface typeface = Typeface.createFromAsset(getActivity().getAssets(),"font/helveticaneue.ttf");
                                txt.setTypeface(typeface);
                                break;
                            case 1:
                                Typeface typeface1 = Typeface.createFromAsset(getActivity().getAssets(),"font/icielsimplifica.ttf");
                                txt.setTypeface(typeface1);
                                break;
                            case 2:
                                Typeface typeface2 = Typeface.createFromAsset(getActivity().getAssets(),"font/tuvbenchmark.ttf");
                                txt.setTypeface(typeface2);
                                break;
                            case 3:
                                txt.setTypeface(Typeface.SERIF);
                                break;
                        }
                    }
                });
                font.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });
                //Tạo Dialog
                AlertDialog alertDialog1 = font.create();
                //Hiển thị
                alertDialog1.show();
                break;

            case R.id.color:
                new ColorPickerPopup.Builder(getActivity()).initialColor(Color.RED)
                        .enableBrightness(true)
                        .enableAlpha(true)
                        .okTitle("Choose")
                        .cancelTitle("Cancel")
                        .showIndicator(true)
                        .showValue(true)
                        .build()
                        .show(
                            new ColorPickerPopup.ColorPickerObserver(){
                                @Override
                                public void onColorPicked(int color) {
                                    txt.setTextColor(color);
                                }
                            });
                break;

            case R.id.bgcolor:
                new ColorPickerPopup.Builder(getActivity()).initialColor(Color.RED)
                        .enableBrightness(true)
                        .enableAlpha(true)
                        .okTitle("Choose")
                        .cancelTitle("Cancel")
                        .showIndicator(true)
                        .showValue(true)
                        .build()
                        .show(
                                new ColorPickerPopup.ColorPickerObserver(){
                                    @Override
                                    public void onColorPicked(int color) {
                                        getView().setBackgroundColor(color);
                                    }
                                });
                break;

        }
        return super.onOptionsItemSelected(item);
    }

    //Function call chapter name
    private String loadChapter(String s) {
        String str = "";
        try {
            InputStream inputStream = getContext().getAssets().open(s);
            int size = inputStream.available();
            byte[] buffer = new byte[size];
            inputStream.read(buffer);
            str = new String(buffer);
        } catch (IOException e) {
            e.printStackTrace();
        }
        //Set Text in textview
        txt.setText(str);
        return str;
    }
}

