package it.pkg.foweb.module.common.util;

import java.io.Serializable;
import java.util.List;

/**
 * 系统用户
 */
public class PageInfoResult implements Serializable {
    private static final long serialVersionUID = 1L;
    private List<?> records;
    private int pageCount;
    private int pageSize;
    private int pageNow;
    private long rowCount;

    public List<?> getRecords() {
        return records;
    }

    public void setRecords(List<?> records) {
        this.records = records;
    }

    public long getPageCount() {
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getPageNow() {
        return pageNow;
    }

    public void setPageNow(int pageNow) {
        this.pageNow = pageNow;
    }

    public long getRowCount() {
        return rowCount;
    }

    public void setRowCount(long rowCount) {
        this.rowCount = rowCount;
    }

}
