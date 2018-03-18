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

    String[] nameArray = {"สาย 2 : บ้านโคกฟันโปง – บ้านโคกน้อย","ชาตะผดุง","ทางรถไฟ","บ้านบะขาม","บ้านหนองไฮ","ประชาสโมสร","ม - ภาค","มลิวรรณ",
            "มิตรภาพ","ร - 8","รอบบึงแก่นนคร","ศรีจันทร์","ศูนย์ราชการ - ทุ่งสร้าง","หน้าเมือง","หลังหอกาฬ","เหล่านาดี"};

    String[] infoArray = {
            "สาย 2 : บ้านโคกฟันโปง – บ้านโคกน้อย",
            "ชาตะผดุง",
            "ทางรถไฟ",
            "บ้านบะขาม",
            "บ้านหนองไฮ",
            "ประชาสโมสร.",
            "ม - ภาค",
            "มลิวรรณ",
            "มิตรภาพ",
            "Nice in a stew",
            "ร - 8",
            "รอบบึงแก่นนคร",
            "ศรีจันทร์",
            "ศูนย์ราชการ - ทุ่งสร้าง",
            "หน้าเมือง",
            "หลังหอกาฬ",
            "เหล่านาดี"
    };

    Integer[] imageArray = {
            R.drawable.logo,
            R.drawable.logo,
            R.drawable.logo,
            R.drawable.logo,
            R.drawable.logo,
            R.drawable.logo,
            R.drawable.logo,
            R.drawable.logo,
            R.drawable.logo,
            R.drawable.logo,
            R.drawable.logo,
            R.drawable.logo,
            R.drawable.logo,
            R.drawable.logo,
            R.drawable.logo,
            R.drawable.logo,
            R.drawable.logo};


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
        miniBus.add(new MiniBus("สาย 2 : บ้านโคกฟันโปง – บ้านโคกน้อย","สาย 2 : บ้านโคกฟันโปง – บ้านโคกน้อย" ,R.drawable.logo));
        miniBus.add(new MiniBus("ชาตะผดุง", "ชาตะผดุง", R.drawable.logo));
        miniBus.add(new MiniBus("ทางรถไฟ", "ทางรถไฟ", R.drawable.logo));
        miniBus.add(new MiniBus("บ้านบะขาม", "บ้านบะขาม", R.drawable.logo));
        miniBus.add(new MiniBus("บ้านหนองไฮ", "บ้านหนองไฮ", R.drawable.logo));
        miniBus.add(new MiniBus("ประชาสโมสร", "ประชาสโมสร", R.drawable.logo));
        miniBus.add(new MiniBus("ม - ภาค", "ม - ภาค", R.drawable.logo));
        miniBus.add(new MiniBus("มลิวรรณ", "มลิวรรณ", R.drawable.logo));
        miniBus.add(new MiniBus("มิตรภาพ", "Tมิตรภาพ", R.drawable.logo));
        miniBus.add(new MiniBus("ร - 8", "ร - 8", R.drawable.logo));
        miniBus.add(new MiniBus("รอบบึงแก่นนคร", "รอบบึงแก่นนคร", R.drawable.logo));
        miniBus.add(new MiniBus("ศรีจันทร์", "ศรีจันทร์", R.drawable.logo));
        miniBus.add(new MiniBus("ศูนย์ราชการ - ทุ่งสร้าง", "ศูนย์ราชการ - ทุ่งสร้าง", R.drawable.logo));
        miniBus.add(new MiniBus("หน้าเมือง", "หน้าเมือง", R.drawable.logo));
        miniBus.add(new MiniBus("หลังหอกาฬ", "หลังหอกาฬ", R.drawable.logo));
        miniBus.add(new MiniBus("เหล่านาดี", "เหล่านาดี", R.drawable.logo));

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
