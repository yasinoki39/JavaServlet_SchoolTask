import java.util.Hashtable;  //import文

public class Bank{
    private Hashtable<String, Account> customer; /* 口座リスト */
    
    public Bank() {  /* 口座リストを初期化する */
        this.customer = new Hashtable<String,Account>();
        // 必要な処理があれば追加する
    } 
    
    public int open(String name /* 口座名 */) {
        if(this.customer.get(name) == null){//口座リストになかったら
            this.customer.put(name,new Account(name));//引数で指定された口座名で口座を開設し、残高を0円にする
            return 0;//正常に終了したら0を返す
        }
        
        return -7;//口座リストがすでにあったら-7を返す
        
    } /* 口座開設 */
    
    public int close(String name /* 口座名 */) {
        int user_balance=0;//残高
        user_balance=showBalance(name);//bankのshowBalanceを実行して残高を変数に入れる
        
        if(this.customer.get(name) == null){//口座リストになかったら
            return -7;//-7を返す
        }else if(user_balance > 0){//残高が0円でない口座を解約しようとしたとき
            return -1;//-1を返す
        }
        
        this.customer.remove(name);//口座を削除する
        
        return 0;//正常に終了したら0を返す
        
    } /* 口座解約 */
    
    public int deposit(String name /* 口座名 */, int amount /* 預金額 */) { 
        Account user_account = this.customer.get(name);//インスタンス化+getで持ってきたAccountを格納
        
        if(this.customer.get(name) == null){//口座リストになかったら
            return -7;//-7を返す
        }else if(amount < 0 || amount == 0){//0以下の額を預金しようとしたとき
            return -3;//-3を返す
        }
        
        user_account.deposit(amount);//depositを使って預金する
        
        return 0;//正常に終了したら0を返す
        
    } /* 預金 */
    
    public int withdraw(String name /* 口座名 */, int amount /* 引き出し額 */) {
        int user_balance=0;//残高
        
        user_balance=showBalance(name);//bankのshowBalanceを実行して残高を変数に入れる
        
        if(this.customer.get(name) == null){//口座リストになかった
            return -7;//-7を返す
        }else if(amount < 0 || amount == 0){//0以下の額を引き出そうとしたとき
            return -3;//-3を返す
        }else if(amount > user_balance){//預金残高を越える額を引き出そうとしたとき
            return -1;//-1を返す
        }
        
        Account user_account = this.customer.get(name);//インスタンス化+getで持ってきたAccountを格納
        user_account.withdraw(amount);//withdrawを使ってお金を引き出す
        
        return 0;//正常に終了したら0を返す
        
    } /* 払い戻し*/
    
    public int showBalance(String name /* 口座名 */){
        int user_balance=0;//残高
        
        if(this.customer.get(name) == null){//口座リストになかったら
            return -7;//-7を返す
        }
        
        Account user_account = this.customer.get(name);//インスタンス化+getで持ってきたAccountを格納
        user_balance = user_account.showBalance();//AccountのshowBalanceを実行して残高を持ってきてbalanceに格納
        
        return user_balance;//残高を返す
        
    } /* 残高照会 */
    
    public int deposit(String name, String amount){
        int deposit_num=0;//変数(数字を格納)
        int user_balance=0;//残高
        
        user_balance = showBalance(name);//showBalanceを実行してbalanceに数字を格納する
        
        if(showBalance(name) == -7){//-7だったら
            return -7;//-7を返す
        }
        
        try{
            deposit_num = Integer.parseInt(amount);//String型からint型への変換
            
            if(deposit_num < 0 || deposit_num == 0){//0以下の額を預金しようとしたとき
                return -3;//-3を返す
            }
            
        }catch(NumberFormatException e){//指定された金額が整数でないとき
            return -4;//-4を返す
        }
        
        deposit(name,deposit_num);//depositメソッドを実行して預金する
        
        return 0;//正常に終了したら0を返す
        
    }

    public int withdraw(String name, String amount){
        int withdraw_num=0;//変数(数字を格納)
        int user_balance=0;//残高

        user_balance = showBalance(name);//showBalanceを実行してbalanceに数字を格納する
        
        if(user_balance == -7){//-7だったら
            return -7;//-7を返す
        }

        try{
            withdraw_num = Integer.parseInt(amount);//String型からint型への変換
            
            if(withdraw_num < 0 || withdraw_num == 0){//0以下の額を預金しようとしたとき
                return -3;//-3を返す
            }else if(withdraw_num > user_balance){//預金残高を越える額を引き出そうとしたとき
                return -1;//-1を返す
            }

        }catch(NumberFormatException e){//指定された金額が整数でないとき
            return -4;//-4を返す
        }
        
        withdraw(name,withdraw_num);//withdrawメソッドを実行して出金する
        
        return 0;//正常に終了したら0を返す
    }
}
