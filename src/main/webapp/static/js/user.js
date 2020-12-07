$(function () {
    $(".form_datatime").datetimepicker({
        format:'yyyy-mm-dd hh:ii:ss',
        language:'zh-CN',
        autoclose:true,
        todayBtn:true
    });

    $("#updateUserModal").on("hidden.bs.modal",function () {
        $(this).removeData("bs.modal");
    })

    //由于插件加载时间问题导致下拉菜单无法加载
    $("#updateUserModal").on("shown.bs.modal",function () {
        $("#updateUserModal .selectpicker").selectpicker();

    })

    $("#batchDelUserBtn").one("click", function () {
    //    获取勾选的复选框对象
        var checkboxes = $(".checkone:checked");
        if(checkboxes.length == 0){
            alert("请选择需要删除的用户记录")
        }else{
            var userIds = new Array();
            checkboxes.each(function () {
                userIds.push(this.value) ;
            });
            var datas = JSON.stringify(userIds);
        //    获取到id后批量删除
            var flag = delSure();
            if (flag) {
                $.ajax({
                    url:'/admin/batchDelUser',
                    type:'POST',
                    data:{
                        uid:datas
                    },
                    success:function (result) {
                        if (result == "success") {
                            $(location).attr("href","/user");
                        }
                    }
                })
            }
        }

    })
    
    $("#searchBtn").on("click", function () {
        $("#search_form").submit();
    })

});



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

function updateUserFormSubmit() {

    // $("#updateUserForm").submit();
}
function delSure() {
    if(confirm("确定要删除这条记录吗?")){
        return true
    }else return false;
}