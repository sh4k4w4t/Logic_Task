package sh4k4w4t.github.io.logictask.Services.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SizeModel {

    @SerializedName("po_break_down_id")
    @Expose
    private Integer poBreakDownId;
    @SerializedName("size_name")
    @Expose
    private String sizeName;

    public SizeModel(Integer poBreakDownId, String sizeName) {
        this.poBreakDownId = poBreakDownId;
        this.sizeName = sizeName;
    }

    public Integer getPoBreakDownId() {
        return poBreakDownId;
    }

    public void setPoBreakDownId(Integer poBreakDownId) {
        this.poBreakDownId = poBreakDownId;
    }

    public String getSizeName() {
        return sizeName;
    }

    public void setSizeName(String sizeName) {
        this.sizeName = sizeName;
    }

}
