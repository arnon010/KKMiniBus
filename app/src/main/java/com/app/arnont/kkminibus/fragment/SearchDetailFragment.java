package com.app.arnont.kkminibus.fragment;

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

import com.app.arnont.kkminibus.R;
import com.app.arnont.kkminibus.activity.MapsDetailActivity;
import com.app.arnont.kkminibus.adapter.CustomListAdapter;
import com.app.arnont.kkminibus.adapter.MiniBus;

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

    EditText txtSearchDeatail;
    String searchPlace;
    private ArrayAdapter<MiniBus> adapter;

    private List<MiniBus> miniBus;
    ArrayList<MiniBus> mAllData=new ArrayList<MiniBus>();

    String[] nameArray = {
            "สาย 2 : บ้านโคกฟันโปง – บ้านโคกน้อย",
            "สาย 3 : บขส.3 – บ้านพรหมนิมิตร",
            "สาย 4 : บขส.3 – บ้านหนองน้ำเกลี้ยง",
            "สาย 5 : ตลาดหนองไผ่ล้อม – บ้านทุ่ม",
            "สาย 6 : ตลาดเทศบาล 1 – บ้านเหล่านกชุม",
            "สาย 8 : สามเหลี่ยม – บ้านดอนบม",
            "สาย 9 : สามเหลี่ยม – บ้านสะอาด",
            "สาย 10 : มหาวิทยาลัยขอนแก่น – สนามม้า",
            "สาย 11 : บ้านโนนสวรรค์ – บ้านขามเจริญ",
            "สาย 12 : พิพิธภัณฑ์ – รร.ท่าพระวิทยายน",
            "สาย 13 : บ้านน้อยนิเวศน์ – บ้านสว่างมรรคา",
            "สาย 16 : บ้านโนนทัน – วัดป่าอดุลยาราม",
            "สาย 17 : บ้านโนนทัน – บ้านโคกท่า",
            "สาย 18 : โรงเรียนกัลยาณวัตร – บ้านโนนพอง",
            "สาย 19 : ตลาดหนองไผ่ล้อม – บ้านโนนเรือง",
            "สาย 20 : ตลาดหนองไผ่ล้อม – บ้านกลางฮุง",
            "สาย 21 : บ้านโนนเขวา – บ้านดอนยาง",
            "สาย 22 : บ้านหนองไฮ- บ้านดอนหญ้านาง",
            "สาย 23 : ตลาดเทศบาล 1 – บ้านห้วยเตย"};

    String[] infoArray = {
            "สาย 2 : บ้านโคกฟันโปง – บ้านโคกน้อย",
            "สาย 3 : บขส.3 – บ้านพรหมนิมิตร",
            "สาย 4 : บขส.3 – บ้านหนองน้ำเกลี้ยง",
            "สาย 5 : ตลาดหนองไผ่ล้อม – บ้านทุ่ม",
            "สาย 6 : ตลาดเทศบาล 1 – บ้านเหล่านกชุม",
            "สาย 8 : สามเหลี่ยม – บ้านดอนบม",
            "สาย 9 : สามเหลี่ยม – บ้านสะอาด",
            "สาย 10 : มหาวิทยาลัยขอนแก่น – สนามม้า",
            "สาย 11 : บ้านโนนสวรรค์ – บ้านขามเจริญ",
            "สาย 12 : พิพิธภัณฑ์ – รร.ท่าพระวิทยายน",
            "สาย 13 : บ้านน้อยนิเวศน์ – บ้านสว่างมรรคา",
            "สาย 16 : บ้านโนนทัน – วัดป่าอดุลยาราม",
            "สาย 17 : บ้านโนนทัน – บ้านโคกท่า",
            "สาย 18 : โรงเรียนกัลยาณวัตร – บ้านโนนพอง",
            "สาย 19 : ตลาดหนองไผ่ล้อม – บ้านโนนเรือง",
            "สาย 20 : ตลาดหนองไผ่ล้อม – บ้านกลางฮุง",
            "สาย 21 : บ้านโนนเขวา – บ้านดอนยาง",
            "สาย 22 : บ้านหนองไฮ- บ้านดอนหญ้านาง",
            "สาย 23 : ตลาดเทศบาล 1 – บ้านห้วยเตย"
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

        populateDrinksList();
        listAdapter = new CustomListAdapter(getActivity().getApplicationContext(),R.layout.listview_layout,miniBus);

        listView = rootView.findViewById(R.id.listViewSearchDetail);
        listView.setAdapter(listAdapter);
        listView.setTextFilterEnabled(true);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent intent = new Intent(getActivity(), MapsDetailActivity.class);
                String message = nameArray[position];
                intent.putExtra("minibus", message);
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

        txtSearchDeatail = rootView.findViewById(R.id.txtSearchDeatail);
//        searchPlace = getArguments().getString("searchPlace");
//        txtSearchDeatail.setText(searchPlace);

        txtSearchDeatail.addTextChangedListener(new TextWatcher() {


            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {


                String text = txtSearchDeatail.getText().toString().toLowerCase(Locale.getDefault());
                filter(text);
                listAdapter.notifyDataSetChanged();

//                InputMethodManager inputManager = (InputMethodManager) getContext().getSystemService(Context.INPUT_METHOD_SERVICE);
//                inputManager.hideSoftInputFromWindow(getActivity().getCurrentFocus().getWindowToken(),InputMethodManager.HIDE_NOT_ALWAYS);
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
        miniBus.add(new MiniBus("สาย 2 : บ้านโคกฟันโปง – บ้านโคกน้อย","สาย 2 : บ้านโคกฟันโปง – บ้านโคกน้อย" ,R.drawable.ic_car2));
        miniBus.add(new MiniBus("สาย 3 : บขส.3 – บ้านพรหมนิมิตร", "สาย 3 : บขส.3 – บ้านพรหมนิมิตร", R.drawable.ic_car3));
        miniBus.add(new MiniBus("สาย 4 : บขส.3 – บ้านหนองน้ำเกลี้ยง", "สาย 4 : บขส.3 – บ้านหนองน้ำเกลี้ยง", R.drawable.ic_car4));
        miniBus.add(new MiniBus("สาย 5 : ตลาดหนองไผ่ล้อม – บ้านทุ่ม", "สาย 5 : ตลาดหนองไผ่ล้อม – บ้านทุ่ม", R.drawable.ic_car5));
        miniBus.add(new MiniBus("สาย 6 : ตลาดเทศบาล 1 – บ้านเหล่านกชุม", "สาย 6 : ตลาดเทศบาล 1 – บ้านเหล่านกชุม", R.drawable.ic_car6));
        miniBus.add(new MiniBus("สาย 8 : สามเหลี่ยม – บ้านดอนบม", "สาย 8 : สามเหลี่ยม – บ้านดอนบม", R.drawable.ic_car8));
        miniBus.add(new MiniBus("สาย 9 : สามเหลี่ยม – บ้านสะอาด", "สาย 9 : สามเหลี่ยม – บ้านสะอาด", R.drawable.ic_car9));
        miniBus.add(new MiniBus("สาย 10 : มหาวิทยาลัยขอนแก่น – สนามม้า", "สาย 10 : มหาวิทยาลัยขอนแก่น – สนามม้า", R.drawable.ic_car10));
        miniBus.add(new MiniBus("สาย 11 : บ้านโนนสวรรค์ – บ้านขามเจริญ", "สาย 11 : บ้านโนนสวรรค์ – บ้านขามเจริญ", R.drawable.ic_car11));
        miniBus.add(new MiniBus("สาย 12 : พิพิธภัณฑ์ – รร.ท่าพระวิทยายน", "สาย 12 : พิพิธภัณฑ์ – รร.ท่าพระวิทยายน", R.drawable.ic_car12));
        miniBus.add(new MiniBus("สาย 13 : บ้านน้อยนิเวศน์ – บ้านสว่างมรรคา", "สาย 13 : บ้านน้อยนิเวศน์ – บ้านสว่างมรรคา", R.drawable.ic_car13));
        miniBus.add(new MiniBus("สาย 16 : บ้านโนนทัน – วัดป่าอดุลยาราม", "สาย 16 : บ้านโนนทัน – วัดป่าอดุลยาราม", R.drawable.ic_car16));
        miniBus.add(new MiniBus("สาย 17 : บ้านโนนทัน – บ้านโคกท่า", "สาย 17 : บ้านโนนทัน – บ้านโคกท่า", R.drawable.ic_car17));
        miniBus.add(new MiniBus("สาย 13 : บ้านน้อยนิเวศน์ – บ้านสว่างมรรคา", "สาย 13 : บ้านน้อยนิเวศน์ – บ้านสว่างมรรคา", R.drawable.ic_car13));
        miniBus.add(new MiniBus("สาย 18 : โรงเรียนกัลยาณวัตร – บ้านโนนพอง", "สาย 18 : โรงเรียนกัลยาณวัตร – บ้านโนนพอง", R.drawable.ic_car18));
        miniBus.add(new MiniBus("สาย 19 : ตลาดหนองไผ่ล้อม – บ้านโนนเรือง", "สาย 19 : ตลาดหนองไผ่ล้อม – บ้านโนนเรือง", R.drawable.ic_car19));
        miniBus.add(new MiniBus("สาย 20 : ตลาดหนองไผ่ล้อม – บ้านกลางฮุง", "สาย 20 : ตลาดหนองไผ่ล้อม – บ้านกลางฮุง", R.drawable.ic_car20));
        miniBus.add(new MiniBus("สาย 21 : บ้านโนนเขวา – บ้านดอนยาง", "สาย 21 : บ้านโนนเขวา – บ้านดอนยาง", R.drawable.ic_car21));
        miniBus.add(new MiniBus("สาย 22 : บ้านหนองไฮ- บ้านดอนหญ้านาง", "สาย 22 : บ้านหนองไฮ- บ้านดอนหญ้านาง", R.drawable.ic_car22));
        miniBus.add(new MiniBus("สาย 23 : ตลาดเทศบาล 1 – บ้านห้วยเตย", "สาย 23 : ตลาดเทศบาล 1 – บ้านห้วยเตย", R.drawable.ic_car23));

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
