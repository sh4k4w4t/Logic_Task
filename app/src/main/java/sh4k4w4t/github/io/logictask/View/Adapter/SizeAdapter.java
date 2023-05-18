package sh4k4w4t.github.io.logictask.View.Adapter;

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
    List<SizeModel> sizeModelList;
    List<PoIdModel> poIdModelList;
    ActivityMainBinding mainBinding;

    public SizeAdapter(Context context, List<SizeModel> sizeModelList, List<PoIdModel> poIdModelList, ActivityMainBinding mBinding) {
        this.context = context;
        this.sizeModelList = sizeModelList;
        this.poIdModelList = poIdModelList;
        this.mainBinding = mBinding;
    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyViewHolder(LayoutInflater.from(context).inflate(R.layout.custom_layout_fot_size, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.binding.textViewSizeId.setText(sizeModelList.get(position).getSizeName());

        holder.binding.textViewSizeId.setOnClickListener(v -> {
            String sizeName = sizeModelList.get(position).getSizeName();
            int po_break_down_id = sizeModelList.get(position).getPoBreakDownId();
            Log.d(TAG, "onBindViewHolder: " + sizeName + "--" + po_break_down_id);

            for (PoIdModel poIdModel : poIdModelList) {
                if (po_break_down_id == poIdModel.getPoId()) {
                    mainBinding.textIdForPO.setText(poIdModel.getPoNumber());
                    Log.d(TAG, "onBindViewHolder 66: " + poIdModel.getPoNumber());
                }
            }
        });


    }

    @Override
    public int getItemCount() {
        return sizeModelList.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        CustomLayoutFotSizeBinding binding;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            binding = CustomLayoutFotSizeBinding.bind(itemView);
        }
    }
}