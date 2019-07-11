package com.kgc.entity;

public class HouseCondition {

    //定义查询条件
    private String title;  //标题

    private Integer startPrice;  //开始价格

    private Integer endPrice;  //结束价格

    private Integer did;  //区域id

    private Integer sid;  //街道id  null

    private Integer tid; //类型id

    private String flooa;  //0-40 转移 startFlooa和endFlooa赋值  ""
    private Integer startFlooa;  //起始面积
    private Integer endFlooa;  //结束面积


    //设置分页的属性
    private Integer page;
    private Integer pageSize=3;


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getStartPrice() {
        return startPrice;
    }

    public void setStartPrice(Integer startPrice) {
        this.startPrice = startPrice;
    }

    public Integer getEndPrice() {
        return endPrice;
    }

    public void setEndPrice(Integer endPrice) {
        this.endPrice = endPrice;
    }

    public Integer getDid() {
        return did;
    }

    public void setDid(Integer did) {
        this.did = did;
    }

    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
    }

    public Integer getTid() {
        return tid;
    }

    public void setTid(Integer tid) {
        this.tid = tid;
    }

    public String getFlooa() {
        return flooa;
    }

    public void setFlooa(String flooa) {
        this.flooa = flooa;
        if(flooa!=null&&flooa!=""){
            String[] split = flooa.split("-");
            this.startFlooa= Integer.parseInt(split[0]);
            this.endFlooa=Integer.parseInt(split[1]);

        }
    }

    public Integer getStartFlooa() {
        return startFlooa;
    }

    public void setStartFlooa(Integer startFlooa) {
        this.startFlooa = startFlooa;

    }

    public Integer getEndFlooa() {
        return endFlooa;
    }

    public void setEndFlooa(Integer endFlooa) {
        this.endFlooa = endFlooa;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    @Override
    public String toString() {
        return "HouseCondition{" +
                "title='" + title + '\'' +
                ", startPrice=" + startPrice +
                ", endPrice=" + endPrice +
                ", did=" + did +
                ", sid=" + sid +
                ", tid=" + tid +
                ", flooa='" + flooa + '\'' +
                ", startFlooa=" + startFlooa +
                ", endFlooa=" + endFlooa +
                ", page=" + page +
                ", pageSize=" + pageSize +
                '}';
    }
}
