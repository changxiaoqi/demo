package demo.utils.excel;

/**
 * @author: pmj
 * @date: 2018/7/16 12:33
 * @description: 获取转换器的工厂
 * 使用demo:
 *  1.需要确定,excel表格中的列和bean的映射是按顺序映射,还是按列的名称来映射
 *  根据不同的情况用工厂创建不同的转换器 IConvertExcel2Pojo convert = ConvertFactory.getConvert(ConvertType.BY_SORT);
 *  2.初始化转换器,需要传入两个东西,一个是excel对象,提供了三个重载的方法,另外一个是bean中每个字段解析后的封装类
 *   convert.initHSSFWorkbook(hssfWorkbook,createMapExcel2Pojo(ConvertType.BY_SORT));
 *   private MapExcel2Pojo createMapExcel2Pojo(ConvertType convertType) {
 *         MapExcel2Pojo pojo = new MapExcel2Pojo(ConvertType.BY_SORT, Book.class);
 *         pojo.addSortMap(0, new BeanFieldProperty("sku", Integer.class));
 *         pojo.addSortMap(1, new BeanFieldProperty("bookCode", String.class));
 *         pojo.addSortMap(2, new BeanFieldProperty("bookName", String.class));
 *         pojo.addSortMap(3, new BeanFieldProperty("kingdeePrice", Double.class));
 *         return pojo;
 *     }
 *  3.调用转换成list还是单个的方法转换成bean, List<Book> list = convert.convertToList();
 *  4.attention:不要注入使用,非线程安全.如果无法生成,检查下bean的生成是否用了链式操作,beanUtils不能给链式操作的bean赋值
 *
 */
public class ConvertFactory {


    public static IConvertExcel2Pojo getConvert(ConvertType convertType) {
        if (convertType.equals(ConvertType.BY_SORT)){

            return new ConvertByColumnSort();
        }else if (convertType.equals(ConvertType.BY_NAME)){
            return new ConvertByColumnName();
        }else {
            throw new IllegalArgumentException("请传入正确的类型");
        }
    }
}
