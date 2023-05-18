package sh4k4w4t.github.io.logictask.View;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import sh4k4w4t.github.io.logictask.R;
import sh4k4w4t.github.io.logictask.Services.Model.PoIdModel;
import sh4k4w4t.github.io.logictask.Services.Model.SizeModel;
import sh4k4w4t.github.io.logictask.databinding.ActivityMainBinding;
import sh4k4w4t.github.io.logictask.databinding.CustomLayoutFotSizeBinding;

public class SizeAdapter extends RecyclerView.Adapter<SizeAdapter.MyViewHolder> {

    private static final String TAG = "SizeAdapter";
    Context context;
    List<String> allSizes;
    List<SizeModel> sizeModelList;
    List<PoIdModel> poIdModelList;
    ActivityMainBinding mainBinding;

    public SizeAdapter(Context context, List<String> allSizes, List<SizeModel> sizeModelList, List<PoIdModel> poIdModelList, ActivityMainBinding mBinding) {
        this.context = context;
        this.allSizes = allSizes;
        this.sizeModelList = sizeModelList;
        this.poIdModelList = poIdModelList;
        this.mainBinding = mBinding;
    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyViewHolder(LayoutInflater.from(context).inflate(R.layout.custom_layout_fot_size,parent,false));
    }
    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Log.d(TAG, "onBindViewHolder: Size -"+allSizes.size());
        holder.binding.textViewSizeId.setText(allSizes.get(position));

        holder.binding.textViewSizeId.setOnClickListener(v -> {
            String sizeName = allSizes.get(position);
            String poNumber = null;
            int poBreakDownId1 = 0;
            for (SizeModel s: sizeModelList){
                if (sizeName.equals(s.getSizeName())){
                    poBreakDownId1= s.getPoBreakDownId();
                    for (PoIdModel model:poIdModelList){
                        if (model.getPoId()==poBreakDownId1){
                            poNumber = model.getPoNumber();
                            Log.d(TAG, "onBindViewHolder: poNumber -"+poNumber);
                        }
                    }
                }
            }
            mainBinding.textIdForPO.setText(poNumber);
        });



    }

    @Override
    public int getItemCount() {
        return allSizes.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        CustomLayoutFotSizeBinding binding;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            binding = CustomLayoutFotSizeBinding.bind(itemView);
        }
    }
}