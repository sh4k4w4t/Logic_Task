package sh4k4w4t.github.io.logictask.Services.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Resultset {

    @SerializedName("po_ids")
    @Expose
    private List<PoIdModel> poIds;
    @SerializedName("size")
    @Expose
    private List<SizeModel> size;

    public Resultset(List<PoIdModel> poIds, List<SizeModel> size) {
        this.poIds = poIds;
        this.size = size;
    }

    public List<PoIdModel> getPoIds() {
        return poIds;
    }

    public void setPoIds(List<PoIdModel> poIds) {
        this.poIds = poIds;
    }

    public List<SizeModel> getSize() {
        return size;
    }

    public void setSize(List<SizeModel> size) {
        this.size = size;
    }
}