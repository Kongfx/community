$().ready(function() {
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
});

$.validator.setDefaults({
    submitHandler : function() {
        save();
    }
});

function save(type) {
    var flag=$('#signupForm').valid();
    if(!flag){
        return;
    }
        $.ajax({
            type : "POST",
            url : "/manual/base/save",
            data : $('#signupForm').serialize(),// 你的formid
            dataType: "json",
            async : false,
            error : function(request) {
                parent.layer.alert("Connection error");
            },
            success : function(r) {
                if (r.code == 200) {
                    parent.layer.msg(r.message);
                    if(type == 'next'){
                        window.location.href='/manual/manager/edit/'+$("#fundCode").val();
                    }else{
                        window.location.href='/manual/base/view/'+$("#fundCode").val();
                    }
                } else {
                    parent.layer.alert(r.message)
                }
            }
        });
}
function update() {
    window.location.href='/manual/base/edit/'+$("#fundCode").val();
}

function add(){
    $("#formId").append($("#formId .form-groups:first-child").clone(true)).append('<div style="width:100%;text-align: right;float: right"><button style="position: relative;top:-50px;right:-15px;" type="button" class="btn  btn-danger"  onclick="removeself(this)"><i class="fa fa-remove"></i></button></div>');
}

function removeself(t){ //删除自己
    console.log($(t).prev())

    $(t).prev().remove();
    $(t).remove();
}

function next(type){
    var flag=$('#signupForm').valid();
    if(!flag){
        return;
    }else{
        if($("#info_id").val() == ""){
            save(type);
        }else{
            window.location.href='/manual/manager/edit/'+$("#fundCode").val();
        }
    }

}
function validateRule() {
    var icon = "<i class='fa fa-times-circle'></i> ";
    jQuery.validator.addMethod("format", function (value, element) {
        var RegExp = /^[0-9]{4}[0-9]{2}[0-9]{2}$/;
        return RegExp.test(value);
    }, $.validator.format("请填写成立日期,格式YYYYMMDD"));
    jQuery.validator.addMethod("isNum", function (value, element) {
        var decimal = /^-?\d+(\.\d{1,4})?$/;
        return this.optional(element) || (decimal.test(value));
    }, $.validator.format("小数位数不能超过四位位!"));
    jQuery.validator.addMethod("fundCode", function (value, element) {
        var decimal = /^[0-9]{6,10}$/;
        return this.optional(element) || (decimal.test(value));
    }, $.validator.format("请填写基金代码,基金代码为数字"));
    $("#signupForm").validate({
    rules : {
            fundName : {
                required : true
            },
            windcode : {
                required : true,
                fundCode :true
            },
            fullname : {
                required : true
            },
            corpFundManagementComp : {
                required : true
            },
            custodianBank : {
                required : true
            },
            managementFeeRatio : {
                required  : true,
                number    :true,
                isNum     :true,
                min       :0

            },
            custodianFeeRatio : {
                required  : true,
                number    :true,
                isNum     :true,
                min       :0

            },
            firstinvestType : {
                required : true
            },
            setupDate:{
                required : true,
                format: true,
                //format:'yyyyMMDD'
            },
            type : {
                required : true
            },
            riskReturn : {
                required : true
            },

        },
        onSubmit:false,
        messages : {
            fundName                   : icon+"请填写基金名称",
            windcode                   : icon+"请填写基金代码,基金代码为数字",
            fullname                   : icon+"请填写基金全称",
            corpFundManagementComp     : icon+"请填写管理人" ,
            custodianBank              : icon+"请填写托管人" ,
            managementFeeRatio         : icon+"输入值必须大于0且小数位数不能超过四位",
            custodianFeeRatio          : icon+"请填写托管费,输入小数或者整数",
            firstinvestType            : icon+"请填写投资类型",
            setupDate                  : icon+"请填写成立日期,格式YYYYMMDD",
            type                       : icon+"请填写基金类型",
            riskReturn                 : icon+"请填写基金风险收益特征",
        }
    });
}


function returnList() {
    var index = parent.layer.getFrameIndex(window.name); // 获取窗口索引
    parent.layer.close(index);
}