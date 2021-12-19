package taduc.com.testebook2;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.github.barteksc.pdfviewer.PDFView;

import java.io.IOException;
import java.io.InputStream;
import java.util.Objects;

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

