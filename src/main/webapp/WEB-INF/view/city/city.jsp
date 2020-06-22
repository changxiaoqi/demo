<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%--<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>--%>

<!DOCTYPE html>
<html lang="en">
<head>
    <title>资源包配置</title>
</head>
<body>

    <input id="num" type="text">
    <input id="price" type="text">
    <input id="maxNum" type="text">
    <input type="button" id="btn">

    <div id="div">
        <table id="table">
            <tr><td>${pageContext.request.contextPath}</td></tr>
            <tr><td>${ctx}</td></tr>
        </table>
    </div>



    <script src="${pageContext.request.contextPath}/resources/assets/plugins/parsley/dist/parsley.js"></script>
    <script src="${pageContext.request.contextPath}/resources/assets/plugins/jquery-ui/ui/minified/jquery-ui.min.js"></script>
    <script src="${pageContext.request.contextPath}/resources/assets/plugins/slimscroll/jquery.slimscroll.min.js"></script>
    <script src="${pageContext.request.contextPath}/resources/assets/plugins/select2/dist/js/select2.min.js"></script>
    <script src="${pageContext.request.contextPath}/resources/assets/plugins/bootstrap3-editable/js/bootstrap-editable.min.js"></script>
    <script src="${pageContext.request.contextPath}/resources/assets/plugins/switchery/switchery.min.js"></script>
    <script src="${pageContext.request.contextPath}/resources/assets/js/form-slider-switcher.demo.min.js"></script>
    <script>

        $(document).ready(function () {
            $("#btn").click(function () {
                checked();
            });

            function checked() {
                var num = $("#num").val();
                var price = $("#price").val();
                var maxNum = $("#maxNum").val();
                $.ajax(
                    {
                        url: "/city/bao",
                        type: "post",
                        data: {
                            num: num, price: price, maxNum: maxNum
                        },
                        dataType: "json",
                        async: false,
                        success: function (json) {

                            var data = json.data;
                            var options = '';
                            if (data != null) {
                                $.each(data, function (i, n) {
                                    options += '<tr><td>' + n + '</td></tr>';
                                });
                            }
                            $("#table").empty().append(options);
                        }
                    }
                )
            }
        });


    </script>
</body>
</html>