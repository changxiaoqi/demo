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