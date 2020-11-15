$(function () {
    $(".form_datatime").datetimepicker({
        format:'yyyy-mm-dd hh:ii:ss',
        language:'zh-CN',
        autoclose:true,
        todayBtn:true
    })
})

function checkall() {
    $(".checkone").prop("checked", $(".checkall").prop("checked"))
}

function checkone() {
    var flag = true;
    $(".checkone").each(function (index, el) {
        var chk = $(el);
        if (chk.prop("checked") == false) {
            flag = false;
        }
    })
    if(flag){
        $(".checkall").prop("checked", true)
    }else {
        $(".checkall").prop("checked", false)
    }

}