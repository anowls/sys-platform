package org.anowls.sys.common

import com.github.pagehelper.PageInfo
import org.apache.commons.collections4.CollectionUtils

class SimplePage<T> implements Serializable {
    private int totalPages
    private long totalElements
    private int number
    private int size = 20
    private List<T> content = new ArrayList()
    private boolean hasContent = false
    private boolean isFirst = true
    private boolean isLast = true

    SimplePage() {
    }

    int getTotalPages() {
        return this.totalPages
    }

    void setTotalPages(int totalPages) {
        this.totalPages = totalPages
    }

    long getTotalElements() {
        return this.totalElements
    }

    void setTotalElements(long totalElements) {
        this.totalElements = totalElements
    }

    int getNumber() {
        return this.number
    }

    void setNumber(int number) {
        this.number = number
    }

    int getSize() {
        return this.size
    }

    void setSize(int size) {
        this.size = size
    }

    List<T> getContent() {
        return this.content
    }

    void setContent(List<T> content) {
        this.content = content
    }

    boolean isHasContent() {
        return this.hasContent
    }

    void setHasContent(boolean hasContent) {
        this.hasContent = hasContent
    }

    boolean isFirst() {
        return this.isFirst
    }

    void setFirst(boolean first) {
        this.isFirst = first
    }

    boolean isLast() {
        return this.isLast
    }

    void setLast(boolean last) {
        this.isLast = last
    }

    static SimplePage<T> convert(PageInfo<T> page) {
        SimplePage<T> simplePage = new SimplePage()
        if (page != null) {
            simplePage.setTotalPages(page.getPages())
            simplePage.setTotalElements(page.getTotal())
            simplePage.setNumber(page.getPageNum())
            simplePage.setSize(page.getSize())
            simplePage.setContent(page.getList())
            simplePage.setHasContent(CollectionUtils.isNotEmpty(page.getList()))
            simplePage.setFirst(page.isIsFirstPage())
            simplePage.setLast(page.isIsLastPage())
        }

        return simplePage
    }
}
