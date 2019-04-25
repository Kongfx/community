$().ready(function() {
    debugger
    $('.summernote').summernote({
        height : '220px',
        lang : 'zh-CN',
        callbacks: {
            onImageUpload: function(files, editor, $editable) {
                sendFile(files);
            }
        }
    });
    validateRule();
    debugger
    if($('#formId .form-groups').length==1){
        $(".btn-form").css({'display':'none'});
        return;
    }
});

$.validator.setDefaults({
    //submitHandler : function() {
    //    save(1);
    //}
});

function next(){
    save();
    window.location.href='/manual/manager'
}
function validateRule() {
    var icon = "<i class='fa fa-times-circle'></i> ";
    jQuery.validator.addMethod("format", function (value, element) {
        var RegExp = /^[0-9]{4}[0-9]{2}[0-9]{2}$/;
        return RegExp.test(value);
    }, $.validator.format("请填写成立日期,格式YYYYMMDD"));
    $("#signupForm").validate({
        rules : {
            windcode : {
                required : true
            },
            fundmanager : {
                required : true
            },
            managerResume : {
                required : true
            },
            managerGender : {
                required : true
            },
            managerEducation : {
                required : true,
            },
            managerStartdate:{
                required : true,
                format: true,
            }
        },
        onSubmit:false,
        messages : {
            windcode                 : icon+"请填写基金代码",
            fundmanager              : icon+"请填写基金经理",
            managerResume            : icon+"请填写简历" ,
            managerGender            : icon+"请填写性别" ,
            managerEducation         : icon+"请填写学历",
            managerStartdate         : icon+"请填写上任日期,格式YYYYMMDD",

        }
    });
}


function returnList() {
    var index = parent.layer.getFrameIndex(window.name); // 获取窗口索引
    parent.layer.close(index);
}


//将表单序列化成json格式的数据(但不适用于含有控件的表单，例如复选框、多选的select)
(function($){
    $.fn.serializeJson = function(){
        debugger
        var jsonData1 = {};
        var serializeArray = this.serializeArray();
        // 先转换成{"id": ["12","14"], "name": ["aaa","bbb"], "pwd":["pwd1","pwd2"]}这种形式
        $(serializeArray).each(function () {
            if (jsonData1[this.name]==""||jsonData1[this.name]) {
                if ($.isArray(jsonData1[this.name])) {
                    jsonData1[this.name].push(this.value);
                } else {
                    jsonData1[this.name] = [jsonData1[this.name], this.value];
                }
            } else {
                jsonData1[this.name] = this.value;
            }
        });
        // 再转成[{"id": "12", "name": "aaa", "pwd":"pwd1"},{"id": "14", "name": "bb", "pwd":"pwd2"}]的形式
        var vCount = 0;
        // 计算json内部的数组最大长度
        for(var item in jsonData1){
            var tmp = $.isArray(jsonData1[item]) ? jsonData1[item].length : 1;
            vCount = (tmp > vCount) ? tmp : vCount;
        }

        if(vCount > 1) {
            var jsonData2 = new Array();
            for(var i = 0; i < vCount; i++){
                var jsonObj = {};
                for(var item in jsonData1) {
                    jsonObj[item] = jsonData1[item][i];
                }
                jsonData2.push(jsonObj);
            }
            return JSON.stringify(jsonData2);
        }else{
            return "[" + JSON.stringify(jsonData1) + "]";
        }
    };
})(jQuery);

function save(type) {
    var flag=$('#signupForm').valid();
    if(!flag){
        return;
    }

    var jsonStr = $('#signupForm').serializeJson();
    $.ajax({
        type : "POST",
        url : "/manual/manager/saveBatch/"+$("#fundCode").val(),
        contentType : 'application/json;charset=utf-8', //设置请求头信息
        dataType:"json",
        data: jsonStr,
        error : function() {
            parent.layer.alert("Connection error");
        },
        success : function(r) {
            if (r.code == 200) {
                parent.layer.msg(r.message);
                if(type == 'next'){
                    window.location.href='/manual/view/'+$("#fundCode").val();
                }else{
                    window.location.href='/manual/manager/view/'+$("#fundCode").val();
                }
            } else {
                parent.layer.alert(r.message)
            }
        }
    });
}

function update(){
    window.location.href='/manual/manager/edit/'+$("#fundCode").val();
}

function add(){
    var appendDiv = $('#append-div').children('div').clone(true);
    $("#formId").prepend(appendDiv);
    if($('#formId .form-groups').length>=1){
        $(".btn-form").css({'display':'block'});
    }

}

function removeself(t){ //删除自己
    //alert($('#formId .form-groups').length);
    if(($('#formId .form-groups').length==2)){
        console.log($(t).prev());
        $(t).parent().remove();
        $(".btn-form").css({'display':'none'});

    }else if($('#formId .form-groups').length==1){
        $(".btn-form").remove();
        return;
    }else{
        $(t).parent().remove();
    }
    console.log($(t).prev())
    //$(t).parent().prev().remove();
    //$(t).remove();
    //$(".btn-form").remove();
}

function prev(){
    window.location.href='/manual/base/view/'+$('#fundCode').val()
}

function next(type){
    // var flag=validateRule();
    var flag = true;
    if(!flag){
        return;
    }else{
        save(type);
        // window.location.href='/manual/manager/edit/'+$("#fundCode").val();
    }
}
