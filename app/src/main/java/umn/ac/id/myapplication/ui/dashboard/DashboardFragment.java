package umn.ac.id.myapplication.ui.dashboard;

import android.app.Activity;
import android.media.Image;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.RecyclerView;

import umn.ac.id.myapplication.HomeActivity;
import umn.ac.id.myapplication.R;

public class DashboardFragment extends Fragment {

    private ListView list_item;
    String list_nama [] = {
            "Americano",
            "Ice-Latte",
            "Chocolatte",
            "Capucino"
    };
    String list_harga [] = {
            "Rp. 5.000",
            "Rp. 7.500",
            "Rp. 6.000",
            "Rp. 8.000"
    };
    int list_gambar [] = {
            R.drawable.kopi,
            R.drawable.ice_coffee,
            R.drawable.chocolatte,
            R.drawable.capucino
    };

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_dashboard, container, false);
        list_item = rootView.findViewById(R.id.list_item);
        AdapaterKopi adapaterKopi =  new AdapaterKopi(getActivity(), list_nama, list_harga, list_gambar);
        list_item.setAdapter(adapaterKopi);
        return rootView;
    }

    private class AdapaterKopi extends ArrayAdapter{
        String list_nama[];
        String list_harga[];
        int list_gambar[];
        Activity activity;

        //constructor
        public AdapaterKopi(Activity homeActivity, String[] list_nama, String[] list_harga, int[] list_gambar){
            super(homeActivity, R.layout.image_row, list_nama);
            this.list_gambar = list_gambar;
            activity = homeActivity;
            this.list_nama = list_nama;
            this.list_harga = list_harga;
        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            LayoutInflater inflater = (LayoutInflater) activity.getLayoutInflater();
            View v = inflater.inflate(R.layout.image_row, null);

            ImageView gambar;
            TextView nama,harga;

            gambar = v.findViewById(R.id.gambarKopi);
            nama = v.findViewById(R.id.namaKopi);
            harga = v.findViewById(R.id.hargaKopi);

            gambar.setImageResource(list_gambar[position]);
            nama.setText(list_nama[position]);
            harga.setText(list_harga[position]);

            return v;
        }
    }


}