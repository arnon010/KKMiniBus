package com.app.arnont.kkminibus.fragment;

import android.content.Context;
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
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.app.arnont.kkminibus.R;
import com.app.arnont.kkminibus.activity.DetailMiniBusActivity;
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

    TextView txtSearchDeatail;
    String searchPlace;
    private ArrayAdapter<MiniBus> adapter;

    private List<MiniBus> miniBus;
    ArrayList<MiniBus> mAllData=new ArrayList<MiniBus>();

    String[] nameArray = {"รถสองแถว สาย 2","รถสองแถว สาย 3","รถสองแถว สาย 4","รถสองแถว สาย 5","รถสองแถว สาย 6",
            "รถสองแถว สาย 12","รถสองแถว สาย 18","รถสองแถว สาย 19","รถสองแถว สาย 20","รถสองแถว สาย 22","รถสองแถว สาย 23"};

    String[] infoArray = {
            "8 tentacled monster",
            "Delicious in rolls",
            "Great for jumpers",
            "Nice in a stew",
            "Great for shoes",
            "Scary.",
            "8 tentacled monster",
            "Delicious in rolls",
            "Great for jumpers",
            "Nice in a stew",
            "Great for shoes",
            "Great for shoes"
    };

    Integer[] imageArray = {R.drawable.logo,
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
                startActivity(intent);
                getActivity().overridePendingTransition(R.anim.push_in, R.anim.push_in_exit);



            }
        });

        LayoutAnimationController lac = new LayoutAnimationController(AnimationUtils.loadAnimation(getActivity(), R.anim.pop_out), 0.5f); //0.5f == time between appearance of listview items.
        listView.setLayoutAnimation(lac);
        listView.startLayoutAnimation();

        txtSearchDeatail = rootView.findViewById(R.id.txtSearchDeatail);
        searchPlace = getArguments().getString("searchPlace");
        txtSearchDeatail.setText(searchPlace);

        txtSearchDeatail.addTextChangedListener(new TextWatcher() {


            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {


                String text = txtSearchDeatail.getText().toString().toLowerCase(Locale.getDefault());
                filter(text);
                listAdapter.notifyDataSetChanged();

                InputMethodManager inputManager =
                        (InputMethodManager) getContext().
                                getSystemService(Context.INPUT_METHOD_SERVICE);
                inputManager.hideSoftInputFromWindow(
                        getActivity().getCurrentFocus().getWindowToken(),
                        InputMethodManager.HIDE_NOT_ALWAYS);


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
        miniBus = new ArrayList<MiniBus>();
        miniBus.add(new MiniBus("รถสองแถว สาย 2","8 tentacled monster" ,R.drawable.logo));
        miniBus.add(new MiniBus("รถสองแถว สาย 3", "Delicious in rolls", R.drawable.logo));
        miniBus.add(new MiniBus("รถสองแถว สาย 4", "Great for jumpers", R.drawable.logo));
        miniBus.add(new MiniBus("รถสองแถว สาย 5", "Fanta Orange", R.drawable.logo));
        miniBus.add(new MiniBus("รถสองแถว สาย 6", "Fanta Lemon", R.drawable.logo));
        miniBus.add(new MiniBus("รถสองแถว สาย 12", "Fanta Blue", R.drawable.logo));
        miniBus.add(new MiniBus("รถสองแถว สาย 18", "Sprite", R.drawable.logo));
        miniBus.add(new MiniBus("รถสองแถว สาย 19", "Soda Water", R.drawable.logo));
        miniBus.add(new MiniBus("รถสองแถว สาย 20", "Tonic Water", R.drawable.logo));
        miniBus.add(new MiniBus("รถสองแถว สาย 22", "Sparkling Water Ioli", R.drawable.logo));
        miniBus.add(new MiniBus("รถสองแถว สาย 23", "Sparkling Water Perrier", R.drawable.logo));

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
                    miniBus .add(wp);
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
