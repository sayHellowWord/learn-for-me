package com.yd.modeldiff;

import java.lang.reflect.Field;
import java.util.Date;

/**
 * Created by nick on 2017/11/10.
 * 对象变化对比工具类
 */
public class ModelDiffUtil {

    private static String PROPERTIES_NO_CHANGE_DESC = "%s未发生变化;";

    private static String PROPERTIES_CHANGE_DESC = "%s：变化前值%s,变化后值%s;";

    /**
     * 对象对比类
     *
     * @param newTarget
     * @param oldTarget
     * @return
     */
    static DiffResult modelDiff(Object newTarget, Object oldTarget) throws Exception {

        if (null == newTarget || null == oldTarget) {
            throw new Exception("比较对象不能为空！");
        }

        if (newTarget.getClass() != oldTarget.getClass()) {
            throw new Exception("比较对象类型不一致！");
        }

        DiffResult diffResult = null;

        Class diffClass = newTarget.getClass();

        //忽略此注解对象
        boolean ignore = false;
        //是否扫描标记类的所有属性
        boolean scanAllProperties = true;

        ModelDiffBean modelDiffBean = (ModelDiffBean) diffClass.getAnnotation(ModelDiffBean.class);
        if (null != modelDiffBean) {
            ignore = modelDiffBean.ignore();
            scanAllProperties = modelDiffBean.scanAllProperties();
        }

        if (ignore) {
            return DiffResult.createIgnoreDiffResult();
        }

        boolean isChange = false;
        StringBuffer changeContentBuffer = new StringBuffer();
        StringBuffer noChangeContentBuffer = new StringBuffer();

        Field[] fields = diffClass.getDeclaredFields();

        for (Field field : fields) {
            ModelDiffProperties modelDiffProperties = field.getAnnotation(ModelDiffProperties.class);
            //扫描全部属性 || 是否忽略此属性
            if (scanAllProperties || (null != modelDiffProperties && !modelDiffProperties.ignore())) {
                field.setAccessible(true);
                Object newValue = (field.get(newTarget));//修改后值
                Object oldValue = (field.get(oldTarget));//修改前值
//                String desc = null == modelDiffProperties ? null : modelDiffProperties.desc();
                if (field.getType() == Date.class) {
                    //日期格式特殊处理

                } else {
                    if (newValue == oldValue || newValue.equals(oldValue)) {
                       /* noChangeContentBuffer.append(null != desc ? String.format(desc, newValue, oldValue) : String.format(PROPERTIES_NO_CHANGE_DESC, field.getName(), newValue, oldValue));*/
                        noChangeContentBuffer.append(String.format(PROPERTIES_NO_CHANGE_DESC, field.getName(), newValue, oldValue));
                    } else {
                        isChange = true;
                   /*     changeContentBuffer.append(null != desc ? String.format(desc, newValue, oldValue) : String.format(PROPERTIES_CHANGE_DESC, field.getName(), newValue, oldValue));*/
                        changeContentBuffer.append(String.format(PROPERTIES_CHANGE_DESC, field.getName(), newValue, oldValue));

                    }
                }
            }
        }

        diffResult = new DiffResult(isChange, changeContentBuffer.toString(), noChangeContentBuffer.toString());

        return diffResult;
    }


    /**
     * 比较结果
     */
    static class DiffResult {
        /**
         * 是否有变化
         */
        private boolean isChange;
        /**
         * 变化内容
         */
        private String changeContent;
        /**
         * 未变化内容
         */
        private String noChangeContent;


        public DiffResult() {

        }

        public DiffResult(boolean isChange, String changeContent, String noChangeContent) {
            this.isChange = isChange;
            this.changeContent = changeContent;
            this.noChangeContent = noChangeContent;
        }

        public static DiffResult createIgnoreDiffResult() {
            return new DiffResult(false, "", "");
        }

        public boolean isChange() {
            return isChange;
        }

        public void setChange(boolean change) {
            isChange = change;
        }

        public String getChangeContent() {
            return changeContent;
        }

        public void setChangeContent(String changeContent) {
            this.changeContent = changeContent;
        }

        public String getNoChangeContent() {
            return noChangeContent;
        }

        public void setNoChangeContent(String noChangeContent) {
            this.noChangeContent = noChangeContent;
        }

        @Override
        public String toString() {
            return "DiffResult{" +
                    "isChange=" + isChange +
                    ", changeContent='" + changeContent + '\'' +
                    ", noChangeContent='" + noChangeContent + '\'' +
                    '}';
        }
    }

}
