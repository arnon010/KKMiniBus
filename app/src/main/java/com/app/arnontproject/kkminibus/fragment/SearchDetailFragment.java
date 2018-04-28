package com.app.arnontproject.kkminibus.fragment;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.app.arnontproject.kkminibus.R;
import com.app.arnontproject.kkminibus.activity.MapsDetailActivity;
import com.app.arnontproject.kkminibus.adapter.CustomListAdapter;
import com.app.arnontproject.kkminibus.adapter.MiniBus;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link SearchDetailFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link SearchDetailFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SearchDetailFragment extends Fragment {

    EditText edtSearchDetail;
    private ArrayAdapter<MiniBus> adapter;

    private List<MiniBus> miniBus;
    ArrayList<MiniBus> mAllData=new ArrayList<>();

    String[] nameArray = {
            "สาย 2 : บ้านโคกฟันโปง – บ้านโคกน้อย\nบ.โคกฟันโปง, บ.หัวทุ่ง, บ.คำไฮ, เซ็นทรัลพลาซ่า ขอนแก่น, ศาลหลักเมือง ขอนแก่น, บขส.1, โรงเรียนขอนแก่นวิทยายน, ตลาดบางลำภู, ตลาดเทศบาล, โรงเรียนกัลยาณวัตร, สถานีตํารวจภูธรเมืองขอนแก่น, เซ็นโทซ่า, ไปรษณีย์ขอนแก่น, วัดศรีจันทร์, เรือนจำขอนแก่น, วิทยาลัยเทคนิคขอนแก่น, โรงพยาบาลศูนย์ขอนแก่น, มหาวิทยาลัยเทคโนโลยีราชมงคลอีสาน, ตลาดหนองใหญ่, บ.พระคือ, บ.หนองโพธิ์, บ.หนองแสง, บ.โคกน้อย",
            "สาย 3 : บขส.3 – บ้านพรหมนิมิตร\nบขส. 3, แม็คโคร ขอนแก่น, ประตูน้ำขอนแก่น, ตลาดอู้ฟู, โรงเรียนแก่นนครวิทยาลัย, ศาลหลักเมือง ขอนแก่น, เซ็นทรัลพลาซ่า ขอนแก่น, โรงบาลราชพฤกษ์ ขอนแก่น, บขส.1, โรงเรียนขอนแก่นวิทยายน, ตลาดบางลำภู, ตลาดเทศบาล, โรงเรียนกัลยาณวัตร, สถานีตํารวจภูธรเมืองขอนแก่น, ไปรษณีย์ขอนแก่น, วิทยาลัยเทคนิคขอนแก่น, มหาวิทยาลัยเทคโนโลยีราชมงคลอีสาน, ตลาดหนองใหญ่, บ.ท่าหิน, บ.พรหมนิมิตร",
            "สาย 4 : บขส.3 – บ้านหนองน้ำเกลี้ยง\nบขส.3, แม็คโคร ขอนแก่น, ประตูน้ำขอนแก่น, ตลาดอู้ฟู, ขอนแก่นแหอวน, โรงเรียนแก่นนครวิทยาลัย, โรงเรียนโสตศึกษาขอนแก่น, สนามกีฬากลางขอนแก่น, โรงเรียนเทศบาลวัดกลาง, แฟรี่พลาซ่า, ตลาดเทศบาล, ตลาดบางลำภู, โรงเรียนขอนแก่นวิทยายน, บขส.1, ศูนย์หัวใจสิริกิตขอนแก่น, โรงพยาบาลศรีนครินทร์, มหาวิทยาลัยขอนแก่น, โลตัสเอ็กซ์ตร้า, บ.สำราญ, บ.หนองน้ำเกลี้ยง",
            "สาย 5 : ตลาดหนองไผ่ล้อม – บ้านทุ่ม\nตลาดหนองไผ่ล้อม, ตลาดเทศบาล, ตลาดบางลำภู, โรงเรียนขอนแก่นวิทยายน, เซ็นโทซ่า, ศูนย์ประชุมกาญจนาภิเษก, มหาวิทยาลัยขอนแก่น, สถาบันพัฒนาฝีมือแรงงานขอนแก่น, บ.ทุ่ม",
            "สาย 6 : ตลาดเทศบาล 1 – บ้านเหล่านกชุม\nตลาดเทศบาล, เทศบาลนครขอนแก่น, ศาลหลักเมืองขอนแก่น, เซ็นทรัลพลาซ่าขอนแก่น, บิ๊กซีขอนแก่น, ตลาดต้นตาล, โฮมโปรขอนแก่น, แม็คโครขอนแก่น, ประตูน้ำขอนแก่น, เทสโก้โลตัสขอนแก่น, บขส.3, บ.กุดกว้าง, บ.ท่าพระ, บ.หนองหญ้าแพรก, บ.ท่าแร่, บ.โนนเขวา, บ.เหล่านกชุม",
            "สาย 8 : สามเหลี่ยม – บ้านดอนบม\nมหาวิทยาลัยขอนแก่น, เซ็นโทซ่า, บขส.1, บขส.2, สถานีตํารวจภูธรเมืองขอนแก่น, โรงเรียนขอนแก่นวิทยายน, โรงเรียนกัลยาณวัตร, ตลาดเทศบาล, แฟรี่พลาซ่า, เมืองเก่า, บึงแก่นนคร, บ.ดอนบม",
            "สาย 9 : สามเหลี่ยม – บ้านสะอาด\nบ.สามเหลี่ยม, บขส.1, บขส.2, โรงเรียนขอนแก่นวิทยายน, ไปรษณีย์ขอนแก่น, ตลาดเทศบาล, แฟรี่พลาซ่า, สนามกีฬากลางขอนแก่น, โรงเรียนแก่นนครวิทยาลัย, ตลาดต้นตาล, มหาวิทยาลัยภาคตะวันออกเฉียงเหนือ, บ.กอก, บ.โจด, บ.สะอาด",
            "สาย 10 : มหาวิทยาลัยขอนแก่น – สนามม้า\nมหาวิทยาลัยขอนแก่น, บขส.1, ที่ว่าการอําเภอเมืองขอนแก่น, บ.บะขาม, เรือนจำขอนแก่น, บขส.2, โรงเรียนขอนแก่นวิทยายน, ไปรษณีย์ขอนแก่น, สถานีตํารวจภูธรเมืองขอนแก่น, ตลาดเทศบาล, แฟรี่พลาซ่า, สนามกีฬากลางขอนแก่น, โรงเรียนแก่นนครวิทยาลัย, ประตูน้ำขอนแก่น, แม็คโครขอนแก่น, เทสโก้โลตัสขอนแก่น",
            "สาย 11 : บ้านโนนสวรรค์ – บ้านขามเจริญ\nบ.โนนสวรรค์, ตลาดหนองใหญ่, วิทยาลัยอาชีวศึกษาขอนแก่น, บขส.2, โรงเรียนขอนแก่นวิทยายน, ตึกคอมขอนแก่น, เทศบาลนครขอนแก่น, ตลาดต้นตาล, บ.โคกฟันโปง",
            "สาย 12 : พิพิธภัณฑ์ – รร.ท่าพระวิทยายน\nศาลากลางจังหวัดขอนแก่น, บขส.1, โรงเรียนขอนแก่นวิทยายน, ตลาดบางลำภู, ตลาดเทศบาล, โรงเรียนแก่นนครวิทยาลัย, ประตูน้ำขอนแก่น, เทสโก้โลตัสขอนแก่น, บขส.3, บ.โนนตุ่น, บ.กุดกว้าง, บ.ท่าพระ, บ.หนองบัวดีหมี",
            "สาย 13 : บ้านน้อยนิเวศน์ – บ้านสว่างมรรคา\nบ้านน้อยนิเวศน์, บขส.1, ตลาด อ.จิระ ขอนแก่น, ตึกคอมขอนแก่น, โรงเรียนกัลยาณวัตรม, ตลาดเทศบาล, โรงเรียนเทศบาลสวนสนุก, บึงแก่นนคร, บ.ตูม, บ.ดอนบม, บ.ดอนแดง, บ้านดอนหัน",
            "สาย 16 : บ้านโนนทัน – วัดป่าอดุลยาราม\nบ.โนนทัน, ตลาดโนนทัน, โรงพยาบาลจิตเวชขอนแก่น, เรือนจำขอนแก่น, โรงเรียนกัลยาณวัตร, บขส.1, บ.สามเหลี่ยม",
            "สาย 17 : บ้านโนนทัน – บ้านโคกท่า\nบ.โนนทัน, บึงแก่นนคร, โรงเรียนเทศบาลสวนสนุก, แฟรี่พลาซ่า, ตลาดเทศบาล, โรงเรียนกัลยาณวัตร, วิทยาลัยอาชีวศึกษาขอนแก่น, ตลาดบ้านดอน, ค่ายศรีพัชรินทร์, โรงเรียนขามแก่นนคร, บ.โกทา, บ.หนองหิน, บ.ห้วยชัน, บ.โคกท่า",
            "สาย 18 : โรงเรียนกัลยาณวัตร – บ้านโนนพอง\nโรงเรียนกัลยาณวัตร, เรือนจำขอนแก่น, วิทยาลัยเทคนิคขอนแก่น, โรงพยาบาลศูนย์ขอนแก่น, มหาวิทยาลัยเทคโนโลยีราชมงคลอีสาน, ตลาดหนองใหญ่, บ.แอ่วมอง, บ.สงเปือย, บ.โนนพอง",
            "สาย 19 : ตลาดหนองไผ่ล้อม – บ้านโนนเรือง\nตลาดหนองไผ่ล้อม, ตลาดเทศบาล, ตลาดบางลำภู, โรงเรียนขอนแก่นวิทยายน, >บขส.1, ศูนย์หัวใจสิริกิตขอนแก่น, โรงพยาบาลศรีนครินทร์ขอนแก่น, มหาวิทยาลัยขอนแก่น, โลตัสเอ็กซ์ตร้า, บ.โนนเมือง, บ.โนนเรือง",
            "สาย 20 : ตลาดหนองไผ่ล้อม – บ้านกลางฮุง\nตลาดหนองไผ่ล้อม, ตลาดเทศบาล, ตลาดบางลำภู, โรงเรียนขอนแก่นวิทยายน, บขส.1, ศูนย์หัวใจสิริกิตขอนแก่น, โรงพยาบาลศรีนครินทร์ขอนแก่น, มหาวิทยาลัยขอนแก่น, โลตัสเอ็กซ์ตร้า, บ.โคกนางาม, บ.หนองค้า, บ.กลางฮุง",
            "สาย 21 : บ้านโนนเขวา – บ้านดอนยาง\nบ.โนนเขวา, บ.เหล่านกชุม, บ.บือ, บ.โนนทัน, บึงแก่นนคร, แฟรี่พลาซ่า, ตลาดเทศบาล, โรงเรียนกัลยาณวัตร, สถานีตํารวจภูธรเมืองขอนแก่น, โรงเรียนขอนแก่นวิทยายน, บขส.1, ศาลากลางจังหวัดขอนแก่น, ตลาดบ้านดอน, บ.ดองยาง",
            "สาย 22 : บ้านหนองไฮ- บ้านดอนหญ้านาง\nบ.หนองไฮ, ตลาดหนองใหญ่, โรงพยาบาลศูนย์ขอนแก่น, เรือนจำขอนแก่น, สถานีตํารวจภูธรเมืองขอนแก่น, ตลาดเทศบาล, ตลาดบางลำภู, โรงเรียนขอนแก่นวิทยายน, บขส.1, ไปรษณีย์ขอนแก่น, บ.ดอนหญ้านาง",
            "สาย 23 : ตลาดเทศบาล 1 – บ้านห้วยเตย\nตลาดเทศบาล, ตลาดเทศบาล, บ.โนนตุ่น, บ.ท่าพระ, บ.หนองบัวดีหมี, บ.หนองแวง, บ.ห้วยเตย"};

    String[] infoArray = {
            "Central",
            "TheMall",
            "KK",
            "School",
            "Football",
            "Central",
            "TheMall",
            "KK",
            "School",
            "Football",
            "Central",
            "TheMall",
            "KK",
            "School",
            "Football",
            "Central",
            "TheMall",
            "KK",
            "School"
    };

    Integer[] imageArray = {
            R.drawable.ic_car2,
            R.drawable.ic_car3,
            R.drawable.ic_car4,
            R.drawable.ic_car5,
            R.drawable.ic_car6,
            R.drawable.ic_car8,
            R.drawable.ic_car9,
            R.drawable.ic_car10,
            R.drawable.ic_car11,
            R.drawable.ic_car12,
            R.drawable.ic_car13,
            R.drawable.ic_car16,
            R.drawable.ic_car17,
            R.drawable.ic_car18,
            R.drawable.ic_car19,
            R.drawable.ic_car20,
            R.drawable.ic_car21,
            R.drawable.ic_car22,
            R.drawable.ic_car23
    };


    ListView listView;
    CustomListAdapter listAdapter;
    TextView firstLine;
    View rootView;



    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public SearchDetailFragment() {
        // Required empty public constructor
    }

    public static SearchDetailFragment newInstance() {
        SearchDetailFragment fragment = new SearchDetailFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        rootView = inflater.inflate(R.layout.fragment_search_detail, container, false);

        firstLine = rootView.findViewById(R.id.firstLine);

        populateDrinksList();
        listAdapter = new CustomListAdapter(getActivity().getApplicationContext(),R.layout.listview_layout,miniBus);

        listView = rootView.findViewById(R.id.listViewSearchDetail);
        listView.setAdapter(listAdapter);
        listView.setTextFilterEnabled(true);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent intent = new Intent(getActivity(), MapsDetailActivity.class);
                String message = null;

                if (message == nameArray[0]) {
                    intent.putExtra("minibus", "สาย 2 : บ้านโคกฟันโปง – บ้านโคกน้อย\nบ.โคกฟันโปง, บ.หัวทุ่ง, บ.คำไฮ, เซ็นทรัลพลาซ่า ขอนแก่น, ศาลหลักเมือง ขอนแก่น, บขส.1, โรงเรียนขอนแก่นวิทยายน, ตลาดบางลำภู, ตลาดเทศบาล, โรงเรียนกัลยาณวัตร, สถานีตํารวจภูธรเมืองขอนแก่น, เซ็นโทซ่า, ไปรษณีย์ขอนแก่น, วัดศรีจันทร์, เรือนจำขอนแก่น, วิทยาลัยเทคนิคขอนแก่น, โรงพยาบาลศูนย์ขอนแก่น, มหาวิทยาลัยเทคโนโลยีราชมงคลอีสาน, ตลาดหนองใหญ่, บ.พระคือ, บ.หนองโพธิ์, บ.หนองแสง, บ.โคกน้อย");
                }
                if (message == nameArray[1]) {
                    intent.putExtra("minibus", "สาย 3 : บขส.3 – บ้านพรหมนิมิตร\nบขส. 3, แม็คโคร ขอนแก่น, ประตูน้ำขอนแก่น, ตลาดอู้ฟู, โรงเรียนแก่นนครวิทยาลัย, ศาลหลักเมือง ขอนแก่น, เซ็นทรัลพลาซ่า ขอนแก่น, โรงบาลราชพฤกษ์ ขอนแก่น, บขส.1, โรงเรียนขอนแก่นวิทยายน, ตลาดบางลำภู, ตลาดเทศบาล, โรงเรียนกัลยาณวัตร, สถานีตํารวจภูธรเมืองขอนแก่น, ไปรษณีย์ขอนแก่น, วิทยาลัยเทคนิคขอนแก่น, มหาวิทยาลัยเทคโนโลยีราชมงคลอีสาน, ตลาดหนองใหญ่, บ.ท่าหิน, บ.พรหมนิมิตร");
                }
                if (message == nameArray[2]) {
                    intent.putExtra("minibus", "สาย 4 : บขส.3 – บ้านหนองน้ำเกลี้ยง\nบขส.3, แม็คโคร ขอนแก่น, ประตูน้ำขอนแก่น, ตลาดอู้ฟู, ขอนแก่นแหอวน, โรงเรียนแก่นนครวิทยาลัย, โรงเรียนโสตศึกษาขอนแก่น, สนามกีฬากลางขอนแก่น, โรงเรียนเทศบาลวัดกลาง, แฟรี่พลาซ่า, ตลาดเทศบาล, ตลาดบางลำภู, โรงเรียนขอนแก่นวิทยายน, บขส.1, ศูนย์หัวใจสิริกิตขอนแก่น, โรงพยาบาลศรีนครินทร์, มหาวิทยาลัยขอนแก่น, โลตัสเอ็กซ์ตร้า, บ.สำราญ, บ.หนองน้ำเกลี้ยง");
                }
                if (message == nameArray[3]) {
                    intent.putExtra("minibus", "สาย 5 : ตลาดหนองไผ่ล้อม – บ้านทุ่ม\nตลาดหนองไผ่ล้อม, ตลาดเทศบาล, ตลาดบางลำภู, โรงเรียนขอนแก่นวิทยายน, เซ็นโทซ่า, ศูนย์ประชุมกาญจนาภิเษก, มหาวิทยาลัยขอนแก่น, สถาบันพัฒนาฝีมือแรงงานขอนแก่น, บ.ทุ่ม");
                }
                if (message == nameArray[4]) {
                    intent.putExtra("minibus", "สาย 6 : ตลาดเทศบาล 1 – บ้านเหล่านกชุม\nตลาดเทศบาล, เทศบาลนครขอนแก่น, ศาลหลักเมืองขอนแก่น, เซ็นทรัลพลาซ่าขอนแก่น, บิ๊กซีขอนแก่น, ตลาดต้นตาล, โฮมโปรขอนแก่น, แม็คโครขอนแก่น, ประตูน้ำขอนแก่น, เทสโก้โลตัสขอนแก่น, บขส.3, บ.กุดกว้าง, บ.ท่าพระ, บ.หนองหญ้าแพรก, บ.ท่าแร่, บ.โนนเขวา, บ.เหล่านกชุม");
                }
                if (message == nameArray[5]) {
                    intent.putExtra("minibus", "สาย 8 : สามเหลี่ยม – บ้านดอนบม\nมหาวิทยาลัยขอนแก่น, เซ็นโทซ่า, บขส.1, บขส.2, สถานีตํารวจภูธรเมืองขอนแก่น, โรงเรียนขอนแก่นวิทยายน, โรงเรียนกัลยาณวัตร, ตลาดเทศบาล, แฟรี่พลาซ่า, เมืองเก่า, บึงแก่นนคร, บ.ดอนบม");
                }
                if (message == nameArray[6]) {
                    intent.putExtra("minibus", "สาย 9 : สามเหลี่ยม – บ้านสะอาด\nบ.สามเหลี่ยม, บขส.1, บขส.2, โรงเรียนขอนแก่นวิทยายน, ไปรษณีย์ขอนแก่น, ตลาดเทศบาล, แฟรี่พลาซ่า, สนามกีฬากลางขอนแก่น, โรงเรียนแก่นนครวิทยาลัย, ตลาดต้นตาล, มหาวิทยาลัยภาคตะวันออกเฉียงเหนือ, บ.กอก, บ.โจด, บ.สะอาด");
                }
                if (message == nameArray[7]) {
                    intent.putExtra("minibus", "สาย 10 : มหาวิทยาลัยขอนแก่น – สนามม้า\nมหาวิทยาลัยขอนแก่น, บขส.1, ที่ว่าการอําเภอเมืองขอนแก่น, บ.บะขาม, เรือนจำขอนแก่น, บขส.2, โรงเรียนขอนแก่นวิทยายน, ไปรษณีย์ขอนแก่น, สถานีตํารวจภูธรเมืองขอนแก่น, ตลาดเทศบาล, แฟรี่พลาซ่า, สนามกีฬากลางขอนแก่น, โรงเรียนแก่นนครวิทยาลัย, ประตูน้ำขอนแก่น, แม็คโครขอนแก่น, เทสโก้โลตัสขอนแก่น");
                }
                if (message == nameArray[8]) {
                    intent.putExtra("minibus", "สาย 11 : บ้านโนนสวรรค์ – บ้านขามเจริญ\nบ.โนนสวรรค์, ตลาดหนองใหญ่, วิทยาลัยอาชีวศึกษาขอนแก่น, บขส.2, โรงเรียนขอนแก่นวิทยายน, ตึกคอมขอนแก่น, เทศบาลนครขอนแก่น, ตลาดต้นตาล, บ.โคกฟันโปง");
                }
                if (message == nameArray[9]) {
                    intent.putExtra("minibus", "สาย 12 : พิพิธภัณฑ์ – รร.ท่าพระวิทยายน\nศาลากลางจังหวัดขอนแก่น, บขส.1, โรงเรียนขอนแก่นวิทยายน, ตลาดบางลำภู, ตลาดเทศบาล, โรงเรียนแก่นนครวิทยาลัย, ประตูน้ำขอนแก่น, เทสโก้โลตัสขอนแก่น, บขส.3, บ.โนนตุ่น, บ.กุดกว้าง, บ.ท่าพระ, บ.หนองบัวดีหมี");
                }
                if (message == nameArray[10]) {
                    intent.putExtra("minibus", "สาย 13 : บ้านน้อยนิเวศน์ – บ้านสว่างมรรคา\nบ้านน้อยนิเวศน์, บขส.1, ตลาด อ.จิระ ขอนแก่น, ตึกคอมขอนแก่น, โรงเรียนกัลยาณวัตรม, ตลาดเทศบาล, โรงเรียนเทศบาลสวนสนุก, บึงแก่นนคร, บ.ตูม, บ.ดอนบม, บ.ดอนแดง, บ้านดอนหัน");
                }
                if (message == nameArray[11]) {
                    intent.putExtra("minibus", "สาย 16 : บ้านโนนทัน – วัดป่าอดุลยาราม\nบ.โนนทัน, ตลาดโนนทัน, โรงพยาบาลจิตเวชขอนแก่น, เรือนจำขอนแก่น, โรงเรียนกัลยาณวัตร, บขส.1, บ.สามเหลี่ยม");
                }
                if (message == nameArray[12]) {
                    intent.putExtra("minibus", "สาย 17 : บ้านโนนทัน – บ้านโคกท่า\nบ.โนนทัน, บึงแก่นนคร, โรงเรียนเทศบาลสวนสนุก, แฟรี่พลาซ่า, ตลาดเทศบาล, โรงเรียนกัลยาณวัตร, วิทยาลัยอาชีวศึกษาขอนแก่น, ตลาดบ้านดอน, ค่ายศรีพัชรินทร์, โรงเรียนขามแก่นนคร, บ.โกทา, บ.หนองหิน, บ.ห้วยชัน, บ.โคกท่า");
                }
                if (message == nameArray[13]) {
                    intent.putExtra("minibus", "สาย 18 : โรงเรียนกัลยาณวัตร – บ้านโนนพอง\nโรงเรียนกัลยาณวัตร, เรือนจำขอนแก่น, วิทยาลัยเทคนิคขอนแก่น, โรงพยาบาลศูนย์ขอนแก่น, มหาวิทยาลัยเทคโนโลยีราชมงคลอีสาน, ตลาดหนองใหญ่, บ.แอ่วมอง, บ.สงเปือย, บ.โนนพอง");
                }
                if (message == nameArray[14]) {
                    intent.putExtra("minibus", "สาย 19 : ตลาดหนองไผ่ล้อม – บ้านโนนเรือง\nตลาดหนองไผ่ล้อม, ตลาดเทศบาล, ตลาดบางลำภู, โรงเรียนขอนแก่นวิทยายน, >บขส.1, ศูนย์หัวใจสิริกิตขอนแก่น, โรงพยาบาลศรีนครินทร์ขอนแก่น, มหาวิทยาลัยขอนแก่น, โลตัสเอ็กซ์ตร้า, บ.โนนเมือง, บ.โนนเรือง");
                }
                if (message == nameArray[15]) {
                    intent.putExtra("minibus", "สาย 20 : ตลาดหนองไผ่ล้อม – บ้านกลางฮุง\nตลาดหนองไผ่ล้อม, ตลาดเทศบาล, ตลาดบางลำภู, โรงเรียนขอนแก่นวิทยายน, บขส.1, ศูนย์หัวใจสิริกิตขอนแก่น, โรงพยาบาลศรีนครินทร์ขอนแก่น, มหาวิทยาลัยขอนแก่น, โลตัสเอ็กซ์ตร้า, บ.โคกนางาม, บ.หนองค้า, บ.กลางฮุง");
                }
                if (message == nameArray[16]) {
                    intent.putExtra("minibus", "สาย 21 : บ้านโนนเขวา – บ้านดอนยาง\nบ.โนนเขวา, บ.เหล่านกชุม, บ.บือ, บ.โนนทัน, บึงแก่นนคร, แฟรี่พลาซ่า, ตลาดเทศบาล, โรงเรียนกัลยาณวัตร, สถานีตํารวจภูธรเมืองขอนแก่น, โรงเรียนขอนแก่นวิทยายน, บขส.1, ศาลากลางจังหวัดขอนแก่น, ตลาดบ้านดอน, บ.ดองยาง");
                }
                if (message == nameArray[17]) {
                    intent.putExtra("minibus", "สาย 22 : บ้านหนองไฮ- บ้านดอนหญ้านาง\nบ.หนองไฮ, ตลาดหนองใหญ่, โรงพยาบาลศูนย์ขอนแก่น, เรือนจำขอนแก่น, สถานีตํารวจภูธรเมืองขอนแก่น, ตลาดเทศบาล, ตลาดบางลำภู, โรงเรียนขอนแก่นวิทยายน, บขส.1, ไปรษณีย์ขอนแก่น, บ.ดอนหญ้านาง");
                }
                if (message == nameArray[18]) {
                    intent.putExtra("minibus", "สาย 23 : ตลาดเทศบาล 1 – บ้านห้วยเตย\nตลาดเทศบาล, ตลาดเทศบาล, บ.โนนตุ่น, บ.ท่าพระ, บ.หนองบัวดีหมี, บ.หนองแวง, บ.ห้วยเตย");
                }



                String message2 = infoArray[position];
                intent.putExtra("btsMinibus2", message2);
                Integer message3 = imageArray[position];
                intent.putExtra("image", message3);
                startActivity(intent);
                getActivity().overridePendingTransition(R.anim.push_in, R.anim.push_in_exit);
            }
        });

        LayoutAnimationController lac = new LayoutAnimationController(AnimationUtils.loadAnimation(getActivity(), R.anim.pop_out), 0.5f); //0.5f == time between appearance of listview items.
        listView.setLayoutAnimation(lac);
        listView.startLayoutAnimation();

        edtSearchDetail = rootView.findViewById(R.id.edtSearchDetail);
        edtSearchDetail.addTextChangedListener(new TextWatcher() {


            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                String text = edtSearchDetail.getText().toString().toLowerCase(Locale.getDefault());
                filter(text);
                listAdapter.notifyDataSetChanged();


//                firstLine.setText(highlight(edtSearchDetail.getText().toString(),firstLine.getText().toString()));
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                // TODO Auto-generated method stub


            }

            @Override
            public void afterTextChanged(Editable s) {
                // TODO Auto-generated method stub


            }
        });

        return rootView;
    }

    private void populateDrinksList() {
        miniBus = new ArrayList<>();
//        miniBus.add(new MiniBus("สาย 2 : บ้านโคกฟันโปง – บ้านโคกน้อย\nบ.โคกฟันโปง, บ.หัวทุ่ง, บ.คำไฮ, เซ็นทรัลพลาซ่า ขอนแก่น, ศาลหลักเมือง ขอนแก่น, บขส.1, โรงเรียนขอนแก่นวิทยายน, ตลาดบางลำภู, ตลาดเทศบาล, โรงเรียนกัลยาณวัตร, สถานีตํารวจภูธรเมืองขอนแก่น, เซ็นโทซ่า, ไปรษณีย์ขอนแก่น, วัดศรีจันทร์, เรือนจำขอนแก่น, วิทยาลัยเทคนิคขอนแก่น, โรงพยาบาลศูนย์ขอนแก่น, มหาวิทยาลัยเทคโนโลยีราชมงคลอีสาน, ตลาดหนองใหญ่, บ.พระคือ, บ.หนองโพธิ์, บ.หนองแสง, บ.โคกน้อย",infoArray[0],imageArray[0]));
//        miniBus.add(new MiniBus("สาย 3 : บขส.3 – บ้านพรหมนิมิตร\nบขส. 3, แม็คโคร ขอนแก่น, ประตูน้ำขอนแก่น, ตลาดอู้ฟู, โรงเรียนแก่นนครวิทยาลัย, ศาลหลักเมือง ขอนแก่น, เซ็นทรัลพลาซ่า ขอนแก่น, โรงบาลราชพฤกษ์ ขอนแก่น, บขส.1, โรงเรียนขอนแก่นวิทยายน, ตลาดบางลำภู, ตลาดเทศบาล, โรงเรียนกัลยาณวัตร, สถานีตํารวจภูธรเมืองขอนแก่น, ไปรษณีย์ขอนแก่น, วิทยาลัยเทคนิคขอนแก่น, มหาวิทยาลัยเทคโนโลยีราชมงคลอีสาน, ตลาดหนองใหญ่, บ.ท่าหิน, บ.พรหมนิมิตร",infoArray[1] ,imageArray[1]));
//        miniBus.add(new MiniBus("สาย 4 : บขส.3 – บ้านหนองน้ำเกลี้ยง\nบขส.3, แม็คโคร ขอนแก่น, ประตูน้ำขอนแก่น, ตลาดอู้ฟู, ขอนแก่นแหอวน, โรงเรียนแก่นนครวิทยาลัย, โรงเรียนโสตศึกษาขอนแก่น, สนามกีฬากลางขอนแก่น, โรงเรียนเทศบาลวัดกลาง, แฟรี่พลาซ่า, ตลาดเทศบาล, ตลาดบางลำภู, โรงเรียนขอนแก่นวิทยายน, บขส.1, ศูนย์หัวใจสิริกิตขอนแก่น, โรงพยาบาลศรีนครินทร์, มหาวิทยาลัยขอนแก่น, โลตัสเอ็กซ์ตร้า, บ.สำราญ, บ.หนองน้ำเกลี้ยง",infoArray[2] ,imageArray[2]));
//        miniBus.add(new MiniBus("สาย 5 : ตลาดหนองไผ่ล้อม – บ้านทุ่ม\nตลาดหนองไผ่ล้อม, ตลาดเทศบาล, ตลาดบางลำภู, โรงเรียนขอนแก่นวิทยายน, เซ็นโทซ่า, ศูนย์ประชุมกาญจนาภิเษก, มหาวิทยาลัยขอนแก่น, สถาบันพัฒนาฝีมือแรงงานขอนแก่น, บ.ทุ่ม",infoArray[3] ,imageArray[3]));
//        miniBus.add(new MiniBus("สาย 6 : ตลาดเทศบาล 1 – บ้านเหล่านกชุม\nตลาดเทศบาล, เทศบาลนครขอนแก่น, ศาลหลักเมืองขอนแก่น, เซ็นทรัลพลาซ่าขอนแก่น, บิ๊กซีขอนแก่น, ตลาดต้นตาล, โฮมโปรขอนแก่น, แม็คโครขอนแก่น, ประตูน้ำขอนแก่น, เทสโก้โลตัสขอนแก่น, บขส.3, บ.กุดกว้าง, บ.ท่าพระ, บ.หนองหญ้าแพรก, บ.ท่าแร่, บ.โนนเขวา, บ.เหล่านกชุม",infoArray[4] ,imageArray[4]));
//        miniBus.add(new MiniBus("สาย 8 : สามเหลี่ยม – บ้านดอนบม\nมหาวิทยาลัยขอนแก่น, เซ็นโทซ่า, บขส.1, บขส.2, สถานีตํารวจภูธรเมืองขอนแก่น, โรงเรียนขอนแก่นวิทยายน, โรงเรียนกัลยาณวัตร, ตลาดเทศบาล, แฟรี่พลาซ่า, เมืองเก่า, บึงแก่นนคร, บ.ดอนบม",infoArray[5] ,imageArray[5]));
//        miniBus.add(new MiniBus("สาย 9 : สามเหลี่ยม – บ้านสะอาด\nบ.สามเหลี่ยม, บขส.1, บขส.2, โรงเรียนขอนแก่นวิทยายน, ไปรษณีย์ขอนแก่น, ตลาดเทศบาล, แฟรี่พลาซ่า, สนามกีฬากลางขอนแก่น, โรงเรียนแก่นนครวิทยาลัย, ตลาดต้นตาล, มหาวิทยาลัยภาคตะวันออกเฉียงเหนือ, บ.กอก, บ.โจด, บ.สะอาด",infoArray[6] ,imageArray[6]));
//        miniBus.add(new MiniBus("สาย 10 : มหาวิทยาลัยขอนแก่น – สนามม้า\nมหาวิทยาลัยขอนแก่น, บขส.1, ที่ว่าการอําเภอเมืองขอนแก่น, บ.บะขาม, เรือนจำขอนแก่น, บขส.2, โรงเรียนขอนแก่นวิทยายน, ไปรษณีย์ขอนแก่น, สถานีตํารวจภูธรเมืองขอนแก่น, ตลาดเทศบาล, แฟรี่พลาซ่า, สนามกีฬากลางขอนแก่น, โรงเรียนแก่นนครวิทยาลัย, ประตูน้ำขอนแก่น, แม็คโครขอนแก่น, เทสโก้โลตัสขอนแก่น",infoArray[7] ,imageArray[7]));
//        miniBus.add(new MiniBus("สาย 11 : บ้านโนนสวรรค์ – บ้านขามเจริญ\nบ.โนนสวรรค์, ตลาดหนองใหญ่, วิทยาลัยอาชีวศึกษาขอนแก่น, บขส.2, โรงเรียนขอนแก่นวิทยายน, ตึกคอมขอนแก่น, เทศบาลนครขอนแก่น, ตลาดต้นตาล, บ.โคกฟันโปง",infoArray[8] ,imageArray[8]));
//        miniBus.add(new MiniBus("สาย 12 : พิพิธภัณฑ์ – รร.ท่าพระวิทยายน\nศาลากลางจังหวัดขอนแก่น, บขส.1, โรงเรียนขอนแก่นวิทยายน, ตลาดบางลำภู, ตลาดเทศบาล, โรงเรียนแก่นนครวิทยาลัย, ประตูน้ำขอนแก่น, เทสโก้โลตัสขอนแก่น, บขส.3, บ.โนนตุ่น, บ.กุดกว้าง, บ.ท่าพระ, บ.หนองบัวดีหมี",infoArray[9] ,imageArray[9]));
//        miniBus.add(new MiniBus("สาย 13 : บ้านน้อยนิเวศน์ – บ้านสว่างมรรคา\nบ้านน้อยนิเวศน์, บขส.1, ตลาด อ.จิระ ขอนแก่น, ตึกคอมขอนแก่น, โรงเรียนกัลยาณวัตรม, ตลาดเทศบาล, โรงเรียนเทศบาลสวนสนุก, บึงแก่นนคร, บ.ตูม, บ.ดอนบม, บ.ดอนแดง, บ้านดอนหัน",infoArray[10] ,imageArray[10]));
//        miniBus.add(new MiniBus("สาย 16 : บ้านโนนทัน – วัดป่าอดุลยาราม\nบ.โนนทัน, ตลาดโนนทัน, โรงพยาบาลจิตเวชขอนแก่น, เรือนจำขอนแก่น, โรงเรียนกัลยาณวัตร, บขส.1, บ.สามเหลี่ยม",infoArray[11] ,imageArray[11]));
//        miniBus.add(new MiniBus("สาย 17 : บ้านโนนทัน – บ้านโคกท่า\nบ.โนนทัน, บึงแก่นนคร, โรงเรียนเทศบาลสวนสนุก, แฟรี่พลาซ่า, ตลาดเทศบาล, โรงเรียนกัลยาณวัตร, วิทยาลัยอาชีวศึกษาขอนแก่น, ตลาดบ้านดอน, ค่ายศรีพัชรินทร์, โรงเรียนขามแก่นนคร, บ.โกทา, บ.หนองหิน, บ.ห้วยชัน, บ.โคกท่า",infoArray[12] ,imageArray[12]));
//        miniBus.add(new MiniBus("สาย 18 : โรงเรียนกัลยาณวัตร – บ้านโนนพอง\nโรงเรียนกัลยาณวัตร, เรือนจำขอนแก่น, วิทยาลัยเทคนิคขอนแก่น, โรงพยาบาลศูนย์ขอนแก่น, มหาวิทยาลัยเทคโนโลยีราชมงคลอีสาน, ตลาดหนองใหญ่, บ.แอ่วมอง, บ.สงเปือย, บ.โนนพอง",infoArray[13] ,imageArray[13]));
//        miniBus.add(new MiniBus("สาย 19 : ตลาดหนองไผ่ล้อม – บ้านโนนเรือง\nตลาดหนองไผ่ล้อม, ตลาดเทศบาล, ตลาดบางลำภู, โรงเรียนขอนแก่นวิทยายน, >บขส.1, ศูนย์หัวใจสิริกิตขอนแก่น, โรงพยาบาลศรีนครินทร์ขอนแก่น, มหาวิทยาลัยขอนแก่น, โลตัสเอ็กซ์ตร้า, บ.โนนเมือง, บ.โนนเรือง",infoArray[14] ,imageArray[14]));
//        miniBus.add(new MiniBus("สาย 20 : ตลาดหนองไผ่ล้อม – บ้านกลางฮุง\nตลาดหนองไผ่ล้อม, ตลาดเทศบาล, ตลาดบางลำภู, โรงเรียนขอนแก่นวิทยายน, บขส.1, ศูนย์หัวใจสิริกิตขอนแก่น, โรงพยาบาลศรีนครินทร์ขอนแก่น, มหาวิทยาลัยขอนแก่น, โลตัสเอ็กซ์ตร้า, บ.โคกนางาม, บ.หนองค้า, บ.กลางฮุง",infoArray[15] ,imageArray[15]));
//        miniBus.add(new MiniBus("สาย 21 : บ้านโนนเขวา – บ้านดอนยาง\nบ.โนนเขวา, บ.เหล่านกชุม, บ.บือ, บ.โนนทัน, บึงแก่นนคร, แฟรี่พลาซ่า, ตลาดเทศบาล, โรงเรียนกัลยาณวัตร, สถานีตํารวจภูธรเมืองขอนแก่น, โรงเรียนขอนแก่นวิทยายน, บขส.1, ศาลากลางจังหวัดขอนแก่น, ตลาดบ้านดอน, บ.ดองยาง",infoArray[16] ,imageArray[16]));
//        miniBus.add(new MiniBus("สาย 22 : บ้านหนองไฮ- บ้านดอนหญ้านาง\nบ.หนองไฮ, ตลาดหนองใหญ่, โรงพยาบาลศูนย์ขอนแก่น, เรือนจำขอนแก่น, สถานีตํารวจภูธรเมืองขอนแก่น, ตลาดเทศบาล, ตลาดบางลำภู, โรงเรียนขอนแก่นวิทยายน, บขส.1, ไปรษณีย์ขอนแก่น, บ.ดอนหญ้านาง",infoArray[17] ,imageArray[17]));
//        miniBus.add(new MiniBus("สาย 23 : ตลาดเทศบาล 1 – บ้านห้วยเตย\nตลาดเทศบาล, ตลาดเทศบาล, บ.โนนตุ่น, บ.ท่าพระ, บ.หนองบัวดีหมี, บ.หนองแวง, บ.ห้วยเตย",infoArray[18] ,imageArray[18]));
        miniBus.add(new MiniBus(nameArray[0],infoArray[0],imageArray[0]));
        miniBus.add(new MiniBus(nameArray[1],infoArray[1] ,imageArray[1]));
        miniBus.add(new MiniBus(nameArray[2],infoArray[2] ,imageArray[2]));
        miniBus.add(new MiniBus(nameArray[3],infoArray[3] ,imageArray[3]));
        miniBus.add(new MiniBus(nameArray[4],infoArray[4] ,imageArray[4]));
        miniBus.add(new MiniBus(nameArray[5],infoArray[5] ,imageArray[5]));
        miniBus.add(new MiniBus(nameArray[6],infoArray[6] ,imageArray[6]));
        miniBus.add(new MiniBus(nameArray[7],infoArray[7] ,imageArray[7]));
        miniBus.add(new MiniBus(nameArray[8],infoArray[8] ,imageArray[8]));
        miniBus.add(new MiniBus(nameArray[9],infoArray[9] ,imageArray[9]));
        miniBus.add(new MiniBus(nameArray[10],infoArray[10] ,imageArray[10]));
        miniBus.add(new MiniBus(nameArray[11],infoArray[11] ,imageArray[11]));
        miniBus.add(new MiniBus(nameArray[12],infoArray[12] ,imageArray[12]));
        miniBus.add(new MiniBus(nameArray[13],infoArray[13] ,imageArray[13]));
        miniBus.add(new MiniBus(nameArray[14],infoArray[14] ,imageArray[14]));
        miniBus.add(new MiniBus(nameArray[15],infoArray[15] ,imageArray[15]));
        miniBus.add(new MiniBus(nameArray[16],infoArray[16] ,imageArray[16]));
        miniBus.add(new MiniBus(nameArray[17],infoArray[17] ,imageArray[17]));
        miniBus.add(new MiniBus(nameArray[18],infoArray[18] ,imageArray[18]));

        mAllData.addAll(miniBus);
        listView = rootView.findViewById(R.id.listViewSearchDetail);
        adapter = new CustomListAdapter(getActivity(),
                R.layout.listview_layout, miniBus);
        listView.setAdapter(adapter);
    }

    public void filter(String charText) {
        charText = charText.toLowerCase(Locale.getDefault());
        miniBus .clear();
        if (charText.length() == 0) {
            miniBus.addAll(mAllData);
        } else {
            for (MiniBus wp : mAllData) {
                if (wp.getName().toLowerCase(Locale.getDefault())
                        .contains(charText)) {
                    miniBus.add(wp);
                }
            }
        }
    }


    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

//    @Override
//    public void onAttach(Context context) {
//        super.onAttach(context);
//        if (context instanceof OnFragmentInteractionListener) {
//            mListener = (OnFragmentInteractionListener) context;
//        } else {
//            throw new RuntimeException(context.toString()
//                    + " must implement OnFragmentInteractionListener");
//        }
//    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }

}
