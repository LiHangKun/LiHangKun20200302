package com.bawei.lihangkun20200302.bean;

import java.util.List;

public class BeanClass {

    /**
     * code : 200
     * data : {"horizontalListData":[{"imageurl":"http://blog.zhaoliang5156.cn/api/images/shop01.jpeg"},{"imageurl":"http://blog.zhaoliang5156.cn/api/images/shop02.png"},{"imageurl":"http://blog.zhaoliang5156.cn/api/images/shop03.png"}],"verticalListData":[{"title":"鏂拌タ鍏癈RIA 鍎跨鍏眰绾卞竷姣涘肪琚偒褰╀簲瑙掓槦","price":"锟�169","imageurl":"http://blog.zhaoliang5156.cn/api/images/shop05.jpeg"},{"title":"鏃ユ湰AITO KATACHI鑺卞Э褰㈣姳鐡ｇ毧M鑺辩摚鐐瑰績纰熼纰�","price":"锟�139","imageurl":"http://blog.zhaoliang5156.cn/api/images/shop06.jpeg"}],"gridData":[{"title":"鑲岃偆涔嬮挜","price":"锟�1680","imageurl":"http://blog.zhaoliang5156.cn/api/images/shop07.jpg"},{"title":"鏂拌タ鍏癈RIA","price":"锟�499","imageurl":"http://blog.zhaoliang5156.cn/api/images/shop08.jpeg"}]}
     */

    private String code;
    private DataBean data;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        private List<HorizontalListDataBean> horizontalListData;
        private List<VerticalListDataBean> verticalListData;
        private List<GridDataBean> gridData;

        public List<HorizontalListDataBean> getHorizontalListData() {
            return horizontalListData;
        }

        public void setHorizontalListData(List<HorizontalListDataBean> horizontalListData) {
            this.horizontalListData = horizontalListData;
        }

        public List<VerticalListDataBean> getVerticalListData() {
            return verticalListData;
        }

        public void setVerticalListData(List<VerticalListDataBean> verticalListData) {
            this.verticalListData = verticalListData;
        }

        public List<GridDataBean> getGridData() {
            return gridData;
        }

        public void setGridData(List<GridDataBean> gridData) {
            this.gridData = gridData;
        }

        public static class HorizontalListDataBean {
            /**
             * imageurl : http://blog.zhaoliang5156.cn/api/images/shop01.jpeg
             */

            private String imageurl;

            public String getImageurl() {
                return imageurl;
            }

            public void setImageurl(String imageurl) {
                this.imageurl = imageurl;
            }
        }

        public static class VerticalListDataBean {
            /**
             * title : 鏂拌タ鍏癈RIA 鍎跨鍏眰绾卞竷姣涘肪琚偒褰╀簲瑙掓槦
             * price : 锟�169
             * imageurl : http://blog.zhaoliang5156.cn/api/images/shop05.jpeg
             */

            private String title;
            private String price;
            private String imageurl;

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getPrice() {
                return price;
            }

            public void setPrice(String price) {
                this.price = price;
            }

            public String getImageurl() {
                return imageurl;
            }

            public void setImageurl(String imageurl) {
                this.imageurl = imageurl;
            }
        }

        public static class GridDataBean {
            /**
             * title : 鑲岃偆涔嬮挜
             * price : 锟�1680
             * imageurl : http://blog.zhaoliang5156.cn/api/images/shop07.jpg
             */

            private String title;
            private String price;
            private String imageurl;

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getPrice() {
                return price;
            }

            public void setPrice(String price) {
                this.price = price;
            }

            public String getImageurl() {
                return imageurl;
            }

            public void setImageurl(String imageurl) {
                this.imageurl = imageurl;
            }
        }
    }
}
