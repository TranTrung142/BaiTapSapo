package com.sapo.api.output;

import com.sapo.dto.NewDTO;

import java.util.ArrayList;
import java.util.List;

/*Output
    - totalPage: tong so trang tinh duoc
    - page: trang hien tai
    - List<NewDTO> : list cac item tra ve cho client
*/
public class NewOutput {
    private int page;
    private int totalPase;
    private List<NewDTO> listResults = new ArrayList<NewDTO>();

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getTotalPase() {
        return totalPase;
    }

    public void setTotalPase(int totalPase) {
        this.totalPase = totalPase;
    }

    public List<NewDTO> getListResults() {
        return listResults;
    }

    public void setListResults(List<NewDTO> listResults) {
        this.listResults = listResults;
    }
}
