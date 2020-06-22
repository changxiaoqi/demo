package demo.utils.excel;

/**
 * @author: pmj
 * @date: 2018/7/16 14:48
 * @description: bean中每一列的属性
 */
public class BeanFieldProperty {

    /**
     * 属性名称
     */
    private String fieldName;

    /**
     * 属性的类型
     */
    private Class type;

    /**
     * 是不是string
     */
    private boolean isString;

    /**
     * 是不是日期
     */
    private boolean isDate;

    /**
     * 是不是基础类型
     */
    private boolean isPrimitive;

    /**
     * 是不是数字类型
     */
    private boolean isNumberic;


    public BeanFieldProperty(String fieldName, Class c) {
        this.fieldName = fieldName;
        type = c;
        parseFieldType(c);
    }

    private void parseFieldType(Class c) {
        if (c.isPrimitive()) {
            //基础数据类型,byte,short,int,long,double,float,char,boolean,只考虑前6种
            setParseValue(false, false, true, true);
        } else {
            abdParse(c);
        }
    }

    /**
     * 抽象数据类型的解析,只考虑 Integer,Long,Double,Float,String,Date其余不考虑
     */
    private void abdParse(Class c) {
        String name = c.getName();
        switch (name) {
            case "java.lang.Integer":
            case "java.lang.Long":
            case "java.lang.Double":
            case "java.lang.Float":
                setParseValue(false, false, false, true);
                break;
            case "java.lang.String":
                setParseValue(true, false, false, false);
                break;
            case "java.util.Date":
                setParseValue(false, true, false, false);
                break;
            default:
                break;
        }

    }


    private void setParseValue(boolean isString, boolean isDate, boolean isPrimitive, boolean isNumberic) {
        this.isString = isString;
        this.isDate = isDate;
        this.isPrimitive = isPrimitive;
        this.isNumberic = isNumberic;
    }

    public String getFieldName() {
        return fieldName;
    }

    public BeanFieldProperty setFieldName(String fieldName) {
        this.fieldName = fieldName;
        return this;
    }

    public Class getType() {
        return type;
    }

    public BeanFieldProperty setType(Class type) {
        this.type = type;
        return this;
    }

    public boolean isString() {
        return isString;
    }

    public BeanFieldProperty setString(boolean string) {
        isString = string;
        return this;
    }

    public boolean isDate() {
        return isDate;
    }

    public BeanFieldProperty setDate(boolean date) {
        isDate = date;
        return this;
    }

    public boolean isPrimitive() {
        return isPrimitive;
    }

    public BeanFieldProperty setPrimitive(boolean primitive) {
        isPrimitive = primitive;
        return this;
    }

    public boolean isNumberic() {
        return isNumberic;
    }

    public BeanFieldProperty setNumberic(boolean numberic) {
        isNumberic = numberic;
        return this;
    }
}
