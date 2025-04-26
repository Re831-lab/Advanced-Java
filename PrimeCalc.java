/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.calc;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

/**
 *
 * @author Dell
 */
public class PrimeCalc extends JFrame {
private JTextField txtNum; 
        private JButton btnCalc;
         private JButton btnClear;
        private JLabel lblAns;
        
    public PrimeCalc() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(300,120);
        this.setLocation(400, 300);
        this.setLayout(new BorderLayout());
        
        txtNum = new JTextField("");
        lblAns = new JLabel("");
        btnCalc = new JButton("calculat");
        btnClear = new JButton ("Clear");
        
        //فعشان اجيب الداتا من 
        //text field
        /*او من اي مكان اللي خزنت فيه الرقم بستخدم 
       get text method 
       هاد عشان اجيب الرقم */
        
        btnClear.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                
                txtNum.setText("");/* هاي بترجع القيمة على صيغة   
                string */
                lblAns.setText("");
            }
        });
        
        btnCalc.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                
                //هي سترينغ لانه القيمة اللي رجعتها سترينغ وهون انا بدي اجيب سترينغ الموجود جوا تيكست فيلد 
         String num = txtNum.getText();
         
         //هسا القيمة المفروض داخل تيكست فيلد عدد صحيح عشان هيك بستخدم رابر كلاس عشان احولها لصحيح
         int x = Integer.parseInt(num);  
         /*ParseInt هذه بتحول ال
         string to integer وبالتالي 
         هيك رقم اللي رجع كأنه 
         string 
         ورح يتحول لل 
         int 
         */
         
         
         
         //هسا هون بدي احسب البرايم تبعه وهون انا حسبته بشكل مباشرما حاطيته في ميثود 
         int count = 0;
         for (int i=1 ;i<=x ;i++){
         if (x%i==0){
             count++;
         }
         }
          //هل هو بيقسم على واحد وعلى الرقم      
          if (count==2) {//Prime
              /*2. هنا أنا بدي اغير لون الخط انه اذا كان رقم برايم يصير لون الخط زهري واذا مش برايم يصر الخط احمر وهاد االاشي بعمل 
              عن طريق 
              set foeground method 
              رح يستدعي جوا الميثود اسم 
              coloer class
              وهو عبارة عن كلاس جاهز من مكتبة awt
              وبستدعي منه اي لون */
              lblAns.setForeground(Color.GREEN);
          
          lblAns.setText(x + " is Prime");//يعني خط جوا ليبل هادي المخرج

         
          } 
          else { //Not Prime
            lblAns.setForeground(Color.red);
            //هسا زي ما انت ملاحظ في الوان محددة هون بس انا بقدر استخدم الوان مختلفة بس عن طريق اسمه صيغة ار جي بي 
            lblAns.setForeground(new Color(200,50,100));//اجا شيء بني محمر المهم هاد ماشي على مبدا احمر اخضر ازرق انا مزود الاحمر جشوي عشان هيك والازرق فغمق اكثر 
            lblAns.setText(x + " is not prime");//اذا لا حط جوا ليبل هاد المخرج 
            }      
                
            }
        });
        
        //اخر شيء بدي اعمله هو انه اخلي الكتابة تظهر بالنص بدل ما تظهرلي على الجهة اليسرى 
      /*عشان هيك بستخدم خاصية 
      setHorizonatalAlignment
      بكتب جوا هاد الكلاس ميثود اسمه 
      swing constants
      وهاد كلاس من الاشياء الي بتوفرها مكتبة الجافا وبستدعي منه  السينتر */
     txtNum.setHorizontalAlignment(SwingConstants.CENTER);
     //وهيك بيكون حط نصي بالمنتصف

     //برضو بدي اعملها لليبل 
     lblAns.setHorizontalAlignment(SwingConstants.CENTER);
        //عملت بانيل وحطيتهم فيهم
     JPanel panelNorth = new JPanel();
     //صفين وعامود 
      panelNorth.setLayout(new GridLayout(2,1));
      panelNorth.add(txtNum);
      panelNorth.add(lblAns);
      
      //هاد بانيل ثانية فيها الازرار
      JPanel panelSouth = new JPanel();
      panelSouth.setLayout(new FlowLayout()); 
      panelSouth.add(btnCalc);
      //هسا بدي لما اكبس على هاد الزر يدخل رقم ويطبعه في نص
      panelSouth.add(btnClear);
      
      
      
      
//نضيفهم للفريم
      this.add(panelNorth, BorderLayout.NORTH);
      this.add(panelSouth, BorderLayout.SOUTH);  
      
      
      this.setVisible(true);
    }
    
}
