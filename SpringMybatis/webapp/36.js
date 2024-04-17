var LODOP; //声明为全局变量
function Moditify(item) {
    LODOP = getLodop(document.getElementById('LODOP2'), document.getElementById('LODOP_EM2'));
    if ((!LODOP.GET_VALUE("ItemIsAdded", item.name)) && (item.checked)) {
        LODOP.ADD_PRINT_TEXTA(item.name, 56, 32, 175, 30, item.value);
    } else {
        LODOP.SET_PRINT_STYLEA(item.name, 'Deleted', !item.checked);
    }
}

function CreatePage() {
    LODOP = getLodop(document.getElementById('LODOP2'), document.getElementById('LODOP_EM2'));
    LODOP.PRINT_INITA(0, 0, 760, 321, "打印控件功能演示_Lodop功能_在线编辑获得程序代码");
    LODOP.SET_PRINT_PAGESIZE(0, 0, 0, "A4");

    LODOP.ADD_PRINT_TEXT(10, 50, 175, 30, "先加的内容");

}

function DisplayDesign() {
    CreatePage();
    LODOP.SET_SHOW_MODE("DESIGN_IN_BROWSE", 1);
    LODOP.SET_SHOW_MODE("SETUP_ENABLESS", "11111111000000");//隐藏关闭(叉)按钮
    LODOP.SET_SHOW_MODE("HIDE_GROUND_LOCK", true);//隐藏纸钉按钮
    LODOP.PRINT_DESIGN();
}

function DisplaySetup() {
    CreatePage();
    LODOP.SET_SHOW_MODE("SETUP_IN_BROWSE", 1);
    LODOP.SET_SHOW_MODE("MESSAGE_NOSET_PROPERTY", '不能设置属性，请用打印设计(本提示可修改)！');
    LODOP.PRINT_SETUP();
}

function Addhtm() {
    LODOP.ADD_PRINT_HTM(45, 494, 288, 88, "<table border='1'>\n<tr>\n<td>表格11</td>\n<td>表格12</td>\n<td>表格13</td>\n</tr>\n<tr>\n<td>表格21</td>\n<td>表格22</td>\n<td>表格23</td>\n</tr>\n</table>");
}

function SetBKIMG() {
    LODOP = getLodop(document.getElementById('LODOP2'), document.getElementById('LODOP_EM2'));
    LODOP.ADD_PRINT_SETUP_BKIMG("<img border='0' src='http://s1.sinaimg.cn/middle/721e77e5t99431b026bd0&690'>");

}

function AddNew() {
    CreatePage();
    //LODOP.PRINT_INITA(0,4,760,921,"打印控件功能演示_Lodop功能_在线编辑获得程序代码");
    LODOP.SET_PRINT_PAGESIZE(0, 0, 0, "A4");
    LODOP.ADD_PRINT_TEXT(72, 404, 175, 30, "先加的内容");
    LODOP.ADD_PRINT_LINE(43, 11, 44, 745, 0, 1);
    LODOP.ADD_PRINT_TEXTA("a", 54, 20, 175, 30, "后加的Text内容，类名为a");
    LODOP.ADD_PRINT_TEXTA("a", 73, 211, 175, 30, "后加的Text内容，类名为a");
    LODOP.ADD_PRINT_TEXTA("a", 72, 18, 175, 30, "后加的Text内容，类名为a");
    LODOP.ADD_PRINT_TEXTA("a", 52, 585, 175, 30, "后加的Text内容，类名为a");
    LODOP.ADD_PRINT_TEXTA("a", 51, 404, 175, 30, "后加的Text内容，类名为a");
    LODOP.ADD_PRINT_TEXTA("a", 53, 210, 175, 30, "后加的Text内容，类名为a");
    LODOP.ADD_PRINT_TEXTA("a", 9, 262, 175, 30, "后加的Text内容，类名为a");
    LODOP.ADD_PRINT_TEXTA("a", 73, 586, 175, 30, "后加的Text内容，类名为a");
    LODOP.ADD_PRINT_LINE(111, 16, 110, 751, 0, 1);
    LODOP.ADD_PRINT_LINE(121, 396, 683, 397, 0, 1);
    LODOP.ADD_PRINT_BARCODE(1, 621, 110, 43, "Code39", "123456789");
    LODOP.ADD_PRINT_HTM(126, 17, 358, 186, "\r\n<table border=1  cellspacing =0>\r\n<tr>\r\n<td width=80>表格11</td>\r\n<td width=55>表格12</td>\r\n<td width=90>表格13</td>\r\n<td width=70>表格13</td>\r\n<td width=60>表格23</td>\r\n</tr>\r\n<tr>\r\n<td>表格21</td>\r\n<td>表格22</td>\r\n<td>表格23</td>\r\n<td>表格23</td>\r\n<td>表格23</td>\r\n</tr><tr>\r\n<td>表格21</td>\r\n<td>表格22</td>\r\n<td>表格23</td>\r\n<td>表格23</td>\r\n<td>表格23</td>\r\n</tr><tr>\r\n<td>表格21</td>\r\n<td>表格22</td>\r\n<td>表格23</td>\r\n<td>表格23</td>\r\n<td>表格23</td>\r\n</tr><tr>\r\n<td>表格21</td>\r\n<td>表格22</td>\r\n<td>表格23</td>\r\n<td>表格23</td>\r\n<td>表格23</td>\r\n</tr><tr>\r\n<td>表格21</td>\r\n<td>表格22</td>\r\n<td>表格23</td>\r\n<td>表格23</td>\r\n<td>表格23</td>\r\n</tr>\r\n</table>");
    LODOP.ADD_PRINT_HTM(129, 398, 357, 182, "\r\n<table border=1  cellspacing =0>\r\n<tr>\r\n<td width=80>表格11</td>\r\n<td width=55>表格12</td>\r\n<td width=90>表格13</td>\r\n<td width=70>表格13</td>\r\n<td width=60>表格23</td>\r\n</tr>\r\n<tr>\r\n<td>表格21</td>\r\n<td>表格22</td>\r\n<td>表格23</td>\r\n<td>表格23</td>\r\n<td>表格23</td>\r\n</tr><tr>\r\n<td>表格21</td>\r\n<td>表格22</td>\r\n<td>表格23</td>\r\n<td>表格23</td>\r\n<td>表格23</td>\r\n</tr><tr>\r\n<td>表格21</td>\r\n<td>表格22</td>\r\n<td>表格23</td>\r\n<td>表格23</td>\r\n<td>表格23</td>\r\n</tr><tr>\r\n<td>表格21</td>\r\n<td>表格22</td>\r\n<td>表格23</td>\r\n<td>表格23</td>\r\n<td>表格23</td>\r\n</tr><tr>\r\n<td>表格21</td>\r\n<td>表格22</td>\r\n<td>表格23</td>\r\n<td>表格23</td>\r\n<td>表格23</td>\r\n</tr>\r\n</table>\r\n");
    LODOP.SET_SHOW_MODE("DESIGN_IN_BROWSE", 1);
    LODOP.SET_SHOW_MODE("SETUP_ENABLESS", "11111111000000");//隐藏关闭(叉)按钮
    LODOP.SET_SHOW_MODE("HIDE_GROUND_LOCK", true);//隐藏纸钉按钮
    LODOP.PRINT_DESIGN();

       // LODOP.SAVE_TO_FILE("C:\\Users\\Administrator\\Desktop\\888a2222.png");
       //
       //  LODOP.SET_PRINTER_INDEXA("XPS");
       //
       //  LODOP.PRINT();

}

function EditTable(lodops) {
    console.log(lodops)
    var strs = "";
    var lodop = lodops.split('\n');
    var str = "";
    for (var i = 0; i < lodop.length; i++) {
        if (lodop[i].indexOf("ADD_PRINT_HTM") > -1) {
            var str = "";
            var start = lodop[i].indexOf("<tr>");
            start = lodop[i].indexOf("<tr>", start + 1);
            str += lodop[i].substring(0, start);
            for (var j = 0; j < 5; j++) {
                str += "<tr>\\n<td>字段1</td>\\n<td>字段2</td>\\n<td>字段3</td>\\n<td>字段4</td>\\n<td>字段5</td>\\n</tr>\\n";
            }
            console.log('')
            console.log(str)
            str += "</table>\");" + '\n';

            strs += str;
        } else {
            console.log(lodop[i] + '\n')
            strs += lodop[i] + '\n';
        }
    }
    console.log('')
    console.log(strs)

    return strs;
}

function AddDb() {
    var data = getCode();
    $.ajax({
        url: '/getlodop/',
        type: 'post',
        data: {"id": 51},
        dataType: 'json',
        success: function (res) {
            if (res["data"] == null) {
                alert(res["msg"])
            } else {
                CreatePage();
                lodopstxt = EditTable(res["data"]["txmtemplate"])
                eval(lodopstxt)
                LODOP.SET_SHOW_MODE("DESIGN_IN_BROWSE", 1);
                LODOP.SET_SHOW_MODE("SETUP_ENABLESS", "11111111000000");//隐藏关闭(叉)按钮
                LODOP.SET_SHOW_MODE("HIDE_GROUND_LOCK", true);//隐藏纸钉按钮
                LODOP.PRINT_DESIGN();
                console.log(res)
            }
        },
        error: function () {
            alert('出错了');
        }
    });

}

function getProgram() {
    LODOP = getLodop(document.getElementById('LODOP2'), document.getElementById('LODOP_EM2'));
    if (LODOP.CVERSION) LODOP.On_Return = function (TaskID, Value) {
        document.getElementById('S1').value = Value;
    };
    var iOption = 0;
    if (document.getElementById('check1').checked) iOption = iOption + 1;
    if (document.getElementById('check2').checked) iOption = iOption + 2;
    if (document.getElementById('check4').checked) iOption = iOption + 4;
    if (document.getElementById('check8').checked) iOption = iOption + 8;

    document.getElementById('S1').value = LODOP.GET_VALUE("ProgramCodes", iOption);
    document.getElementById('button01').style.display = "";
}

function getCode() {
    LODOP = getLodop(document.getElementById('LODOP2'), document.getElementById('LODOP_EM2'));
    if (LODOP.CVERSION) LODOP.On_Return = function (TaskID, Value) {
        document.getElementById('S1').value = Value;
    };
    var iOption = 0;
    if (document.getElementById('check1').checked) iOption = iOption + 1;
    if (document.getElementById('check2').checked) iOption = iOption + 2;
    if (document.getElementById('check4').checked) iOption = iOption + 4;
    if (document.getElementById('check8').checked) iOption = iOption + 8;

    return LODOP.GET_VALUE("ProgramCodes", iOption);
}

function SaveCode() {
    var data = getCode();
    $.ajax({
        url: '/save/',
        type: 'post',
        data: {"lodoptxt": data},
        dataType: 'json',
        success: function (res) {
            console.log(res)
        },
        error: function () {
            alert('出错了');
        }
    });
}

function prn_Preview() {
    LODOP = getLodop(document.getElementById('LODOP1'), document.getElementById('LODOP_EM1'));
    eval(document.getElementById('S1').value);
    LODOP.PREVIEW();
    LODOP = getLodop(document.getElementById('LODOP2'), document.getElementById('LODOP_EM2'));
}

function getMyValue(strType, oResultOB) {
    var LODOP = getLodop(document.getElementById('LODOP_X'), document.getElementById('LODOP_EM'));
    if (LODOP.CVERSION) CLODOP.On_Return = function (TaskID, Value) {
        if (oResultOB) oResultOB.value = Value;
    };
    var stResult = LODOP.GET_VALUE(strType, "0");
    if (!LODOP.CVERSION) oResultOB.value = stResult;
}