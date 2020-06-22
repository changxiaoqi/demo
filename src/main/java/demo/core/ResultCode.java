package demo.core;

/**
 * Created by 李恒名 on 2017/6/13.
 * 响应码枚举，参考HTTP状态码的语义
 */
public enum ResultCode {
    SUCCESS(200,"请求成功"),//成功
    FAIL(400,"请求失败"),//失败
    UNAUTHORIZED(401,"认证失败"),//未认证（签名错误）
    NO_CLASS_TICKET(402,"未携带班级认证"),//未认证（签名错误）
    NOT_FOUND(404,"不存在的资源"),//接口不存在
    INTERNAL_SERVER_ERROR(500,"服务器内部错误"),//服务器内部错误


    /*******自定义*********/
    NO_USER_SESSION(600,"没有登录状态"),
    CLASS_END(601,"班级到期"),//
    CLASS_DROP_OUT(602,"休学中"),//休学中
    NO_GUARANTEE(603,"没有签署课程协议"),
    NO_PAYMENT(604,"分期到期"),//拒绝执行，如进课表时需支付下期分期但未支付，设置为此状态码时，一般需在data中设置订单号字段（payNum）
    RECHOSE_CLASS(605,"重选班级"),//
    NO_DATA(606,"没有数据"),
    NO_INSURANCE(607,"没有签署保险协议"),
    EXAM_EXHAUST(608,"证书考试次数已达上限"),
    PARAM_EX(609,"参数不正确"),
    AUDITRULE_WRONG(610,"旁听规则不正确！"),
    SEARCH_WRONG(611,"查询结果不正确！"),//连续查询时，数据不能完整衔接，可能存在无效数据！
    NEED_WAIT_FINANCE_AUDIT(612, "需要等待财务审核"),
    EVALUATE_SUCCESS(614,"评价成功"),
    NO_EVALUATE(615,"未评价"),
    GUARANTEE_SUCCESS(616,"保过签署成功"),
    INSURANCE_SUCCESS(617,"保险签署成功"),
    CLASS_STUDENT_DETAIL_NO_FAIL(618,"班级卡片未填写");


    public int code;
    public String msg;

    ResultCode(int code,String msg) {
        this.code = code;
        this.msg = msg;
    }
}
