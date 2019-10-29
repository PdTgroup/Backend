package com.electricity.servlet;

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/*
    建设部: 主网工程造价准确率

    projectFinancialStatement: 工程财务决算
    approvalEstimate: 批复概算
    costAccuracy: 主网工程造价准确率

    18个指标城市准确率:
        安阳 85.57    鹤壁 82.25    济源 82.25
        焦作 82.59    开封 82.53    洛阳 81.03
        漯河 84.47    南阳 84.27    平顶山 82.25
        濮阳 81.80    三门峡 82.25  商丘 69.96
        新乡 83.13    信阳 82.25    许昌 82.38
        郑州 81.88    周口 82.25    驻马店 82.28
 */
public class CostAccuracy {
    private static double projectFinancialStatement;
    private static double approvalEstimate;
    private static double costAccuracy;
    private static int CostAccuracy;
    public String show(String[] strings,HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		
    	  Scanner sc = new Scanner(System.in);
          Map<String, Integer> zjl = new HashMap<>();     //存储各个地市和对应的造价准确率
          String[] Locals = {"安阳" ,"鹤壁", "济源", "焦作", "开封", "洛阳",
                              "漯河", "南阳", "平顶山", "濮阳", "三门峡", "商丘",
                              "新乡", "信阳", "许昌", "郑州", "周口", "驻马店"};
          DecimalFormat df = new DecimalFormat("0.0000");
         
     for (int i = 0; i <strings.length-1; i++) {
    	 Double double1=Double.parseDouble(strings[i]);
    	 costAccuracy = Double.parseDouble(df.format(double1));
         CostAccuracy = (int)(costAccuracy * 10000);
         zjl.put(Locals[i], CostAccuracy);
	}


          //利用List，将zjl中的键值对根据value值大小排序
          List<Map.Entry<String, Integer>> entryList = new ArrayList<>(zjl.entrySet());
          Collections.sort(entryList, new Comparator<Map.Entry<String, Integer>>() {
              @Override
              public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                  //按照value值从小到大
//                  return o1.getValue() - o2.getValue();

                  //按照value值从大到小
                  return o2.getValue() - o1.getValue();

                  //按照value值，用compareTo()方法默认是从小到大排序
//                  return o1.getValue().compareTo(o2.getValue());
              }
          });

          List<Integer> list = new ArrayList<>();
          int[] array = new int[entryList.size() + 1];
          array[0] = 1;
          int index = 1, k, up = 1;  //index为array数组下标
          for (Map.Entry s : entryList) {
              Integer value = (Integer) s.getValue();
              list.add(value);
          }
//          System.out.println(list);
          if (list.get(0) == list.get(1)){
              k = 1;
          }else{
              k = 0;
          }

          //将各地市进行排名
          for (int i = 1; i < list.size(); i++) {
              up++;
              if (list.get(i).equals(list.get(i-1))){
                  array[index++] = k;
              }else{
                  array[index++] = up;
                  k = up;
              }
          }

          //重置index
          index = 0;
          int pingIndex = 0;

          //遍历输出各个地市
          for (Map.Entry s : entryList) {
              System.out.println("第" + array[index++] + "名: " + s.getKey() + "-->" + ((Integer)s.getValue() / 100.0) + "%");

              //获取平顶山的排名
              if ("平顶山".equals(s.getKey())){
                  pingIndex = array[index - 1];
              }
          }
          System.out.println();
   
          System.out.println("在主网工程造价准确率中: ");
          if (pingIndex > 0 && pingIndex <= 9) {
              System.out.println("平顶山的排名为: " + pingIndex + ", 排名相对靠前, 继续保持!!!");
              String success="平顶山的排名为: " + pingIndex + ", 排名相对靠前, 继续保持!!!";
              request.setAttribute("paiming",success);
              request.getRequestDispatcher("success.jsp").forward(request,response);
              return success;
          }else {
              System.out.println("平顶山的排名为: " + pingIndex + ", 排名相对靠后, 原因为工程财务决算过少或批复概算过多。");
              String falses="平顶山的排名为: " + pingIndex + ", 排名相对靠后, 原因为工程财务决算过少或批复概算过多。";
              request.setAttribute("paiming",falses);
              request.getRequestDispatcher("success.jsp").forward(request,response);
              return falses;
          }

      }
	
    
    public static void main(String[] args) {
    	CostAccuracy c=new CostAccuracy();
//    	c.show();
    }
}
