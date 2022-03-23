var username = localStorage.getItem('loginCode');
garbageTrue_math = 0;
garbageFalse_math = 0;

/*按下开始键，start（）---> Math.randon()*garbageJson.length  [0,1]之间的数，[0,length]。
图片开始随机跳动。    按下停止，stop()，一轮游戏开始，circle_start=1，鼠标移动到垃圾桶，变成鼠标手，点击时进行答案比对。
对的题目，错的题目，统计出百分比， */

function localStorage_text() {
    alert("欢迎进入小游戏!您共可以进行10轮游戏,答对9次即可通关！");
}

const vm = new Vue({
    el: '#Container',
    data: {
        handFlag: 0,
        clickflag: 0,
        handmove: -1,
        Answer_Flag: false,
        game_total: 0,
        game_True: 0,
        game_False: 0,
        circulation_start: 1,
        question_number: 0,
        resultFlag_1: 0,
        resultFlag_2: 0,
        resultFlag_3: 0,
        resultFlag_4: 0,
        lotteryNumber: 0,
        lotteryTimer: null,
        garbageJson : "",
        garbageResult : "",
        garbageName: "请点击开始",
        game_result: 0,
    },
    mounted: function () {
        this.getGarbage();
    },
    methods: {
        getGarbage: function () {
            let _this = this;
            axios.get('../api/game/query').then(function (response) {
                _this.garbageJson = response.data.listGarbage;
            }).catch(function (error) {
                console.log(error);
            });
        },

        sorting: function (garbageType, garbageNum) {
            let postData = new FormData();
            postData.append("garbageId",this.lotteryNumber);
            let _this = this;
           // 把lotteryNumber放入postData，通过axios传入后端，进行‘结果查询’，再得到返回结果response
            axios.post('../api/game/resultQuery',postData).then(function (response) {
                _this.garbageResult = response.data;
                //alert(_this.garbageResult.sortName);
                _this.handmove = -1;
                _this.resultFlag_1 = 0;
                _this.resultFlag_2 = 0;
                _this.resultFlag_3 = 0;
                _this.resultFlag_4 = 0;
                _this.question_number = _this.question_number - 1;
                if (_this.question_number == 0) {
                    if (_this.garbageResult.sortName == garbageType) {
                        if (garbageNum == 1) {
                            _this.resultFlag_1 = 1;
                        } else if (garbageNum == 2) {
                            _this.resultFlag_2 = 2;
                        } else if (garbageNum == 3) {
                            _this.resultFlag_3 = 3;
                        } else if (garbageNum == 4) {
                            _this.resultFlag_4 = 4;
                        }
                        if (_this.question_number == 0) {
                            _this.game_True = _this.game_True + 10;
                        }
                        _this.$message.success("恭喜您！回答正确！");
                    } else {
                        if (_this.garbageResult.sortName == '厨余垃圾') {
                            _this.resultFlag_1 = 1;
                            _this.resultFlag_2 = -1;
                            _this.resultFlag_3 = -1;
                            _this.resultFlag_4 = -1;
                        } else if (_this.garbageResult.sortName == '可回收物') {
                            _this.resultFlag_1 = -1;
                            _this.resultFlag_2 = 2;
                            _this.resultFlag_3 = -1;
                            _this.resultFlag_4 = -1;
                        } else if (_this.garbageResult.sortName == '其他垃圾') {
                            _this.resultFlag_1 = -1;
                            _this.resultFlag_2 = -1;
                            _this.resultFlag_3 = 3;
                            _this.resultFlag_4 = -1;
                        } else if (_this.garbageResult.sortName == '有害垃圾') {
                            _this.resultFlag_1 = -1;
                            _this.resultFlag_2 = -1;
                            _this.resultFlag_3 = -1;
                            _this.resultFlag_4 = 4;
                        }
                        if (_this.question_number == 0) {
                            _this.game_False = _this.game_False + 10;
                        }
                        _this.$message.error("很可惜，回答错了，答案是" + _this.garbageResult.sortName);
                    }
                } else {
                    _this.$message({
                        message: '请点击开始进行下一轮游戏！',
                        type: 'warning'
                    });
                }

                if (_this.game_total == 100) {

                    _this.$alert('游戏结束', '请等待结果评测', {
                        confirmButtonText: '确定',
                    });
                    garbageTrue_math = _this.game_True;
                    garbageFalse_math = _this.game_False;
                    True_percent = garbageTrue_math / 100 * 100;
                    //在这里把显示的内容填进去，在后面进行显示和不显示
                    document.getElementById("login_False_text").innerText = "不好意思！本次游戏失败! 您的正确率" + True_percent + "%"
                    document.getElementById("login_true_text").innerText = "恭喜您！成功通过游戏! 您的正确率为" + True_percent + "%"
                    localStorage.setItem("garbageright_math", garbageTrue_math);
                    localStorage.setItem("garbagewrong_math", garbageFalse_math);
                    setTimeout(function () {
                        document.getElementById("garbage").style.display = "none";
                        document.getElementById("loading").style.display = "block";
                    }, 2000);

                    if (_this.game_True >= 90) {
                        setTimeout(function () {
                            document.getElementById("loginTrue").style.display = "block";
                            document.getElementById("loading").style.display = "none";
                        }, 3000);
                    } else {
                        setTimeout(function () {
                            document.getElementById("loginFalse").style.display = "block";
                            document.getElementById("loading").style.display = "none";
                        }, 3000);
                    }

                }
            })

        }

        ,
        enter: function (garbageNum) {
            if (this.handmove == 0) {
                this.handFlag = garbageNum;
            }

        },/*绑定mouseenter事件*/
        leave: function () {
            this.handFlag = 0;
        },/*绑定mouseleave事件*/

        lottery: function () {

            this.lotteryNumber = Math.floor(Math.random() * this.garbageJson.length);
            this.garbageName = this.garbageJson[this.lotteryNumber].garbageName;
        },
        start: function () {
            if (this.question_number == 1) {
                this.$message({
                    message: '请作答！',
                    iconClass: "el-icon-bell"
                });
            } else {
                this.resultFlag = 0;
                if (!this.lotteryTimer) {
                    //setInterval，不停地调用函数，间隔0.1s，后面stop（）会停止
                    this.lotteryTimer = setInterval(this.lottery, 100);
                }
                this.handmove = -1;
                this.resultFlag_1 = 0;
                this.resultFlag_2 = 0;
                this.resultFlag_3 = 0;
                this.resultFlag_4 = 0;
                this.circulation_start = 1;
                this.clickflag = 0;
                this.Answer_Flag = false;
            }
        },
        stop: function () {
            if (this.circulation_start == 1) {
                clearInterval(this.lotteryTimer);
                this.lotteryTimer = null;
                this.handmove = 0;/*停止时出现小手*/
                this.resultFlag_1 = 0;
                this.resultFlag_2 = 0;
                this.resultFlag_3 = 0;
                this.resultFlag_4 = 0;
                this.circulation_start = this.circulation_start - 1;/*点击一次停止进行一轮游戏*/
                this.game_total = this.game_total + 10;
                this.question_number = 1;
                this.clickflag = 1;/*点击判断事件*/
                this.Answer_Flag = true;/*图片的小手判断*/
                this.$message({
                    message: '请开始作答！',
                    iconClass: "el-icon-s-promotion"
                });
            } else if (this.circulation_start <= 0) {
                this.$message({
                    message: '请点击开始进行下一轮游戏！',
                    type: 'warning'
                });
            }
            if (this.game_total == 100) {
                this.$notify({
                    title: '加油,还剩最后一局！',
                    message: '把握最后的机会！',
                    duration: 0
                });
            }
        },
        goBack() {
            location.href = '../index.html';
        },
        login() {
            location.href = '../pages/loginelement.html';
        },

    }
});