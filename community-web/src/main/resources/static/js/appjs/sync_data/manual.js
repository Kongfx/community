$(function() {
    load();
});

function load() {
    $('#exampleTable')
        .bootstrapTable(
            {
                method : 'get', // 服务器数据的请求方式 get or post
                url : "/manual/list", // 服务器数据的加载地址
                showColumns : true,
                iconSize : 'outline',
                toolbar : '#exampleToolbar',
                striped : true, // 设置为true会有隔行变色效果
                dataType : "json", // 服务器返回的数据类型
                pagination : true, // 设置为true会在底部显示分页条
                singleSelect : false, // 设置为true将禁止多选
                // contentType : "application/x-www-form-urlencoded", //发送到服务器的数据编码类型
                pageSize : 5, // 如果设置了分页，每页数据条数
                pageNumber : 1, // 如果设置了分布，首页页码
                // search : true, // 是否显示搜索框
                // showColumns : false, // 是否显示内容下拉框（选择显示的列）
                sidePagination : "server", // 设置在哪里进行分页，可选值为"client" 或者 "server"

                queryParams : function(params) {
                    return {
                        // 说明：传入后台的参数包括offset开始索引，limit步长，sort排序列，order：desc或者,以及所有列的键值对
                        limit : params.limit,
                        page: (params.offset / params.limit) + 1,   //页码
                        code:$('#fundCode').val(),
                    };
                },
                // 请求服务器数据时，你可以通过重写参数的方式添加一些额外的参数，例如 toolbar 中的参数
                // 如果 queryParamsType = 'limit' ,返回参数必须包含 limit, offset, search, sort, order
                // 否则, 需要包含: pageSize, pageNumber, searchText, sortName, sortOrder.
                // 返回false将会终止请求
                columns : [
                    {
                        field : 'fundCode',
                        title : '基金代码',
                        align: 'center'
                    },
                    {
                        field : 'saveState',
                        title : '录入状态',
                        align : 'center',
                        formatter : function(value, row, index) {
                            if (value == '0') {
                                return '<span class="label label-danger">草稿</span>';
                            } else if (value == '1') {
                                return '<span class="label label-primary">发布</span>';
                            }
                        }
                    },
                     {
                        field : 'submitState',
                        title : '提交状态',
                        align : 'center',
                        formatter : function(value, row, index) {
                            if (value == '0') {
                                return '<span class="label label-danger">未提交</span>';
                            } else if (value == '1') {
                                return '<span class="label label-primary">已提交</span>';
                            }
                        }
                    },
                    {
                        visible : true,
                        field : 'createTime',
                        title : '创建时间',
                        align: 'center'
                    },
                    {
                        visible : true,
                        field : 'updateTime',
                        title : '最近修改时间',
                        align: 'center'
                    },
                    {
                        title : '操作',
                        field : 'id',
                        align : 'center',
                        formatter : function(value, row, index) {
                            var s_edit_h = '';
                            var s_remove_h = '';
                            if(row.submitState){
                                s_edit_h = 'hidden';
                                s_remove_h = 'hidden';
                            }
                            var f = '<a class="btn btn-success btn-sm" href="#" title="预览"  mce_href="#" onclick="preview(\''
                                + row.fundCode
                                + '\')"><i class="fa fa-rocket"></i></a> ';
                            var e = '<a class="btn btn-primary btn-sm '+s_edit_h+'" href="#" mce_href="#" title="编辑" onclick="edit(\''
                                + row.fundCode
                                + '\')"><i class="fa fa-edit"></i></a> ';
                            var d = '<a class="btn btn-warning btn-sm '+s_remove_h+'" href="#" title="删除"  mce_href="#" onclick="remove(\''
                                + row.id
                                + '\')"><i class="fa fa-remove"></i></a> ';
                            return f + e + d;
                        }
                    }
                ]
            });
}

function reLoad() {
    $('#exampleTable').bootstrapTable('refresh');
}

function add() {
    window.location.href = "/manual/add";
}



function edit(fundCode) {
    window.location.href='/manual/base/edit/'+fundCode;
}
function remove(id) {
    layer.confirm('确定要删除选中的记录？', {
        btn : [ '确定', '取消' ]
    }, function() {  });
}

function preview(fundCode) {
    var addPage =
        layer.open({
            type: 2 //此处以iframe举例
            ,title: '基金信息预览'
            ,area: ['390px', '260px']
            ,shade: 0
            ,maxmin: true
            ,offset: 'auto'
            ,content:'/manual/view/'+fundCode, //iframe的url，no代表不显示滚动条

        });

    layer.full(addPage);
}





