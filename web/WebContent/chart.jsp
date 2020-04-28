<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ page import="java.util.ArrayList"%>
<%@ page import="java.util.HashMap"%>
<%@ page import="java.util.List"%>
<%@ page import="java.util.Map"%>
<% Map<String,Object> examineeInfo = (Map<String,Object>)request.getAttribute("ExamineeInfo"); %>
<html lang="ja">
<style>
.table1, .table2, .table11 {
  border-collapse: collapse;
  width: 1000px;
}
.table6, .table7 {
  border-collapse: collapse;
  width: 400px;
}
.table1 th, .table1 td, .table3 th, .table4 th, .table4 td, .table7 th {
  border: 1px solid gray;
  text-align: center;
}
.table11 th, .table11 td{
  border: 1px solid gray;
}
.table1 th, .table4 th, .table7 th, .table11 th {
  background-color: #F2F2F2;
}
.table2 th, .table6 th {
  background-color: gray;
}
.table3 {
  border-collapse: collapse;
  width: 1400px;
}
.table4 {
  border-collapse: collapse;
  height: 100px;
  width: 250px;
}
</style>
<head>
  <meta charset="utf-8">
　<title>診断表</title>
</head>
<body>
<div style="position:absolute; top:5px;">
<table class="table3">
<th>診断表</th>
</table>
</div>
<div style="position:absolute; top:35px;">
<table class="table1">
<th>氏名</th><td><%=examineeInfo.get("name")%></td>
<th>受験日</th><td><%=examineeInfo.get("date")%></td>
<th>最終学歴</th><td><%=examineeInfo.get("edu")%></td>
</table>
<table class="table1">
<tr><th>性別</th><td><%=examineeInfo.get("gender")%></td>
<th>生年月日</th><td><%=examineeInfo.get("birth")%></td>
<th>年齢</th><td><%=examineeInfo.get("age")%></td></tr>
</table>
<br>
<table class="table2" style="color:#ffffff">
<tr><th>総合診断</th></tr>
</table>
<table>
<tr>
<td>
<table class="table4">
<tr><th rowspan="2">全体正答数<br>（全１６０問）</th><th>正答数</th><th>換算点</th></tr>
<tr><td><%=examineeInfo.get("correctNumTotal")%></td><td><%=examineeInfo.get("conScoreCor")%></td></tr>
<tr><th rowspan="2">全体解答数<br>（全１６０問）</th><th>解答数</th><th>換算点</th></tr>
<tr><td><%=examineeInfo.get("answersNumTotal")%></td><td><%=examineeInfo.get("conScoreAns")%></td></tr>
</table>
</td>
<td>
<table class="table4">
<tr><th rowspan="2">全体正答率<br></th><th>正答率</th><th>評価</th></tr>
<tr><td><%=examineeInfo.get("correctRate")%></td><td><%=examineeInfo.get("eval")%></td></tr>
</table>
</td>
</tr>
</table>
<br>
<table class="table2" style="color:#ffffff">
<tr><th>個別能力測定</th></tr>
</table>
<table class="table11">
<tr><td align="center">診断項目</td><td align="center">診断内容</td><td align="center">解答数</td><td align="center">正解数</td><td align="center">正答率</td><td align="center">換算点</td></tr>
<tr><td align="center">言語<br>テスト１＋３</td><td>言語的思考を進める為の学習力があるかどうか</td><td align="center"><%=examineeInfo.get("answersNumLang")%></td><td align="center"><%=examineeInfo.get("correctNumLang")%></td><td align="center"><%=examineeInfo.get("correctRateLang")%></td><td align="center"><%=examineeInfo.get("conScoreLang")%></td></tr>
<tr><td align="center">数理<br>テスト２＋４</td><td>数理的、記号的思考を進めるための基礎学力があるかどうか</td><td align="center"><%=examineeInfo.get("answersNumMath")%></td><td align="center"><%=examineeInfo.get("correctNumMath")%></td><td align="center"><%=examineeInfo.get("correctRateMath")%></td><td align="center"><%=examineeInfo.get("conScoreMath")%></td></tr>
<tr><td align="center">テスト１<br>（文章把握）</td><td>接続詞や言葉の言い回しから文章を理解できるかどうか</td><td align="center"><%=examineeInfo.get("answersNum1")%></td><td align="center"><%=examineeInfo.get("correctNum1")%></td><td align="center"><%=examineeInfo.get("correctRate1")%></td><td align="center">-</td></tr>
<tr><td align="center">テスト2<br>（四則演算）</td><td>基礎的な計算ができるか</td><td align="center"><%=examineeInfo.get("answersNum2")%></td><td align="center"><%=examineeInfo.get("correctNum2")%></td><td align="center"><%=examineeInfo.get("correctRate2")%></td><td align="center">-</td></tr>
<tr><td align="center">テスト3<br>（言語推論）</td><td>複数の言葉が持つ関係性を推測できるかどうか、語彙が豊富かどうか</td><td align="center"><%=examineeInfo.get("answersNum3")%></td><td align="center"><%=examineeInfo.get("correctNum3")%></td><td align="center"><%=examineeInfo.get("correctRate3")%></td><td align="center">-</td></tr>
<tr><td align="center">テスト4<br>（数列）</td><td>数を用いた一定のルールを見つけることができるかどうか</td><td align="center"><%=examineeInfo.get("answersNum4")%></td><td align="center"><%=examineeInfo.get("correctNum4")%></td><td align="center"><%=examineeInfo.get("correctRate4")%></td><td align="center">-</td></tr>
</table>
<br><br>
<table class="table11">
<tr><th colspan="3">■評価Ⅰ　基礎能力（言語・数理）の特徴</th><th colspan="3">■評価Ⅱ　解答の量と正確さ</th></tr>
<tr><td>1</td><td>基礎能力が高い</td><td>偏りはなく同室集団の中では基礎能力は高い</td><td>1</td><td>速くて正確</td><td>解答量も多く、解答した内容も正確で、<br>能力は高い</td></tr>
<tr><td>2</td><td>標準</td><td>能力は標準で、特に偏りもない</td><td>2</td><td>標準</td><td>解答量、正答率ともに標準で、<br>目立った特徴はない</td></tr>
<tr><td>3</td><td>基礎能力が低い</td><td>全体的に正答数が少なく、<br>基礎能力は平均的に低い</td><td>3</td><td>遅くて不正確</td><td>全体的に解答量は少ない、またその正答率も低い</td></tr>
<tr><td>4</td><td>数理的素養に長ける</td><td>数、論理を扱う能力が偏って高い</td><td>4</td><td>遅いが正確</td><td>一つ一つの解答は遅いが正確である</td></tr>
<tr><td>5</td><td>言語要素に長ける</td><td>言語を扱う基礎能力が偏って高い</td><td>5</td><td>不正確だが速い</td><td>解答に間違いは散見されるが、解答量は多い</td></tr>
</table>
</div>
<div style="position:absolute; top:35px; left:1007px;">
<table class="table6" style="color:#ffffff">
<th>能力評価票</th>
</table>
<table class="table7">
<th>■評価Ⅰ　基礎能力（言語・数理）の特徴</th>
</table>
</div>
<div style="position:absolute; top:500px; left:1007px;">
<table class="table7">
<th>■評価Ⅱ　解答の量と正確さ</th>
</table>
</div>
<div style="position:absolute; top:105px; left:1042px; width:200px; height:5px; font-size:8pt; color:gray;">
数理的要素に長ける
</div>
<div style="position:absolute; top:105px; left:1315px; width:200px; height:5px; font-size:8pt; color:gray;">
基礎能力が高い
</div>
<div style="position:absolute; top:440px; left:1042px; width:200px; height:5px; font-size:8pt; color:gray;">
基礎能力が低い
</div>
<div style="position:absolute; top:440px; left:1295px; width:200px; height:5px; font-size:8pt; color:gray;">
言語的能力に長ける
</div>
<div style="position:absolute; top:270px; left:1205px; width:200px; height:5px; font-size:8pt; color:gray;">
標準
</div>

<div style="position:absolute; top:540px; left:1045px; width:200px; height:5px; font-size:8pt; color:gray;">
遅いが正確
</div>
<div style="position:absolute; top:540px; left:1335px; width:200px; height:5px; font-size:8pt; color:gray;">
速くて正確
</div>
<div style="position:absolute; top:880px; left:1045px; width:200px; height:5px; font-size:8pt; color:gray;">
遅くて不正確
</div>
<div style="position:absolute; top:880px; left:1310px; width:200px; height:5px; font-size:8pt; color:gray;">
不正確だが速い
</div>
<div style="position:absolute; top:710px; left:1205px; width:200px; height:5px; font-size:8pt; color:gray;">
標準
</div>
<div style="position:absolute; top:90px; left:1007px; width:400px; height:400px;">
  <canvas id="myLineChart"></canvas>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.7.2/Chart.bundle.js"></script>

  <script>
  var ctx = document.getElementById('myLineChart').getContext('2d');
  ctx.canvas.height = 1;
  ctx.canvas.width = 1;
  var myLineChart = new Chart(ctx, {
    type: 'scatter',
    data: {
      datasets: [
        {
          data: [{x:<%=examineeInfo.get("conScoreLang")%>, y:<%=examineeInfo.get("conScoreMath")%>}],
          borderColor: "rgba(0,0,255,1)",
          backgroundColor: "rgba(0,0,255,1)"
        }
      ],
    },
    options: {
      legend: {
        display: false
      },
      scales: {
        xAxes: [{
          ticks: {
            suggestedMax: 80,
            suggestedMin: 20,
            stepSize: 20,
            callback: function(value, index, values){
              return  value
            }
          }
        }],
        yAxes: [{
          ticks: {
            suggestedMax: 80,
            suggestedMin: 20,
            stepSize: 20,
            callback: function(value, index, values){
              return  value
            }
          }
        }]
      },
    }
  });
  </script>
  </div>

  <div style="position:absolute; top:530px; left:1007px; width:400px; height:400px;">
  <canvas id="myLineChart2"></canvas>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.7.2/Chart.bundle.js"></script>

  <script>
  var ctx = document.getElementById('myLineChart2').getContext('2d');
  ctx.canvas.height = 1;
  ctx.canvas.width = 1;
  var myLineChart = new Chart(ctx, {
    type: 'scatter',
    data: {
      datasets: [
        {
          data: [{x:<%=examineeInfo.get("conScoreAns")%>, y:<%=examineeInfo.get("correctRateNum")%>}],
          borderColor: "rgba(0,0,255,1)",
          backgroundColor: "rgba(0,0,255,1)"
        }
      ],
    },
    options: {
      legend: {
        display: false
      },
      scales: {
        xAxes: [{
          ticks: {
            suggestedMax: 80,
            suggestedMin: 20,
            stepSize: 20,
            callback: function(value, index, values){
              return  value
            }
          }
        }],
        yAxes: [{
          ticks: {
            suggestedMax: 100.00,
            suggestedMin: 70.00,
            stepSize: 10,
            callback: function(value, index, values){
              return  value
            }
          }
        }]
      },
    }
  });
  </script>
  </div>
</body>

</html>