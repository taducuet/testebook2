package taduc.com.testebook2;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;


import java.util.Objects;

public class Fragment1 extends Fragment {
    ListView pdfListView;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view =inflater.inflate(R.layout.fragment_1,container,false);

        pdfListView = (ListView) view.findViewById(R.id.PDFlist);

        String[] pdffiles   ={"Chương 1. Đứa bé vẫn sống",
                            "Chương 2. Tấm kính biến mất",
                            "Chương 3. Những lá thư không xuất xứ",
                            "Chương 4. Người giữ khoá",
                            "Chương 5. Hẻm xéo",
                            "Chương 6. Hành trình từ sân ga chín - ba - phần - tư",
                            "Chương 7. Chiếc nón phân loại",
                            "Chương 8. Bậc thầy độc dược",
                            "Chương 9. Cuộc giao đấu nửa đêm",
                            "Chương 10. Lễ hội ma Halloween",
                            "Chương 11. Quidditch",
                            "Chương 12. Tấm gương ảo ảnh",
                            "Chương 13. Nicolas Flamel",
                            "Chương 14. Trứng rồng đen",
                            "Chương 15. Khu rừng cấm",
                            "Chương 16. Bẫy sập",
                            "Chương 17. Người hai mặt"};

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1,pdffiles){
            @NonNull
            @Override
            public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
                View view1 = super.getView(position, convertView, parent);
                TextView myText = (TextView) view1.findViewById(android.R.id.text1);
                return view1;
            }
        };

        pdfListView.setAdapter(adapter);
        pdfListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view2, int i, long l) {
                String item = pdfListView.getItemAtPosition(i).toString();

                //receive bundle from MainActivity
                Bundle bundle = getArguments();
                assert bundle != null;
                if(Objects.equals(bundle.getString("mode"),"portrait")) {
                    //portrait
                    Intent intent = new Intent(getActivity().getApplicationContext(), SecondActivity.class);
                    intent.putExtra("pdfFileName", item);
                    intent.putExtra("itemPosition",pdfListView.getItemAtPosition(i).toString());
                    startActivity(intent);
                }
                else if (Objects.equals(bundle.getString("mode"),"landscape")){
                    //landscape
                    //send data from frag1 to main activity
                    Intent intent = new Intent(getActivity().getApplicationContext(),MainActivity.class);
                    intent.putExtra("pdfFileName", item);
                    getActivity().startActivity(intent);
                }
            }
        });
        return view;
    }
}
