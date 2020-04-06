package br.com.ricardofelix.futtrademobile.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import br.com.ricardofelix.futtrademobile.R;
import br.com.ricardofelix.futtrademobile.adapter.PlayersAdapter;

/**
 * A simple {@link Fragment} subclass.
 */
public class PlayersFragment extends Fragment {

    public PlayersFragment() {
        // Required empty public constructor
    }

    RecyclerView recyclerPlayers;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_players, container, false);
        PlayersAdapter playersAdapter = new PlayersAdapter();


        recyclerPlayers = view.findViewById(R.id.recyclerPlayers);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity().getApplicationContext());
        recyclerPlayers.setLayoutManager(layoutManager);
        recyclerPlayers.setHasFixedSize(true);
        recyclerPlayers.setAdapter(playersAdapter);





        return view;
    }
}
