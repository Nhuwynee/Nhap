package com.example.btcanhan;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Spinner;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SortFragment extends Fragment {
    private FeatureAdapter adapter;
    private List<FeaturedItem> items;
    private List<FeaturedItem> filteredItems;
    private Spinner spinner;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.sortactivity, container, false);
        RecyclerView recyclerView = view.findViewById(R.id.rvFeatured);
        LinearLayoutManager layoutManager1 = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager1);

        // Dữ liệu giả lập
        items = new ArrayList<>();
        items.add(new FeaturedItem("Tiểu thuyết", "Seller Information 1", R.drawable.ic_launcher_foreground));
        items.add(new FeaturedItem("Văn học", "Seller Information 2", R.drawable.ic_launcher_foreground));
        items.add(new FeaturedItem("Trinh thám", "Seller Information 3", R.drawable.ic_launcher_foreground));
        items.add(new FeaturedItem("Tiểu thuyết", "Seller Information 4", R.drawable.ic_launcher_foreground));
        items.add(new FeaturedItem("Trinh thám", "Seller Information 5", R.drawable.ic_launcher_foreground));
        items.add(new FeaturedItem("Văn học", "Seller Information 6", R.drawable.ic_launcher_foreground));

        filteredItems = new ArrayList<>(items); // Sao chép dữ liệu gốc vào filteredItems
        adapter = new FeatureAdapter(filteredItems); // Sử dụng filteredItems trong adapter
        recyclerView.setAdapter(adapter);
// bắt đầu sắp xếp
        //sắp xếp A-Z
        Button sort = view.findViewById(R.id.sort);
        sort.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        Collections.sort(filteredItems);
        adapter.notifyDataSetChanged();

    }
        });
        //kết thúc

        //sắp xếp tù Z-A
            Button sort2 = view.findViewById(R.id.sort2);
sort2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    // Sắp xếp danh sách từ Z đến A
                    Collections.sort(filteredItems, new Comparator<FeaturedItem>() {
                        @Override
                        public int compare(FeaturedItem item1, FeaturedItem item2) {
                            return item2.getTitle().compareToIgnoreCase(item1.getTitle());
                        }
                    });
                    adapter.notifyDataSetChanged(); // Cập nhật lại giao diện
                }
            });

// kết thúc sắp xếp
        return view;
    }


}


