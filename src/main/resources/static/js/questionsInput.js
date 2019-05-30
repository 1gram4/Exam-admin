var um1 = UM.getEditor('questionText');
//这两行代码用来控制土图片回显的
var j=0
imageInputProcess()
//这个变量是区别弹框是因为添加打开的还是修改打开的,默认是添加打开的
var popAdd = true
//这个变量是用来记录点击题目后记录题号de
var $questionThis   //点击题目后获得的jquery对象
var index = 0
//paper这个json用来存储试卷信息的
var paper={
    paperName:"测试试卷1",
    grade:"MIDDLE1",
    paperDifficulty:0.6,
    date:"2019",
    paperSubject:"CHINESE",
    paperSchool:{
        schoolName:"上海大学"
    },
    questions:[]
}
//question用来存储一道题目
var question={
    questionType:"CHOICE",
    choiceA:"",
    choiceB:"",
    choiceC:"",
    choiceD:"",
    score:5,
    difficulty:0.6,
    questionSubject:"CHINESE",
    grade:"MIDDLE1",
    questionText:"这是题目描述",
    knowledgePoints:[],
    images:[],
    questionAnswer:{
        answerText:"这是答案",
        answerImages:[],
        answerExplain:"这是答案解释",
        answerExplainImages:[]
    }
}
//动态绑定range值
setInterval( function () {
    $("#showDifficulty").html($("#paperDifficulty").val())
}, 50)
setInterval( function () {
    $("#showQDifficulty").html($("#questionDifficulty").val())
}, 50)
/*点击弹出按钮*/
function popBox() {
    var popBox = document.getElementById("popBox");
    var popLayer = document.getElementById("popLayer");
    popBox.style.display = "block";
    popLayer.style.display = "block";
    //imageInputProcess()     //这行傻逼代码，害老子调了五个小时
};
/*点击关闭按钮*/
function closeBox() {
    var popBox = document.getElementById("popBox");
    var popLayer = document.getElementById("popLayer");
    popBox.style.display = "none";
    popLayer.style.display = "none";
}
//当打开弹窗后就运行这个函数，这个函数的目的是将图片打开回显到浏览器
function imageInputProcess() {
    var input1 = $("#images")
    var input2 = $("#answerImages")
    var input3 = $("#answerExplainImages")
    var result
    if(typeof FileReader==='undefined'){
        result.innerHTML = "抱歉，你的浏览器不支持 FileReader";
        input1.setAttribute('disabled','disabled');
        input2.setAttribute('disabled','disabled');
        input3.setAttribute('disabled','disabled');
    }else{
        input1.on("change",readFile1)
        input2.on("change",readFile2)
        input3.on("change",readFile3)
    }　　　　　//handler
    function readFile1() {
        for (var i = 0; i < this.files.length; i++) {
            if (!this['value'].match(/.jpg|.gif|.png|.bmp/i)) {　　//判断上传文件格式
                return alert("上传的图片格式不正确，请重新选择")
            }
            var reader = new FileReader();
            reader.readAsDataURL(this.files[i]);
            reader.onload = function (e) {
                result = '<div class="imageContainer"  id="result' + (++j) + '"><img style="width: 100px;height: 100px" src="' + this.result + '" alt=""/><img src="http://www.iconpng.com/png/sm-reflection-r/button-cross.png" class="delete" onclick="deleteImage(this)"/></div>'
                $("#img1").append(result)
            }
        }
    }
    function readFile2() {
        for (var i = 0; i < this.files.length; i++) {
            if (!this['value'].match(/.jpg|.gif|.png|.bmp/i)) {　　//判断上传文件格式
                return alert("上传的图片格式不正确，请重新选择")
            }
            var reader = new FileReader();
            reader.readAsDataURL(this.files[i]);
            reader.onload = function (e) {
                result = '<div class="imageContainer" id="result' + (++j) + '"><img style="width: 100px;height: 100px" src="'+this.result+'" alt=""/><img src="http://www.iconpng.com/png/sm-reflection-r/button-cross.png" class="delete" onclick="deleteImage(this)"/></div>'
                $("#img2").append(result)
            }
        }
    }
    function readFile3() {
        for (var i = 0; i < this.files.length; i++) {
            if (!this['value'].match(/.jpg|.gif|.png|.bmp/i)) {　　//判断上传文件格式
                return alert("上传的图片格式不正确，请重新选择")
            }
            var reader = new FileReader();
            reader.readAsDataURL(this.files[i]);
            reader.onload = function (e) {
                result = '<div class="imageContainer" id="result' + (++j) + '"><img style="width: 100px;height: 100px" src="' + this.result + '" alt=""/><img src="http://www.iconpng.com/png/sm-reflection-r/button-cross.png" class="delete" onclick="deleteImage(this)"/></div>'
                $("#img3").append(result)
            }
        }
    }
}

//点击了保存这里有两种可能，有可能是修改有可能是添加
function confirmAddQuestion() {
    //如果弹框非空空的直接返回
    if(!popIsEmpty()){
        if(popAdd){  //添加题目
            paper.questions.push(saveQuestion())
            clearBox()//清空box
            j=0  //j这个全局变量用来绑定图片
            closeBox()
            //将添加的题目回显到html上
            var questionShow=paper.questions[paper.questions.length-1]
            var div='<div style="position: relative" ><div onclick="questionClick(this)"><span id="qNO">'+paper.questions.length+'</span>题<p>'+questionShow.questionText+'</p></div><img src="http://www.iconpng.com/png/sm-reflection-r/button-cross.png" class="delete" onclick="deleteQuestion(this)"/></div>'
            $("#questions").append(div)
        }
        else{ //修改题目
            paper.questions[index]=saveQuestion()
            //将question修改后回显到页面上面
            $($questionThis.children().get(0)).text(index+1)
            $($questionThis.children().get(1)).text(paper.questions[index].questionText)
            clearBox()//清空box
            j=0  //j这个全局变量用来绑定图片
            closeBox()
        }
    }
}
//清空box内容
function clearBox() {
    $("#popBox input").val("")
    $("#img1").html("")
    $("#img2").html("")
    $("#img3").html("")
}
//判断popBox中输入框不能为空
function popIsEmpty() {
    var a=false
    //判断输入框不能为空，因为这里的display:none也会被选择所以要分开
    $("#popBox input").not("#images").not("#answerImages").not("#answerExplainImages").each(function () {
        if($("#questionType").val()=="CHOICE"){
            if($(this).val()==""){
                console.log(this)
                alert("输入框不能为空")
                a=true
                return false//这里是跳出for循环
            }
        }
        else {
            if($(this).parent().parent().attr("id")!="abcd"&&$(this).val()==""){
                alert("输入框不能为空")
                a=true
                return false
            }
        }
    })
    return a
}
//将弹出框的内容保存到question中
function saveQuestion() {
    var question1={};
    $.extend(true,question1,question)
    question1.questionType=$("#questionType").val()
    question1.choiceA=$("#A").val()
    question1.choiceB=$("#B").val()
    question1.choiceC=$("#C").val()
    question1.choiceD=$("#D").val()
    question1.difficulty=$("#questionDifficulty").val()
    question1.questionSubject=$("#paperSubject").val()
    question1.grade=$("#grade").val()
    //这里暂时只弄一个知识点
    question1.knowledgePoints.push({knowledgePointName:$("#knowledgePoints").val()})
    question1.questionText=$("#questionText").val()
    question1.questionAnswer.answerExplain=$("#answerExplain").val()
    question1.questionAnswer.answerText=$("#questionAnswer").val()
    question1.images.push({imgPath:"123"})
    question1.questionAnswer.answerImages.push({imgPath:"123"})
    question1.questionAnswer.answerExplainImages.push({imgPath:"123"})
    return question1;
}

//点击添加题目触发事件
function addQuestion() {
    //弹出弹框
    popBox()
    //将判别弹框弹出的bool类型置为add
    popAdd = true
}
//点击了题目这里应该弹出框来编辑
function questionClick(that) {
    //弹出弹框
    popBox()
    $questionThis=$(that)
    //设置弹出类型
    popAdd=false
    //将题目回显到弹框上面
    index=parseInt($($(that).children().get(0)).text())-1
    $("#questionType").val(paper.questions[index].questionType)
    $("#A").val(paper.questions[index].A)
    $("#B").val(paper.questions[index].B)
    $("#C").val(paper.questions[index].C)
    $("#D").val(paper.questions[index].D)
    $("#questionDifficulty").val(paper.questions[index].difficulty)
    $("#paperSubject").val(paper.questions[index].paperSubject)
    $("#grade").val(paper.questions[index].grade)
    $("#knowledgePoints").val(paper.questions[index].knowledgePoints[0].knowledgePointName)
    $("#questionText").val(paper.questions[index].questionText)
    $("#score").val(paper.questions[index].score)
    $("#answerExplain").val(paper.questions[index].questionAnswer.answerExplain)
    $("#questionAnswer").val(paper.questions[index].questionAnswer.answerText)
}
//题型更改
function qtChange() {
    console.log("111")
    if($("#questionType").val()==='CHOICE')
        $("#abcd").show()
    else
        $("#abcd").hide()

}
//删除题目
function deleteQuestion(t) {
    var message=confirm("你确定要删除吗")
    if(message==true){
        //$(t).parent().remove()  //这行代码又tm改了劳资5个小时，我操他妈隔壁
        //然后还要从questions数组将题删掉
        var num= parseInt($($(t).prev().children().get(0)).text())-1
        paper.questions.splice(num,1)
        //将后面的题目序号都-1
        //我要学vue.js，这样操控dom谁顶的住呀
        $($($(t).parent().nextAll().children().get(0)).children().get(0)).text(parseInt($($($(t).parent().nextAll().children().get(0)).children().get(0)).text())-1)
        $(t).parent().remove()  //应该写在这里，弟弟
    }
    else if(message==false)
        return
}
//删除图片
function deleteImage(t) {
    var message=confirm("你确定要删除吗")
    if(message==true){
        $(t).parent().remove()
    }
    else if(message==false)
        return
}
//确认提交试卷
function paperMessIsEmpty() {
    var a=false
    //检查paperinput非空
    $("#paperMessInput input").each(function () {
        if($(this).val()==""){
            alert("输入框不能为空")
            a = true
            return false
        }
    })
    return a
}
function submitPaper () {
    if(!paperMessIsEmpty()){
        paper.date=$("#date").val()
        paper.grade=$("#grade").val()
        paper.paperDifficulty=$("#paperDifficulty").val()
        paper.paperName=$("#paperName").val()
        paper.paperSchool.schoolName=$("#paperSchool").val()
        paper.paperSubject=$("#paperSubject").val()
        //开始ajax上传paper内容，图片上传我先不搞
        $.ajax({
            url: '/api/v1/addPaper',
            type:'POST',
            contentType: "application/json; charset=utf-8",
            data: JSON.stringify(paper),
            dataType: "json",
            async: false,
            success: function (responseStr) {
                if(responseStr.status===0){
                    console.log("成功"+responseStr);
                    window.location.href = '/indexPage'
                }else{
                    alert("失败第"+responseStr.result)
                    console.log("失败"+responseStr.result);
                }
            },
            error : function(responseStr) {
                console.log("error"+responseStr);
            }
        });
    }
}