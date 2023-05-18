package sh4k4w4t.github.io.logictask.Services.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PoIdModel {

    @SerializedName("po_id")
    @Expose
    private Integer poId;
    @SerializedName("po_number")
    @Expose
    private String poNumber;

    public PoIdModel(Integer poId, String poNumber) {
        this.poId = poId;
        this.poNumber = poNumber;
    }

    public Integer getPoId() {
        return poId;
    }

    public void setPoId(Integer poId) {
        this.poId = poId;
    }

    public String getPoNumber() {
        return poNumber;
    }

    public void setPoNumber(String poNumber) {
        this.poNumber = poNumber;
    }
}