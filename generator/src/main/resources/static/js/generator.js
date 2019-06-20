$(function () {
    $("#jqGrid").jqGrid({
        url: 'sys/generator/list',
        datatype: "json",
        colModel: [
            {label: '表名', name: 'tableName', width: 100, key: true},
            {label: 'Engine', name: 'engine', width: 70},
            {label: '表备注', name: 'tableComment', width: 100},
            {label: '创建时间', name: 'createTime', width: 100}
        ],
        viewrecords: true,
        height: 385,
        rowNum: 10,
        rowList: [10, 30, 50, 100, 200],
        rownumbers: true,
        rownumWidth: 25,
        autowidth: true,
        multiselect: true,
        pager: "#jqGridPager",
        jsonReader: {
            root: "page.list",
            page: "page.currPage",
            total: "page.totalPage",
            records: "page.totalCount"
        },
        prmNames: {
            page: "page",
            rows: "limit",
            order: "order"
        },
        gridComplete: function () {
            //隐藏grid底部滚动条
            $("#jqGrid").closest(".ui-jqgrid-bdiv").css({"overflow-x": "hidden"});
        }
    });
});

var vm = new Vue({
    el: '#rrapp',
    mounted: function () {
        this.$nextTick(function () {
            axios.get(`sys/generator/properties`)
                .then(function (response) {
                    if (response.data.code == 0) {
                        $("#packageInfo").attr("placeholder", response.data.package);
                        $("#moduleName").attr("placeholder", response.data.moduleName);
                        $("#authorForm").attr("placeholder", response.data.author);
                        $("#emailForm").attr("placeholder", response.data.email);
                    } else {
                        console.log(response.data.msg);
                    }
                })
                .catch(function (error) {
                    console.log(error);
                });
        })
    },
    data: {
        q: {
            tableName: null
        }
    },
    methods: {
        validateAndShowModal: function () {
            var grid = $("#jqGrid");
            var rowKey = grid.getGridParam("selrow");
            if (!rowKey) {
                alert("请选择一条记录");
                return;
            }
            $("#moreInfomation").modal('show');
        },
        query: function () {
            $("#jqGrid").jqGrid('setGridParam', {
                postData: {'tableName': vm.q.tableName},
                page: 1
            }).trigger("reloadGrid");
        },
        generator: function () {
            var tableNames = getSelectedRows();
            if (tableNames == null) {
                return;
            }
            var p = (CheckIsNullOrEmpty($("#packageInfo").val()) ? $("#packageInfo").attr("placeholder") : $("#packageInfo").val());
            var m = (CheckIsNullOrEmpty($("#moduleName").val()) ? $("#moduleName").attr("placeholder") : $("#moduleName").val());
            var a = (CheckIsNullOrEmpty($("#authorForm").val()) ? $("#authorForm").attr("placeholder") : $("#authorForm").val());
            var e = (CheckIsNullOrEmpty($("#emailForm").val()) ? $("#emailForm").attr("placeholder") : $("#emailForm").val());
            location.href = "sys/generator/code?tables=" + tableNames.join()
            + "&packageInfo=" + p
            + "&moduleName=" + m
            + "&author=" + a
            + "&email=" + e;
        }
    }
});

function CheckIsNullOrEmpty(value) {
    var reg = /\s+/g//正则表达式用于判斷是否有空格或空字符串;
    //reg.test(value)判斷是否有空格，有空格為true,如果首尾空格要求不嚴格的話可以加上trim(),如reg.test(value.trim()
    return (value === "");
}