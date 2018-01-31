package org.anowls.sys.common

import com.google.common.base.Splitter
import org.springframework.util.CollectionUtils
import org.springframework.util.StringUtils

class PageQuery implements Serializable {
    private int page
    private int size
    private String filter
    private String order

    PageQuery() {
    }

    int getPage() {
        return this.page
    }

    void setPage(int page) {
        this.page = page
    }

    int getSize() {
        return this.size
    }

    void setSize(int size) {
        this.size = size
    }

    String getFilter() {
        return this.filter
    }

    void setFilter(String filter) {
        this.filter = filter
    }

    String getOrder() {
        return this.order
    }

    void setOrder(String order) {
        this.order = order
    }

    Map<String, String> convertFilterToMap() {
        if (StringUtils.isEmpty(this.filter)) {
            return null
        } else {
            List<String> list = Splitter.on("").omitEmptyStrings().trimResults().splitToList(this.filter)
            if (CollectionUtils.isEmpty(list)) {
                return null
            } else {
                Map<String, String> map = new HashMap<>()
                Iterator var3 = list.iterator()

                while (var3.hasNext()) {
                    String s = (String) var3.next()
                    List<String> item = Splitter.on("=").limit(2).omitEmptyStrings().trimResults().splitToList(s)
                    if (item.size() == 2) {
                        map.put(item.get(0), item.get(1))
                    }
                }

                return map
            }
        }
    }

    String convertSort() {
        if (StringUtils.isEmpty(this.order)) {
            return ""
        } else {
            List<String> list = Splitter.on(",").omitEmptyStrings().trimResults().splitToList(this.order)
            if (CollectionUtils.isEmpty(list)) {
                return ""
            } else {
                StringBuilder sb = new StringBuilder()
                Iterator var3 = list.iterator()

                while (var3.hasNext()) {
                    String s = (String) var3.next()
                    List<String> item = Splitter.on("=").limit(2).omitEmptyStrings().trimResults().splitToList(s)
                    if (item.size() == 2) {
                        String fieldName = item.get(0)
                        String sortDirection = item.get(1)
                        sb.append(fieldName)
                        sb.append(" ")
                        sb.append(sortDirection)
                        sb.append(",")
                    }
                }

                if (StringUtils.isEmpty(sb.toString())) {
                    return ""
                } else {
                    return sb.toString().substring(0, sb.toString().length() - 1)
                }
            }
        }
    }
}