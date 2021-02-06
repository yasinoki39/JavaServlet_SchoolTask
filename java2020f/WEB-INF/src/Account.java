public class Account {
    private String name; /* 口座名 */
    private int balance; /* 口座の残高 */
    
    public Account(String myName /* 口座名 */) { /*コンストラクタ*/
        this.name = myName;
    }
    
    public int deposit(int amount/* 預金額 */) { 
        if(amount == 0 || amount < 0){/* 預金する関数*/
            return -3;//-3を返す
        }
        
        this.balance = this.balance + amount;//預金する
        return 0;//0を返す
    }
        
    public int withdraw(int amount/* 出金額 */) {/* 払い戻しする関数*/
        if(amount>this.balance){
            return -1;//-1を返す
        }else if(amount < 0 || amount == 0){
            return -3;//-3を返す
        }
        
        this.balance = this.balance - amount;//出金する
        return 0;//0を返す
    }
      

    public int showBalance() { /* 残高照会する関数*/
        return this.balance;//残高を返す
    }
}
