import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BankServlet extends HttpServlet {
    private Bank bank; /* 口座の管理をするオブジェクト */

    public BankServlet() {  /* bankを初期化する */
        bank = new Bank();
    } 
    
    public void doGet(HttpServletRequest request, HttpServletResponse response) 
        throws IOException, ServletException { 
        int return_num; //返り値を格納する変数
        String user_name; //ユーザーの名前を格納する変数
        int user_balance; //ユーザーの残高を格納する変数
        String user_amount; //ユーザーの金額に関する変数

        String command = request.getParameter("command");//commandに値を入れる
        
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter pw = response.getWriter();


        if(command.equals("open")){//openの処理

            String button = request.getParameter("cmd");
            if(button.equals("OK")){
                user_name = request.getParameter("name");
                return_num=bank.open(user_name);
                /* 口座開設処理 */
                if(return_num == 0) {
                    /* 口座開設成功のHTML生成*/
                    pw.println("<!DOCTYPE html>");
                    pw.println("<html lang=ja>");
                    pw.println("<head>");
                    pw.println("<meta charset=UTF-8>"); 
                    pw.println("<link rel=stylesheet href=style.css>");
                    pw.println("<title>口座開設成功画面</title>");      
                    pw.println("</head>");    
                    pw.println("<body>");  
                    pw.println("<h1><font color=#F00#>口座開設成功画面</font></h1>");
                    pw.println("<br>");    
                    pw.println("<p>"+user_name+"様の口座の開設に成功しました。</p>");
                    pw.println("<div class='btn-menu'>");
                    pw.println("<button onclick=location.href='index.html' style=width:150px;height:50px ><font size=4>メニューに戻る</font></button>"); 
                    pw.println("</div>");
                    pw.println("</body>");   
                    pw.println("</html>");
                } else if(return_num == -7){ 
                    /*口座開設失敗のHTML生成 */
                    pw.println("<!DOCTYPE html>");
                    pw.println("<html lang=ja>");
                    pw.println("<head>");
                    pw.println("<meta charset=UTF-8>");
                    pw.println("<link rel=stylesheet href=style.css>");
                    pw.println("<title>口座開設失敗画面</title>");
                    pw.println("</head>");
                    pw.println("<body>");
                    pw.println("<h1><font color=#F00#>口座開設失敗画面</font></h1>");
                    pw.println("<br>");
                    pw.println("<p>"+user_name+"様の口座の開設に失敗しました。("+user_name+"様の口座はすでに開設されています！)</p>");
                    pw.println("<div class='btn-menu'>");
                    pw.println("<button onclick=location.href='index.html' style=width:150px;height:50px ><font size=4>メニューに戻る</font></button>");
                    pw.println("</div>");
                    pw.println("</body>");
                    pw.println("</html>");
                }
                
            }else if(button.equals("CANCEL")){
                /*キャンセル画面*/
                pw.println("<!DOCTYPE html>");
                pw.println("<html lang=ja>");
                pw.println("<link rel=stylesheet href=style.css>");
                pw.println("<head><title>キャンセル画面</title></head>");
                pw.println("<body>");
                pw.println("<h1><font color=#F00#>口座開設をキャンセルしました</font></h1>");
                pw.println("<div class='btn-menu'>");
                pw.println("<button onclick=location.href='index.html' style=width:150px;height:50px ><font size=4>メニューに戻る</font></button>");
                pw.println("</div>");
                pw.println("</body></html>");
            
            }else{
                /*不明画面*/
                pw.println("<!DOCTYPE html>");
                pw.println("<html lang=ja>");
                pw.println("<link rel=stylesheet href=style.css>");
                pw.println("<head><title>不明</title></head>");
                pw.println("<body>");
                pw.println("<h1><font color=#F00#>不明なボタンがクリックされました</font></h1>");
                pw.println("<div class='btn-menu'>");
                pw.println("<p><a href='index.html'>メニューに戻る</a></p>");
                pw.println("</div>");
                pw.println("</body></html>");
            }
       
        
        }else if(command.equals("close")){//closeの処理

            String button = request.getParameter("cmd");
            if(button.equals("OK")){
                user_name = request.getParameter("name");
                return_num=bank.close(user_name);
                /* 口座解約処理 */
                if(return_num == 0) {
                    /*口座解約成功のHTML生成*/
                    pw.println("<!DOCTYPE html>");
                    pw.println("<html lang=ja>");
                    pw.println("<head>");
                    pw.println("<meta charset=UTF-8>");
                    pw.println("<link rel=stylesheet href=style.css>");
                    pw.println("<title>口座解約成功画面</title>");
                    pw.println("</head>");
                    pw.println("<body>");
                    pw.println("<h1><font color=#F00#>口座解約成功画面</font></h1>");
                    pw.println("<br>");
                    pw.println("<p>"+user_name+"様の口座の解約に成功しました。</p>");
                    pw.println("<div class='btn-menu'>");
                    pw.println("<button onclick=location.href='index.html' style=width:150px;height:50px ><font size=4>メニューに戻る</font></button>");
                    pw.println("</div>");
                    pw.println("</body>");
                    pw.println("</html>");
                } else if(return_num == -1){
                    /*口座解約失敗(残高有り)のHTML生成 */
                    pw.println("<!DOCTYPE html>");
                    pw.println("<html lang=ja>");
                    pw.println("<head>");
                    pw.println("<meta charset=UTF-8>");
                    pw.println("<link rel=stylesheet href=style.css>");
                    pw.println("<title>口座解約失敗画面</title>");
                    pw.println("</head>");
                    pw.println("<body>");
                    pw.println("<h1><font color=#F00#>口座解約失敗画面</font></h1>");
                    pw.println("<br>");
                    pw.println("<p>"+user_name+"様の口座の解約に失敗しました。("+user_name+"様の口座にはまだ残高が残っています！)</p>");
                    pw.println("<div class='btn-menu'>");
                    pw.println("<button onclick=location.href='index.html' style=width:150px;height:50px ><font size=4>メニューに戻る</font></button>");
                    pw.println("</div>");
                    pw.println("</body>");
                    pw.println("</html>");
                }else if(return_num == -7){
                    /*口座解約失敗(口座無し)のHTML生成 */
                    pw.println("<!DOCTYPE html>");
                    pw.println("<html lang=ja>");
                    pw.println("<head>");
                    pw.println("<meta charset=UTF-8>");
                    pw.println("<link rel=stylesheet href=style.css>");
                    pw.println("<title>口座解約失敗画面</title>");
                    pw.println("</head>");
                    pw.println("<body>");
                    pw.println("<h1><font color=#F00#>口座解約失敗画面</font></h1>");
                    pw.println("<br>");
                    pw.println("<p>"+user_name+"様の口座の解約に失敗しました。("+user_name+"様の口座はリストに存在しません！)</p>");
                    pw.println("<div class='btn-menu'>");
                    pw.println("<button onclick=location.href='index.html' style=width:150px;height:50px ><font size=4>メニューに戻る</font></button>");
                    pw.println("</div>");
                    pw.println("</body>");
                    pw.println("</html>");
                }
            }else if(button.equals("CANCEL")){
                /*キャンセル画面*/
                pw.println("<!DOCTYPE html>");
                pw.println("<html lang=ja>");
                pw.println("<link rel=stylesheet href=style.css>");
                pw.println("<head><title>キャンセル画面</title></head>");
                pw.println("<body>");
                pw.println("<h1><font color=#F00#>口座解約をキャンセルしました</font></h1>");
                pw.println("<div class='btn-menu'>");
                pw.println("<button onclick=location.href='index.html' style=width:150px;height:50px ><font size=4>メニューに戻る</font></button>");
                pw.println("</div>");
                pw.println("</body></html>");
            }else{
                /*不明画面*/
                pw.println("<!DOCTYPE html>");
                pw.println("<html lang=ja>");
                pw.println("<link rel=stylesheet href=style.css>");
                pw.println("<head><title>不明</title></head>");
                pw.println("<body>");
                pw.println("<h1><font color=#F00#>不明なボタンがクリックされました</font></h1>");
                pw.println("<div class='btn-menu'>");
                pw.println("<p><a href='index.html'>メニューに戻る</a></p>");
                pw.println("</div>");
                pw.println("</body></html>");
            } 
       
        }else if(command.equals("deposit")){//depositの処理
            String button = request.getParameter("cmd");
            if(button.equals("OK")){
                user_name = request.getParameter("name");
                user_amount = request.getParameter("amount");
                
                return_num = bank.deposit(user_name,user_amount);
                user_balance = bank.showBalance(user_name);
                
                /* 預金処理 */
                if(return_num == 0) {
                    /* 預金成功のHTML生成*/
                    pw.println("<!DOCTYPE html>");
                    pw.println("<html lang=ja>");
                    pw.println("<head>");
                    pw.println("<meta charset=UTF-8>");
                    pw.println("<link rel=stylesheet href='style.css'>");
                    pw.println("<title>預金成功画面</title>");
                    pw.println("</head>");
                    pw.println("<body>");
                    pw.println("<h1><font color=#F00#>預金成功画面</font></h1>");
                    pw.println("<br>");
                    pw.println("<p>"+user_name+"様の口座への"+user_amount+"円の預金に成功し、残高は"+user_balance+"円となりました。</p>");
                    pw.println("<div class='btn-menu'>");
                    pw.println("<button onclick=location.href='index.html' style=width:150px;height:50px ><font size=4>メニューに戻る</font></button>");
                    pw.println("</div>");
                    pw.println("</body>");
                    pw.println("</html>");
                }else if(return_num == -3){
                    /*預金失敗(0以下の預金)のHTML生成 */
                    pw.println("<!DOCTYPE html>");
                    pw.println("<html lang=ja>");
                    pw.println("<head>");
                    pw.println("<meta charset=UTF-8>");
                    pw.println("<link rel=stylesheet href='style.css'>");
                    pw.println("<title>預金失敗画面</title>");
                    pw.println("</head>");
                    pw.println("<body>");
                    pw.println("<h1><font color=#F00#>預金失敗画面</font></h1>");
                    pw.println("<br>");
                    pw.println("<p>"+user_name+"様の口座に"+user_amount+"円という金額は預金できません！</p>");
                    pw.println("<div class='btn-menu'>");
                    pw.println("<button onclick=location.href='index.html' style=width:150px;height:50px ><font size=4>メニューに戻る</font></button>");
                    pw.println("</div>");
                    pw.println("</body>");
                    pw.println("</html>");
                }else if(return_num == -4){
                    /*預金失敗(整数でない時)のHTML生成 */
                    pw.println("<!DOCTYPE html>");
                    pw.println("<html lang=ja>");
                    pw.println("<head>");
                    pw.println("<meta charset=UTF-8>");
                    pw.println("<link rel=stylesheet href='style.css'>");
                    pw.println("<title>預金失敗画面</title>");
                    pw.println("</head>");
                    pw.println("<body>");
                    pw.println("<h1><font color=#F00#>預金失敗画面</font></h1>");
                    pw.println("<br>");
                    pw.println("<p>"+user_amount+"は整数でないため、"+user_name+"様の口座に預金できません！</p>");
                    pw.println("<div class='btn-menu'>");
                    pw.println("<button onclick=location.href='index.html' style=width:150px;height:50px ><font size=4>メニューに戻る</font></button>");
                    pw.println("</div>");
                    pw.println("</body>");
                    pw.println("</html>");
                }else if(return_num == -7){
                    /*預金失敗(null)のHTML生成 */
                    pw.println("<!DOCTYPE html>");
                    pw.println("<html lang=ja>");
                    pw.println("<head>");
                    pw.println("<meta charset=UTF-8>");
                    pw.println("<link rel=stylesheet href=style.css>");
                    pw.println("<title>預金失敗画面</title>");
                    pw.println("</head>");
                    pw.println("<body>");
                    pw.println("<h1><font color=#F00#>預金失敗画面</font></h1>");
                    pw.println("<br>");
                    pw.println("<p>"+user_name+"様の口座への"+user_amount+"円の預金は失敗しました。("+user_name+"様の口座はリストに存在しません！)</p>");
                    pw.println("<div class='btn-menu'>");
                    pw.println("<button onclick=location.href='index.html' style=width:150px;height:50px ><font size=4>メニューに戻る</font></button>");
                    pw.println("</div>");
                    pw.println("</body>");
                    pw.println("</html>");
                }
            }else if(button.equals("CANCEL")){
                /*キャンセル画面*/
                pw.println("<!DOCTYPE html>");
                pw.println("<html lang=ja>");
                pw.println("<link rel=stylesheet href=style.css>");
                pw.println("<head><title>キャンセル画面</title></head>");
                pw.println("<body>");
                pw.println("<h1><font color=#F00#>預金をキャンセルしました</font></h1>");
                pw.println("<div class='btn-menu'>");
                pw.println("<button onclick=location.href='index.html' style=width:150px;height:50px ><font size=4>メニューに戻る</font></button>");
                pw.println("</div>");
                pw.println("</body></html>");
            }else{
                /*不明画面*/
                pw.println("<!DOCTYPE html>");
                pw.println("<html lang=ja>");
                pw.println("<link rel=stylesheet href=style.css>");
                pw.println("<head><title>不明</title></head>");
                pw.println("<body>");
                pw.println("<h1><font color=#F00#>不明なボタンがクリックされました</font></h1>");
                pw.println("<div class='btn-menu'>");
                pw.println("<p><a href='index.html'>メニューに戻る</a></p>");
                pw.println("</div>");
                pw.println("</body></html>");
            }

        }else if(command.equals("withdraw")){
            String button = request.getParameter("cmd");
            if(button.equals("OK")){
                user_name = request.getParameter("name");
                user_amount = request.getParameter("amount");

                return_num = bank.withdraw(user_name,user_amount);
                user_balance = bank.showBalance(user_name);

                /* 引き出し処理 */
                if(return_num == 0) {
                    /* 引き出し成功のHTML生成*/
                    pw.println("<!DOCTYPE html>");
                    pw.println("<html lang=ja>");
                    pw.println("<head>");
                    pw.println("<meta charset=UTF-8>");
                    pw.println("<link rel=stylesheet href='style.css'>");
                    pw.println("<title>引き出し成功画面</title>");
                    pw.println("</head>");
                    pw.println("<body>");
                    pw.println("<h1><font color=#F00#>引き出し成功画面</font></h1>");
                    pw.println("<br>");
                    pw.println("<p>"+user_name+"様の口座への"+user_amount+"円の引き出しに成功し、残高は"+user_balance+"円となりました。</p>");
                    pw.println("<div class='btn-menu'>");
                    pw.println("<button onclick=location.href='index.html' style=width:150px;height:50px ><font size=4>メニューに戻る</font></button>");
                    pw.println("</div>");
                    pw.println("</body>");
                    pw.println("</html>");
                }else if(return_num == -1) {
                    /* 引き出し失敗(残高を超える引き出し)のHTML生成*/
                    pw.println("<!DOCTYPE html>");
                    pw.println("<html lang=ja>");
                    pw.println("<head>");
                    pw.println("<meta charset=UTF-8>");
                    pw.println("<link rel=stylesheet href='style.css'>");
                    pw.println("<title>引き出し失敗画面</title>");
                    pw.println("</head>");
                    pw.println("<body>");
                    pw.println("<h1><font color=#F00#>引き出し失敗画面</font></h1>");
                    pw.println("<br>");
                    pw.println("<p>"+user_name+"様の口座への"+user_amount+"円の引き出しは、残高を超えるため、失敗しました。(残高は"+user_balance+"円です。)</p>");
                    pw.println("<div class='btn-menu'>");
                    pw.println("<button onclick=location.href='index.html' style=width:150px;height:50px ><font size=4>メニューに戻る</font></button>");
                    pw.println("</div>");
                    pw.println("</body>");
                    pw.println("</html>");
                }else if(return_num == -3){
                    /*引き出し失敗(0以下の預金)のHTML生成 */
                    pw.println("<!DOCTYPE html>");
                    pw.println("<html lang=ja>");
                    pw.println("<head>");
                    pw.println("<meta charset=UTF-8>");
                    pw.println("<link rel=stylesheet href='style.css'>");
                    pw.println("<title>引き出し失敗画面</title>");
                    pw.println("</head>");
                    pw.println("<body>");
                    pw.println("<h1><font color=#F00#>引き出し失敗画面</font></h1>");
                    pw.println("<br>");
                    pw.println("<p>"+user_name+"様の口座に"+user_amount+"円という金額は引き出しできません！</p>");
                    pw.println("<div class='btn-menu'>");
                    pw.println("<button onclick=location.href='index.html' style=width:150px;height:50px ><font size=4>メニューに戻る</font></button>");
                    pw.println("</div>");
                    pw.println("</body>");
                    pw.println("</html>");
                }else if(return_num == -4){
                    /*引き出し失敗(整数でない時)のHTML生成 */
                    pw.println("<!DOCTYPE html>");
                    pw.println("<html lang=ja>");
                    pw.println("<head>");
                    pw.println("<meta charset=UTF-8>");
                    pw.println("<link rel=stylesheet href='style.css'>");
                    pw.println("<title>引き出し失敗画面</title>");
                    pw.println("</head>");
                    pw.println("<body>");
                    pw.println("<h1><font color=#F00#>引き出し失敗画面</font></h1>");
                    pw.println("<br>");
                    pw.println("<p>"+user_amount+"は整数でないため、"+user_name+"様の口座から引き出しできません！</p>");
                    pw.println("<div class='btn-menu'>");
                    pw.println("<button onclick=location.href='index.html' style=width:150px;height:50px ><font size=4>メニューに戻る</font></button>");
                    pw.println("</div>");
                    pw.println("</body>");
                    pw.println("</html>");
                }else if(return_num == -7){
                    /*引き出し失敗(null)のHTML生成 */
                    pw.println("<!DOCTYPE html>");
                    pw.println("<html lang=ja>");
                    pw.println("<head>");
                    pw.println("<meta charset=UTF-8>");
                    pw.println("<link rel=stylesheet href=style.css>");
                    pw.println("<title>引き出し失敗画面</title>");
                    pw.println("</head>");
                    pw.println("<body>");
                    pw.println("<h1><font color=#F00#>引き出し失敗画面</font></h1>");
                    pw.println("<br>");
                    pw.println("<p>"+user_name+"様の口座への"+user_amount+"円の引き出しは失敗しました。("+user_name+"様の口座はリストに存在しません！)</p>");
                    pw.println("<div class='btn-menu'>");
                    pw.println("<button onclick=location.href='index.html' style=width:150px;height:50px ><font size=4>メニューに戻る</font></button>");
                    pw.println("</div>");
                    pw.println("</body>");
                    pw.println("</html>");
                }
            }else if(button.equals("CANCEL")){
                /*キャンセル画面*/
                pw.println("<!DOCTYPE html>");
                pw.println("<html lang=ja>");
                pw.println("<link rel=stylesheet href=style.css>");
                pw.println("<head><title>キャンセル画面</title></head>");
                pw.println("<body>");
                pw.println("<h1><font color=#F00#>引き出しをキャンセルしました</font></h1>");
                pw.println("<div class='btn-menu'>");
                pw.println("<button onclick=location.href='index.html' style=width:150px;height:50px ><font size=4>メニューに戻る</font></button>");
                pw.println("</div>");
                pw.println("</body></html>");
            }else{
                /*不明画面*/
                pw.println("<!DOCTYPE html>");
                pw.println("<html lang=ja>");
                pw.println("<link rel=stylesheet href=style.css>");
                pw.println("<head><title>不明</title></head>");
                pw.println("<body>");
                pw.println("<h1><font color=#F00#>不明なボタンがクリックされました</font></h1>");
                pw.println("<div class='btn-menu'>");
                pw.println("<p><a href='index.html'>メニューに戻る</a></p>");
                pw.println("</div>");
                pw.println("</body></html>");
            }
        }else if(command.equals("balance")){
            String button = request.getParameter("cmd");
            if(button.equals("OK")){
                user_name = request.getParameter("name");
                user_balance = bank.showBalance(user_name);

                /* 残高照会処理 */
                if(user_balance >= 0) {//残高(user_balance)で判断する
                    /* 残高照会成功のHTML生成*/
                    pw.println("<!DOCTYPE html>");
                    pw.println("<html lang=ja>");
                    pw.println("<head>");
                    pw.println("<meta charset=UTF-8>");
                    pw.println("<link rel=stylesheet href='style.css'>");
                    pw.println("<title>残高照会成功画面</title>");
                    pw.println("</head>");
                    pw.println("<body>");
                    pw.println("<h1><font color=#F00#>残高照会成功画面</font></h1>");
                    pw.println("<br>");
                    pw.println("<p>"+user_name+"様の口座の照会に成功しました。残高は"+user_balance+"円です。</p>");
                    pw.println("<div class='btn-menu'>");
                    pw.println("<button onclick=location.href='index.html' style=width:150px;height:50px ><font size=4>メニューに戻る</font></button>");
                    pw.println("</div>");
                    pw.println("</body>");
                    pw.println("</html>");
                }else if(user_balance == -7){
                    /* 残高照会失敗のHTML生成*/
                    pw.println("<!DOCTYPE html>");
                    pw.println("<html lang=ja>");
                    pw.println("<head>");
                    pw.println("<meta charset=UTF-8>");
                    pw.println("<link rel=stylesheet href='style.css'>");
                    pw.println("<title>残高照会失敗画面</title>");
                    pw.println("</head>");
                    pw.println("<body>");
                    pw.println("<h1><font color=#F00#>残高照会失敗画面</font></h1>");
                    pw.println("<br>");
                    pw.println("<p>"+user_name+"様の口座の照会に失敗しました。("+user_name+"様の口座はリストに存在しません！)</p>");
                    pw.println("<div class='btn-menu'>");
                    pw.println("<button onclick=location.href='index.html' style=width:150px;height:50px ><font size=4>メニューに戻る</font></button>");
                    pw.println("</div>");
                    pw.println("</body>");
                    pw.println("</html>");
                }
            }else if(button.equals("CANCEL")){
                /*キャンセル画面*/
                pw.println("<!DOCTYPE html>");
                pw.println("<html lang=ja>");
                pw.println("<link rel=stylesheet href=style.css>");
                pw.println("<head><title>キャンセル画面</title></head>");
                pw.println("<body>");
                pw.println("<h1><font color=#F00#>残高照会をキャンセルしました</font></h1>");
                pw.println("<div class='btn-menu'>");
                pw.println("<button onclick=location.href='index.html' style=width:150px;height:50px ><font size=4>メニューに戻る</font></button>");
                pw.println("</div>");
                pw.println("</body></html>");
            }else{
                /*不明画面*/
                pw.println("<!DOCTYPE html>");
                pw.println("<html lang=ja>");
                pw.println("<link rel=stylesheet href=style.css>");
                pw.println("<head><title>不明</title></head>");
                pw.println("<body>");
                pw.println("<h1><font color=#F00#>不明なボタンがクリックされました</font></h1>");
                pw.println("<div class='btn-menu'>");
                pw.println("<p><a href='index.html'>メニューに戻る</a></p>");
                pw.println("</div>");
                pw.println("</body></html>");
            }
        }
    } 
}
