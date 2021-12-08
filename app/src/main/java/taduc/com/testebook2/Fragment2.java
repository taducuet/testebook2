package taduc.com.testebook2;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.github.barteksc.pdfviewer.PDFView;

import java.util.Objects;

public class Fragment2 extends Fragment {
    PDFView myPDFViewer;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view =inflater.inflate(R.layout.fragment_2,container,false);
        myPDFViewer = (PDFView) view.findViewById(R.id.pdfViewer);
        //receive bundle
        Bundle bundle = getArguments();
        String getItem = getActivity().getIntent().getStringExtra("pdfFileName");
        if(Objects.equals(getItem, "Chương 1. Đứa bé vẫn sống")){
            myPDFViewer.fromAsset("Chapter 1.pdf").load();
        }
        if(Objects.equals(getItem, "Chương 2. Tấm kính biến mất")){
            myPDFViewer.fromAsset("Chapter 2.pdf").load();
        }
        if(Objects.equals(getItem, "Chương 3. Những lá thư không xuất xứ")){
            myPDFViewer.fromAsset("Chapter 3.pdf").load();
        }
        if(Objects.equals(getItem, "Chương 4. Người giữ khoá")){
            myPDFViewer.fromAsset("Chapter 4.pdf").load();
        }
        if(Objects.equals(getItem, "Chương 5. Hẻm xéo")){
            myPDFViewer.fromAsset("Chapter 5.pdf").load();
        }
        if(Objects.equals(getItem, "Chương 6. Hành trình từ sân ga chín - ba - phần - tư")){
            myPDFViewer.fromAsset("Chapter 6.pdf").load();
        }
        if(Objects.equals(getItem, "Chương 7. Chiếc nón phân loại")){
            myPDFViewer.fromAsset("Chapter 7.pdf").load();
        }
        if(Objects.equals(getItem, "Chương 8. Bậc thầy độc dược")){
            myPDFViewer.fromAsset("Chapter 8.pdf").load();
        }
        if(Objects.equals(getItem, "Chương 9. Cuộc giao đấu nửa đêm")){
            myPDFViewer.fromAsset("Chapter 9.pdf").load();
        }
        if(Objects.equals(getItem, "Chương 10. Lễ hội ma Halloween")){
            myPDFViewer.fromAsset("Chapter 10.pdf").load();
        }
        if(Objects.equals(getItem, "Chương 11. Quidditch")){
            myPDFViewer.fromAsset("Chapter 11.pdf").load();
        }
        if(Objects.equals(getItem, "Chương 12. Tấm gương ảo ảnh")){
            myPDFViewer.fromAsset("Chapter 12.pdf").load();
        }
        if(Objects.equals(getItem, "Chương 13. Nicolas Flamel")){
            myPDFViewer.fromAsset("Chapter 13.pdf").load();
        }
        if(Objects.equals(getItem, "Chương 14. Trứng rồng đen")){
            myPDFViewer.fromAsset("Chapter 14.pdf").load();
        }
        if(Objects.equals(getItem, "Chương 15. Khu rừng cấm")){
            myPDFViewer.fromAsset("Chapter 15.pdf").load();
        }
        if(Objects.equals(getItem, "Chương 16. Bẫy sập")){
            myPDFViewer.fromAsset("Chapter 16.pdf").load();
        }
        if(Objects.equals(getItem, "Chương 17. Người hai mặt")){
            myPDFViewer.fromAsset("Chapter 17.pdf").load();
        }

        return view;
    }
}
